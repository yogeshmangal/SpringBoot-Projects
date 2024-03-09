package com.librarymanagementsystem.springboot.LibraryManagmentSystem.service;

import com.librarymanagementsystem.springboot.LibraryManagmentSystem.dao.LibraryRepository;
import com.librarymanagementsystem.springboot.LibraryManagmentSystem.entities.Library;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryServiceImpl implements LibraryService {
    private LibraryRepository libraryRepository;

    @Autowired
    public LibraryServiceImpl(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    @Override
    public List<Library> findAll() {
        return libraryRepository.findAll();
    }

    @Override
    public Optional<Library> findLibraryById(int id) {
        return libraryRepository.findById(id);
    }

    @Transactional
    @Override
    public void createUpdateLibrary(Library library) {
        libraryRepository.save(library);
    }

    @Transactional
    @Override
    public void deleteLibraryById(int id) {
        libraryRepository.deleteById(id);
    }
}
