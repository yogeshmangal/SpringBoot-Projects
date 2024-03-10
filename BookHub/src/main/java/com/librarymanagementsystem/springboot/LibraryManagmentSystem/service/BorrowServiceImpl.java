package com.librarymanagementsystem.springboot.LibraryManagmentSystem.service;

import com.librarymanagementsystem.springboot.LibraryManagmentSystem.dao.BorrowRepository;
import com.librarymanagementsystem.springboot.LibraryManagmentSystem.entities.Borrow;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BorrowServiceImpl implements BorrowService {
    private BorrowRepository borrowRepository;

    @Autowired
    public BorrowServiceImpl(BorrowRepository borrowRepository) {
        this.borrowRepository = borrowRepository;
    }

    @Override
    public List<Borrow> findAll() {
        return borrowRepository.findAll();
    }

    @Override
    public Optional<Borrow> findBorrowById(int id) {
        return borrowRepository.findById(id);
    }

    @Transactional
    @Override
    public void createUpdateBorrow(Borrow borrow) {
        borrowRepository.save(borrow);
    }

    @Transactional
    @Override
    public void deleteBorrowById(int id) {
        borrowRepository.deleteById(id);
    }
}
