package com.bookStore.bookStore.service;

import com.bookStore.bookStore.model.MyBookList;
import com.bookStore.bookStore.repository.MyBooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyBookListService {
    @Autowired
    public MyBooksRepository mybook;


    public void saveMyBooks(MyBookList book){
        mybook.save(book);

    }
    public List<MyBookList> getAllMyBooks()
    {
        return mybook.findAll();
    }
    public void deleteById(int id){
        mybook.deleteById(id);

    }
}
