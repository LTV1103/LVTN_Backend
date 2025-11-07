package com.learning.lvtn_backend.service;

import com.learning.lvtn_backend.dto.request.dtoReading.dtoCreateReading;
import com.learning.lvtn_backend.dto.request.dtoReading.dtoUpdateReading;
import com.learning.lvtn_backend.dto.response.dtoReading.dtoGetReading;
import com.learning.lvtn_backend.entity.LessonListening;
import com.learning.lvtn_backend.entity.LessonReading;
import com.learning.lvtn_backend.mapper.MapperEntity;
import com.learning.lvtn_backend.reponsitory.LessonReadingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LessonReadingService {
    @Autowired
    private LessonReadingRepository lessonReadingRepository;
    @Autowired
    private MapperEntity readMapping;

    public List<dtoGetReading> getAllLessonReadings() { return readMapping.listReadingToListDtoGetReading(lessonReadingRepository.findAll()); }

    public dtoGetReading getLessonReadingById(int id) {
        return readMapping.readingToDtoGetReading(lessonReadingRepository.findById(id).orElseThrow(() -> new RuntimeException("Reading not found with ID = " + id)));
    }

    public LessonReading createLessonReading(dtoCreateReading reading) {
        LessonReading lesreading = readMapping.dtoCreateReadingToReading(reading);
        return lessonReadingRepository.save(lesreading); }

    public dtoGetReading updateLessonReading(int id, dtoUpdateReading reading) {
        LessonReading existing = lessonReadingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy"));
        readMapping.readingUpdate(existing,reading);
        LessonReading lessonReading = lessonReadingRepository.save(existing);
        return readMapping.readingToDtoGetReading(lessonReading);
    }

    public void deleteLessonReading(int id) {
        if (!lessonReadingRepository.existsById(id)) throw new RuntimeException("Reading not found with ID = " + id);
        lessonReadingRepository.deleteById(id);
    }
}
