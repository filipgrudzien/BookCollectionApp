package com.bookstore.controllers;

import com.bookstore.entities.OwnedBook;
import com.bookstore.services.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/collection")
public class OwnedBooksController {

    @Autowired
    private BookService bookService;

    @Autowired
    private ModelMapper modelMapper;

    @RequestMapping("/simpleall")
    public String showStorePage(Model model){
        model.addAttribute("books", bookService.getAllBooksDTO(modelMapper));
        return "mybooks-view";
    }

    @RequestMapping("detailed/{id}")
    public String showDetailedBook(@PathVariable int id, Model model){
        OwnedBook detailedBook = bookService.getSpecificBook(id);
        model.addAttribute("book", detailedBook);
        return "detail-view";
    }
}

/*
//@RequestMapping(value = "/edit/{id}", method = {RequestMethod.GET, RequestMethod.POST})
    @RequestMapping(value = "/edit/{id}")
    public String editPerson(@PathVariable long id, Model model) {

        Person person = personService.getSpecificPerson(id);
        model.addAttribute("person", person);
        return "edit-person";
    }

    //@RequestMapping(value = "/update/{id}", method = {RequestMethod.PUT, RequestMethod.POST, RequestMethod.GET})
    @RequestMapping(value = "/update/{id}")
    public String updatePerson(@PathVariable("id") long id, Model model, @Valid Person person, Errors errors) {

        if(errors.hasErrors()){
            model.addAttribute("person", person);
            return "edit-person";
        }

        personService.insertOrUpdatePerson(person);
        model.addAttribute("people", personService.getAllPeople());
        return "redirect:/";
    }
* */