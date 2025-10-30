package com.learning.lvtn_backend.reponsitory;

import com.learning.lvtn_backend.entity.LessonListening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonListeningRepository extends JpaRepository<LessonListening, Integer> {

}
