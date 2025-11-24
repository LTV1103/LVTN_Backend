package com.learning.lvtn_backend.service;

import com.learning.lvtn_backend.entity.Payment_Course;
import com.learning.lvtn_backend.reponsitory.PaymentCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentCourseService {

    @Autowired
    private PaymentCourseRepository paymentCourseRepository;

    // Lấy Payment_Course theo ID
    public Payment_Course findById(int id) {
        return paymentCourseRepository.findById(id).orElse(null);
    }

    // Lấy tất cả Payment_Course
    public List<Payment_Course> findAll() {
        return paymentCourseRepository.findAll();
    }

    // Lấy danh sách khóa học theo idPayment
    public List<Payment_Course> findByPaymentId(int idPayment) {
        return paymentCourseRepository.findByIdPayment(idPayment);
    }

    // Thêm mới Payment_Course
    public Payment_Course save(Payment_Course paymentCourse) {
        return paymentCourseRepository.save(paymentCourse);
    }

    // Thêm nhiều khóa học cho 1 payment
    public List<Payment_Course> saveAll(List<Payment_Course> paymentCourses) {
        return paymentCourseRepository.saveAll(paymentCourses);
    }

    // Xóa Payment_Course theo ID
    public void deleteById(int id) {
        paymentCourseRepository.deleteById(id);
    }

    // Xóa tất cả khóa học của 1 payment
    public void deleteByPaymentId(int idPayment) {
        List<Payment_Course> list = paymentCourseRepository.findByIdPayment(idPayment);
        paymentCourseRepository.deleteAll(list);
    }
}
