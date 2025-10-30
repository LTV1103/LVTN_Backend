package com.learning.lvtn_backend.reponsitory;

import com.learning.lvtn_backend.entity.LessonGrammar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonGrammarRepository extends JpaRepository<LessonGrammar, Integer> {
}
