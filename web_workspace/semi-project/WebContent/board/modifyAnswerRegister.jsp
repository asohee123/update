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
	String title = request.getParameter("title");
	String content = request.getParameter("content");

	Answer answer = new Answer();
	answer.setQuestionNo(questionNo);
	answer.setAnswerNo(answerNo);
	answer.setAnswerTitle(title);
	answer.setAnswerContent(content);
	
	AnswerDao answerDao = new AnswerDao();
	answerDao.modifyAnswer(answer);
	
	response.sendRedirect("../product/detail.jsp?productno=" + productNo);
%>