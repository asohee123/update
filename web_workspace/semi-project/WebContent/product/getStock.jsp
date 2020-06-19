<%@page import="com.google.gson.Gson"%>
<%@page import="semi.vo.Item"%>
<%@page import="semi.dao.ItemDao"%>
<%@page import="semi.util.NumberUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	int productNo = NumberUtil.stringToInt(request.getParameter("productNo"));
	String productSize = request.getParameter("productSize");
	String productColor = request.getParameter("productColor");
		 
	System.out.println(productNo);
	System.out.println(productSize);
	System.out.println(productColor);
	
	ItemDao itemDao = new ItemDao();
	Item item = itemDao.getItemBySizeAndColor(productNo, productColor, productSize);
	
	int stock = item.getStock();
	
	Gson gson = new Gson();
	String resultStock = gson.toJson(stock);
	
	out.write(resultStock);
	
%>