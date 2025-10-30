package com.learning.lvtn_backend.reponsitory;

import com.learning.lvtn_backend.entity.LessonReading;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonReadingRepository extends JpaRepository<LessonReading, Integer> {
}
