package com.example.studentapi.service;

import com.example.studentapi.entity.StudentEntity;
import com.example.studentapi.pojo.Student;
import com.example.studentapi.pojo.StudentPageInfo;
import com.example.studentapi.repository.StudentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student registerStudent(Student newStudent) {
        StudentEntity entity = new StudentEntity();
        BeanUtils.copyProperties(newStudent, entity);
        StudentEntity savedEntity = studentRepository.save(entity);

        Student student = Student.builder().id(savedEntity.getId()).lastName(savedEntity.getLastName()).firstName(savedEntity.getFirstName() ).build();

        return student;
    }

    @Override
    public Student getStudentById(String id) {
        StudentEntity entity = studentRepository.findById(id).orElseThrow();
        Student student = new Student();
        BeanUtils.copyProperties(entity, student);

        return student;
    }

    @Override
    public void deleteStudentById(String id) {
        studentRepository.deleteById(id);
    }

    @Override
    public List<Student> getStudentByLastName(String lastName) {
        List<StudentEntity> entities = studentRepository.findAllByLastNameIgnoreCase(lastName);
        List<Student> list = new ArrayList<>();
        for (StudentEntity entity : entities) {
            Student student = new Student();
            BeanUtils.copyProperties(entity, student);
            list.add(student);
        }

        return list;
    }

    @Override
    public StudentPageInfo getStudentByPage(int pageNo, int rows) {
        PageRequest pageRequest =  PageRequest.of(pageNo, rows);
        Page<StudentEntity> pageInfo = studentRepository.findAll(pageRequest);
        List<StudentEntity> entities = pageInfo.getContent();

        List<Student> list = new ArrayList<>();
        for (StudentEntity entity : entities) {
            Student student = new Student();
            BeanUtils.copyProperties(entity, student);
            list.add(student);
        }

        StudentPageInfo studentPageInfo = new StudentPageInfo();
        studentPageInfo.setCurrentPage(pageNo);
        studentPageInfo.setRowsPerPage(rows);
        studentPageInfo.setTotalPages(pageInfo.getTotalPages());
        studentPageInfo.setTotalElements(pageInfo.getTotalElements());
        studentPageInfo.setData(list);

        return studentPageInfo;
    }
}
