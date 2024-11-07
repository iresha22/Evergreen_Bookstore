package com.develhope.bookstore.repositories;

import com.develhope.bookstore.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {
    // elimination logic
    @Transactional
    @Modifying
    @Query(value = "update client set is_active = false where id = :id", nativeQuery = true)
    void eliminationLogic(@Param("id") Long id);
    // find by active id
    @Query(value = "select * from client where is_active = true and id = :id", nativeQuery = true)
    Optional<Client> findByActiveId(@Param("id") Long id);
    // find all active id's
    @Query(value = "select * from client where is_active = true", nativeQuery = true)
    List<Client> findAllActiveIds();
}
