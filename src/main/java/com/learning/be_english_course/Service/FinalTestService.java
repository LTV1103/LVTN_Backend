package com.learning.be_english_course.Service;

import com.learning.be_english_course.DTO.request.final_test.dtoCreateTest;
import com.learning.be_english_course.DTO.request.final_test.dtoUpdateTest;
import com.learning.be_english_course.Entity.Final_test;
import com.learning.be_english_course.Mapper.EntityMapping;
import com.learning.be_english_course.Repository.FinalTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinalTestService {
    @Autowired
    private FinalTestRepository finaltestrepository;

    @Autowired
    private EntityMapping entityMapping;

    // Lấy tất cả Final_test
    public List<Final_test> findAll() {
        return finaltestrepository.findAll();
    }

    // Tìm theo id
    public Final_test findById(Long id) {
        return finaltestrepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy bài kiểm tra với id = " + id));
    }


    // Tạo mới Final_test
    public Final_test createFinalTest(dtoCreateTest request) {
        Final_test finalTest = entityMapping.DTOtoCreateTest(request);
        return finaltestrepository.save(finalTest);
    }

    // Cập nhật Final_test
    public Final_test updateFinalTest(Long id, dtoUpdateTest request) {
        Final_test finalTest = finaltestrepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy bài kiểm tra với id = " + id));
        entityMapping.DTOtoUpdateTest(finalTest, request);
        return finaltestrepository.save(finalTest);
    }

    // Xóa Final_test
    public void deleteFinalTest(Long id) {
        if (!finaltestrepository.existsById(id)) {
            throw new RuntimeException("Không thể xóa vì không tồn tại id = " + id);
        }
        finaltestrepository.deleteById(id);
    }

}
