package com.iitu.webdev.student_info_app.controller;

import com.iitu.webdev.studentinfoapp.model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    // In-memory storage (will be replaced with database later)
    private Map<String, Student> students = new HashMap<>();

    // Initialize with sample data
    public StudentController() {
        students.put("S001",
                new Student("S001", "Alice Johnson",
                        "alice@iitu.edu.kz", "Computer Science"));

        students.put("S002",
                new Student("S002", "Bob Smith",
                        "bob@iitu.edu.kz", "Software Engineering"));
    }

    // GET /students - Get all students
    @GetMapping
    public List<Student> getAllStudents() {
        return new ArrayList<>(students.values());
    }

    // GET /students/{id} - Get student by ID
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable String id) {
        return students.get(id);
    }

    // POST /students - Create new student
    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        students.put(student.getId(), student);
        return student;
    }

    // GET /students/health - Health check endpoint
    @GetMapping("/health")
    public String health() {
        return "Student API is running!";
    }
}

