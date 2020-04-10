package com.sample.school.repository;

import java.util.Arrays;

import com.sample.school.vo.Subject;

public class SubjectRepository {

	private Subject[] db = new Subject[100];
	private int position = 0;
	private int sequence = 30000;
	
	public void insertSubject(Subject subject)  {
		
	}
	
	public Subject getSubjectByNo(int subjectNo) {
		return null;
	}
	
	public Subject[] getAllSubject() {
		return Arrays.copyOfRange(db, 0, position);
	}
}
