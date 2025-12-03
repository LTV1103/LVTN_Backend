package com.learning.be_english_course.Repository;

import com.learning.be_english_course.DTO.respone.user_vocabulary.dtoGetSaveVocabulary;
import com.learning.be_english_course.Entity.User_vocabulary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserVocabularyRepository extends JpaRepository<User_vocabulary, Long> {
    @Query("""
    SELECT new com.learning.be_english_course.DTO.respone.user_vocabulary.dtoGetSaveVocabulary (
       uv.saveId , lv.word , lv.meaning , lv.pronunciation , lv.audioUrl , uv.savedAt
    )
    FROM User_vocabulary uv
    JOIN Lesson_vocabulary lv ON uv.vocabularyId = lv.vocabularyId
    WHERE uv.userId = :userId
    """)
    List<dtoGetSaveVocabulary> saveVocabulary (long userId);
}
