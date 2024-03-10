package com.librarymanagementsystem.springboot.LibraryManagmentSystem.rest;

import com.librarymanagementsystem.springboot.LibraryManagmentSystem.entities.Borrow;
import com.librarymanagementsystem.springboot.LibraryManagmentSystem.exception.EntityNotFoundException;
import com.librarymanagementsystem.springboot.LibraryManagmentSystem.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BorrowRestController {
    private BorrowService borrowService;

    @Autowired
    public BorrowRestController(BorrowService borrowService) {
        this.borrowService = borrowService;
    }

    @GetMapping("/borrowings")
    public List<Borrow> getAllBorrowings() {
        return borrowService.findAll();
    }

    @GetMapping("/borrowings/{id}")
    public Optional<Borrow> getBorrowingById(@PathVariable int id) {
        Optional<Borrow> borrow = borrowService.findBorrowById(id);
        if (borrow.isEmpty())
            throw new EntityNotFoundException("Borrow Id not found " + id);
        return borrow;
    }

    @PostMapping("/borrowings")
    public Borrow createBorrowing(@RequestBody Borrow borrow) {
        borrow.setId(0);
        borrowService.createUpdateBorrow(borrow);
        return borrow;
    }

    @PutMapping("/borrowings")
    public Borrow updateBorrowing(@RequestBody Borrow borrow) {
        borrowService.createUpdateBorrow(borrow);
        return borrow;
    }

    @DeleteMapping("/borrowings/{id}")
    public String deleteBorrowingById(@PathVariable int id) {
        Optional<Borrow> borrow = borrowService.findBorrowById(id);
        if (borrow.isEmpty())
            throw new EntityNotFoundException("Borrow Id not found " + id);
        borrowService.deleteBorrowById(id);
        return "Deleted Borrow Id is: " + id;
    }

    @PostMapping("/borrowings/{id}/payfine")
    public String payFine(@PathVariable int id) {
        Optional<Borrow> borrow = borrowService.findBorrowById(id);
        if (borrow.isEmpty())
            throw new EntityNotFoundException("Borrow Id not found " + id);
        int fineAmount = borrow.get().getFineAmount();
        if (fineAmount == 0)
            return "There is no fine associated with this borrowing.";
        borrow.get().setFineAmount(0);
        borrowService.createUpdateBorrow(borrow.get());
        return "Fine Paid Successfully";
    }
}
