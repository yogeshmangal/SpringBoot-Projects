package com.librarymanagementsystem.springboot.LibraryManagmentSystem.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "borrow")
public class Borrow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "book_id")
    private int bookId;
    @Column(name = "user_id")
    private int userId;
    @Column(name = "borrow_date")
    private Date borrowDate;
    @Column(name = "return_date")
    private Date returnDate;
    @Column(name = "actual_return_date")
    private Date actualReturnDate;
    @Column(name = "status")
    private String status;
    @Column(name = "fine_amount")
    private int fineAmount;

    public Borrow() {

    }

    public Borrow(int bookId, int userId, Date borrowDate, Date returnDate, Date actualReturnDate, String status, int fineAmount) {
        this.bookId = bookId;
        this.userId = userId;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.actualReturnDate = actualReturnDate;
        this.status = status;
        this.fineAmount = fineAmount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Date getActualReturnDate() {
        return actualReturnDate;
    }

    public void setActualReturnDate(Date actualReturnDate) {
        this.actualReturnDate = actualReturnDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getFineAmount() {
        return fineAmount;
    }

    public void setFineAmount(int fineAmount) {
        this.fineAmount = fineAmount;
    }

    @Override
    public String toString() {
        return "Borrow{" +
                "id=" + id +
                ", bookId=" + bookId +
                ", userId=" + userId +
                ", borrowDate=" + borrowDate +
                ", returnDate=" + returnDate +
                ", actualReturnDate=" + actualReturnDate +
                ", status='" + status + '\'' +
                ", fineAmount=" + fineAmount +
                '}';
    }
}
