package com.vinay.jobportal.controller;

import com.vinay.jobportal.entity.Application;
import com.vinay.jobportal.entity.Job;
import com.vinay.jobportal.entity.User;
import com.vinay.jobportal.repository.ApplicationRepository;
import com.vinay.jobportal.repository.JobRepository;
import com.vinay.jobportal.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ApplicationRepository applicationRepository;

    @GetMapping("/")
    public String home(Model model) {

        model.addAttribute("jobCount", jobRepository.count());
        model.addAttribute("userCount", userRepository.count());
        model.addAttribute("applicationCount", applicationRepository.count());

        return "index";
    }

    @GetMapping("/jobs-page")
    public String jobsPage(Model model) {

        List<Job> jobs = jobRepository.findAll();
        model.addAttribute("jobs", jobs);

        return "jobs";
    }

    @GetMapping("/users-page")
    public String usersPage(Model model) {

        List<User> users = userRepository.findAll();
        model.addAttribute("users", users);

        return "users";
    }

    @GetMapping("/applications-page")
    public String applicationsPage(Model model) {

        List<Application> applications = applicationRepository.findAll();
        model.addAttribute("applications", applications);

        return "applications";
    }
}