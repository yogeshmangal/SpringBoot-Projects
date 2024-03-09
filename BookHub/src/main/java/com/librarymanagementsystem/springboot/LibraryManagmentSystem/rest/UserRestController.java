package com.librarymanagementsystem.springboot.LibraryManagmentSystem.rest;

import com.librarymanagementsystem.springboot.LibraryManagmentSystem.entities.User;
import com.librarymanagementsystem.springboot.LibraryManagmentSystem.exception.EntityNotFoundException;
import com.librarymanagementsystem.springboot.LibraryManagmentSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserRestController {
    private UserService userService;
    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public Optional<User> findUserById(@PathVariable int id) {
        Optional<User> user = userService.findUserById(id);
        if (user.isEmpty())
            throw new EntityNotFoundException("User Id Not Found " + id);
        return user;
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        user.setId(0);
        userService.createUpdateUser(user);
        return user;
    }

    @PutMapping("/users")
    public User updateUser(@RequestBody User user) {
        userService.createUpdateUser(user);
        return user;
    }

    @DeleteMapping("/users/{id}")
    public String deleteUserId(@PathVariable int id) {
        Optional<User> user = userService.findUserById(id);
        if (user.isEmpty())
            throw new EntityNotFoundException("User Id not found " + id);
        userService.deleteUserById(id);
        return "Deleted User Id is: " + id;
    }
}
