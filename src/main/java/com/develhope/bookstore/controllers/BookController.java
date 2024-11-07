package com.develhope.bookstore.controllers;

import com.develhope.bookstore.entities.UsedBooks;
import com.develhope.bookstore.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("book")
public class BookController {
    // parameters
    @Autowired
    private BookService bookService;

    /**
     * post
     */

    @PostMapping("/new-book")
    public ResponseEntity<UsedBooks> createBook(@RequestBody UsedBooks usedBooks){
       UsedBooks newUsedBooks = bookService.create(usedBooks);
       return ResponseEntity.ok(newUsedBooks);
    }
    /**
     * get by id
     */



    /**
     * get all
     */

    /**
     * put
     */

    /**
     * delete
     */
}
