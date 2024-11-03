package com.develhope.bookstore.controllers;

import com.develhope.bookstore.entities.Author;
import com.develhope.bookstore.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("author")
public class AuthorController {
    // parameters
    @Autowired
    private AuthorService authorService;

    // create new author
    @PostMapping("/new-author")
    public ResponseEntity<Author> createAuthor(@RequestBody Author author){
        Author newAuthor = authorService.createAuthor(author);
        return ResponseEntity.ok(newAuthor);
    }
    // get author by id
    @GetMapping("/{id}")
    public ResponseEntity<Author> readAuthor(@PathVariable Long id){
        Optional<Author> authorOptional = authorService.getAuthorById(id);
        return authorOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    // get author list
    @GetMapping("/author-catalog")
    public ResponseEntity<List<Author>> readAuthorCatalog(){
        return ResponseEntity.ok(authorService.getAuthorCatalog());
    }
    // update author
    @PutMapping("/author-id/{id}")
    public ResponseEntity<Author> updateAuthor(@PathVariable Long id, @RequestBody Author author){
        Optional<Author> authorOptional = authorService.updateAuthor(id,author);
        return authorOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    // delete author
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAuthor(@PathVariable Long id){
        String deactivateAuthor = authorService.deleteAuthor(id);
        return ResponseEntity.ok().build();
    }
}
