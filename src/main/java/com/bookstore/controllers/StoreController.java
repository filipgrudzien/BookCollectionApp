package com.bookstore.controllers;

import com.bookstore.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StoreController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/store")
    public String showStorePage(Model model){
        model.addAttribute("books", bookService.getAllBooks());
        return "store-view";
    }

}
