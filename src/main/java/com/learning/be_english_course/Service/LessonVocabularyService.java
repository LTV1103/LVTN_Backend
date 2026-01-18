package com.learning.be_english_course.Service;

import com.learning.be_english_course.DTO.request.lesson_vocabulary.dtoCreateVocabulary;
import com.learning.be_english_course.DTO.request.lesson_vocabulary.dtoUpdateVocabulary;
import com.learning.be_english_course.Entity.Lesson_vocabulary;
import com.learning.be_english_course.Mapper.EntityMapping;
import com.learning.be_english_course.Repository.LessonVocabularyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class LessonVocabularyService {
    @Autowired
    private LessonVocabularyRepository lessonVocabularyRepository;
    @Autowired
    private CloudinaryService cloudinaryService;
    @Autowired
    private EntityMapping entityMapping;

    // Lấy tất cả Lesson_vocabulary
    public List<Lesson_vocabulary> findAll() {
        return lessonVocabularyRepository.findAll();
    }

    public List<Lesson_vocabulary> findByLessonId(Long lessonId) {
        return lessonVocabularyRepository.findByLessonId(lessonId);
    }

    // Tìm theo id
    public Lesson_vocabulary findById(Long id) {
        return lessonVocabularyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy bài từ vựng với id = " + id));
    }

    // Tạo mới Lesson_vocabulary
    public Lesson_vocabulary createLessonVocabulary(dtoCreateVocabulary request) throws IOException {
        Lesson_vocabulary lessonVocabulary =
                entityMapping.DTOtoCreateLessonVocabulary(request);

        // Upload image
        if (request.getImage() != null && !request.getImage().isEmpty()) {
            String imgUrl = cloudinaryService
                    .uploadFile(request.getImage(), "vocabulary/images")
                    .get("secure_url")
                    .toString();
            lessonVocabulary.setImgUrl(imgUrl);
        }

        // Upload audio
        if (request.getAudio() != null && !request.getAudio().isEmpty()) {
            String audioUrl = cloudinaryService
                    .uploadMp3(request.getAudio(), "vocabulary/audio")
                    .get("secure_url")
                    .toString();
            lessonVocabulary.setAudioUrl(audioUrl);
        }

        return lessonVocabularyRepository.save(lessonVocabulary);
    }


    // Cập nhật Lesson_vocabulary
    public Lesson_vocabulary updateLessonVocabulary(Long id, dtoUpdateVocabulary request) throws IOException {
        Lesson_vocabulary lessonVocabulary = lessonVocabularyRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Không tìm thấy bài từ vựng với id = " + id));

        entityMapping.DTOtoUpdateLessonVocabulary(lessonVocabulary, request);

        // Update image nếu có
        if (request.getImage() != null && !request.getImage().isEmpty()) {
            String imgUrl = cloudinaryService
                    .uploadFile(request.getImage(), "vocabulary/images")
                    .get("secure_url")
                    .toString();
            lessonVocabulary.setImgUrl(imgUrl);
        }

        // Update audio nếu có
        if (request.getAudio() != null && !request.getAudio().isEmpty()) {
            String audioUrl = cloudinaryService
                    .uploadMp3(request.getAudio(), "vocabulary/audio")
                    .get("secure_url")
                    .toString();
            lessonVocabulary.setAudioUrl(audioUrl);
        }

        return lessonVocabularyRepository.save(lessonVocabulary);
    }


    // Xóa Lesson_vocabulary
    public void deleteLessonVocabulary(Long id) {
        if (!lessonVocabularyRepository.existsById(id)) {
            throw new RuntimeException("Không thể xóa vì không tồn tại id = " + id);
        }
        lessonVocabularyRepository.deleteById(id);
    }

}

