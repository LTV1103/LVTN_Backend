package com.learning.be_english_course.Service;

import com.learning.be_english_course.DTO.request.lesson_listening.dtoCreateListening;
import com.learning.be_english_course.DTO.request.lesson_listening.dtoUpdateListening;
import com.learning.be_english_course.Entity.Lesson_listening;
import com.learning.be_english_course.Mapper.EntityMapping;
import com.learning.be_english_course.Repository.LessonListeningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class LessonListeningService {

    @Autowired
    private LessonListeningRepository lessonListeningRepository;
    @Autowired
    private CloudinaryService cloudinaryService;
    @Autowired
    private EntityMapping entityMapping;

    // Lấy tất cả Lesson_listening
    public List<Lesson_listening> findAll() {
        return lessonListeningRepository.findAll();
    }
    public List<Lesson_listening> findByLessonId(Long lessonId) {
        return lessonListeningRepository.findByLessonId(lessonId);
    }
    // Tìm theo id
    public Lesson_listening findById(Long id) {
        return lessonListeningRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy bài nghe với id = " + id));
    }

    // Tạo mới Lesson_listening
    public Lesson_listening createLessonListening(dtoCreateListening request)
            throws IOException {

        Lesson_listening lessonListening =
                entityMapping.DTOtoCreateLessonListening(request);

        MultipartFile audio = request.getAudio();
        if (audio != null && !audio.isEmpty()) {
            String audioUrl = cloudinaryService
                    .uploadMp3(audio, "listen/audio")
                    .get("secure_url")
                    .toString();

            lessonListening.setAudioUrl(audioUrl);
        }

        return lessonListeningRepository.save(lessonListening);
    }


    // Cập nhật Lesson_listening
    public Lesson_listening updateLessonListening(Long id, dtoUpdateListening request)
            throws IOException {

        Lesson_listening lessonListening = lessonListeningRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Không tìm thấy bài nghe với id = " + id));

        // map field thường (transcript, etc.)
        entityMapping.DTOtoUpdateLessonListening(lessonListening, request);

        MultipartFile audio = request.getAudio();
        if (audio != null && !audio.isEmpty()) {
            String audioUrl = cloudinaryService
                    .uploadMp3(audio, "listen/audio")
                    .get("secure_url")
                    .toString();

            lessonListening.setAudioUrl(audioUrl);
        }

        return lessonListeningRepository.save(lessonListening);
    }


    // Xóa Lesson_listening
    public void deleteLessonListening(Long id) {
        if (!lessonListeningRepository.existsById(id)) {
            throw new RuntimeException("Không thể xóa vì không tồn tại id = " + id);
        }
        lessonListeningRepository.deleteById(id);
    }

}

