package com.learning.lvtn_backend.reponsitory;

import com.learning.lvtn_backend.entity.TestResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestResultRepository  extends JpaRepository<TestResult, Integer> {

}
