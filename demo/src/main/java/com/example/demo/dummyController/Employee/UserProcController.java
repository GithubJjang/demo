package com.example.demo.dummyController.Employee;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repository.JobOpeningRepo;
import com.example.demo.Repository.UserAndJobRepo;
import com.example.demo.Repository.UserRepo;

import com.example.demo.Service.UserService;
import com.example.demo.model.JobOpening;
import com.example.demo.model.User;
import com.example.demo.model.UserAndjob;



@RestController
public class UserProcController {
	
	@Autowired
	private UserService userService;
	
	//
	@Autowired
	private UserAndJobRepo userAndJobRepo;
	
	@Autowired
	private JobOpeningRepo jobOpeningRepo;
	

	
	
	// dummy
	@Autowired
	private UserRepo userRepo;
	
	
	
	//Ajax를 고려하여 설계.
	@GetMapping("/home/sign/proc")
	public ResponseEntity<Object> signProc(@RequestBody User user) {
		// 회원가입 처리.(Ajax)
		System.out.println(user.getName());
		System.out.println(user.getRoleType());
		userService.signUp(user);
		return ResponseEntity.ok(HttpStatus.OK);
	}
	
	@GetMapping("/home/ncs/proc")
	public ResponseEntity<Object> ncsProc(@RequestBody UserAndjob userAndjob ){
		
		// 
		User findUser = userRepo.findByName(userAndjob.getUser().getName());
		Optional<JobOpening> findjob;
		try {
			findjob = jobOpeningRepo.findById(userAndjob.getJobOpening().getId());
		} catch (Exception e) {
			throw new NullPointerException("Error occur at /home/ncs/proc");
		}
		
		JobOpening getJob = findjob.get();
		
 		//
		UserAndjob inputData = new UserAndjob();
		inputData.setUser(findUser);
		inputData.setJobOpening(getJob);
		
		// UserAndjob테이블에 저장
		userAndJobRepo.save(inputData);
		
		return ResponseEntity.ok(HttpStatus.OK);
	}

}
