package com.example.Midterm1;

import com.example.Midterm1.dto.StudentDto;
import com.example.Midterm1.mapper.StudentMapper;
import com.example.Midterm1.models.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class StudentMapperTest {
    @Autowired
    private StudentMapper studentMapper;

    @Test
    void convertEntityToDtoTest() {
        Student student = Student.builder()
                .id(1L)
                .name("daun")
                .lastName("daunov")
                .build();

        StudentDto studentDto = studentMapper.toDto(student);
        Assertions.assertNotNull(studentDto);
        Assertions.assertNotNull(studentDto.getNameDto());
        Assertions.assertNotNull(studentDto.getLastNameDto());

        Assertions.assertEquals(student.getName(), studentDto.getNameDto());
        Assertions.assertEquals(student.getLastName(), studentDto.getLastNameDto());
    }

    @Test
    void convertDtoToEntityTest() {
        StudentDto studentDto = StudentDto.builder()
                .nameDto("Islam")
                .lastNameDto("Sultanyly")
                .build();

        Student entityStudent = studentMapper.toEntity(studentDto);
        Assertions.assertNotNull(entityStudent);
        Assertions.assertNotNull(entityStudent.getName());
        Assertions.assertNotNull(entityStudent.getLastName());

        Assertions.assertEquals(studentDto.getNameDto(), entityStudent.getName());
        Assertions.assertEquals(studentDto.getLastNameDto(), entityStudent.getLastName());
    }

    @Test
    void convertListEntityToDtoList() {
        List<Student> studentEntityList = new ArrayList<>();
        studentEntityList.add(Student.builder()
                .id(1L)
                .name("test1")
                .lastName("testov1")
                .build());

        studentEntityList.add(Student.builder()
                .id(2L)
                .name("test2")
                .lastName("testov2")
                .build());

        List<StudentDto> studentDtoList = studentMapper.toDtoList(studentEntityList);
        Assertions.assertNotNull(studentDtoList);
        Assertions.assertNotEquals(0, studentDtoList.size());
        Assertions.assertEquals(studentEntityList.size(), studentDtoList.size());

        for (int i = 0; i < studentDtoList.size(); i++) {
            StudentDto studentDto = studentDtoList.get(i);
            Student student = studentEntityList.get(i);

            Assertions.assertNotNull(studentDto);
            Assertions.assertNotNull(student);
        }
    }
}



//        Student student1 = Student.builder()
//                .id(2L)
//                .name("Dake")
//                .lastName("Umnik")
//                .build();
//
//        Student student2 = Student.builder()
//                .id(3L)
//                .name("Sandu")
//                .lastName("Amze")
//                .build();
//
//        Student studen3 = Student.builder()
//                .id(4L)
//                .name("Oralbek")
//                .lastName("Urusov")
//                .build();
