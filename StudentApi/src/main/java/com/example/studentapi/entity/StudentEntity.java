package com.example.studentapi.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
public class StudentEntity {
    private String id;
    private String firstName;
    private String lastName;
}
