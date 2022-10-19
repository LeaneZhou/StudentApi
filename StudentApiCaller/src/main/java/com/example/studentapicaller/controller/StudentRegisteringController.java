package com.example.studentapicaller.controller;

import com.example.studentapicaller.response.Student;
import com.example.studentapicaller.service.StudentQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentRegisteringController {

    private StudentQueryService studentQueryService;

    @Autowired
    public StudentRegisteringController(StudentQueryService studentQueryService) {
        this.studentQueryService = studentQueryService;
    }

    @GetMapping("/student")
    public List<Student> getStudentByLastName(@RequestParam String lastName) {
        return studentQueryService.getStudentByLastName(lastName);
    }
}
