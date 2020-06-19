<%@page import="com.google.gson.Gson"%>
<%@page import="semi.dao.BucketDao"%>
<%@page import="semi.dto.BucketDto"%>
<%@page import="semi.util.NumberUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int inputstock = NumberUtil.stringToInt(request.getParameter("inputStock"));
	int bucketNo = NumberUtil.stringToInt(request.getParameter("bucketNo"));
	
	BucketDao bucketDao = new BucketDao();
	
	BucketDto bucketDto = bucketDao.getProductStockBybucketNo(bucketNo);
	
	int productStock = bucketDto.getProductStock();
	
	Gson gson = new Gson();
	
	out.write(gson.toJson(productStock));
	
%>