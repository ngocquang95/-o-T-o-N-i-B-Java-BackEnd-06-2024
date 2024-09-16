package com.techzen.academy.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/students")
public class StudentController {
    private List<Student> students = new ArrayList<>(
            Arrays.asList(
                    new Student(UUID.randomUUID(), "Thắng", 6.0),
                    new Student(UUID.randomUUID(), "A.Tuấn", 3.0),
                    new Student(UUID.randomUUID(), "Vi", 5.0)
            )
    );

    @GetMapping
    public ResponseEntity<List<Student>> getAll() {
        return ResponseEntity.ok(students);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getById(@PathVariable("id") Integer id) {
        return students.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Student> create(@RequestBody Student student) {
        student.setId(UUID.randomUUID());
        students.add(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }
}
