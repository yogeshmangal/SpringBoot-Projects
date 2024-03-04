package com.librarymanagementsystem.springboot.LibraryManagmentSystem.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="birthday_date")
    private Date birthdayDate;
    @Column(name="nationality")
    private String nationality;
    @Column(name="books")
    private String books;
}
