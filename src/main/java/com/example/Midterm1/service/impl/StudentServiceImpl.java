package com.example.Midterm1.service.impl;

import com.example.Midterm1.dto.StudentDto;
import com.example.Midterm1.mapper.StudentMapper;
import com.example.Midterm1.models.Student;
import com.example.Midterm1.repositories.StudentRepository;
import com.example.Midterm1.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    @Override
    public List<StudentDto> getStudents() {
        return studentMapper.toDtoList( studentRepository.findAll());
    }

    @Override
    public void getById(Long id) {

    }

    @Override
    public void addStudent(StudentDto studentDto) {

    }

    @Override
    public void updateStudent(Long id, StudentDto studentDto) {
        Student student = studentRepository.findById(id).orElse(null);
        student.setName(studentDto.getName());
        student.setLastName(studentDto.getLastName());
        studentRepository.save(student);

    }

    @Override
    public boolean deleteStudent(Long id) {
        Student student = studentRepository.findById(id).orElse(null);
        if(Objects.isNull(student)){
            return false;
        }else{
            return true;
        }
    }
}
