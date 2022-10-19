package com.example.studentapi.service;

import com.example.studentapi.pojo.Student;
import com.example.studentapi.pojo.StudentPageInfo;

import java.util.List;

public interface StudentService {
    Student registerStudent(Student newStudent);

    Student getStudentById(String id);

    void deleteStudentById(String id);

    List<Student> getStudentByLastName(String lastName);

   StudentPageInfo getStudentByPage(int pageNo, int rows);
}
