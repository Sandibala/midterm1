package com.example.Midterm1.service;

import com.example.Midterm1.dto.BookDto;
import com.example.Midterm1.dto.StudentDto;
import com.example.Midterm1.models.Student;

import java.util.List;

public interface BookService {
    List<BookDto> getBooks();
    void getById(Long id);
    void addBOOK(StudentDto studentDto);
    void updateBook(Long id, Student student);

    void addBOOK(BookDto bookDto);

    void updateBook(Long id, BookDto bookDto);

    boolean deleteBook(Long id);
}
