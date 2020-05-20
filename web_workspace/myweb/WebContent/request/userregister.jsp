<%@page import="com.sample.dao.UserDao"%>
<%@page import="com.sample.vo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		
		User user = new User();
		user.setId(id);
		user.setName(name);
		user.setPassword(password);
		user.setEmail(email);
		
		UserDao userDao = new UserDao();
		userDao.insertUser(user);
		
	%>

	<dl>
		<dt>아이디</dt>
		<dd><%=id %></dd>
	</dl>
	
	<dl>
		<dt>이름</dt>
		<dd><%=name %></dd>
	</dl>
	
	<dl>
		<dt>비밀번호</dt>
		<dd><%=password %></dd>
	</dl>
	
	<dl>
		<dt>이메일</dt>
		<dd><%=email %></dd>
	</dl>
	
</body>
</html>