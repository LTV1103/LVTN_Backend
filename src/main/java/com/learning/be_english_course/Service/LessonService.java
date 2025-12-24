package com.learning.be_english_course.Service;

import com.learning.be_english_course.DTO.request.lesson.dtoCreateLesson;
import com.learning.be_english_course.DTO.request.lesson.dtoUpdateLesson;
import com.learning.be_english_course.DTO.respone.grammar.dtoGrammar;
import com.learning.be_english_course.DTO.respone.lesson.dtoDetailLesson;
import com.learning.be_english_course.DTO.respone.lesson.dtoLesson;
import com.learning.be_english_course.DTO.respone.listening.dtoListening;
import com.learning.be_english_course.DTO.respone.reading.dtoReading;
import com.learning.be_english_course.DTO.respone.vocabulary.dtoVocabulary;
import com.learning.be_english_course.Entity.Lesson;
import com.learning.be_english_course.Entity.Lesson_grammar;
import com.learning.be_english_course.Entity.Lesson_vocabulary;
import com.learning.be_english_course.Mapper.EntityMapping;
import com.learning.be_english_course.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class LessonService {
    @Autowired
    private LessonRepository lessonRepository;
    @Autowired
    private  LessonVocabularyRepository lessonVocabularyRepository;
    @Autowired
    private  LessonGrammarRepository lessonGrammarRepository;
    @Autowired
    private  LessonReadingRepository lessonReadingRepository;
    @Autowired
    private  LessonListeningRepository lessonListeningRepository;


    @Autowired
    private EntityMapping entityMapping;

    // Lấy tất cả Lesson
    public List<dtoLesson> findAll() {
        return lessonRepository.findAllLessons();
    }

    // Tìm theo id
    public Lesson findById(Long id) {
        return lessonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy bài học với id = " + id));
    }
    public List<Lesson> getAllByCourseId(Long courseId) {
        return lessonRepository.findByCourseId(courseId);
    }

    // Tạo mới Lesson
    public Lesson createLesson(dtoCreateLesson request) {
        Lesson lesson = entityMapping.DTOtoCreateLesson(request);
        return lessonRepository.save(lesson);
    }

    // Cập nhật Lesson
    public Lesson updateLesson(Long id, dtoUpdateLesson request) {
        Lesson lesson = lessonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy bài học với id = " + id));
        entityMapping.DTOtoUpdateLesson(lesson, request);
        return lessonRepository.save(lesson);
    }


    // Xóa Lesson
    public void deleteLesson(Long id) {
        if (!lessonRepository.existsById(id)) {
            throw new RuntimeException("Không thể xóa vì không tồn tại id = " + id);
        }
        lessonRepository.deleteById(id);
    }

    //Lay tat ca cac dang bai
    public dtoDetailLesson detailLesson(Long id) {
        Lesson lesson = lessonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Khong tin thay"));

        dtoDetailLesson res = new dtoDetailLesson();
        res.setLessonId(lesson.getLessonId());
        res.setLessonTitle(lesson.getLessonTitle());
        res.setDescription(lesson.getDescription());

        res.setVocabulary(
                lessonVocabularyRepository.findByLessonId(id)
                        .stream()
                        .map(v -> new dtoVocabulary(v.getWord(), v.getMeaning() , v.getExample(), v.getPronunciation(), v.getAudioUrl()))
                        .toList()
        );

        res.setGrammar(
                lessonGrammarRepository.findByLessonId(id)
                        .stream()
                        .map(g -> new dtoGrammar(g.getTitle(), g.getExample() , g.getExplanation()))
                        .toList()
        );

        res.setReading(
                lessonReadingRepository.findByLessonId(id)
                        .stream()
                        .map(r -> new dtoReading(r.getReadingId(),r.getPassage()))
                        .toList()
        );

        res.setListening(
                lessonListeningRepository.findByLessonId(id)
                         .stream()
                        .map(l -> new dtoListening(l.getListeningId(),l.getAudioUrl(), l.getTranscript()))
                        .toList()
        );

        return res;
    }



}
