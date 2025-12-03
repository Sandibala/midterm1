package com.example.Midterm1.mapper;

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

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class StudentMapperTest {
    @Autowired
    StudentMapper studentMapper;

    @Test
    void convertEntityToDtoTest() {
        Book book1 = new Book(1L, "Book A", "S.Kiosaki"); // Assuming Book has (id, title, studentId)
        Teacher teacher1 = new Teacher(10L, "Professor", "Smith", List.of());

        Student student = new Student(
                1L,
                "John",
                "Doe",
                List.of(book1),
                List.of(teacher1)
        );

        StudentDto studentDto = studentMapper.toDto(student);
        Assertions.assertNotNull(studentDto);
        Assertions.assertNotNull(studentDto.getId());
        Assertions.assertNotNull(studentDto.getNameDto());
        Assertions.assertNotNull(studentDto.getLastNameDto());
        Assertions.assertNotNull(studentDto.getBooks());
        Assertions.assertNotNull(studentDto.getTeachers());

        Assertions.assertEquals(student.getName(), studentDto.getNameDto());
        Assertions.assertEquals(student.getLastName(), studentDto.getLastNameDto());
        Assertions.assertEquals(student.getId(), studentDto.getId());
    }

    @Test
    void convertListEntityToDtoTest() {
        List<Student> studentList = new ArrayList<>();
        Book book1 = new Book(1L, "Book A", "S.Kiosaki"); // Assuming Book has (id, title, studentId)
        Teacher teacher1 = new Teacher(10L, "Professor", "Smith", List.of());
        studentList.add(new Student(3L, "Sandi", "Amze", List.of(book1), List.of(teacher1)));

        List<StudentDto> studentDtoList = studentMapper.toDtoList(studentList);
        Assertions.assertNotNull(studentDtoList);
        Assertions.assertNotEquals(0, studentDtoList.size());
        Assertions.assertEquals(studentList.size(), studentDtoList.size());

        for (int i = 0; i < studentList.size(); i++) {
            Student student = studentList.get(i);
            StudentDto studentDto = studentMapper.toDto(student);

            Assertions.assertNotNull(studentDto);
            Assertions.assertNotNull(studentDto.getId());
            Assertions.assertNotNull(studentDto.getNameDto());
            Assertions.assertNotNull(studentDto.getLastNameDto());
            Assertions.assertNotNull(studentDto.getBooks());
            Assertions.assertNotNull(studentDto.getTeachers());

            Assertions.assertEquals(student.getId(), studentDto.getId());
            Assertions.assertEquals(student.getName(), studentDto.getNameDto());
            Assertions.assertEquals(student.getLastName(), studentDto.getLastNameDto());

        }
    }
    @Test
    void convertDtoToEntityTest(){
        BookDto bookDto = new BookDto("ABC","A.America");
        TeacherDto teacherDto = new TeacherDto("Akylbek", "Abdikulov");
        StudentDto studentDto = new StudentDto(
                1L,
                "Sandi",
                "Amze",
                List.of(bookDto),
                List.of(teacherDto)

        );

     Student student = studentMapper.toEntity(studentDto);
     Assertions.assertNotNull(student);

     Assertions.assertNotNull(student.getId());
        Assertions.assertNotNull(student.getName());
        Assertions.assertNotNull(student.getLastName());
        Assertions.assertNotNull(student.getBooks());
        Assertions.assertNotNull(student.getTeachers());

        Assertions.assertEquals(student.getId(), studentDto.getId());
        Assertions.assertEquals(student.getName(),studentDto.getNameDto());
        Assertions.assertEquals(student.getLastName(),studentDto.getLastNameDto());
//        Assertions.assertEquals(student.getBooks(), studentDto.getBooks());
//        Assertions.assertEquals(student.getTeachers(), studentDto.getTeachers());


    }
}
