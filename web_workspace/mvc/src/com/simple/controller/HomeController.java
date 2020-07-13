package com.simple.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simple.dao.BookDao;
import com.simple.vo.Book;

import kr.co.jhta.mvc.annotation.Controller;
import kr.co.jhta.mvc.annotation.RequestMapping;
import kr.co.jhta.mvc.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping("/home.hta")
	public ModelAndView home(HttpServletRequest req, HttpServletResponse res) throws Exception{
		ModelAndView mav = new ModelAndView();
		
		mav.addAttribute("message", "홈페이지 방문을 환영합니다.");
		mav.setViewName("home.jsp");
		
		BookDao bookDao = new BookDao();
		List<Book> books = bookDao.getRecentBooks();
		mav.addAttribute("recentBooks", books);
			
		return mav;
	}
}