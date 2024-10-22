package com.techzen.academy.mapper;

import com.techzen.academy.dto.student.StudentRequest;
import com.techzen.academy.dto.student.StudentResponse;
import com.techzen.academy.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface IStudentMapper {
    @Mappings({
            @Mapping(source = "clazz.name", target = "clazzName")
    })
    StudentResponse studentToStudentResponse(Student student);
    Student studentRequestToStudent(StudentRequest studentRequest);
}
