package com.example.Midterm1.mapper;

import com.example.Midterm1.dto.BookDto;
import com.example.Midterm1.models.Book;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookDto toDto(BookDto bookDto);
    Book toEntity(Book book);

    List<BookDto> toDtoList(List<Book> books);
    List<Book> toEntityLList(List<BookDto> bookDtos);
}
