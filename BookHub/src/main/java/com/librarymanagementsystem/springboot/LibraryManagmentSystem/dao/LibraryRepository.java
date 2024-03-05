package com.librarymanagementsystem.springboot.LibraryManagmentSystem.dao;

import com.librarymanagementsystem.springboot.LibraryManagmentSystem.entities.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository<Library, Integer> {
}
