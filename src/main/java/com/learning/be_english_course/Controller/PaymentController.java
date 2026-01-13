package com.learning.be_english_course.Controller;

import com.learning.be_english_course.DTO.request.payment.VNPayRequest;
import com.learning.be_english_course.DTO.request.payment.dtoCreatePayment;
import com.learning.be_english_course.DTO.request.payment.dtoUpdatePayment;
import com.learning.be_english_course.DTO.request.user_course.dtoCreateUserCourse;
import com.learning.be_english_course.DTO.respone.payment.dtoGetPayment;
import com.learning.be_english_course.Entity.Payment;
import com.learning.be_english_course.Entity.Payment_course;
import com.learning.be_english_course.Entity.User_course;
import com.learning.be_english_course.Exception.apiRespone.ApiResponse;
import com.learning.be_english_course.Exception.apiRespone.BaseController;
import com.learning.be_english_course.Repository.PaymentRepository;
import com.learning.be_english_course.Repository.UserCourseRepository;
import com.learning.be_english_course.Service.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

@RestController
@RequestMapping("/payment")
public class PaymentController extends BaseController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Payment>> getPayment(@PathVariable long id) {
        Payment payment = paymentService.findById(id);
        return  success("Lay thong tin thanh cong", payment);

    }
    @GetMapping("/totalAmount")
    public ResponseEntity<ApiResponse<Long>> totalAmount() {
        Long totalAmount = paymentService.totalPayments();
        return success("Tổng tiền", totalAmount);
    }
    @GetMapping
    public ResponseEntity<ApiResponse<List<dtoGetPayment>>> getAll() {
        List<dtoGetPayment> payments = paymentService.findAll();
         return success("Lấy thông tin thanh toán thành công" , payments);

    }
    @GetMapping("/user/{id}")
    public ResponseEntity<ApiResponse<List<Payment>>> getPaymentByUserId(@PathVariable long id) {
        List<Payment> payments = paymentService.findByUserId(id);
        return success("Lấy thông tin thanh toán thành công" , payments);

    }
    //VNpay
    @PostMapping("/create")
    public ResponseEntity<ApiResponse<Map<String, Object>>> createPayment(
            @RequestBody VNPayRequest req,
            HttpServletRequest request
    ) throws Exception {
        Map<String, Object> data = paymentService.createPayment(req, request);
        return success("Tạo Hóa Đơn Thanh toán thành công", data);
    }

    @GetMapping("/vnpay-return")
    public ResponseEntity<String> paymentReturn(
            @RequestParam Map<String, String> params,
            HttpServletRequest request
    ) {
        return paymentService.handleVNPayReturn(params, request);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Payment>> updatePayment(@PathVariable Long id, @RequestBody @Valid dtoUpdatePayment request) {
        Payment payment = paymentService.updatePaymet(id, request);
        return success("Cập nhật thành công!", payment);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deletePayment(@PathVariable Long id) {
        paymentService.deletePaymet(id);
        return success("Xóa thanh toán thành công!", "ID = " + id);
    }
}
