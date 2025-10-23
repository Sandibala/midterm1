package com.example.Midterm1.controllers;

import com.example.Midterm1.dto.TeacherDto;
import com.example.Midterm1.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/teachers")
public class TeacherController {
    private final TeacherService teacherService;

    @GetMapping("/all")
    public ResponseEntity<?> getTeachers(){
        return new ResponseEntity<>(teacherService.getTeachers(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable(name = "id") Long id){
        return new ResponseEntity<>(teacherService.getById(id), HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<?> addTeacher(@RequestBody TeacherDto teacherDto){
        return new ResponseEntity<>(teacherService.addTeacher(teacherDto),HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<?> updateTeacher(@PathVariable(name = "id") Long id, @RequestBody TeacherDto teacherDto){
        return new ResponseEntity<>(teacherService.updateTeacher(id, teacherDto), HttpStatus.OK);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteTeacher(@PathVariable(name = "id") Long id){
        return new ResponseEntity<>(teacherService.deleteTeacher(id), HttpStatus.OK);
    }
}
