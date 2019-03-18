package com.bookstore.controllers;

import com.bookstore.entities.Book;
import com.bookstore.services.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/collection")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private ModelMapper modelMapper;

    @RequestMapping("/simpleall")
    public String showStorePage(Model model){
        model.addAttribute("ownedbooks", bookService.getAllOwnedBooksDTO(modelMapper));
        model.addAttribute("tobuybooks", bookService.getAllToBuyBooksDTO(modelMapper));
        return "mybooks-view";
    }

    @RequestMapping("detailed/{id}")
    public String showDetailedBook(@PathVariable int id, Model model){
        Book detailedBook = bookService.getSpecificBook(id);
        model.addAttribute("book", detailedBook);
        return "detail-view";
    }

    @RequestMapping("/ownedmanager")
    public String showOwnedBooksManager(Model model){
        model.addAttribute("ownedbooks", bookService.getAllOwnedBooksDTO(modelMapper));
        return "mybooks-manager";
    }

    @RequestMapping("/tobuymanager")
    public String showToBuyBooksManager(Model model){
        model.addAttribute("tobuybooks", bookService.getAllToBuyBooksDTO(modelMapper));
        return "tobuybooks-manager";
    }

    @RequestMapping("/add")
    public String showAddingOnwedBook(Model model){
        model.addAttribute("book", new Book());
        return "add-book";
    }

    @RequestMapping("/create")
    public String showAddingOnwedBook(@Valid Book book, Errors errors, Model model){

        if(errors.hasErrors()){
            return "add-book";
        }

        bookService.addNewBook(book);
        model.addAttribute("books", bookService.getAllOwnedBooksDTO(modelMapper));
        return "mybooks-manager";
    }
}