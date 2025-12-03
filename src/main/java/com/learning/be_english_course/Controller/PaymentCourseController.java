package com.learning.be_english_course.Controller;

import com.learning.be_english_course.DTO.request.payment_course.dtoCreatePaymentCourse;
import com.learning.be_english_course.DTO.request.payment_course.dtoUpdatePaymentCourse;
import com.learning.be_english_course.DTO.respone.payment.dtoDetailPayment;
import com.learning.be_english_course.Entity.Payment_course;
import com.learning.be_english_course.Exception.apiRespone.ApiResponse;
import com.learning.be_english_course.Exception.apiRespone.BaseController;
import com.learning.be_english_course.Service.PaymentCourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment-course")
public class PaymentCourseController extends BaseController {

    @Autowired
    private PaymentCourseService paymentCourseService;

    // Lấy tất cả Payment_course
    @GetMapping
    public ResponseEntity<ApiResponse<List<Payment_course>>> getAll() {
        List<Payment_course> payments = paymentCourseService.findAll();
        return success("Lấy danh sách thanh toán khóa học thành công!", payments);
    }
    @GetMapping("/detail/{paymentId}")
    public ResponseEntity<ApiResponse<List<dtoDetailPayment>>> GetbyIdPayment(@PathVariable long paymentId) {
        List<dtoDetailPayment> dto = paymentCourseService.findByIDPayment(paymentId);
        return success("Lấy thông tin chi tiet thanh toán thành công!" , dto);

    }
    // Lấy Payment_course theo id
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Payment_course>> getById(@PathVariable Long id) {
        Payment_course payment = paymentCourseService.findById(id);
        return success("Lấy thông tin thanh toán thành công!", payment);
    }

    // Tạo mới Payment_course
    @PostMapping
    public ResponseEntity<ApiResponse<Payment_course>> create(@RequestBody @Valid dtoCreatePaymentCourse request) {
        Payment_course payment = paymentCourseService.createPaymentCourse(request);
        return created("Tạo thanh toán mới thành công!", payment);
    }

    // Cập nhật Payment_course
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Payment_course>> update(@PathVariable Long id,
                                                              @RequestBody @Valid dtoUpdatePaymentCourse request) {
        Payment_course payment = paymentCourseService.updatePaymentCourse(id, request);
        return success("Cập nhật thanh toán thành công!", payment);
    }

    // Xóa Payment_course
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> delete(@PathVariable Long id) {
        paymentCourseService.deleteById(id);
        return success("Xóa thanh toán thành công!", "ID = " + id);
    }
}
