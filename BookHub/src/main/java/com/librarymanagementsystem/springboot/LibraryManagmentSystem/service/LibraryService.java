package com.librarymanagementsystem.springboot.LibraryManagmentSystem.service;

import com.librarymanagementsystem.springboot.LibraryManagmentSystem.entities.Library;

import java.util.List;
import java.util.Optional;

public interface LibraryService {
    List<Library> findAll();

    Optional<Library> findLibraryById(int id);

    void createUpdateLibrary(Library library);

    void deleteLibraryById(int id);
}
