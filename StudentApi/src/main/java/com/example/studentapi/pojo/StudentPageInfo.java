package com.example.studentapi.pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StudentPageInfo {
    private int totalPages;
    private long totalElements;
    private int currentPage;
    private int rowsPerPage;
    private List<Student> data;
}
