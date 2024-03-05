package com.librarymanagementsystem.springboot.LibraryManagmentSystem.dao;

import com.librarymanagementsystem.springboot.LibraryManagmentSystem.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
