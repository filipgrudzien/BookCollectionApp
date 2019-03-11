package com.bookstore.services;

import com.bookstore.entities.OwnedBook;
import com.bookstore.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<OwnedBook> getAllBooks(){
        return bookRepository.findAll();
    }
}
