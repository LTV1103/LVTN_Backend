package com.learning.be_english_course.Repository;

import com.learning.be_english_course.Entity.User_vocabulary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserVocabularyRepository extends JpaRepository<User_vocabulary, Long> {
}
