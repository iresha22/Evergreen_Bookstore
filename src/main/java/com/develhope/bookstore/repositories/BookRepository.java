package com.develhope.bookstore.repositories;

import com.develhope.bookstore.entities.UsedBooks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<UsedBooks,Long> {
    // query for elimination logic
    @Transactional
    @Modifying
    @Query(value = "update book set is_active = false where id = :id",nativeQuery = true)
    void deactivate(@Param("id") Long id);
    // query to view activeId by id
    @Query(value = "select * from book where id = :id", nativeQuery = true)
    Optional<UsedBooks> findByActiveId(@Param("id") Long id);
    // query to view a list of activeId
    @Query(value = "select * from book where is_active = true", nativeQuery = true)
    List<UsedBooks> findAllActiveIds();
}
