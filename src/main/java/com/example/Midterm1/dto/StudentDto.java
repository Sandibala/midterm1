package com.example.Midterm1.dto;

import com.example.Midterm1.models.Book;
import com.example.Midterm1.models.Student;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    private String nameDto;
    private String lastNameDto;
}
