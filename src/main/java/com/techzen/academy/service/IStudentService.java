package com.techzen.academy.service;

import com.techzen.academy.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IStudentService {
    Page<Student> findByName(String name, Double minScore, Double maxScore, Pageable pageable);

    Optional<Student> findById(UUID id);

    Student save(Student student);
}
