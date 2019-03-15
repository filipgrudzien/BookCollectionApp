package com.bookstore.controllers;

import com.bookstore.entities.Book;
import com.bookstore.services.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
        System.out.println(detailedBook);
        return "detail-view";
    }
}