package com.develhope.bookstore.services;

import com.develhope.bookstore.entities.UsedBooks;
import com.develhope.bookstore.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    // parameters
    @Autowired
    private BookRepository bookRepository;

    // CRUD methods with the elimination logic
    /**
     * create
     */
    public UsedBooks create(UsedBooks usedBooks){
        return bookRepository.save(usedBooks);
    }

    /**
     * read by id
     */
    public Optional<UsedBooks> readById(Long id){
        return bookRepository.findByActiveId(id);
    }

    /**
     * read all
     */
    public List<UsedBooks> readAll(){
        return bookRepository.findAllActiveIds();
    }

    /**
     * update
     */
    public Optional<UsedBooks> update(Long id, UsedBooks usedBooks){
        Optional<UsedBooks> bookOptional = bookRepository.findByActiveId(id);
        if (bookOptional.isPresent()){
            UsedBooks updatedUsedBooks = bookOptional.get();
            updatedUsedBooks.setName(usedBooks.getName());
            updatedUsedBooks.setAvailable(usedBooks.getAvailable());
            updatedUsedBooks.setActive(usedBooks.isActive());
            updatedUsedBooks.setDescription(usedBooks.getDescription());
            // need to add the modifying of relations here
            return Optional.of(bookRepository.save(updatedUsedBooks));
        } else {
            return Optional.empty();
        }
    }

    /**
     * elimination logic
     */
    public String deactivate(Long id){
        Optional<UsedBooks> bookOptional = bookRepository.findByActiveId(id);
        if (bookOptional.isPresent()){
            bookRepository.deactivate(id);
            return "Book removed successfully";
        } else {
            return "unable to proceed with the request.";
        }
    }
}
