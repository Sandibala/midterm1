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
    public StudentDto getById(Long id) {
   return studentMapper.toDto(studentRepository.findById(id).orElse(null));
    }

    @Override
    public StudentDto addStudent(StudentDto studentDto) {
        return studentMapper.toDto(studentRepository.save(studentMapper.toEntity(studentDto)));
    }


    @Override
    public StudentDto updateStudent(Long id, StudentDto studentDto) {
        Student student = studentRepository.findById(id).orElse(null);
        student.setName(studentDto.getNameDto());
        student.setLastName(studentDto.getLastNameDto());
        studentRepository.save(student);
        Student student2 = studentRepository.findById(id).orElse(null);
        return studentMapper.toDto(student2);



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
