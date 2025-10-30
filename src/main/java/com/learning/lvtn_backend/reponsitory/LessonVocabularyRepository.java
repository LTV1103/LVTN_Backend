package com.learning.lvtn_backend.reponsitory;

import com.learning.lvtn_backend.entity.LessonVocabulary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonVocabularyRepository extends JpaRepository<LessonVocabulary, Integer> {
}
