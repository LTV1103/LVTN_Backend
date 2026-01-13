package com.learning.be_english_course.Service;

import com.learning.be_english_course.DTO.request.payment.VNPayRequest;
import com.learning.be_english_course.DTO.request.payment.dtoCreatePayment;
import com.learning.be_english_course.DTO.request.payment.dtoUpdatePayment;
import com.learning.be_english_course.DTO.respone.payment.dtoGetPayment;
import com.learning.be_english_course.Entity.Payment;
import com.learning.be_english_course.Entity.Payment_course;
import com.learning.be_english_course.Entity.User_course;
import com.learning.be_english_course.Mapper.EntityMapping;
import com.learning.be_english_course.Repository.PaymentRepository;
import com.learning.be_english_course.Repository.UserCourseRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private EntityMapping entityMapping;
    @Autowired
    private PaymentCourseService paymentCourseService;
    @Autowired
    private VNPayService vnPayService;
    @Autowired
    private url_VnPayService urlVnPayService;
    @Autowired
    private UserCourseRepository userCourseRepository;
    // tong tien
    public Long totalPayments() {
        Long totalPayments = 0L;
        for (Payment payment : paymentRepository.findAll()) {
           totalPayments = paymentRepository.countAmount(payment.getAmount());
        }
        return totalPayments;
    }
    //ds hoa don
    public List<dtoGetPayment> findAll() {
       return paymentRepository.getPayments();

    }
    //tim theo id
    public Payment findById(Long id) {
        if (!paymentRepository.existsById(id)) {
            throw new RuntimeException("Không tìm thấy thanh toán với id = " + id);
        }
        return paymentRepository.findById(id).get();
    }
    // tim theo id nguoi dung
    public List<Payment> findByUserId(long iduser) {
        if(!paymentRepository.existsById(iduser)) {throw new RuntimeException("Không tìm thấy người dùng với id = " + iduser);
        }
        return paymentRepository.findByUserId(iduser);
    }
    // cap nhat
    public Payment updatePaymet(long id , dtoUpdatePayment request) {
        Payment payment = paymentRepository.findById(id).orElseThrow(()->new RuntimeException("Không tìm thanh toán với id = " + id));;
        entityMapping.DTOtoUpdatePayment(payment,request);
        return paymentRepository.save(payment);
    }
    // xoa
    public void deletePaymet(long id) {
        if(!paymentRepository.existsById(id)){
            throw new RuntimeException("Không thể xóa vì không tồn tại id = " + id);
        }
        paymentRepository.deleteById(id);
    }


    // tao moi
    public Map<String, Object> createPayment(VNPayRequest req, HttpServletRequest request) throws Exception {
        Payment payment = createPendingPayment(req);
        savePaymentCourses(payment.getPaymentId(), req.getCourseId());
        String paymentUrl = vnPayService.createPaymentUrl(
                payment.getPaymentId(),
                payment.getAmount().longValue(),
                "Thanh toán khóa học",
                req.getCourseId(),
                request
        );
        return buildPaymentResponse(payment, req.getCourseId(), paymentUrl);
    }

    // xu ly du lieu tra ve
    public ResponseEntity<String> handleVNPayReturn(
            Map<String, String> params,
            HttpServletRequest request
    ) {

        String responseCode = params.get("vnp_ResponseCode");
        Long paymentId = Long.valueOf(params.get("vnp_TxnRef"));

        String callbackUrl = request.getRequestURL() + "?" + request.getQueryString();
        urlVnPayService.save(callbackUrl);

        String status = processPaymentResult(paymentId, responseCode, callbackUrl);

        return buildRedirectHtml(status);
    }
    // tao moi hoa don trong trang thai doi
    private Payment createPendingPayment(VNPayRequest req) {
        Payment payment = new Payment();
        payment.setUserId(req.getUserId());
        payment.setAmount(req.getAmount());
        payment.setPaymentMethod("vnpay");
        payment.setPaymentStatus("pending");
        return paymentRepository.save(payment);
    }
    // luu hoa don cua khoa hoc
    private void savePaymentCourses(Long paymentId, String coursesStr) {
        List<Payment_course> list = Arrays.stream(coursesStr.split(","))
                .map(id -> {
                    Payment_course pc = new Payment_course();
                    pc.setPaymentId(paymentId);
                    pc.setCourseId(Long.parseLong(id.trim()));
                    pc.setCreatedAt(LocalDateTime.now());
                    return pc;
                })
                .toList();

        paymentCourseService.saveAll(list);
    }
    // trang thai tra ve cua thanh toan
    private String processPaymentResult(
            Long paymentId,
            String responseCode,
            String callbackUrl
    ) {
        return paymentRepository.findById(paymentId)
                .map(payment -> {

                    if ("00".equals(responseCode)) {
                        payment.setPaymentStatus("success");
                        payment.setNameBank(extractBank(callbackUrl));
                        paymentRepository.save(payment);
                        activateUserCourses(payment);
                        return "success";
                    }

                    payment.setPaymentStatus("failed");
                    paymentRepository.save(payment);
                    return "failed";

                }).orElse("failed");
    }
    // mo khoa hoc cho nguoi dung
    private void activateUserCourses(Payment payment) {
        List<Payment_course> list =
                paymentCourseService.findByPaymentId(payment.getPaymentId());

        for (Payment_course pc : list) {
            User_course uc = userCourseRepository
                    .findByUserIdAndCourseId(payment.getUserId(), pc.getCourseId())
                    .orElse(new User_course());

            uc.setUserId(payment.getUserId());
            uc.setCourseId(pc.getCourseId());
            uc.setStatus("active");
            uc.setEnrolledAt(LocalDateTime.now());
            userCourseRepository.save(uc);
        }
    }
    // cap nhat ten ngan hang
    private String extractBank(String callbackUrl) {
        try {
            return callbackUrl.split("vnp_BankCode=")[1].split("&")[0];
        } catch (Exception e) {
            return "unknown";
        }
    }
    // tao chuoi thanh toan de day len
    private Map<String, Object> buildPaymentResponse(
            Payment payment,
            String courses,
            String paymentUrl
    ) {
        Map<String, Object> data = new HashMap<>();
        data.put("paymentId", payment.getPaymentId());
        data.put("userId", payment.getUserId());
        data.put("courses", courses);
        data.put("amount", payment.getAmount());
        data.put("paymentMethod", payment.getPaymentMethod());
        data.put("paymentStatus", payment.getPaymentStatus());
        data.put("paymentUrl", paymentUrl);
        return data;
    }
    // tao trang tra ve sau khi thanh toan thanh cong
    private ResponseEntity<String> buildRedirectHtml(String status) {
        String html = """
            <html>
              <head>
                <meta http-equiv='refresh' content='0; URL=http://localhost:5173/shop?status=%s' />
              </head>
              <body>
                <p>Đang chuyển hướng...</p>
              </body>
            </html>
            """.formatted(status);

        return ResponseEntity.ok()
                .header("Content-Type", "text/html")
                .body(html);
    }
}



