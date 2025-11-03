package com.example.Midterm1;

import com.example.Midterm1.dto.BookDto;
import com.example.Midterm1.mapper.BookMapper;
import com.example.Midterm1.models.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class BookMapperTest {
    @Autowired
    BookMapper bookMapper;

    @Test
    void convertEntityToDtoTest(){
        Book book = Book.builder()
                .title("Les Miserable")
                .author("Victor Hugo")
                .build();

        BookDto bookDto = bookMapper.toDto(book);
        Assertions.assertNotNull(bookDto);
        Assertions.assertNotNull(bookDto.getTitleDto());
        Assertions.assertNotNull(bookDto.getAuthorDto());

        Assertions.assertEquals(book.getTitle(), bookDto.getTitleDto());
        Assertions.assertEquals(book.getAuthor(), bookDto.getAuthorDto());
    }

    @Test
    void convertDtoToEntityTest(){
     BookDto bookDto = BookDto.builder()
             .titleDto("Gauhartas")
             .authorDto("Dulat Isabekov")
             .build();

     Book entityBook = bookMapper.toEntity(bookDto);
     Assertions.assertNotNull(entityBook);
     Assertions.assertNotNull(entityBook.getTitle());
     Assertions.assertNotNull(entityBook.getAuthor());

     Assertions.assertEquals(bookDto.getTitleDto(), entityBook.getTitle());
     Assertions.assertEquals(bookDto.getAuthorDto(), entityBook.getAuthor());
    }

    @Test
    void convertEntityListToDto(){
        List<Book> entityBookList = new ArrayList<>();
        entityBookList.add(Book.builder()
                .title("The speed of thought")
                .author("Bill Gates")
                .build());

        List<BookDto> bookDtoList = bookMapper.toDtoList(entityBookList);
        Assertions.assertNotNull(bookDtoList);
        Assertions.assertNotEquals(0, bookDtoList.size());
        Assertions.assertEquals(bookDtoList.size(), entityBookList.size());

        for (int i = 0; i < bookDtoList.size(); i++) {
            BookDto bookDto = bookDtoList.get(i);
            Book book = entityBookList.get(i);

            Assertions.assertNotNull(bookDto);
            Assertions.assertNotNull(book);
        }
    }
}
