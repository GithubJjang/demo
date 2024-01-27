package com.example.demo.dummyController.Employer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repository.JobOpeningRepo;
import com.example.demo.model.JobOpening;

@RestController
public class EmployerController {
	
	@Autowired
	private JobOpeningRepo jobOpeningRepo;
	
	@GetMapping("/test")
	public String wirteRecruitment() {
		JobOpening job1 = new JobOpening();
		job1.setLocation("대구");
		job1.setPayType("계약직");
		job1.setPay(100);
		job1.setStatus("고용중");
		
		JobOpening job2 = new JobOpening();
		job2.setLocation("대구");
		job2.setPayType("일용직");
		job2.setPay(100);
		job2.setStatus("고용중");
		
		JobOpening job3 = new JobOpening();
		job3.setLocation("대구");
		job3.setPayType("일용직");
		job3.setPay(100);
		job3.setStatus("마감");

		JobOpening job4 = new JobOpening();
		job4.setLocation("서울");
		job4.setPayType("계약직");
		job4.setPay(10);
		job4.setStatus("마감");
		
		jobOpeningRepo.save(job1);
		jobOpeningRepo.save(job2);
		jobOpeningRepo.save(job3);
		jobOpeningRepo.save(job4);
		
		return HttpStatus.OK.toString();
	}

}
