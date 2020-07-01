<%@page import="semi.dao.QuestionDao"%>
<%@page import="semi.vo.Question"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	request.setCharacterEncoding("utf-8");
	
	int productNo = Integer.parseInt(request.getParameter("productno"));
	int questionNo = Integer.parseInt(request.getParameter("questionno"));
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	
	Question question = new Question();
	question.setNo(questionNo);
	question.setProductNo(productNo);
	question.setTitle(title);
	question.setContent(content);
	
	QuestionDao questionDao = new QuestionDao();
	questionDao.modifyQuestion(question);
	
	response.sendRedirect("../product/detail.jsp?productno=" + productNo);
%>