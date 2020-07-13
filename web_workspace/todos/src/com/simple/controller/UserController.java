package com.simple.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.simple.service.UserService;
import com.simple.vo.User;

import kr.co.jhta.mvc.annotation.Controller;
import kr.co.jhta.mvc.annotation.RequestMapping;
import kr.co.jhta.mvc.servlet.ModelAndView;
import kr.co.jhta.mvc.view.JSONView;

@Controller
public class UserController {

	private JSONView jsonView = new JSONView();
	private UserService userService = new UserService();
	
	@RequestMapping("/register.hta")
	public ModelAndView registerUser(HttpServletRequest req, HttpServletResponse res) throws Exception {
	
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String pwd = req.getParameter("pwd");
		String email = req.getParameter("email");
		
		User user = new User();
		user.setId(id);
		user.setName(name);
		user.setPassword(pwd);
		user.setEmail(email);
		
		boolean isSuccess = userService.insertUser(user);
		
		ModelAndView mav = new ModelAndView();
		mav.addAttribute("result", isSuccess);
		mav.setView(jsonView); // 클라이언트에 jsonText 응답을 제공
							   // {"result":true} 혹은 {"result":false} JSON 텍스트에
		
		return mav;
		
	}
	
	@RequestMapping("/login.hta")
	public ModelAndView login(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// 요청파라미터 정보를 조회한다.
		String id = req.getParameter("userid");
		String pwd = req.getParameter("userpwd");

		User user = userService.loginCheck(id, pwd);
		
		ModelAndView mav = new ModelAndView();
		
		if(user == null) {
			mav.addAttribute("result", false);

		} else {
			mav.addAttribute("result", true);
			HttpSession session = req.getSession();
			session.setAttribute("loginUser", user);
		}
		mav.setView(jsonView);
		
		
		
		return mav;
		// UserService의 loginCheck(String id, String password)를 실행한다.
		// 반환값이 null이면 UserModelAndView의 result -> false를 저장한다.
		// 반환값이 null이 아니면 ModelAndView에 reuslt -> true를 저장한다.
		//					HttpSession 객체를 획득해서 "loginUser"라는 속성멱으로 사용자정보를 세션에 저장한다.
	}
	@RequestMapping("/logout.hta")
	public ModelAndView logout(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// 세션을 무효화 시킨다.
		// home.hta를 재요청하게 한다. --> ModelAndView에 재요청URL을 담는다.
		
		ModelAndView mav = new ModelAndView();
		
		HttpSession session = req.getSession(false);
		
		if(session != null) {
			session.invalidate();
		}
		mav.setViewName("redirect:/home.hta");
		return mav;
	}
}
