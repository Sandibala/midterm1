package com.example.Midterm1.controllers;
import com.example.Midterm1.dto.StudentDto;
import com.example.Midterm1.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping()
    public ResponseEntity<?> getStudents(){
        return new ResponseEntity<>(studentService.getStudents(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable(name = "id") Long id){
        return new ResponseEntity<>(studentService.getById(id),HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> addStudent(@RequestBody StudentDto studentDto){
        return new ResponseEntity<>(studentService.addStudent(studentDto), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable(name ="id") Long id, @RequestBody StudentDto studentDto){
        return new ResponseEntity<>(studentService.updateStudent(id, studentDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable(name = "id") Long id){
        return new ResponseEntity<>(studentService.deleteStudent(id), HttpStatus.OK);
    }
}
