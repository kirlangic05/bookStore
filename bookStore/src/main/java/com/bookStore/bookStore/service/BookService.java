package com.bookStore.bookStore.service;

import com.bookStore.bookStore.model.Books;
import com.bookStore.bookStore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    public BookRepository bookRepository;

    public void save(Books b) {
        bookRepository.save(b);
    }

    public List<Books> getAllBooks() {
        return bookRepository.findAll();
    }

    public Books getBookById(int id) {
        return bookRepository.findById(id).get();
    }
    public void deleteById(int id){
         bookRepository.deleteById(id);
    }
}
