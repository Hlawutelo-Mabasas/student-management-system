package com.hlawutelo.studentmanagement.service;

import com.hlawutelo.studentmanagement.exception.ResourceNotFoundException;
import com.hlawutelo.studentmanagement.model.Student;
import com.hlawutelo.studentmanagement.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class StudentService {

    private final StudentRepository repository;
    private final Random random = new Random();

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Student getStudentById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));
    }

    public Student addStudent(Student student) {
        cleanStudentDetails(student);

        repository.findByEmail(student.getEmail())
                .ifPresent(existing -> {
                    throw new RuntimeException("Email already exists");
                });

        student.setStudentNumber(generateStudentNumber());

        return repository.save(student);
    }

    public Student updateStudent(Long id, Student updatedStudent) {
        cleanStudentDetails(updatedStudent);

        Student existing = getStudentById(id);

        repository.findByEmail(updatedStudent.getEmail())
                .filter(student -> !student.getId().equals(id))
                .ifPresent(student -> {
                    throw new RuntimeException("Email already exists");
                });

        existing.setName(updatedStudent.getName());
        existing.setEmail(updatedStudent.getEmail());

        return repository.save(existing);
    }

    public void deleteStudent(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Student not found");
        }
        repository.deleteById(id);
    }

    private void cleanStudentDetails(Student student) {
        student.setName(student.getName().trim());
        student.setEmail(student.getEmail().trim().toLowerCase());

        if (student.getName().isBlank() || student.getEmail().isBlank()) {
            throw new RuntimeException("Name and email are required");
        }
    }

    private String generateStudentNumber() {
        String studentNumber;

        do {
            studentNumber = String.valueOf(100000000 + random.nextInt(900000000));
        } while (repository.existsByStudentNumber(studentNumber));

        return studentNumber;
    }
}
