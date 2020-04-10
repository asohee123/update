package com.sample.school.repository;

import java.util.Arrays;

import com.sample.school.vo.Professor;

public class ProfessorRepository {

	private Professor[] db = new Professor[100];
	private int position = 0;
	private int sequence = 20000;
	
	public void insertProfessor(Professor professor) {
		
		
	}
	
	public Professor getProfessorByNo(int professorNo) {
		return null;
	}
	
	public Professor[] getAllProfessor() {
		return Arrays.copyOfRange(db, 0, position);
	}
}
