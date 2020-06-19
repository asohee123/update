<%@page import="com.google.gson.Gson"%>
<%@page import="com.sample.hr.vo.Employee"%>
<%@page import="com.sample.hr.dao.EmployeeDao"%>
<%@page import="com.simple.util.NumberUtil"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	int employeeId = NumberUtil.stringToInt(request.getParameter("id"));

	EmployeeDao employeeDao = new EmployeeDao();
	Employee emp = employeeDao.getEmployeeById(employeeId);
	
	Gson gson = new Gson();
	
	String jsonContent = gson.toJson(emp);
	
	out.write(jsonContent);
%>
    
    