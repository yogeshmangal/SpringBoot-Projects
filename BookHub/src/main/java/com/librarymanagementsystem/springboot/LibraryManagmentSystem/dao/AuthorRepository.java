package com.librarymanagementsystem.springboot.LibraryManagmentSystem.dao;

import com.librarymanagementsystem.springboot.LibraryManagmentSystem.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
