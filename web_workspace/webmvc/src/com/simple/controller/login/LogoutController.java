package com.simple.controller.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.simple.controller.Controller;

public class LogoutController implements Controller{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		HttpSession session = req.getSession(false);
		if(session != null) {
			session.invalidate();
		}
		
		/*
		 * HttpServletRequest의 getSession() 메소드
		 * 		HttpSession getSession()
		 * 				* 요청객체에 세션아이디가 없으면 새로운 세션객체를 생성해서 반환한다.
		 * 				* 요청객체에 세션아이디가 있는데, 세션아이디에 해당하는 세션을 발견할 수 없으면 새로운 세션객체를 생성해서 반환한다.
		 * 				* 요청객체에 세션아이디가 있고, 세션아이디에 해당하는 세션객체가 발견되면 그 세션을 반환한다.
		 * 				* 반환값이 결코 null이 아님
		 * 
		 * 		HttpSession getSession(true)
		 * 				* 요청객체에 세션아이디가 없으면 새로운 세션객체를 생성해서 반환한다.
		 * 				* 요청객체에 세션아이디가 있는데, 세션아이디에 해당하는 세션을 발견할 수 없으면 새로운 세션객체를 생성해서 반환한다.
		 * 				* 요청객체에 세션아이디가 있고, 세션아이디에 해당하는 세션객체가 발견되면 그 세션을 반환한다.
		 * 				* 반환값이 결코 null이 아님
		 * 
		 * 		HttpSession getSession(false)
		 * 				* 요청객체에 세션아이디가 없으면 null을 반환한다.
		 * 				* 요청객체에 세션아이디가 있는데, 세션아이디에 해당하는 세션을 발견할 수 없으면 null을 반환한다.
		 * 				* 요청객체에 세션아이디가 있고, 세션아이디에 해당하는 세션객체가 발견되면 그 세션을 반환한다.
		 * 				* 반환값이 null일 수 있음
		 * 
		 */
		
		
		return "redirect:../homt.hta";
	}
}
