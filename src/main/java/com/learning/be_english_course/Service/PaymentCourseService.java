package com.learning.be_english_course.Service;

import com.learning.be_english_course.DTO.request.payment_course.dtoCreatePaymentCourse;
import com.learning.be_english_course.DTO.request.payment_course.dtoUpdatePaymentCourse;
import com.learning.be_english_course.DTO.respone.payment.dtoDetailPayment;
import com.learning.be_english_course.DTO.respone.payment_course.dtoChartMonth;
import com.learning.be_english_course.Entity.Payment;
import com.learning.be_english_course.Entity.Payment_course;
import com.learning.be_english_course.Mapper.EntityMapping;
import com.learning.be_english_course.Repository.PaymentCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PaymentCourseService {

    @Autowired
    private PaymentCourseRepository paymentCourseRepository;
    @Autowired
    private EntityMapping  entityMapping;

    // Lấy Payment_Course theo ID
    public Payment_course findById(long paymentCourseId) {
        return paymentCourseRepository.findById(paymentCourseId).orElse(null);
    }
    public List<dtoDetailPayment> findByIDPayment(long paymentId) {
        return paymentCourseRepository.findPaymentById(paymentId);
    }
    public List<dtoChartMonth> getPaymentCourseByMonth() {
        return paymentCourseRepository.countPaymentCourseByMonth();
    }

    // Lấy tất cả Payment_Course
    public List<Payment_course> findAll() {
        return paymentCourseRepository.findAll();
    }

    // Lấy danh sách khóa học theo idPayment
    public List<Payment_course> findByPaymentId(long paymentId) {
        return paymentCourseRepository.findByPaymentId(paymentId);
    }

    // Thêm mới Payment_Course
    public Payment_course save(Payment_course paymentCourse) {
        return paymentCourseRepository.save(paymentCourse);
    }
    public Payment_course createPaymentCourse(dtoCreatePaymentCourse request) {
        Payment_course newPaymentCourse = entityMapping.DTOtoCreatePaymentCourse(request);
        return paymentCourseRepository.save(newPaymentCourse);

    }

    public Payment_course updatePaymentCourse(Long id,dtoUpdatePaymentCourse request) {
        Payment_course paymentCourse = paymentCourseRepository.findById(id).orElse(null);
        entityMapping.DTOtoUpdatePaymentCourse(paymentCourse,request);
        return paymentCourseRepository.save(paymentCourse);
    }
    // Thêm nhiều khóa học cho 1 payment
    public List<Payment_course> saveAll(List<Payment_course> paymentCourses) {
        return paymentCourseRepository.saveAll(paymentCourses);
    }

    // Xóa Payment_Course theo ID
    public void deleteById(long paymentCourseId) {
        paymentCourseRepository.deleteById(paymentCourseId);
    }

    // Xóa tất cả khóa học của 1 payment
    public void deleteByPaymentId(long paymentId) {
        List<Payment_course> list = paymentCourseRepository.findByPaymentId(paymentId);
        paymentCourseRepository.deleteAll(list);
    }
}
