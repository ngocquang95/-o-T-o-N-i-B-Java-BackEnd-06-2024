package com.techzen.academy.repository;

import com.techzen.academy.entity.Student;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IStudentRepository {
     List<Student> findByName(String name);
     Optional<Student> findById(UUID id);
     Student save(Student student);
}
