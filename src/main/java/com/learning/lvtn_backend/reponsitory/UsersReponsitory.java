package com.learning.lvtn_backend.reponsitory;

import com.learning.lvtn_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface UsersReponsitory extends JpaRepository<User, Integer> {
   boolean existsByUsername (String username);
   Optional<User> findByUsername(String username);
   Optional<User> findByEmail(String email);
}
