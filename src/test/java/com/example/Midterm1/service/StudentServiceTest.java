package com.example.Midterm1.service;

import com.example.Midterm1.dto.BookDto;
import com.example.Midterm1.dto.StudentDto;
import com.example.Midterm1.dto.TeacherDto;
import com.example.Midterm1.models.Book;
import com.example.Midterm1.models.Student;
import com.example.Midterm1.models.Teacher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Random;
import java.util.zip.Adler32;

@SpringBootTest
public class StudentServiceTest {
    @Autowired StudentService studentService;

    @Test
    void getAllTest(){
        List<StudentDto> studentDtoList = studentService.getStudents();

        Assertions.assertNotNull(studentDtoList);
        Assertions.assertEquals(0,studentDtoList.size());
       for (StudentDto studentDto : studentDtoList){
           Assertions.assertNotNull(studentDto.getId());
           Assertions.assertNotNull(studentDto.getNameDto());
           Assertions.assertNotNull(studentDto.getLastNameDto());
           Assertions.assertNotNull(studentDto.getBooks());
           Assertions.assertNotNull(studentDto.getTeachers());
       }

    }

    @Test
    void getByIdTest(){
        Random random = new Random();
        int randomIndex = random.nextInt(studentService.getStudents().size());

        Long someStudId = studentService.getStudents().get(randomIndex).getId();
        StudentDto studentDto = studentService.getById(someStudId);
        Assertions.assertNotNull(studentDto);

        Assertions.assertNotNull(studentDto.getId());
        Assertions.assertNotNull(studentDto.getNameDto());
        Assertions.assertNotNull(studentDto.getLastNameDto());
        Assertions.assertNotNull(studentDto.getBooks());
        Assertions.assertNotNull(studentDto.getTeachers());

        StudentDto checkStud = studentService.getById(-1L);
        Assertions.assertNotNull(checkStud);
    }

    @Test
    void addStudentTest(){
        BookDto book1 = new BookDto( "Book A", "S.Kiosaki"); // Assuming Book has (id, title, studentId)
        TeacherDto teacher1 = new TeacherDto( "Professor", "Smith");

        StudentDto student1 = new StudentDto(
                1L,
                "John",
                "Doe",
                List.of(book1),
                List.of(teacher1)
        );

        StudentDto createdStud = studentService.addStudent(student1);
        Assertions.assertNotNull(createdStud);
        Assertions.assertNotEquals(0L,createdStud.getId());

        Assertions.assertNotNull(createdStud.getNameDto());
        Assertions.assertNotNull(createdStud.getLastNameDto());
        Assertions.assertNotNull(createdStud.getTeachers());
        Assertions.assertNotNull(createdStud.getBooks());

        Assertions.assertEquals(createdStud.getId(),student1.getId());
        Assertions.assertEquals(createdStud.getNameDto(), student1.getNameDto());
        Assertions.assertEquals(createdStud.getLastNameDto(), student1.getLastNameDto());
    }
    @Test
    void updateStudent(){
        
    }
}
