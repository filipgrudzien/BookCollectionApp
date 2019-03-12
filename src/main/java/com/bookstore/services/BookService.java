package com.bookstore.services;

import com.bookstore.DTO.BookDTO;
import com.bookstore.entities.OwnedBook;
import com.bookstore.repositories.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public OwnedBook getSpecificBook(int id){
        OwnedBook person = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        return person;
    }

    public List<BookDTO> getAllBooksDTO(ModelMapper modelMapper){
        List<OwnedBook> books = bookRepository.findAll();
        List<BookDTO> limitedBooks = new ArrayList<>();
        for (OwnedBook book : books) {
            limitedBooks.add(modelMapper.map(book,BookDTO.class));
        }
        return limitedBooks;
    }

    public List<OwnedBook> getAllBooks(){
        return bookRepository.findAll();
    }
}
