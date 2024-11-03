package com.develhope.bookstore.repositories;

import com.develhope.bookstore.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {

    // custom query for elimination logic
    // update the table and make the isActive false
    // query to findactivebyid
    // select from the table author where it is active and the id is equal to the parameter
    @Query(value = "select * from author where is_active = true and id = :id", nativeQuery = true)
    Author findActiveById(@Param("id") Long id);
    // find all active by id
    // select all the authors where isactive = true
}
