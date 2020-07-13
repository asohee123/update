package com.simple.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simple.dto.TodoDto;
import com.simple.service.TodoService;
import com.simple.util.NumberUtil;

import kr.co.jhta.mvc.annotation.Controller;
import kr.co.jhta.mvc.annotation.RequestMapping;
import kr.co.jhta.mvc.servlet.ModelAndView;
import kr.co.jhta.mvc.view.JSONView;

@Controller
public class HomeController {

	private TodoService todoService = new TodoService();
	private JSONView jsonView = new JSONView();

	@RequestMapping("/home.hta")
	public ModelAndView home(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		
		List<TodoDto> dtos = todoService.getRecentTodos();
		
		mav.addAttribute("todos", dtos);
		mav.setViewName("home.jsp");
		
		return mav;
	}
	
	@RequestMapping("/todo/updatestatus.hta")
	public ModelAndView updateTodoStatus(HttpServletRequest req, HttpServletResponse res) throws Exception {
		/*
		 *  요청 파라미터 값 조회
		 *  todoService의 updateStatus(번호, 상태)를 실행하고, 변경된 정보를 반환받는다.
		 *  ModelAndView를 생성해서 Ajax 응답을 제공한다.
		 *  ModelAndView에 반환값과 jsonView을 저장하고, mav를 반환한다.
		 */

		int todoNo = NumberUtil.stringToInt(req.getParameter("todono"));
		String status = req.getParameter("status"); // null 넘어오는 중
		
		ModelAndView mav = new ModelAndView();
		TodoDto dto = todoService.updateTodoStatus(todoNo, status);
		
		mav.addAttribute("todoDto", dto);
		mav.setView(jsonView);
		
		return mav;
	}
}
