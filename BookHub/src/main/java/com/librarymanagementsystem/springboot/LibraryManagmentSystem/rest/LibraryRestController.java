package com.librarymanagementsystem.springboot.LibraryManagmentSystem.rest;

import com.librarymanagementsystem.springboot.LibraryManagmentSystem.entities.Library;
import com.librarymanagementsystem.springboot.LibraryManagmentSystem.exception.EntityNotFoundException;
import com.librarymanagementsystem.springboot.LibraryManagmentSystem.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class LibraryRestController {
    private LibraryService libraryService;

    @Autowired
    public LibraryRestController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping("/libraries")
    public List<Library> getAllLibraries() {
        return libraryService.findAll();
    }

    @GetMapping("/libraries/{id}")
    public Optional<Library> findLibraryById(@PathVariable int id) {
        Optional<Library> library = libraryService.findLibraryById(id);
        if (library.isEmpty())
            throw new EntityNotFoundException("Library Id Not Found " + id);
        return library;
    }

    @PostMapping("/libraries")
    public Library createLibrary(@RequestBody Library library) {
        library.setId(0);
        libraryService.createUpdateLibrary(library);
        return library;
    }

    @PutMapping("/libraries")
    public Library updateLibrary(@RequestBody Library library) {
        libraryService.createUpdateLibrary(library);
        return library;
    }

    @DeleteMapping("/libraries/{id}")
    public String deleteLibraryById(@PathVariable int id) {
        Optional<Library> library = libraryService.findLibraryById(id);
        if (library.isEmpty())
            throw new EntityNotFoundException("Library Id not found " + id);
        libraryService.deleteLibraryById(id);
        return "Deleted Library Id is: " + id;
    }
}
