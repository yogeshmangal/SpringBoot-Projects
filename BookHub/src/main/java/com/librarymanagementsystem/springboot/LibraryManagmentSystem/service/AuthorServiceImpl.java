package com.librarymanagementsystem.springboot.LibraryManagmentSystem.service;

import com.librarymanagementsystem.springboot.LibraryManagmentSystem.dao.AuthorRepository;
import com.librarymanagementsystem.springboot.LibraryManagmentSystem.entities.Author;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {
    private AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Optional<Author> findAuthorById(int id) {
        return authorRepository.findById(id);
    }

    @Transactional
    @Override
    public void createUpdateAuthor(Author author) {
        authorRepository.save(author);
    }

    @Transactional
    @Override
    public void deleteAuthorById(int id) {
        authorRepository.deleteById(id);
    }
}
