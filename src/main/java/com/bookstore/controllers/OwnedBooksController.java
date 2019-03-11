package com.bookstore.controllers;

import com.bookstore.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/collection")
public class OwnedBooksController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/simpleall")
    public String showStorePage(Model model){
        model.addAttribute("books", bookService.getAllBooks());
        return "store-view";
    }

}
