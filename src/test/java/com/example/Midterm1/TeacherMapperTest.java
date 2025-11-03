package com.example.Midterm1;

import com.example.Midterm1.dto.TeacherDto;
import com.example.Midterm1.mapper.TeacherMapper;
import com.example.Midterm1.models.Teacher;
import org.hibernate.tuple.Tuplizer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class TeacherMapperTest {
    @Autowired
    private TeacherMapper teacherMapper;

    @Test
    void convertEntityToDtoTest(){
        Teacher teacher = Teacher.builder()
                .id(1L)
                .name("Temirlan")
                .lastName("Shoyinbekov")
                .build();

        TeacherDto teacherDto = teacherMapper.toDto(teacher);
        Assertions.assertNotNull(teacherDto);
        Assertions.assertNotNull(teacherDto.getNameDto());
        Assertions.assertNotNull(teacherDto.getLastNameDto());
        Assertions.assertEquals(teacherDto.getNameDto(), teacher.getName());
        Assertions.assertEquals(teacherDto.getLastNameDto(), teacher.getLastName());
    }

    @Test
    void convertDtoToEntityTest(){
        TeacherDto teacherDto = TeacherDto.builder()
                .nameDto("Temirlan")
                .lastNameDto("Shoyinbekov")
                .build();
        Teacher entityTeacher = teacherMapper.toEntity(teacherDto);
        Assertions.assertNotNull(entityTeacher);
        Assertions.assertNotNull(entityTeacher.getName());
        Assertions.assertNotNull(entityTeacher.getLastName());

        Assertions.assertEquals(entityTeacher.getName(), teacherDto.getNameDto());
        Assertions.assertEquals(entityTeacher.getLastName(), entityTeacher.getLastName());
    }

    @Test
    void convertListEntityToDtoList(){
        List<Teacher> entityTeacherList = new ArrayList<>();
        entityTeacherList.add(Teacher.builder()
                .id(1L)
                .name("Timur")
                .lastName("Yeslamgaliyev")
                .build());
        List<TeacherDto> teacherDtosList = teacherMapper.toDtoList(entityTeacherList);
        Assertions.assertNotNull(teacherDtosList);
        Assertions.assertNotEquals(0,teacherDtosList.size());
        Assertions.assertEquals(teacherDtosList.size(), entityTeacherList.size());

        for (int i = 0; i < teacherDtosList.size(); i++) {
            TeacherDto teacherDto = teacherDtosList.get(i);
            Teacher teacher = entityTeacherList.get(i);

            Assertions.assertNotNull(teacherDtosList);
            Assertions.assertNotNull(entityTeacherList);
        }
    }
}
