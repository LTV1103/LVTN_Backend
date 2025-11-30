package com.learning.be_english_course.Service;

import com.learning.be_english_course.DTO.request.final_result.dtoCreateResult;
import com.learning.be_english_course.DTO.request.final_result.dtoUpdateResult;
import com.learning.be_english_course.Entity.Final_result;
import com.learning.be_english_course.Mapper.EntityMapping;
import com.learning.be_english_course.Repository.FinalResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinalResultService {
    @Autowired
    private FinalResultRepository finalResultRepository;

    @Autowired
    private EntityMapping entityMapping;

    // Lấy tất cả Final_result
    public List<Final_result> findAll() {
        return finalResultRepository.findAll();
    }

    // Tìm theo id
    public Final_result findById(Long id) {
        return finalResultRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy kết quả với id = " + id));
    }

    // Tạo mới Final_result
    public Final_result createFinalResult(dtoCreateResult request) {
        Final_result result = entityMapping.DTOtoCreateTestResult(request);
        return finalResultRepository.save(result);
    }

    // Cập nhật Final_result
    public Final_result updateFinalResult(Long id, dtoUpdateResult request) {
        Final_result result = finalResultRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy kết quả với id = " + id));
        entityMapping.DTOtoUpdateTestResult(result, request);
        return finalResultRepository.save(result);
    }

    // Xóa Final_result
    public void deleteFinalResult(Long id) {
        if (!finalResultRepository.existsById(id)) {
            throw new RuntimeException("Không thể xóa vì không tồn tại id = " + id);
        }
        finalResultRepository.deleteById(id);
    }

}
