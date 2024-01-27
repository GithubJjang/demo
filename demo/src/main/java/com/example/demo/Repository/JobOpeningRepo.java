package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.JobOpening;

public interface JobOpeningRepo extends JpaRepository<JobOpening, Integer> {

}
