package com.librarymanagementsystem.springboot.LibraryManagmentSystem.rest;

import com.librarymanagementsystem.springboot.LibraryManagmentSystem.entities.Book;
import com.librarymanagementsystem.springboot.LibraryManagmentSystem.exception.EntityNotFoundException;
import com.librarymanagementsystem.springboot.LibraryManagmentSystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BookRestController {
    private BookService bookService;
    @Autowired
    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookService.findAll();
    }

    @GetMapping("/books/{id}")
    public Optional<Book> findById(@PathVariable int id) {
        Optional<Book> book = bookService.findBookById(id);
        if(book.isEmpty())
            throw new EntityNotFoundException("Id not found " + id);
        return book;
    }

    @PostMapping("/books")
    public Book addBook(@RequestBody Book book) {
        book.setId(0);
        bookService.createUpdateBook(book);
        return book;
    }

    @PutMapping("/books")
    public Book updateBook(@RequestBody Book book) {
        bookService.createUpdateBook(book);
        return book;
    }

    @DeleteMapping("/books/{id}")
    public String deleteBookById(@PathVariable int id) {
        Optional<Book> book = bookService.findBookById(id);
        if(book.isEmpty())
            throw new EntityNotFoundException("Id not found " + id);
        bookService.deleteBookById(id);
        return "Deleted Book Id is: " + id;
    }
}
