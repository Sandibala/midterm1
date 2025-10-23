package com.example.Midterm1.service;
import com.example.Midterm1.dto.BookDto;
import java.util.List;

public interface BookService {
    List<BookDto> getBooks();
    BookDto getById(Long id);
    BookDto updateBook(Long id, BookDto bookDto);
    BookDto addBooK(BookDto bookDto);
    boolean deleteBook(Long id);
}
