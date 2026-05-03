package com.hlawutelo.studentmanagement.repository;

import com.hlawutelo.studentmanagement.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findByEmail(String email);

    boolean existsByStudentNumber(String studentNumber);
}
