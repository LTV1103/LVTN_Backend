package com.learning.be_english_course.Repository;

import com.learning.be_english_course.DTO.respone.result.dtoResult;
import com.learning.be_english_course.Entity.Final_result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FinalResultRepository extends JpaRepository<Final_result,Long> {
    @Query("""
    SELECT new com.learning.be_english_course.DTO.respone.result.dtoResult(
        ft.testTitle , fr.score , fr.completedAt
        )
     FROM Final_result fr JOIN Final_test ft ON fr.finalTestId = ft.finalTestId
     WHERE fr.userId = :userId
    """)
    List<dtoResult> findByUserId(Long userId);

}
