package com.techzen.academy.service.impl;

import com.techzen.academy.entity.Student;
import com.techzen.academy.repository.IStudentRepository;
import com.techzen.academy.service.IStudentService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StudentService implements IStudentService {
    IStudentRepository studentRepository;

    public Page<List<Student>> findByName(String name, Double minScore, Double maxScore, Pageable pageable) {
        return studentRepository.findByAttr(name, minScore, maxScore, pageable);
    }

    public Optional<Student> findById(UUID id) {
        return studentRepository.findById(id);
    }

    // CRUD
    public Student save(Student student) {
        return studentRepository.save(student);
    }
}
