package com.example.demo.dummyController.Employer;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class EmployerController {
	
	@GetMapping("/home/recruit")
	public String doRecruitment() { //구인공고 작성하기
		// 구인공고 페이지 띄우기.
		// 로그인 했을 경우에만 가능하게.
		// security설정(admin, employer만 해당 페이지 접근이 가능하게끔 권한 설정.)
		return HttpStatus.OK.toString();
	}
	
	
}
