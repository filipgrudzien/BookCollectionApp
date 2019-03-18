package com.bookstore.controllers;

import com.bookstore.entities.User;
import com.bookstore.services.UserService;
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

    @RequestMapping("/editprofile/{id}")
    public String showEditProfilePage(@PathVariable int id, Model model){
        model.addAttribute("user", userService.getSpecificUser(id));
        return "edit-profile";
    }

    //public String updatePerson(@PathVariable("id") int id, Model model, @Valid User user, Errors errors)

    @RequestMapping("/update/{id}")
    public String updatePerson(@PathVariable("id") int id, Model model, @Valid User user, Errors errors) {

        if(errors.hasErrors()){
            model.addAttribute("user", user);
            return "edit-profile";
        }

        System.out.println(user);
        userService.updateUser(user);

        return "redirect:/user/profile";
    }

    @RequestMapping("/ownedbooks")
    public String redirectToOwnedBooksManager(){
        return "redirect:/collection/ownedmanager";
    }

    @RequestMapping("/tobuybooks")
    public String redirectToToBuyBooksManager(){
        return "redirect:/collection/tobuymanager";
    }

}
