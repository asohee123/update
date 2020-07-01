<%@page import="semi.util.StringUtil"%>
<%@page import="semi.dto.ProductImgDto"%>
<%@page import="java.util.List"%>
<%@page import="semi.dao.ProductDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="/semi-project/common/style.css">
<%
	if("Yes".equals(isLogined) && !("admin".equals(userName))){
		
%>
<nav class="navbar bg-light a fixed navbar-light">
<%
	ProductDao viewDao = new ProductDao();
	List<Integer> views = viewDao.getRecentView(StringUtil.nullToValue(userName, ""));
%>
  <!-- Links -->
  <h4>최근 본 상품</h4>
  <ul class="navbar-nav">
<%
	for(int view : views) {
		ProductImgDto img = viewDao.getProductByNo(view);
%>
    <li class="nav-item">
      <a href="/semi-project/product/detail.jsp?productno=<%=img.getProductNo() %>"><img class="img-thumbnail" src="/semi-project/resources/<%=img.getImg()%>"></a>
    </li>
<%
	}
%>
  </ul>
</nav>

<%
	}
%>
