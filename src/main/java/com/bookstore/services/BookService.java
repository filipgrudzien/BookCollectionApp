package com.bookstore.services;

import com.bookstore.DTO.BookDTO;
import com.bookstore.entities.Book;
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

    public Book getSpecificBook(int id){
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + id));
        book.setTitle(book.getTitle());
        return book;
    }

    public void deleteBook(int id){
        bookRepository.deleteById(id);
    }

    public List<BookDTO> getAllOwnedBooksDTO(ModelMapper modelMapper){
        List<Book> books = getAllOwnedBooks();
        List<BookDTO> limitedBooks = new ArrayList<>();
        for (Book book : books) {
            book.setTitle(book.getTitle());
            limitedBooks.add(modelMapper.map(book,BookDTO.class));
        }
        return limitedBooks;
    }

    public List<BookDTO> getAllToBuyBooksDTO(ModelMapper modelMapper){
        List<Book> books = getAllToBuyBooks();
        List<BookDTO> limitedBooks = new ArrayList<>();
        for (Book book : books) {
            book.setTitle(book.getTitle());
            limitedBooks.add(modelMapper.map(book,BookDTO.class));
        }
        return limitedBooks;
    }

    public void addOrUpdateBook(Book book){
        bookRepository.save(book);
    }

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public List<Book> getAllOwnedBooks(){
        return bookRepository.findByStatus("owned");
    }

    public List<Book> getAllToBuyBooks(){
        return bookRepository.findByStatus("to-buy");
    }
}
