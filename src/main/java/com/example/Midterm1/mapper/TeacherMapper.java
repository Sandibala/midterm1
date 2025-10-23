package com.example.Midterm1.mapper;
import com.example.Midterm1.dto.TeacherDto;
import com.example.Midterm1.models.Teacher;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TeacherMapper {
    @Mapping(target = "name", source = "name")
    @Mapping(target = "lastName", source = "lastName")
    TeacherDto toDto(Teacher teacher);
    Teacher toEntity(TeacherDto teacherDto);
    List<Teacher> toEntityList(List<TeacherDto> teacherDtoList);
    List<TeacherDto> toDtoList(List<Teacher> teachers);
}
