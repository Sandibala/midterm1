package com.example.Midterm1.mapper;

import com.example.Midterm1.dto.StudentDto;
import com.example.Midterm1.dto.TeacherDto;
import com.example.Midterm1.models.Student;
import com.example.Midterm1.models.Teacher;

import java.util.List;

public interface TeacherMapper {
    Teacher toDto(Teacher teacher);
    Teacher toEntity(TeacherDto teacherDto);

    List<Teacher> toEntityList(List<TeacherDto> teacherDtos);
    List<TeacherDto> toDtoList(List<Teacher> teachers);
}
