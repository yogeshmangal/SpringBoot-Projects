package com.librarymanagementsystem.springboot.LibraryManagmentSystem.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "birth_date")
    private Date birthDate;
    @Column(name = "nationality")
    private String nationality;
    @Column(name = "books")
    private String books;

    public Author() {

    }

    public Author(String name, Date birthDate, String nationality, String books) {
        this.name = name;
        this.birthDate = birthDate;
        this.nationality = nationality;
        this.books = books;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getBooks() {
        return books;
    }

    public void setBooks(String books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", nationality='" + nationality + '\'' +
                ", books='" + books + '\'' +
                '}';
    }
}
