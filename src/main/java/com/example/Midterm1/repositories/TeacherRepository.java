package com.example.Midterm1.repositories;

import com.example.Midterm1.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
