package com.learning.lvtn_backend.controller;

import com.learning.lvtn_backend.entity.Payment_Course;
import com.learning.lvtn_backend.service.PaymentCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment-course")
public class PaymentCourseController {

    @Autowired
    private PaymentCourseService paymentCourseService;

    // Lấy tất cả Payment_Course
    @GetMapping()
    public ResponseEntity<List<Payment_Course>> getAll() {
        List<Payment_Course> list = paymentCourseService.findAll();
        return ResponseEntity.ok(list);
    }

    // Lấy tất cả khóa học theo idPayment
    @GetMapping("/payment/{idPayment}")
    public ResponseEntity<List<Payment_Course>> getByPaymentId(@PathVariable int idPayment) {
        List<Payment_Course> list = paymentCourseService.findByPaymentId(idPayment);
        return ResponseEntity.ok(list);
    }

    // Thêm nhiều khóa học cho 1 payment
    @PostMapping("/payment/{idPayment}/add")
    public ResponseEntity<List<Payment_Course>> addCoursesToPayment(
            @PathVariable int idPayment,
            @RequestBody List<Integer> courseIds) {

        List<Payment_Course> toSave = courseIds.stream().map(courseId -> {
            Payment_Course pc = new Payment_Course();
            pc.setIdPayment(idPayment);
            pc.setCourseId(courseId);
            return pc;
        }).toList();

        List<Payment_Course> saved = paymentCourseService.saveAll(toSave);
        return ResponseEntity.ok(saved);
    }

    // Xóa tất cả khóa học của 1 payment
    @DeleteMapping("/payment/{idPayment}/delete")
    public ResponseEntity<String> deleteByPaymentId(@PathVariable int idPayment) {
        paymentCourseService.deleteByPaymentId(idPayment);
        return ResponseEntity.ok("Đã xóa tất cả khóa học của payment " + idPayment);
    }

    // Xóa 1 khóa học khỏi payment
    @DeleteMapping("/payment-course/{idPaymentCourse}")
    public ResponseEntity<String> deleteOne(@PathVariable int idPaymentCourse) {
        paymentCourseService.deleteById(idPaymentCourse);
        return ResponseEntity.ok("Đã xóa khóa học khỏi payment " + idPaymentCourse);
    }
}
