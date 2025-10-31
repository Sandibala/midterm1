package com.example.Midterm1.service.impl;
import com.example.Midterm1.dto.BookDto;
import com.example.Midterm1.mapper.BookMapper;
import com.example.Midterm1.models.Book;
import com.example.Midterm1.repositories.BookRepositories;
import com.example.Midterm1.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {
    private final BookRepositories bookRepositories;
    private final BookMapper bookMapper;
    @Override
    public  List<BookDto> getBooks() {
        return bookMapper.toDtoList(bookRepositories.findAll());
    }

    @Override
    public BookDto getById(Long id) {
    return bookMapper.toDto(bookRepositories.findById(id).orElse(null));
    }



    @Override
    public BookDto addBooK(BookDto bookDto) {
        return bookMapper.toDto(bookRepositories.save(bookMapper.toEntity(bookDto)));
    }


    @Override
    public BookDto updateBook(Long id, BookDto bookDto) {
     Book book = bookRepositories.findById(id).orElse(null);
     book.setTitle(bookDto.getTitleDto());
     book.setAuthor(bookDto.getAuthorDto());
     bookRepositories.save(book);
     Book book1 = bookRepositories.findById(id).orElse(null);
     return bookMapper.toDto(book1);
    }

    @Override
    public boolean deleteBook(Long id) {
        Book book = bookRepositories.findById(id).orElse(null);
        if(Objects.isNull(book)){
            return false;
        } else {
            return true;
        }
    }
}
