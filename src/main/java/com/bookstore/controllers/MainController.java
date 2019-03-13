package com.bookstore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    /// later probably there is going to be a need for adding model parameter
    @RequestMapping("/")
    public String showMainPage(Model model){
        return "index";
    }

}
