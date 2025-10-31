package com.example.Midterm1.mapper;
import com.example.Midterm1.dto.BookDto;
import com.example.Midterm1.models.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {
    @Mapping(target = "titleDto", source = "title")
    @Mapping(target = "authorDto", source = "author")
    BookDto toDto(Book book);
    @Mapping(target = "title", source = "titleDto")
    @Mapping(target = "author", source = "authorDto")
    Book toEntity(BookDto bookDto);
    List<BookDto> toDtoList(List<Book> books);
    List<Book> toEntityLList(List<BookDto> bookDto);
}
