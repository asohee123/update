<%@page import="com.google.gson.Gson"%>
<%@page import="semi.vo.Item"%>
<%@page import="semi.dao.ItemDao"%>
<%@page import="semi.dao.ProductDao"%>
<%@page import="semi.util.NumberUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	 request.setCharacterEncoding("utf-8");

	 int inputAmount = NumberUtil.stringToInt(request.getParameter("inputAmount"));
	 int productNo = NumberUtil.stringToInt(request.getParameter("productNo"));
	 String productSize = request.getParameter("productSize");
	 String productColor = request.getParameter("productColor");
	 	 
	 System.out.println(inputAmount);
	 System.out.println(productNo);
	 System.out.println(productSize);
	 System.out.println(productColor);
	 
	 ItemDao itemDao = new ItemDao();
	 
	 Item findItem = itemDao.getItemBySizeAndColor(productNo, productColor, productSize);
	 
	 int findStock = findItem.getStock();
	 
	 String YorN = "";
	 
	 // 재고가 부족한가?
	 if (inputAmount > findStock) {
		 YorN = "Y";
	 } else {
		 YorN = "N";
	 }
	 
	 Gson gson = new Gson();
	 
	 String YN = gson.toJson(YorN);
	 
	 out.write(YN);
	 
	 
%>
