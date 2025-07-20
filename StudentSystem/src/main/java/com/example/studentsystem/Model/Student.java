package com.example.studentsystem.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Student {
    private String id, name, degree;
    private double gpa;
    private int age;
}
