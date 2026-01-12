package com.learning.be_english_course.Service;

import com.learning.be_english_course.Entity.URL_VNPay;
import com.learning.be_english_course.Repository.url_vnpayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class url_VnPayService {
    @Autowired
    private url_vnpayRepository repository;

    public URL_VNPay save(String url) {
        URL_VNPay entity = new URL_VNPay();
        entity.setUrl(url);
        return repository.save(entity);
    }
}
