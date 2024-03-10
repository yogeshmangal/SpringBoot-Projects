package com.librarymanagementsystem.springboot.LibraryManagmentSystem.service;

import com.librarymanagementsystem.springboot.LibraryManagmentSystem.entities.Borrow;

import java.util.List;
import java.util.Optional;

public interface BorrowService {
    List<Borrow> findAll();

    Optional<Borrow> findBorrowById(int id);

    void createUpdateBorrow(Borrow borrow);

    void deleteBorrowById(int id);
}
