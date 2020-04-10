package com.sample.school.repository;

import java.util.Arrays;

import com.sample.school.vo.Registration;

public class RegistrationRepository {

	private Registration[] db = new Registration[100];
	private int position = 0;
	private int sequence = 50000;
	
	public void insertRegistration(Registration registration) {
	
	}
	
	public Registration getRegistrationByNo(int registerationNo) {
		return null;
	}
	
	public Registration[] getAllRegistrationis() {
		return Arrays.copyOfRange(db, 0, position);
	}
	
}
