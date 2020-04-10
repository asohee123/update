package com.sample.school.repository;

import java.util.Arrays;

public class StudentRepository {

	private Student[] db = new Student[100];
	private int position = 0;
	private int sequence = 30000;
	
	public void insertStudent(Student student)  {
		
	}
	
	public Student getStudentByNo(int studentNo) {
		return null;
	}
	
	public Student[] getAllStudentt() {
		return Arrays.copyOfRange(db, 0, position);
	}
}
