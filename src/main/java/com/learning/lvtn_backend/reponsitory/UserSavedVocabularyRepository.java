package com.learning.lvtn_backend.reponsitory;

import com.learning.lvtn_backend.entity.UserSavedVocabulary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSavedVocabularyRepository extends JpaRepository<UserSavedVocabulary, Integer> {
}
