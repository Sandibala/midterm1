package com.example.Midterm1.controllers;
import com.example.Midterm1.dto.BookDto;
import com.example.Midterm1.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/books")

public class BookController {
    private final BookService bookService;

    @GetMapping()
    public ResponseEntity<?> getBooks(){
        return new ResponseEntity<>(bookService.getBooks(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?>  getById(@PathVariable(name = "id") Long id){
     return new ResponseEntity<>(bookService.getById(id), HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<?> addBook(@RequestBody BookDto bookDto){
        return new ResponseEntity<>(bookService.addBooK(bookDto),HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateBook(@PathVariable Long id, @RequestBody BookDto bookDto){
        return new ResponseEntity<>(bookService.updateBook(id, bookDto), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Long id){
        return new ResponseEntity<>(bookService.deleteBook(id), HttpStatus.OK);
    }
}
