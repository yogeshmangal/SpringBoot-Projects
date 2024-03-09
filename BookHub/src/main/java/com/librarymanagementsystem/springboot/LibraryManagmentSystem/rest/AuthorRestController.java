package com.librarymanagementsystem.springboot.LibraryManagmentSystem.rest;

import com.librarymanagementsystem.springboot.LibraryManagmentSystem.entities.Author;
import com.librarymanagementsystem.springboot.LibraryManagmentSystem.exception.EntityNotFoundException;
import com.librarymanagementsystem.springboot.LibraryManagmentSystem.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AuthorRestController {
    private AuthorService authorService;
    @Autowired
    public AuthorRestController(AuthorService authorService) {
        this.authorService = authorService;
    }
    @GetMapping("/authors")
    public List<Author> getAllAuthors() {
        return authorService.findAll();
    }

    @GetMapping("/authors/{id}")
    public Optional<Author> findById(@PathVariable int id) {
        Optional<Author> author = authorService.findAuthorById(id);
        if(author.isEmpty())
            throw new EntityNotFoundException("Author Id not found " + id);
        return author;
    }

    @PostMapping("/authors")
    public Author createAuthor(@RequestBody Author author) {
        author.setId(0);
        authorService.createUpdateAuthor(author);
        return author;
    }

    @PutMapping("/authors")
    public Author updateAuthor(@RequestBody Author author) {
        authorService.createUpdateAuthor(author);
        return author;
    }

    @DeleteMapping("/authors/{id}")
    public String deleteAuthorById(@PathVariable int id) {
        Optional<Author> author = authorService.findAuthorById(id);
        if(author.isEmpty())
            throw new EntityNotFoundException("Author Id not found " + id);
        authorService.deleteAuthorById(id);
        return "Deleted Author Id is: " + id;
    }
}
