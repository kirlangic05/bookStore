package com.bookStore.bookStore.repository;

import com.bookStore.bookStore.model.MyBookList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyBooksRepository extends JpaRepository<MyBookList,Integer> {
}
