package com.simple.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simple.dao.UserDao;
import com.simple.vo.User;

import kr.co.jhta.mvc.annotation.RequestMapping;
import kr.co.jhta.mvc.servlet.ModelAndView;

public class UserService {

	private UserDao userDao = new UserDao();
	
	public boolean insertUser(User user) throws Exception {
		User savedUser = userDao.getUserById(user.getId());
		
		if(savedUser != null) {
			return false;
		} 
		userDao.insertUser(user);
		
		return true;
	}
	
	public User loginCheck(String id, String password) throws Exception {
		User user = userDao.getUserById(id);
		
		if(null == user) {
			System.out.println("1111");
			return null;
		} 
		if(!user.getPassword().equals(password)) {
			System.out.println("2222");
			return null;
		}
		// 전달 받은 아이디로 사용자 정보를 조회한다.	
		// 사용자 정보가 존재하지 않으면 null 반환
		// 비밀번호가 일치하지 않으면 null 반환
		// 그 외는 조회된 사용자 정보를 반환한다.

		return user;
	}
	

}
	
