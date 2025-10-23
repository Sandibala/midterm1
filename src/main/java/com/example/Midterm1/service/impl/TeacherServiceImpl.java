package com.example.Midterm1.service.impl;
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
    private final  TeacherMapper teacherMapper;

    @Override
    public List<TeacherDto> getTeachers() {
        return teacherMapper.toDtoList(teacherRepository.findAll());

    }

    @Override
    public TeacherDto getById(Long id) {
     return teacherMapper.toDto(teacherRepository.findById(id).orElse(null));
    }

    @Override
    public TeacherDto addTeacher(TeacherDto teacherDto) {
            return teacherMapper.toDto(teacherRepository.save(teacherMapper.toEntity(teacherDto)));
    }

    @Override
    public TeacherDto updateTeacher(Long id, TeacherDto teacherDto) {
       Teacher teacher = teacherRepository.findById(id).orElse(null);
       teacher.setName(teacherDto.getName());
       teacher.setName(teacherDto.getLastName());

       return  teacherMapper.toDto(teacherRepository.save(teacher));
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
