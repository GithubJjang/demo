package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class JobOpening {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	private User user;
	
	//@Column(nullable = false)
	private String company;
	
	//@Column(nullable = false)
	private String title;
	
	//@Column(nullable = false)
	private String content;
	
	//@Column(nullable = false)
	private String job;
	
	//@Column(nullable = false)
	private String location;
	
	//@Column(nullable = false)
	private String worktime;
	
	//@Column(nullable = false)
	private String recruitePeriod;
	
	//@Column(nullable = false)
	private String status ;
	
	//@Column(nullable = false)
	private String employmentType;
	
	//@Column(nullable = false)
	private int pay;
	
	//@Column(nullable = false)
	private String payType;// 기타 등...
	
	//@Column(nullable = true)
	private String etc;// 기타 등...

	// getter - setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getWorktime() {
		return worktime;
	}

	public void setWorktime(String worktime) {
		this.worktime = worktime;
	}

	public String getRecruitePeriod() {
		return recruitePeriod;
	}

	public void setRecruitePeriod(String recruitePeriod) {
		this.recruitePeriod = recruitePeriod;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getEmploymentType() {
		return employmentType;
	}

	public void setEmploymentType(String employmentType) {
		this.employmentType = employmentType;
	}

	public int getPay() {
		return pay;
	}

	public void setPay(int pay) {
		this.pay = pay;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getEtc() {
		return etc;
	}

	public void setEtc(String etc) {
		this.etc = etc;
	}
	
	
	
	
	

}
