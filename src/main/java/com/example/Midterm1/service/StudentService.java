package com.example.Midterm1.service;
import com.example.Midterm1.dto.StudentDto;
import java.util.List;

public interface StudentService {
    List<StudentDto> getStudents();
    StudentDto getById(Long id);
    StudentDto addStudent(StudentDto studentDto);
    StudentDto updateStudent(Long id, StudentDto studentDto);
    boolean deleteStudent(Long id);
}
