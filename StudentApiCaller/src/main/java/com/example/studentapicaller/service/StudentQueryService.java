package com.example.studentapicaller.service;

import com.example.studentapicaller.response.Student;

import java.util.List;

public interface StudentQueryService {
    List<Student> getStudentByLastName(String lastName);
}
