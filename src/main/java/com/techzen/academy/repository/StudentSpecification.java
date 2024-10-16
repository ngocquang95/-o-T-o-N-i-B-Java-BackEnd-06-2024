package com.techzen.academy.repository;

import com.techzen.academy.entity.Student;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class StudentSpecification {

    // Tìm sinh viên theo tên
    public static Specification<Student> hasName(String name) {
        return (Root<Student> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> {
            if (name == null || name.isEmpty()) {
                return builder.conjunction(); // Không có điều kiện
            }
            return builder.like(root.get("name"), "%" + name + "%");
        };
    }

    // Tìm sinh viên có điểm >= minScore
    public static Specification<Student> hasMinScore(Double minScore) {
        return (Root<Student> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> {
            if (minScore == null) {
                return builder.conjunction(); // Không có điều kiện
            }
            return builder.greaterThanOrEqualTo(root.get("score"), minScore);
        };
    }

    // Tìm sinh viên có điểm <= maxScore
    public static Specification<Student> hasMaxScore(Double maxScore) {
        return (Root<Student> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> {
            if (maxScore == null) {
                return builder.conjunction(); // Không có điều kiện
            }
            return builder.lessThanOrEqualTo(root.get("score"), maxScore);
        };
    }
}