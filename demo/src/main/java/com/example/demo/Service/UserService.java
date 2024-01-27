package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.UserRepo;
import com.example.demo.model.User;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;
	

	
	// 1. 회원가입.
	public void signUp(User user) {
		userRepo.save(user);
	}
}
