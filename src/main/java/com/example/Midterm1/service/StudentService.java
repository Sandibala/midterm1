package com.example.Midterm1.service;

import com.example.Midterm1.dto.StudentDto;
import com.example.Midterm1.models.Student;

import java.util.List;

public interface StudentService {
    List<StudentDto> getStudents();
    void getById(Long id);
    void addStudent(StudentDto studentDto);
    void updateStudent(Long id, Student student);

    void updateStudent(Long id, StudentDto studentDto);

    boolean deleteStudent(Long id);
}
