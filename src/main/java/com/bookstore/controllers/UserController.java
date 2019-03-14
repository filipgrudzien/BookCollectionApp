package com.bookstore.controllers;

import com.bookstore.entities.User;
import com.bookstore.services.BookService;
import com.bookstore.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/profile")
    public String showProfilePage(Model model){
        model.addAttribute("user", userService.getFirstUser());
        return "profile";
    }

    @RequestMapping("editprofile/{id}")
    public String showEditProfilePage(@PathVariable int id, Model model){
        model.addAttribute("user", userService.getSpecificUser(id));
        return "edit-profile";
    }

    @RequestMapping("update/{id}")
    public String updatePerson(@PathVariable("id") int id, Model model, @Valid User user, Errors errors) {

        if(errors.hasErrors()){
            model.addAttribute("user", user);
            return "edit-profile";
        }

        userService.updateUser(user);
        return "index";
    }

}
