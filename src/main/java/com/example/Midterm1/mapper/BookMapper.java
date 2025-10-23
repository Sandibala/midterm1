package com.example.Midterm1.mapper;
import com.example.Midterm1.dto.BookDto;
import com.example.Midterm1.models.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {
    @Mapping(target = "title", source = "title")
    @Mapping(target = "author", source = "author")
    BookDto toDto(Book book);
    Book toEntity(BookDto bookDto);
    List<BookDto> toDtoList(List<Book> books);
    List<Book> toEntityLList(List<BookDto> bookDto);
}
