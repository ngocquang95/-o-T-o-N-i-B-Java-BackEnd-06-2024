package com.techzen.academy.controller;

import com.techzen.academy.dto.ApiResponse;
import com.techzen.academy.exception.ApiException;
import com.techzen.academy.exception.ErrorCode;
import com.techzen.academy.service.IStudentService;
import com.techzen.academy.service.impl.StudentService;
import com.techzen.academy.service.impl.StudentService2;
import com.techzen.academy.util.JsonResponse;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/students")
@Scope("singleton") // Mỗi request sẽ tạo một Bean
// singleton Mặc định
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StudentController { // Bean
//    @Autowired
    IStudentService studentService;
//    @Autowired
//    public void setStudentService(IStudentService studentService) {
//        this.studentService = studentService;
//    }

//    public StudentController(IStudentService studentService) {
//        this.studentService = studentService;
//    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Student>>> getAll() {
        return JsonResponse.ok(studentService.findAll());
    }

//    @GetMapping("/changeBean")
//    public void changeBean(int bean) {
//        if(bean == 1) {
//            studentService = new StudentService();
//        } else {
//            studentService = new StudentService2();
//        }
//    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Student>> getById(@PathVariable("id") UUID id) {
        return studentService.findById(id)
                .map(JsonResponse::ok)
                .orElseThrow(() -> new ApiException(ErrorCode.EMPLOYEE_NOT_EXIST)); // Service
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Student>> create(@RequestBody Student student) {
        studentService.save(student);
        return JsonResponse.created(student);
    }
}
