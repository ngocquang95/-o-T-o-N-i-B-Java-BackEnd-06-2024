package com.techzen.academy.service.impl;

import com.techzen.academy.entity.Student;
import com.techzen.academy.repository.impl.StudentRepository;
import com.techzen.academy.service.IStudentService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
//@Primary
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StudentService2 implements IStudentService {
    StudentRepository studentRepository = new StudentRepository();

    public List<Student> findByName(String name) {
        return null;
    }

    public Optional<Student> findById(UUID id) {
        return studentRepository.findById(id);
    }

    // CRUD
    public Student save(Student student) {
        return studentRepository.save(student);
    }
}
