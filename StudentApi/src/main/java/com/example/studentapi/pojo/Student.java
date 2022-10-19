package com.example.studentapi.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private String id;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
}
