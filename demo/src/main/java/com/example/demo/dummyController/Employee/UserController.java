package com.example.demo.dummyController.Employee;

import java.util.List;
import java.util.Optional;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repository.JobOpeningRepo;

import com.example.demo.Service.UserService;

import com.example.demo.model.JobOpening;
import com.example.demo.model.User;

import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;



@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private JobOpeningRepo jobOpeningRepo;// user가 건들필요 x
	
	
	@GetMapping("/home")
	public String getIndex() {
		// 초기화면 반환을 한다.
		return HttpStatus.OK.toString();
	}
	
	
	@GetMapping("/home/signup")
	public String signUp(@RequestBody User user) {
		// 회원가입 페이지.
		userService.signUp(user);
		return HttpStatus.OK.toString();
	}
	
	
	@GetMapping("/home/login")
	public String Login() {
		// 로그인 화면 반환을 한다.
		// 그리고 시큐리티를 이용해서 세션을 user에 준다.
		// JWT 토큰으 토큰 관리 어려움. 사용 미숙.
		return HttpStatus.OK.toString();
	}
	
	@SuppressWarnings("unlikely-arg-type")
	@ResponseBody
	@GetMapping("/home/ncs")
	public List<JobOpening>  chooseOptions(@RequestBody JobOpening jobOpening) {
		// 페이지
		// jobOReducation
		// User(세션)
		
		// select * from where job=? and location ? ... 총 쿼리 2^7개 만큼 생성??? <- 못함
		// 차라리 다 가져온 후, Stream의 filter을 이용하자	
		// 만약, 데이터가 없는경우, NPE오류를 강제로 발생

		List<JobOpening> findJoblist = Optional.ofNullable(jobOpeningRepo.findAll())
												   .orElseGet(() ->{
													  throw new NullPointerException("There is no any data in jobOpening_Table");
												   }
												   
												   );
		
		List<JobOpening> getList = findJoblist.stream()
										/*
									   .filter(e->{
										   if(e.equals(jobOpening.getJob()) || e.equals("전체")) {
											   return true;
										   }
										   else {
											   return false;
										   }
									   })
										*/
									   .filter(e->{
										   
										   if(e.getLocation().equals(jobOpening.getLocation())|| jobOpening.getLocation().equals("전체")) {

											   return true;
										   }
										   else {
											   return false;
										   }
									   })
									   /*					   
									   .filter(e->{
										   if(e.equals(jobOpening.getWorktime())|| e.equals("전체")) {
											   return true;
										   }
										   else {
											   return false;
										   }
									   })
									   */
									   /*
									   .filter(e->{
										   if(e.equals(jobOpening.getRecruitePeriod())|| e.equals("전체")) {
											   return true;
										   }
										   else {
											   return false;
										   }
									   })
									   */
									   .filter(e->{
										   if(e.getStatus().equals(jobOpening.getStatus())|| jobOpening.getStatus().equals("전체")) {
											   return true;
										   }
										   else {
											   return false;
										   }
									   })
									   /*
									   .filter(e->{
										   if(e.equals(jobOpening.getEmploymentType())|| e.equals("전체")) {
											   return true;
										   }
										   else {
											   return false;
										   }
									   })
									   */
									   .filter(e->{
										   if((e.getPay()==jobOpening.getPay())|| jobOpening.equals("전체")) {
											   return true;
										   }
										   else {
											   return false;
										   }
									   })
									   .toList();
				   
		return getList;
	}
	
}
