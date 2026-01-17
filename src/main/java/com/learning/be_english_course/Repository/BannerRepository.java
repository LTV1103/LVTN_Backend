package com.learning.be_english_course.Repository;

import com.learning.be_english_course.Entity.Banner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BannerRepository extends JpaRepository<Banner, Integer> {
}
