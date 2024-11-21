package com.API.examregister.Dto;

import java.util.List;

import com.API.examregister.Entites.Student;

import lombok.Data;

@Data
public class SubjectDto {
    private String Name;
    private List<Student> RegisterStudent;
}
