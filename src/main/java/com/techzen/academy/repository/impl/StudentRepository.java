package com.techzen.academy.repository.impl;

import com.techzen.academy.controller.Student;
import com.techzen.academy.repository.IStudentRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class StudentRepository implements IStudentRepository {
    private List<Student> students = new ArrayList<>(
            Arrays.asList(
                    new Student(UUID.randomUUID(), "Thắng", 6.0),
                    new Student(UUID.randomUUID(), "A.Tuấn", 3.0),
                    new Student(UUID.randomUUID(), "Vi", 5.0)
            )
    ); // Model nhỏ

    public List<Student> findAll() {
        return students;
    }

    public Optional<Student> findById(UUID id) {
        return students.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst();
    }

    // CRUD
    public Student save(Student student) {
        student.setId(UUID.randomUUID());
        students.add(student);

        return student;
    }
}
