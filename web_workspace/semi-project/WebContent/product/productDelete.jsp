<%@page import="semi.dao.TagDao"%>
<%@page import="semi.dao.ProductDao"%>
<%@page import="semi.dao.ItemDao"%>
<%@page import="semi.util.NumberUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int productNo = NumberUtil.stringToInt(request.getParameter("productno"));

	ItemDao itemDao = new ItemDao();
	ProductDao productDao = new ProductDao();
	TagDao tagDao = new TagDao();
	
	tagDao.deleteTag(productNo);
	itemDao.deleteItem(productNo);
	productDao.deleteImg(productNo);
	productDao.deleteProduct(productNo);
	
	response.sendRedirect("../home.jsp");

%>