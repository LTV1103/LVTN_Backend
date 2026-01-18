package com.learning.be_english_course.Service;
import com.learning.be_english_course.Entity.Course;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class CourseFilter {
    public static Specification<Course> filter(
            String courseName,
            String level,
            String keyword,
            Long price
    ) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (keyword != null && !keyword.isBlank()) {
                predicates.add(
                        cb.like(
                                cb.lower(root.get("courseName")),
                                "%" + keyword.toLowerCase() + "%"
                        )
                );
            }
            if (price != null && price > 0) {
                predicates.add(cb.greaterThanOrEqualTo(root.get("price"), price));
            }
            if (courseName != null && !courseName.isBlank()) {
                predicates.add(cb.like(cb.lower(root.get("courseName")),"%" + courseName.toLowerCase() + "%"));
            }
            if (level != null && !level.isBlank()) {
                predicates.add(
                        cb.equal(root.get("level"), level)
                );
            }


            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
