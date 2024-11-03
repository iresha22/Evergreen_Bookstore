package com.develhope.bookstore.services;

import com.develhope.bookstore.entities.Author;
import com.develhope.bookstore.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    // parameters
    @Autowired
    private AuthorRepository authorRepository;

    // CRUD
    /**
     * create an author
     */
    public Author createAuthor(Author author){
        return authorRepository.save(author);
    }

    /**
     * get an author by id
     */
    public Optional<Author> getAuthorById(Long id){
         return authorRepository.findActiveById(id);
    }

    /**
     * get author catalogue
     */
    public List<Author> getAuthorCatalog(){
        return authorRepository.findAllActive();
    }

    /**
     * modify the author details by id
     */
    public Optional<Author> updateAuthor(Long id, Author author){
        Optional<Author> authorOptional = authorRepository.findById(id);
        if (authorOptional.isPresent()){
            Author updatedAuthor = authorOptional.get();
            updatedAuthor.setName(author.getName());
            updatedAuthor.setDescription(author.getDescription());
            updatedAuthor.setEmail(author.getEmail());
            updatedAuthor.setPassword(author.getPassword());
            updatedAuthor.setBookCatalogue(author.getBookCatalogue());
            updatedAuthor.setOrders(author.getOrders());
            return Optional.of(authorRepository.save(updatedAuthor));
        } else {
            return Optional.empty();
        }
    }

    /**
     * eliminate using the elimination logic so the user is not deleted from the database but can deactivate the profile
     */
    public String deleteAuthor(Long id){
        Optional<Author> authorOptional = authorRepository.findActiveById(id);
        if (authorOptional.isPresent()){
            authorRepository.deactivate(id);
            return "Author successfully deactivated";
        } else {
            return "Author id not found";
        }
    }
}
