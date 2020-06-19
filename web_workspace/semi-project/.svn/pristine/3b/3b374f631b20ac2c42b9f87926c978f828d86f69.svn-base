<%@page import="com.google.gson.Gson"%>
<%@page import="semi.dto.ProductDto"%>
<%@page import="java.util.List"%>
<%@page import="semi.util.NumberUtil"%>
<%@page import="semi.dao.ProductDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int categoryNo = NumberUtil.stringToInt(request.getParameter("categoryno"));
	String searchPname = request.getParameter("searchname");
	int minMoney = NumberUtil.stringToInt(request.getParameter("minmoney"));
	int maxMoney = NumberUtil.stringToInt(request.getParameter("maxmoney"));
	int orderBy = NumberUtil.stringToInt(request.getParameter("orderby"));
	
	ProductDao productDao = new ProductDao();
	
	List<ProductDto> dto = productDao.getSearchProduct(categoryNo, searchPname, minMoney, maxMoney, orderBy);

	Gson gson = new Gson();
	
	String jsonContent = gson.toJson(dto);
	
	out.write(jsonContent);
%>