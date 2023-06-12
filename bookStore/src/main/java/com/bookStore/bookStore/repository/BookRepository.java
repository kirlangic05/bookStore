package com.bookStore.bookStore.repository;

import com.bookStore.bookStore.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookRepository extends JpaRepository<Books,Integer> {

}
