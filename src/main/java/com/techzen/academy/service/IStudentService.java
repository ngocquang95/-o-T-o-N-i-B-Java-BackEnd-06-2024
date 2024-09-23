package com.techzen.academy.service;

import com.techzen.academy.controller.Student;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IStudentService {
     List<Student> findAll();
     Optional<Student> findById(UUID id);
     Student save(Student student);
}
