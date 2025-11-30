package com.learning.be_english_course.Controller;

import com.learning.be_english_course.DTO.request.payment.VNPayRequest;
import com.learning.be_english_course.DTO.request.payment.dtoCreatePayment;
import com.learning.be_english_course.DTO.request.payment.dtoUpdatePayment;
import com.learning.be_english_course.DTO.request.user_course.dtoCreateUserCourse;
import com.learning.be_english_course.Entity.Payment;
import com.learning.be_english_course.Entity.Payment_course;
import com.learning.be_english_course.Entity.User_course;
import com.learning.be_english_course.Exception.apiRespone.ApiResponse;
import com.learning.be_english_course.Exception.apiRespone.BaseController;
import com.learning.be_english_course.Repository.PaymentRepository;
import com.learning.be_english_course.Service.PaymentCourseService;
import com.learning.be_english_course.Service.PaymentService;
import com.learning.be_english_course.Service.UserCourseService;
import com.learning.be_english_course.Service.VNPayService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

@RestController
@RequestMapping("/payment")
public class PaymentController extends BaseController {

    @Autowired
    private VNPayService vnPayService;
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private PaymentService paymentService;
    @Autowired
    private PaymentCourseService paymentCourseService;
    @Autowired
    private UserCourseService userCourseService;

    @GetMapping
    public List<Payment> getAll() {
        return paymentService.findAll();
    }
    //VNpay
    @PostMapping("/create")
    public ResponseEntity<ApiResponse<Map<String, Object>>> createPayment(@RequestBody VNPayRequest req, HttpServletRequest request) {
        try {
            // Tạo Payment
            Payment newPayment = new Payment();
            newPayment.setUserId(req.getUserId());
            newPayment.setAmount(req.getAmount());
            newPayment.setPaymentStatus("pending");
            newPayment.setPaymentMethod("vnpay");
            paymentRepository.save(newPayment);


            // Lưu Payment_Course cho nhiều khóa học
            String coursesStr = req.getCourseId();
            String[] courseIdsArr = coursesStr.split(",");
            List<Payment_course> paymentCourses = new ArrayList<>();
            for (String id : courseIdsArr) {
                Payment_course pc = new Payment_course();
                pc.setPaymentId(newPayment.getPaymentId());
                pc.setCourseId(Long.parseLong(id.trim()));
                pc.setCreatedAt(LocalDateTime.now());
                paymentCourses.add(pc);
            }
            paymentCourseService.saveAll(paymentCourses);


            // Tạo URL VNPAY
            String paymentUrl = vnPayService.createPaymentUrl(newPayment.getPaymentId(), Long.valueOf(req.getAmount().toPlainString()), "Thanh toán khóa học: " + coursesStr, coursesStr, request);


            // Chuẩn bị data trả về
            Map<String, Object> data = new HashMap<>();
            data.put("paymentId", newPayment.getPaymentId());
            data.put("userId", newPayment.getUserId());
            data.put("courses", coursesStr);
            data.put("amount", newPayment.getAmount());
            data.put("paymentMethod", newPayment.getPaymentMethod());
            data.put("paymentStatus", newPayment.getPaymentStatus());
            data.put("paymentUrl", paymentUrl);
            return success("Tạo Hóa Đơn Thanh toán thành công",data);
        } catch (Exception e) {
            e.printStackTrace();
            return error(HttpStatus.BAD_REQUEST, "Lỗi tạo URL thanh toán: " + e.getMessage(), null);
        }
    }


    @GetMapping("/vnpay-return")
    public ResponseEntity<String> paymentReturn(@RequestParam Map<String, String> params) {
        String responseCode = params.get("vnp_ResponseCode");
        String txnRef = params.get("vnp_TxnRef"); // Mã đơn hàng
        AtomicReference<String> status = new AtomicReference<>("fail");
        try {
            paymentRepository.findById(Long.valueOf(txnRef)).ifPresent(order -> {
                if ("00".equals(responseCode)) {
                    // Giao dịch thành công
                    order.setPaymentStatus("success");
                    paymentRepository.save(order);

                    List<Payment_course> paymentCourses = paymentCourseService.findByPaymentId(order.getPaymentId());
                    for (Payment_course pc : paymentCourses) {
                        User_course uc = new User_course();
                        uc.setUserId(order.getUserId());
                        uc.setCourseId(pc.getCourseId());
                        uc.setEnrolledAt(LocalDateTime.now());
                        uc.setStatus("active");
                        userCourseService.createEntiryUserCourse(uc);
                    }
                    status.set("success");
                } else {
                    // Giao dịch thất bại
                    order.setPaymentStatus("failed");
                    paymentRepository.save(order);
                    status.set("failed");
                }
            });

            // HTML redirect về FE
            String html = """
                <html>
                  <head>
                    <meta http-equiv='refresh' content='0; URL=http://localhost:5173/shop?status=%s' />
                  </head>
                  <body>
                    <p>Đang chuyển hướng về cửa hàng...</p>
                  </body>
                </html>
                """.formatted(status.get());

            return ResponseEntity.ok()
                    .header("Content-Type", "text/html")
                    .body(html);

        } catch (Exception e) {
            String errorHtml = "<html><body><h3>Lỗi xử lý thanh toán: " + e.getMessage() + "</h3></body></html>";
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .header("Content-Type", "text/html")
                    .body(errorHtml);
        }
    }


    @PostMapping
    public ResponseEntity<ApiResponse<Payment>> createPayment(@RequestBody @Valid dtoCreatePayment request) {
        Payment payment = paymentService.createPaymet(request);
        return created ("Tạo hóa đơn thanh toán thành công", payment);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Payment>> updatePayment(@PathVariable Long id, @RequestBody @Valid dtoUpdatePayment request) {
        Payment payment = paymentService.updatePaymet(id, request);
        return success("Cập nhật thành công!", payment);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deletePayment(@PathVariable Long id) {
        paymentRepository.deleteById(id);
        return success("Xóa thanh toán thành công!", "ID = " + id);
    }
}
