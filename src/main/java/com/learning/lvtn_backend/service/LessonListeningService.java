package com.learning.lvtn_backend.service;

import com.learning.lvtn_backend.dto.request.dtoListening.dtoCreateListening;
import com.learning.lvtn_backend.dto.request.dtoListening.dtoUpdateListening;
import com.learning.lvtn_backend.dto.response.dtoListening.dtoGetListening;
import com.learning.lvtn_backend.entity.LessonListening;
import com.learning.lvtn_backend.mapper.MapperEntity;
import com.learning.lvtn_backend.reponsitory.LessonListeningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LessonListeningService {
    @Autowired
    private LessonListeningRepository lessonListeningRepository;
    @Autowired
    private MapperEntity listeningMapping;

    public List<dtoGetListening> getAllLessonListenings() { return listeningMapping.listListeningToListDtoGetListening(lessonListeningRepository.findAll());  }

    public dtoGetListening getLessonListeningById(int id) {
        return listeningMapping.listeningToDtoGetListening(lessonListeningRepository.findById(id).orElseThrow(() -> new RuntimeException("Listening not found with ID = " + id)));
    }

    public LessonListening createLessonListening(dtoCreateListening listening) {
        LessonListening lessonListening = listeningMapping.dtoCreateListeningToListening(listening);
        return lessonListeningRepository.save(lessonListening);
    }

    public dtoGetListening updateLessonListening(int id, dtoUpdateListening lessonListening) {
        LessonListening existing = lessonListeningRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy bài nghe với ID = " + id));
        listeningMapping.listeningUpdate(existing,lessonListening);
        LessonListening listening = lessonListeningRepository.save(existing);
        return listeningMapping.listeningToDtoGetListening(listening);
    }

    public void deleteLessonListening(int id) {
        if (!lessonListeningRepository.existsById(id)) throw new RuntimeException("Listening not found with ID = " + id);
        lessonListeningRepository.deleteById(id);
    }
}
