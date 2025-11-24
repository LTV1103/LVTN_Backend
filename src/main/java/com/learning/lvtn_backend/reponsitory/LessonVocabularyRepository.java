package com.learning.lvtn_backend.reponsitory;

import com.learning.lvtn_backend.entity.LessonVocabulary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonVocabularyRepository extends JpaRepository<LessonVocabulary, Integer> {


}
