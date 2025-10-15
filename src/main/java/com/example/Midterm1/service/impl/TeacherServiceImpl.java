package com.example.Midterm1.service.impl;

import com.example.Midterm1.dto.StudentDto;
import com.example.Midterm1.dto.TeacherDto;
import com.example.Midterm1.mapper.TeacherMapper;
import com.example.Midterm1.models.Teacher;
import com.example.Midterm1.repositories.TeacherRepository;
import com.example.Midterm1.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Service
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;

    @Override
    public List<StudentDto> getTeachers() {
        return (List<StudentDto>) teacherMapper.toDto(teacherRepository.findAll());

    }

    @Override
    public Teacher getById(Long id) {
     return teacherMapper.toDto(teacherRepository.findById(id).orElse(null));
    }

    @Override
    public void addTeacher(TeacherDto teacherDto) {

    }

    @Override
    public void updateTeacher(Long id, TeacherDto teacherDto) {
       Teacher teacher = teacherRepository.findById(id).orElse(null);
       teacher.setName(teacherDto.getName());
       teacher.setName(teacherDto.getLastName());
    }

    @Override
    public boolean deleteTeacher(Long id) {
        Teacher teacher = teacherRepository.findById(id).orElse(null);
        if(Objects.isNull(teacher)){
            return false;
        }else{
            return true;
        }
    }
}
