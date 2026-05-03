package com.hlawutelo.studentmanagement.config;

import com.hlawutelo.studentmanagement.model.Student;
import com.hlawutelo.studentmanagement.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final StudentRepository repository;

    public DataInitializer(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) {
        String studentNumber = "222223219";

        if (!repository.existsByStudentNumber(studentNumber)) {
            Student student = new Student("Mabasa Hlawutelo", "mabasas.hlawutelo@gmail.com");
            student.setStudentNumber(studentNumber);
            repository.save(student);
        }
    }
}
