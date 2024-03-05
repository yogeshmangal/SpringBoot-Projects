package com.librarymanagementsystem.springboot.LibraryManagmentSystem.dao;

import com.librarymanagementsystem.springboot.LibraryManagmentSystem.entities.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowRepository extends JpaRepository<Borrow, Integer> {
}
