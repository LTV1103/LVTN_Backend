package com.learning.be_english_course.Repository;


import com.learning.be_english_course.DTO.respone.user.dtoGetUser;
import com.learning.be_english_course.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);

}
