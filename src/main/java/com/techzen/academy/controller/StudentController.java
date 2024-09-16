package com.techzen.academy.controller;

import com.techzen.academy.dto.ApiResponse;
import com.techzen.academy.exception.ApiException;
import com.techzen.academy.exception.ErrorCode;
import com.techzen.academy.util.JsonResponse;
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
    public ResponseEntity<ApiResponse<List<Student>>> getAll() {
        return JsonResponse.ok(students);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Student>> getById(@PathVariable("id") UUID id) {
        return students.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .map(JsonResponse::ok)
                .orElseThrow(() -> new ApiException(ErrorCode.EMPLOYEE_NOT_EXIST));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Student>> create(@RequestBody Student student) {
        student.setId(UUID.randomUUID());
        students.add(student);
        return JsonResponse.created(student);
    }
}
