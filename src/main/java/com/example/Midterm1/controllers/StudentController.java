package com.example.Midterm1.controllers;

import com.example.Midterm1.dto.StudentDto;
import com.example.Midterm1.models.Student;
import com.example.Midterm1.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/all")
    public ResponseEntity<?> getStudents(){
        return new ResponseEntity<>(studentService.getStudents(), HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<?> getById(@PathVariable(name = "id") Long id){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addStudent(@RequestBody Student student){
        return new ResponseEntity<>(studentService.addStudent(student), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable(name ="id") Long id, @RequestBody Student student){
        new ResponseEntity<>(studentService.updateStudent(id), HttpStatus.OK;)
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable(name = "id") Long id){
        return new ResponseEntity<>(studentService.deleteStudent(id), HttpStatus.OK)
    }
}
