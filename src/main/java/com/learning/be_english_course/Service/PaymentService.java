package com.learning.be_english_course.Service;

import com.learning.be_english_course.DTO.request.payment.dtoCreatePayment;
import com.learning.be_english_course.DTO.request.payment.dtoUpdatePayment;
import com.learning.be_english_course.DTO.respone.payment.dtoGetPayment;
import com.learning.be_english_course.Entity.Payment;
import com.learning.be_english_course.Mapper.EntityMapping;
import com.learning.be_english_course.Repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private EntityMapping entityMapping;
    public Long totalPayments() {
        Long totalPayments = 0L;
        for (Payment payment : paymentRepository.findAll()) {
           totalPayments = paymentRepository.countAmount(payment.getAmount());
        }
        return totalPayments;
    }
    public List<dtoGetPayment> findAll() {
       return paymentRepository.getPayments();

    }
    public Payment findById(Long id) {
        if (!paymentRepository.existsById(id)) {
            throw new RuntimeException("Không tìm thấy thanh toán với id = " + id);
        }
        return paymentRepository.findById(id).get();
    }
    public List<Payment> findByUserId(long iduser) {
        if(!paymentRepository.existsById(iduser)) {throw new RuntimeException("Không tìm thấy người dùng với id = " + iduser);
        }
        return paymentRepository.findByUserId(iduser);
    }

    public Payment createPaymet(dtoCreatePayment request) {
        Payment payment = entityMapping.DTOtoCreatePayment(request);
        return paymentRepository.save(payment);
    }
    public Payment updatePaymet(long id , dtoUpdatePayment request) {
        Payment payment = paymentRepository.findById(id).orElseThrow(()->new RuntimeException("Không tìm thanh toán với id = " + id));;
        entityMapping.DTOtoUpdatePayment(payment,request);
        return paymentRepository.save(payment);
    }
    public void deletePaymet(long id) {
        if(!paymentRepository.existsById(id)){
            throw new RuntimeException("Không thể xóa vì không tồn tại id = " + id);
        }
        paymentRepository.deleteById(id);
    }
}



