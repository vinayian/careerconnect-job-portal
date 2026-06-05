package com.vinay.jobportal.controller;

import com.vinay.jobportal.entity.Application;
import com.vinay.jobportal.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/applications")
public class ApplicationController {

    @Autowired
    private ApplicationRepository applicationRepository;

    @PostMapping
    public Application createApplication(@RequestBody Application application) {
        return applicationRepository.save(application);
    }

    @GetMapping
    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }
}
