package com.example.Midterm1.service;
import com.example.Midterm1.dto.TeacherDto;
import java.util.List;

public interface TeacherService {
    List<TeacherDto> getTeachers();
    TeacherDto getById(Long id);
    TeacherDto updateTeacher(Long id, TeacherDto teacherDto);
    TeacherDto addTeacher(TeacherDto teacherDto);
    boolean deleteTeacher(Long id);
}
