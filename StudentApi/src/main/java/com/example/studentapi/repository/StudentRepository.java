package com.example.studentapi.repository;

import com.example.studentapi.entity.StudentEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface StudentRepository extends MongoRepository<StudentEntity, String> {
    List<StudentEntity> findAllByLastNameIgnoreCase(String lastName);
}
