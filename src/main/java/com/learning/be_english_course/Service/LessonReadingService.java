package com.learning.be_english_course.Service;

import com.learning.be_english_course.DTO.request.lesson_reading.dtoCreateReading;
import com.learning.be_english_course.DTO.request.lesson_reading.dtoUpdateReading;
import com.learning.be_english_course.Entity.Lesson_reading;
import com.learning.be_english_course.Mapper.EntityMapping;
import com.learning.be_english_course.Repository.LessonReadingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonReadingService {
    @Autowired
    private LessonReadingRepository lessonReadingRepository;

    @Autowired
    private EntityMapping entityMapping;

    // Lấy tất cả Lesson_reading
    public List<Lesson_reading> findAll() {
        return lessonReadingRepository.findAll();
    }

    // Tìm theo id
    public Lesson_reading findById(Long id) {
        return lessonReadingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy bài đọc với id = " + id));
    }

    // Tạo mới Lesson_reading
    public Lesson_reading createLessonReading(dtoCreateReading request) {
        Lesson_reading lessonReading = entityMapping.DTOtoCreateLessonReading(request);
        return lessonReadingRepository.save(lessonReading);
    }

    // Cập nhật Lesson_reading
    public Lesson_reading updateLessonReading(Long id, dtoUpdateReading request) {
        Lesson_reading lessonReading = lessonReadingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy bài đọc với id = " + id));
        entityMapping.DTOtoUpdateLessonReading(lessonReading, request);
        return lessonReadingRepository.save(lessonReading);
    }

    // Xóa Lesson_reading
    public void deleteLessonReading(Long id) {
        if (!lessonReadingRepository.existsById(id)) {
            throw new RuntimeException("Không thể xóa vì không tồn tại id = " + id);
        }
        lessonReadingRepository.deleteById(id);
    }

}
