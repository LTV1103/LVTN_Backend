package com.learning.lvtn_backend.reponsitory;

import com.learning.lvtn_backend.entity.LearningProgress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LearningProgressRepository extends JpaRepository<LearningProgress, Integer> {
}
