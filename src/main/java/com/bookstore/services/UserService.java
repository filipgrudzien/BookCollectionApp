package com.bookstore.services;

import com.bookstore.entities.User;
import com.bookstore.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getSpecificPerson(int id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        return user;
    }

    /* Hard coded example, current scenario considers only one user
       without option to add more users */
    public User getFirstUser(){
        int id = 1;
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        return user;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
}
