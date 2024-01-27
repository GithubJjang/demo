package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.UserAndjob;

public interface UserAndJobRepo extends JpaRepository<UserAndjob, Integer> {

}
