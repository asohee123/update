<%@page import="semi.dao.AnswerDao"%>
<%@page import="semi.vo.Answer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	request.setCharacterEncoding("utf-8");

	int productNo = Integer.parseInt(request.getParameter("productno"));
	int questionNo = Integer.parseInt(request.getParameter("questionno"));
	int answerNo = Integer.parseInt(request.getParameter("answerno"));
	
	Answer answer = new Answer();
	
	answer.setAnswerNo(answerNo);
	answer.setQuestionNo(questionNo);
	
	AnswerDao answerDao = new AnswerDao();
	answerDao.deleteAnswer(answer);
	
	response.sendRedirect("../product/detail.jsp?productno=" + productNo);
%>