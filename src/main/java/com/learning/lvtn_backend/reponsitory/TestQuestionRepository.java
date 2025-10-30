package com.learning.lvtn_backend.reponsitory;

import com.learning.lvtn_backend.entity.TestQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestQuestionRepository extends JpaRepository<TestQuestion, Integer> {
}
