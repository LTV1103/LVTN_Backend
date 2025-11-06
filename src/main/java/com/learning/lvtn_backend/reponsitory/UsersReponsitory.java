package com.learning.lvtn_backend.reponsitory;

import com.learning.lvtn_backend.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface UsersReponsitory extends JpaRepository<Users, Integer> {
   boolean existsByUsername (String username);
   Optional<Users> findByUsername(String username);
   Optional<Users> findByEmail(String email);
}
