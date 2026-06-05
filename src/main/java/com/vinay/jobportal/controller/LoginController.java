package com.vinay.jobportal.controller;

import com.vinay.jobportal.entity.User;
import com.vinay.jobportal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(
            @RequestParam String email,
            @RequestParam String password,
            Model model) {

        User user = userRepository.findByEmailAndPassword(email, password);

        if (user != null) {
            return "redirect:/";
        }

        model.addAttribute("error", "Invalid Email or Password");
        return "login";
    }
}