package com.example.Midterm1.repositories;

import com.example.Midterm1.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
