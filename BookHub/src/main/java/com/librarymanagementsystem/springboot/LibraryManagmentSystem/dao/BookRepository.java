package com.librarymanagementsystem.springboot.LibraryManagmentSystem.dao;

import com.librarymanagementsystem.springboot.LibraryManagmentSystem.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
