package com.example.demo.Service;

import java.util.Optional;

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
	
	// dummy 메서드
	public User findUser(User user) {
		
		// User를 못찾으면, NPE발생, 아니면 해당 USER반환.
		User findUser = Optional.ofNullable(userRepo.findByName(user.getName()))
				 						  .orElseGet(()->{
				 							  throw new NullPointerException("There is no User which you find");
				 						  });
		return findUser;
	}
}
