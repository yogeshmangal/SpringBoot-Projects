package com.librarymanagementsystem.springboot.LibraryManagmentSystem.service;

import com.librarymanagementsystem.springboot.LibraryManagmentSystem.dao.BookRepository;
import com.librarymanagementsystem.springboot.LibraryManagmentSystem.entities.Book;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findBookById(int id) {
        return bookRepository.findById(id);
    }

    @Transactional
    @Override
    public void createUpdateBook(Book book) {
        bookRepository.save(book);
    }

    @Transactional
    @Override
    public void deleteBookById(int id) {
        bookRepository.deleteById(id);
    }
}
