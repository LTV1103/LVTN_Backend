package com.learning.lvtn_backend.controller;

import com.learning.lvtn_backend.dto.request.dtoPayment.VNPayRequest;
import com.learning.lvtn_backend.dto.request.dtoUserCourse.dtoCreateUserCourse;
import com.learning.lvtn_backend.entity.Payment_Course;
import com.learning.lvtn_backend.exception.base.BaseController;
import com.learning.lvtn_backend.dto.request.dtoPayment.dtoCreatePayment;
import com.learning.lvtn_backend.dto.request.dtoPayment.dtoUpdatePayment;
import com.learning.lvtn_backend.dto.response.dtoPayment.dtoGetPayment;
import com.learning.lvtn_backend.entity.Payment;
import com.learning.lvtn_backend.reponsitory.PaymentRepository;
import com.learning.lvtn_backend.service.PaymentCourseService;
import com.learning.lvtn_backend.service.PaymentService;
import com.learning.lvtn_backend.service.UserCourseService;
import com.learning.lvtn_backend.service.VNPayService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
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
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")

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


    //    VNpay
    @PostMapping("/create")
    public ResponseEntity<?> createPayment(@RequestBody VNPayRequest req,
                                           HttpServletRequest request) {

        try {
            //Tạo Payment
            Payment payment = new Payment();
            payment.setUserId((int) req.getUserId());
            payment.setAmount(new BigDecimal(req.getAmount()));
            payment.setPaymentMethod("vnpay");
            payment.setPaymentStatus("pending");
            Payment savedPayment = paymentRepository.save(payment);

            //Lưu Payment_Course cho nhiều khóa học
            String coursesStr = req.getCourseId();
            String[] courseIdsArr = coursesStr.split(",");
            List<Payment_Course> paymentCourses = new ArrayList<>();
            for (String id : courseIdsArr) {
                Payment_Course pc = new Payment_Course();
                pc.setIdPayment(savedPayment.getPaymentId());
                pc.setCourseId(Integer.parseInt(id.trim()));
                pc.setCreatedAt(LocalDateTime.now());
                paymentCourses.add(pc);
            }
            paymentCourseService.saveAll(paymentCourses);

            //Tạo URL VNPAY
            String paymentUrl = vnPayService.createPaymentUrl(
                    (long) savedPayment.getPaymentId(),
                    req.getAmount(),
                    "Thanh toán khóa học: " + coursesStr,
                    coursesStr,
                    request
            );

            //Trả response
            Map<String, Object> response = new HashMap<>();
            response.put("idPayment", savedPayment.getPaymentId());
            response.put("idUser", savedPayment.getUserId());
            response.put("courses", coursesStr); // trả về tất cả id khóa học
            response.put("amount", savedPayment.getAmount());
            response.put("paymentMethod", savedPayment.getPaymentMethod());
            response.put("paymentStatus", savedPayment.getPaymentStatus());
            response.put("paymentUrl", paymentUrl);

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Lỗi tạo URL thanh toán: " + e.getMessage());
        }
    }

    @GetMapping("/vnpay-return")
    public ResponseEntity<String> paymentReturn(@RequestParam Map<String, String> params) {
        String responseCode = params.get("vnp_ResponseCode");
        String txnRef = params.get("vnp_TxnRef"); // Mã đơn hàng
        AtomicReference<String> status = new AtomicReference<>("fail");

        try {
            paymentRepository.findById(Integer.parseInt(txnRef)).ifPresent(order -> {
                if ("00".equals(responseCode)) {
                    // Giao dịch thành công
                    order.setPaymentStatus("SUCCESS");
                    paymentRepository.save(order);

                    List<Payment_Course> paymentCourses = paymentCourseService.findByPaymentId(order.getPaymentId());
                    for (Payment_Course pc : paymentCourses) {
                        dtoCreateUserCourse uc = new dtoCreateUserCourse();
                        uc.setUserId(order.getUserId());
                        uc.setCourseId(pc.getCourseId());
                        uc.setEnrolledAt(LocalDateTime.now());
                        uc.setStatus("active");
                        userCourseService.createUserCourse(uc);
                    }

                    status.set("success");
                } else {
                    // Giao dịch thất bại
                    order.setPaymentStatus("FAILED");
                    paymentRepository.save(order);
                    status.set("fail");
                }
            });
            String html = """
                    <html>
                      <head>
                        <meta http-equiv='refresh' content='0; URL=http://localhost:5173/shop?status=%s' />
                      </head>
                      <body>
                        <p>Đang chuyển hướng về cửa hàng...</p>
                      </body>
                    </html>
                    """.formatted(status);

            return ResponseEntity.ok()
                    .header("Content-Type", "text/html")
                    .body(html);

        } catch (Exception e) {
            String errorHtml = "<html><body><h3>Lỗi xử lý thanh toán: " + e.getMessage() + "</h3></body></html>";
            return ResponseEntity.status(500)
                    .header("Content-Type", "text/html")
                    .body(errorHtml);
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllPayments() {
        List<dtoGetPayment> payments = paymentService.getAllPayments();
        return success("Lấy danh sách thanh toán thành công!", payments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPaymentById(@PathVariable int id) {
        dtoGetPayment payment = paymentService.getPaymentById(id);
        return success("Lấy thông tin thanh toán thành công!", payment);
    }

    @PostMapping
    public ResponseEntity<?> createPayment(@RequestBody dtoCreatePayment request) {
        Payment newPayment = paymentService.createPayment(request);
        return created("Tạo thanh toán mới thành công!", newPayment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePayment(@PathVariable int id, @RequestBody dtoUpdatePayment request) {
        dtoGetPayment updatedPayment = paymentService.updatePayment(id, request);
        return success("Cập nhật thanh toán thành công!", updatedPayment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePayment(@PathVariable int id) {
        paymentService.deletePayment(id);
        return success("Xóa thanh toán thành công!", "Deleted payment with ID = " + id);
    }
}

