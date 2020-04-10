package com.sample.school.repository;

import java.util.Arrays;

import com.sample.school.vo.Course;

public class CourseRepository {

	private Course[] db = new Course[100];
	private int position = 0;
	private int sequence = 40000;
	
	public CourseRepository() {
		
	}
	public void insertCourse(Course course) {
		course.setNo(sequence);
		db[position] = course;
		position++;
		sequence++;
	}
	
	public Course getCourseByNo(int courseNo) {
		
		return null;
	}
	
	public Course[] getAllCourse() {
		return Arrays.copyOfRange(db, 0, position);
	}
	
}
