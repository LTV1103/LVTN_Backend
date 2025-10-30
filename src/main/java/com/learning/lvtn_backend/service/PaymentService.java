package com.learning.lvtn_backend.service;

import com.learning.lvtn_backend.entity.Payment;
import com.learning.lvtn_backend.reponsitory.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    public List<Payment> getAllPayments() { return paymentRepository.findAll(); }

    public Payment getPaymentById(int id) {
        return paymentRepository.findById(id).orElseThrow(() -> new RuntimeException("Payment not found with ID = " + id));
    }

    public Payment createPayment(Payment payment) { return paymentRepository.save(payment); }

    public Payment updatePayment(int id, Payment details) {
        Payment existing = getPaymentById(id);
        existing.setIdUser(details.getIdUser());
        existing.setIdCourse(details.getIdCourse());
        existing.setAmount(details.getAmount());
        existing.setPaymentMethod(details.getPaymentMethod());
        existing.setPaymentStatus(details.getPaymentStatus());
        return paymentRepository.save(existing);
    }

    public void deletePayment(int id) {
        if (!paymentRepository.existsById(id)) throw new RuntimeException("Payment not found with ID = " + id);
        paymentRepository.deleteById(id);
    }
}
