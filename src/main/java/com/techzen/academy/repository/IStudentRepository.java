package com.techzen.academy.repository;

import com.techzen.academy.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface IStudentRepository extends JpaRepository<Student, UUID> {
    // Tìm theo điem
    // List<Student> findByNameContainingAndScoreBetween(String name, Double minScore, Double maxScore);
//    @Query("from Student s where s.name like concat('%', :name, '%')" +
//            " and (:minScore is null or s.score >= :minScore)" +
//            " and (:maxScore is null or s.score <= :maxScore)")
//    List<Student> findByAttr(@Param("name") String name,
//                             @Param("minScore") Double minScore,
//                             @Param("maxScore") Double maxScore);

    @Query(value = "select * from student s where s.namE like concat('%', :name, '%')" +
            " and (:minScore is null or s.score >= :minScore)" +
            " and (:maxScore is null or s.score <= :maxScore)", nativeQuery = true)
    Page<List<Student>> findByAttr(@Param("name") String name,
                                   @Param("minScore") Double minScore,
                                   @Param("maxScore") Double maxScore, Pageable pageable);
}
