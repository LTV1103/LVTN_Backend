package com.learning.lvtn_backend.service;

import com.learning.lvtn_backend.dto.request.dtoPayment.dtoCreatePayment;
import com.learning.lvtn_backend.dto.request.dtoPayment.dtoUpdatePayment;
import com.learning.lvtn_backend.dto.response.dtoPayment.dtoGetPayment;
import com.learning.lvtn_backend.entity.Payment;
import com.learning.lvtn_backend.mapper.MapperEntity;
import com.learning.lvtn_backend.reponsitory.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private MapperEntity paymentMapping;

    public List<dtoGetPayment> getAllPayments() {
        List<Payment> payments = paymentRepository.findAll();
        return paymentMapping.listPaymentToListDtoGetPayment(payments);
    }

    public dtoGetPayment getPaymentById(int id) {
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy thanh toán với ID = " + id));
        return paymentMapping.paymentToDtoGetPayment(payment);
    }

    public Payment createPayment(dtoCreatePayment request) {
        Payment payment = paymentMapping.dtoCreatePaymentToPayment(request);
        return paymentRepository.save(payment);
    }

    public dtoGetPayment updatePayment(int id, dtoUpdatePayment request) {
        Payment existing = paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy thanh toán với ID = " + id));
        paymentMapping.paymentUpdate(existing, request);
        Payment updated = paymentRepository.save(existing);
        return paymentMapping.paymentToDtoGetPayment(updated);
    }

    public void deletePayment(int id) {
        if (!paymentRepository.existsById(id)) {
            throw new RuntimeException("Không tìm thấy thanh toán với ID = " + id);
        }
        paymentRepository.deleteById(id);
    }
}
