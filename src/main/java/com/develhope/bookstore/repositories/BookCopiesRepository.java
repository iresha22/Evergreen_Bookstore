package com.develhope.bookstore.repositories;

import com.develhope.bookstore.entities.BookCopies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookCopiesRepository extends JpaRepository<BookCopies,Long> {
}
