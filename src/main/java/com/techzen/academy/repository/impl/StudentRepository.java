package com.techzen.academy.repository.impl;

import com.techzen.academy.entity.Student;
import com.techzen.academy.repository.IStudentRepository;
import org.hibernate.Session;
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
        Session session = ConnectionUtil.sessionFactory.openSession(); // Bước 1: Mở phiên làm việc (Session) từ ConnectionUtil
        List<Student> students = null;
        try {
            students = session.createQuery("FROM Student WHERE name LIKE CONCAT('%', :name, '%')")
                    .setParameter("name", name).getResultList(); // Bước 2: Sử dụng HQL để lấy danh sách sinh viên
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close(); // Bước 3: Đóng phiên làm việc sau khi lấy danh sách xong
        }
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
