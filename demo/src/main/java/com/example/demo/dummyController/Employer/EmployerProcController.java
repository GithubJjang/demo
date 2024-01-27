package com.example.demo.dummyController.Employer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repository.JobOpeningRepo;
import com.example.demo.Service.UserService;
import com.example.demo.model.JobOpening;
import com.example.demo.model.User;

@RestController
public class EmployerProcController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private JobOpeningRepo jobOpeningRepo;
	
	//Ajax
	//구인공고 페이지 처리
	@GetMapping("/home/recruit/proc")
	public String recuritProc(@RequestBody JobOpening jobOpening) {
		// User는 사용자 세션을 가져오면 해결가능.
		System.out.println("이름: "+jobOpening.getUser().getName());
		User getUser = userService.findUser(jobOpening.getUser());
		jobOpening.setUser(getUser);
		
		// 구인공고 저장하기.
		jobOpeningRepo.save(jobOpening);
		
		return HttpStatus.OK.toString();
	}

}
