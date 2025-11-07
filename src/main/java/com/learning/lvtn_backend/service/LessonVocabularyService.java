package com.learning.lvtn_backend.service;

import com.learning.lvtn_backend.dto.request.dtoVocabulary.dtoCreateVocabulary;
import com.learning.lvtn_backend.dto.request.dtoVocabulary.dtoUpdateVocabulary;
import com.learning.lvtn_backend.dto.response.dtoVocabulary.dtoGetVocabulary;
import com.learning.lvtn_backend.entity.LessonVocabulary;
import com.learning.lvtn_backend.mapper.MapperEntity;
import com.learning.lvtn_backend.reponsitory.LessonVocabularyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LessonVocabularyService {
    @Autowired
    private LessonVocabularyRepository lessonVocabularyRepository;
    @Autowired
    private MapperEntity vocabMapping;
    @Autowired
    private MapperEntity mapperEntity;

    public List<dtoGetVocabulary> getAllLessonVocabularies() { return vocabMapping.listVocabularyToListDtoGetVocabulary(lessonVocabularyRepository.findAll()); }

    public dtoGetVocabulary getLessonVocabularyById(int id) {
        return vocabMapping.vocabularyToDtoGetVocabulary(lessonVocabularyRepository.findById(id).orElseThrow(() -> new RuntimeException("Vocab not found with ID = " + id)));
    }

    public LessonVocabulary createLessonVocabulary(dtoCreateVocabulary vocab) {
        LessonVocabulary lesVocabulary = vocabMapping.dtoCreateVocabularyToVocabulary(vocab);
        return lessonVocabularyRepository.save(lesVocabulary); }

    public dtoGetVocabulary updateLessonVocabulary(int id, dtoUpdateVocabulary vocab) {
        LessonVocabulary existing = lessonVocabularyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy = " + id));
        vocabMapping.vocabularyUpdate(existing, vocab);
        LessonVocabulary lesVocab = lessonVocabularyRepository.save(existing);
        return mapperEntity.vocabularyToDtoGetVocabulary(lesVocab);
    }

    public void deleteLessonVocabulary(int id) {
        if (!lessonVocabularyRepository.existsById(id)) throw new RuntimeException("Vocab not found with ID = " + id);
        lessonVocabularyRepository.deleteById(id);
    }
}
