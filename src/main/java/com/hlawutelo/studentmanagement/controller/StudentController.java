package com.hlawutelo.studentmanagement.controller;

import com.hlawutelo.studentmanagement.model.Student;
import com.hlawutelo.studentmanagement.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String viewStudents(Model model) {
        model.addAttribute("students", service.getAllStudents());
        model.addAttribute("student", new Student());
        return "students";
    }

    @PostMapping("/students")
    public String addStudent(@ModelAttribute Student student) {
        service.addStudent(student);
        return "redirect:/";
    }

    @GetMapping("/students/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("student", service.getStudentById(id));
        return "edit-student";
    }

    @PostMapping("/students/{id}/update")
    public String updateStudent(@PathVariable Long id, @ModelAttribute Student student) {
        service.updateStudent(id, student);
        return "redirect:/";
    }

    @PostMapping("/students/{id}/delete")
    public String deleteStudent(@PathVariable Long id) {
        service.deleteStudent(id);
        return "redirect:/";
    }
}
