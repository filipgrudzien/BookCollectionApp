package com.bookstore.controllers;

import com.bookstore.services.BookService;
import com.bookstore.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/profile")
    public String showMainPage(Model model){
        model.addAttribute("user", userService.getFirstUser());
        System.out.println(userService.getFirstUser());
        return "profile";
    }

}
