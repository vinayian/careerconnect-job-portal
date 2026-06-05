package com.vinay.jobportal.repository;

import com.vinay.jobportal.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
}