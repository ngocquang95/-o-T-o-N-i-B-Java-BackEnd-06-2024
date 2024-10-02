package com.techzen.academy.repository.impl;

import com.techzen.academy.model.Student;
import com.techzen.academy.repository.IStudentRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class StudentRepository implements IStudentRepository {
    private List<Student> students = new ArrayList<>(
            Arrays.asList(
                    new Student(UUID.randomUUID(), "Thắng", 6.0),
                    new Student(UUID.randomUUID(), "A.Tuấn", 3.0),
                    new Student(UUID.randomUUID(), "Vi", 5.0)
            )
    ); // Model nhỏ

    public List<Student> findByName(String name) {
        List<Student> studentList = new ArrayList<>();
        try {
            String query = "SELECT id, name, score FROM student WHERE name LIKE CONCAT('%', ?, '%')";
            PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement(query);
            preparedStatement.setString(1, name);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Student student = new Student(
                        UUID.fromString(resultSet.getString("id")),
                        resultSet.getString("name"),
                        resultSet.getDouble("score")
                );
                studentList.add(student);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return studentList;
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
