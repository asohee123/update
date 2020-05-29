<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	request.setCharacterEncoding("utf-8");
	String value1 = request.getParameter("value1");
	String value2 = request.getParameter("value2");
	String value3 = request.getParameter("value3");
	String value4 = request.getParameter("value4");
	
	//pageContext, HttpServletRequest, HttpSession, ServletContext객체에 속성값 담기객체에 속성값 담기
	pageContext.setAttribute("p", value1);
	request.setAttribute("r", value2);
	session.setAttribute("s", value3);
	application.setAttribute("a", value4);
	
	//pageContext, HttpServletRequest, HttpSession, ServletContext객체에 저장된 속성값 꺼내기
	String pageContextValue = (String)pageContext.getAttribute("p");
	String requestValue = (String)request.getAttribute("r");
	String sessionValue = (String)session.getAttribute("s");
	String applicationValue = (String)application.getAttribute("a");
	
	System.out.println("page1.jsp의 pageContext에서 조회한 값 : " + pageContextValue);
	System.out.println("page1.jsp의 request에서 조회한 값 : " + requestValue);
	System.out.println("page1.jsp의 session에서 조회한 값 : " + sessionValue);
	System.out.println("page1.jsp의 application에서 조회한 값 : " + applicationValue);
	
	//home.jsp를 재요청하는 응답을 브라우저로 보내기
	response.sendRedirect("home.jsp");
	
	
%>