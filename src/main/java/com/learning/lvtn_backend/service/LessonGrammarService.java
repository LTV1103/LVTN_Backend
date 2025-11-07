package com.learning.lvtn_backend.service;

import com.learning.lvtn_backend.dto.request.dtoGrammar.dtoCreateGrammar;
import com.learning.lvtn_backend.dto.request.dtoGrammar.dtoUpdateGrammar;
import com.learning.lvtn_backend.dto.response.dtoGrammar.dtoGetGrammar;
import com.learning.lvtn_backend.entity.LessonGrammar;
import com.learning.lvtn_backend.mapper.MapperEntity;
import com.learning.lvtn_backend.reponsitory.LessonGrammarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonGrammarService {

    @Autowired
    private LessonGrammarRepository lessonGrammarRepository;

    @Autowired
    private MapperEntity GrammarMapping;

    public List<dtoGetGrammar> getAllLessonGrammars() {
        List<LessonGrammar> grammarList = lessonGrammarRepository.findAll();
        return GrammarMapping.listGrammarToListDtoGetGrammar(grammarList);
    }

    public dtoGetGrammar getLessonGrammarById(int id) {
        LessonGrammar grammar = lessonGrammarRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy bài học ngữ pháp với ID = " + id));
        return GrammarMapping.grammarToDtoGetGrammar(grammar);
    }

    public LessonGrammar createLessonGrammar(dtoCreateGrammar request) {
        LessonGrammar grammar = GrammarMapping.dtoCreateGrammarToGrammar(request);
         return lessonGrammarRepository.save(grammar);
    }

    public dtoGetGrammar updateLessonGrammar(int id, dtoUpdateGrammar request) {
        LessonGrammar existing = lessonGrammarRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy bài học ngữ pháp với ID = " + id));
        GrammarMapping.grammarUpdate(existing, request);
        LessonGrammar updated = lessonGrammarRepository.save(existing);
        return GrammarMapping.grammarToDtoGetGrammar(updated);
    }

    public void deleteLessonGrammar(int id) {
        if (!lessonGrammarRepository.existsById(id)) {
            throw new RuntimeException("Không tìm thấy bài học ngữ pháp với ID = " + id);
        }
        lessonGrammarRepository.deleteById(id);
    }
}
