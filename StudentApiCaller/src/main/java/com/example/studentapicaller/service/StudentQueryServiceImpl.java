package com.example.studentapicaller.service;

import com.example.studentapicaller.response.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class StudentQueryServiceImpl implements StudentQueryService {

    @Override
    public List<Student> getStudentByLastName(String lastName) {
        RestTemplate rt =  new RestTemplate();
        ResponseEntity<List> response = rt.getForEntity("http://localhost:8080/student/lastname?lastName=" + lastName, List.class);
        List<Student> list = response.getBody();

        return list;
    }
}
