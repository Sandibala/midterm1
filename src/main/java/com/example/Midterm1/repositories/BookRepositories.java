package com.example.Midterm1.repositories;

import com.example.Midterm1.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepositories extends JpaRepository<Book, Long> {
}
