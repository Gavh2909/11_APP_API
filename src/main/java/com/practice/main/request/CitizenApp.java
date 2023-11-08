package com.practice.main.request;

import java.time.LocalDate;

public class CitizenApp {
	private Integer caseNum;

	private String citizenName;

	private String citizen;

	private Long phno;

	private String citizenGender;

	private LocalDate citizenDob;

	private Long citizenSsn;

	public Integer getCaseNum() {
		return caseNum;
	}

	public void setCaseNum(Integer caseNum) {
		this.caseNum = caseNum;
	}

	public String getCitizenName() {
		return citizenName;
	}

	public void setCitizenName(String citizenName) {
		this.citizenName = citizenName;
	}

	public String getCitizen() {
		return citizen;
	}

	public void setCitizen(String citizen) {
		this.citizen = citizen;
	}

	public Long getPhno() {
		return phno;
	}

	public void setPhno(Long phno) {
		this.phno = phno;
	}

	public String getCitizenGender() {
		return citizenGender;
	}

	public void setCitizenGender(String citizenGender) {
		this.citizenGender = citizenGender;
	}

	public LocalDate getCitizenDob() {
		return citizenDob;
	}

	public void setCitizenDob(LocalDate citizenDob) {
		this.citizenDob = citizenDob;
	}

	public Long getCitizenSsn() {
		return citizenSsn;
	}

	public void setCitizenSsn(Long citizenSsn) {
		this.citizenSsn = citizenSsn;
	}
	
	
}
