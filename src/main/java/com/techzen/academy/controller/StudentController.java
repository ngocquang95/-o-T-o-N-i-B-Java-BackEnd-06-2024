package com.techzen.academy.controller;

import com.techzen.academy.dto.ApiResponse;
import com.techzen.academy.dto.clazz.ClazzResponse;
import com.techzen.academy.dto.student.StudentRequest;
import com.techzen.academy.dto.student.StudentResponse;
import com.techzen.academy.exception.ApiException;
import com.techzen.academy.exception.ErrorCode;
import com.techzen.academy.entity.Student;
import com.techzen.academy.mapper.IStudentMapper;
import com.techzen.academy.service.IStudentService;
import com.techzen.academy.util.JsonResponse;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/students")
@Scope("singleton") // Mỗi request sẽ tạo một Bean
// singleton Mặc định
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
//@Validated
public class StudentController { // Bean
    //    @Autowired
    IStudentService studentService;
    IStudentMapper studentMapper;
//    @Autowired
//    public void setStudentService(IStudentService studentService) {
//        this.studentService = studentService;
//    }

//    public StudentController(IStudentService studentService) {
//        this.studentService = studentService;
//    }

    @GetMapping
    public ResponseEntity<?> getByName(
            @RequestParam(defaultValue = "") String name,
            Double minScore,
            Double maxScore,
            @PageableDefault(size = 2) Pageable pageable) {
        return JsonResponse.ok(
                studentService.findByName(name, minScore, maxScore, pageable)
                        .map(studentMapper::studentToStudentResponse)
        );
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
    public ResponseEntity<ApiResponse<StudentResponse>> getById(@PathVariable("id") UUID id) {
        return studentService.findById(id)
                .map(s -> JsonResponse.ok(
                        studentMapper.studentToStudentResponse(s))
                )
                .orElseThrow(() -> new ApiException(ErrorCode.EMPLOYEE_NOT_EXIST)); // Service
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody StudentRequest studentRequest) {
        Student student = studentMapper.studentRequestToStudent(studentRequest);
        studentService.save(student);
        return JsonResponse.created(studentMapper.studentToStudentResponse(student));
    }
}
