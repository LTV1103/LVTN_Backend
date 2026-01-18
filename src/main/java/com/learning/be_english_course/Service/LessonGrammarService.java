package com.learning.be_english_course.Service;

import com.learning.be_english_course.DTO.request.lesson_grammar.dtoCreateGrammar;
import com.learning.be_english_course.DTO.request.lesson_grammar.dtoUpdateGrammar;
import com.learning.be_english_course.Entity.Lesson_grammar;
import com.learning.be_english_course.Mapper.EntityMapping;
import com.learning.be_english_course.Repository.LessonGrammarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class LessonGrammarService {

    @Autowired
    private LessonGrammarRepository lessonGrammarRepository;
    @Autowired
    private CloudinaryService cloudinaryService;
    @Autowired
    private EntityMapping entityMapping;

    // Lấy tất cả Lesson_grammar
    public List<Lesson_grammar> findAll() {
        return lessonGrammarRepository.findAll();
    }
    public List<Lesson_grammar> findByLessonId(Long lessonId) {
        return lessonGrammarRepository.findByLessonId(lessonId);
    }
    // Tìm theo id
    public Lesson_grammar findById(Long id) {
        return lessonGrammarRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy bài ngữ pháp với id = " + id));
    }

    // Tạo mới Lesson_grammar
    public Lesson_grammar createLessonGrammar(dtoCreateGrammar request)
            throws IOException {

        Lesson_grammar lessonGrammar =
                entityMapping.DTOtoCreateLessonGrammar(request);

        MultipartFile video = request.getVideo();
        if (video != null && !video.isEmpty()) {
            String videoUrl = cloudinaryService
                    .uploadVideo(video, "grammar/video")
                    .get("secure_url")
                    .toString();

            lessonGrammar.setVideoUrl(videoUrl);
        }

        return lessonGrammarRepository.save(lessonGrammar);
    }


    // Cập nhật Lesson_grammar
    public Lesson_grammar updateLessonGrammar(Long id, dtoUpdateGrammar request)
            throws IOException {

        Lesson_grammar lessonGrammar = lessonGrammarRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Không tìm thấy grammar id = " + id));

        entityMapping.DTOtoUpdateLessonGrammar(lessonGrammar, request);

        MultipartFile video = request.getVideo();
        if (video != null && !video.isEmpty()) {
            String videoUrl = cloudinaryService
                    .uploadVideo(video, "grammar/video")
                    .get("secure_url")
                    .toString();

            lessonGrammar.setVideoUrl(videoUrl);
        }

        return lessonGrammarRepository.save(lessonGrammar);
    }


    // Xóa Lesson_grammar
    public void deleteLessonGrammar(Long id) {
        if (!lessonGrammarRepository.existsById(id)) {
            throw new RuntimeException("Không thể xóa vì không tồn tại id = " + id);
        }
        lessonGrammarRepository.deleteById(id);
    }

}

