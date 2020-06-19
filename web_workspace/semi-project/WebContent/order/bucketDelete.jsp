<%@page import="java.util.Arrays"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="semi.util.NumberUtil"%>
<%@page import="semi.dao.BucketDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int bucketNo = NumberUtil.stringToInt(request.getParameter("bucketno"));
	
	BucketDao bucketDao = new BucketDao();
	
	if (bucketNo != 0) {	
	
	bucketDao.deleteBucketbyBucketNo(bucketNo);
	
	} else if (bucketNo == 0) {
		
	bucketDao.deleteAutoBucket();
		
	} 
%>