package com.example.Midterm1.mapper;

import com.example.Midterm1.dto.StudentDto;
import com.example.Midterm1.models.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    @Mapping(target = "nameDto", source = "name")
    @Mapping(target = "lastNameDto", source = "lastName")
    StudentDto toDto(Student student);
     Student toEntity(StudentDto studentDto);

     List<Student> toEntityList(List<StudentDto> studentDtos);
      List<StudentDto> toDtoList(List<Student> students);
}
