<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="navibar">
	<ul>
		<li><a href="/simple-board/home.jsp">홈</a></li>
		<li><a href="/simple-board/board/list.jsp">게시판</a></li>
		<li><a href="/simple-board/user/my.jsp">내정보</a></li>
		
	<% 
		String isLogined = (String)session.getAttribute("LOGINED_YN");
	
		if("Yes".equals(isLogined)){
	%>
		<li class="right"><a href="/simple-board/user/logout.jsp">로그아웃</a></li>
		
	<%
		} else {
	%>
		<li class="right"><a href="/simple-board/user/loginform.jsp">로그인</a></li>
		<li class="right"><a href="/simple-board/user/form.jsp">회원가입</a></li>
	<%
		}	
	%>
	</ul>
	<%
		if("Yes".equals(isLogined)){
		String userName = (String)session.getAttribute("LOGINED_USER_NAME");
	%>
	<p><%=userName %>님 환영합니다.</p>
	<%
		}
	%>
</div>