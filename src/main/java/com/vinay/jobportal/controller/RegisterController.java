package com.vinay.jobportal.controller;

import com.vinay.jobportal.entity.User;
import com.vinay.jobportal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegisterController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/register")
    public String showRegisterPage(User user) {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(User user) {

        userRepository.save(user);

        return "redirect:/users-page";
    }
}