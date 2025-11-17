package com.learning.lvtn_backend.controller;

import com.learning.lvtn_backend.exception.base.BaseController;
import com.learning.lvtn_backend.dto.request.dtoPayment.dtoCreatePayment;
import com.learning.lvtn_backend.dto.request.dtoPayment.dtoUpdatePayment;
import com.learning.lvtn_backend.dto.response.dtoPayment.dtoGetPayment;
import com.learning.lvtn_backend.entity.Payment;
import com.learning.lvtn_backend.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/payment")
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")

public class PaymentController extends BaseController {

    @Autowired
    private PaymentService paymentService;

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
