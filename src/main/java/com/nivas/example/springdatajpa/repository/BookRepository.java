package com.nivas.example.springdatajpa.repository;

import com.nivas.example.springdatajpa.entity.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface BookRepository extends CrudRepository<Book,Long> {
    List<Book> findByName(String name);
    List<Book> findByNameContaining(String name);
    //Using Query with native SQL query indexing mechanism
    @Query(
            value = "SELECT * FROM Book u WHERE u.category = ?1",
            nativeQuery = true)
    List<Book> findBackendProgrammingBooks(String category);

    //Using collection parameter

    @Query(
            value = "SELECT * FROM Book u WHERE u.name in :names",
            nativeQuery = true)
    List<Book> findListOfBooks(@Param("names") Collection<String> names);
}
