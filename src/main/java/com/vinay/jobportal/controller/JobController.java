package com.vinay.jobportal.controller;

import com.vinay.jobportal.entity.Job;
import com.vinay.jobportal.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {

    @Autowired
    private JobRepository jobRepository;

    @PostMapping
    public Job createJob(@RequestBody Job job) {
        return jobRepository.save(job);
    }

    @GetMapping
    public List<Job> getAllJobs() {
        return jobRepository.findAll();

    }
    @GetMapping("/{id}")
    public Job getJobById(@PathVariable Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Job updateJob(@PathVariable Long id, @RequestBody Job updatedJob) {

        Job job = jobRepository.findById(id).orElse(null);

        if (job != null) {
            job.setTitle(updatedJob.getTitle());
            job.setCompany(updatedJob.getCompany());
            job.setLocation(updatedJob.getLocation());
            job.setDescription(updatedJob.getDescription());
            job.setSalary(updatedJob.getSalary());

            return jobRepository.save(job);
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public String deleteJob(@PathVariable Long id) {
        jobRepository.deleteById(id);
        return "Job deleted successfully";
    }

}