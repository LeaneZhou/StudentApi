package com.example.studentapi.controller;

import com.example.studentapi.pojo.ErrorMsg;
import com.example.studentapi.pojo.Student;
import com.example.studentapi.pojo.StudentPageInfo;
import com.example.studentapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/student")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public Student registerStudent(@Validated @RequestBody Student newStudent) {
        Student student = studentService.registerStudent(newStudent);
        Student s = Student.builder().id("1").lastName("ll").firstName("dfd").build();

        return student;
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable String id) {
         return studentService.getStudentById(id);
    }

    @GetMapping("/lastname")
    public List<Student> getStudentByLastName(@RequestParam String lastName) {
        return studentService.getStudentByLastName(lastName);
    }

    @GetMapping()
    public StudentPageInfo getStudentByPage(@RequestParam int pageNo, int rows) {
        return studentService.getStudentByPage(pageNo, rows);
    }

    @DeleteMapping("/{id}")
    public Student deleteStudentById(@PathVariable String id) {
        Student student = studentService.getStudentById(id);
        studentService.deleteStudentById(id);

        return student;
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ErrorMsg handleNoSuchElt(NoSuchElementException e) {
         return new ErrorMsg("Student not found");
    }
}
