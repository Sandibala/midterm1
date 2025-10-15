package com.example.Midterm1.service;

import com.example.Midterm1.dto.StudentDto;
import com.example.Midterm1.dto.TeacherDto;
import com.example.Midterm1.models.Student;
import com.example.Midterm1.models.Teacher;

import java.util.List;

public interface TeacherService {
    List<StudentDto> getTeachers();
    Teacher getById(Long id);
    void addTeacher(StudentDto studentDto);
    void updateTeacher(Long id, Student student);

    void addTeacher(TeacherDto teacherDto);

    void updateTeacher(Long id, Teacher teacher);

    void updateTeacher(Long id, TeacherDto teacherDto);

    boolean deleteTeacher(Long id);

}
