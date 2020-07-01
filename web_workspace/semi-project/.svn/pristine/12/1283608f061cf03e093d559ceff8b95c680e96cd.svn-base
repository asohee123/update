<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.google.gson.JsonObject"%>
<%@page import="java.util.ArrayList"%>
<%@page import="semi.vo.Pagination"%>
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
	int pageNo = NumberUtil.stringToInt(request.getParameter("pageNo"));

	
	ProductDao productDao = new ProductDao();
	

	int cnt = productDao.getSearchRows(categoryNo, searchPname, minMoney, maxMoney, orderBy);

	Pagination pagination = new Pagination(9,5,pageNo, cnt);
	int beginIndex = pagination.getBeginIndex();
	int endIndex = pagination.getEndIndex();
	int totalPage = pagination.getTotalPages();
	
	List<ProductDto> dtoList = productDao.getSearchProduct(categoryNo, searchPname, minMoney, maxMoney, orderBy, beginIndex , endIndex);
	int begin = pagination.getBeginPage();
	int end = pagination.getEndPage();
	
	Map<String, Object> result = new HashMap<String, Object>();
	result.put("totalPage", totalPage);
	result.put("begin", begin);
	result.put("end", end);
	result.put("dtoList", dtoList);
	
	Gson gson = new Gson();
	String jsonData = gson.toJson(result);
	
	out.write(jsonData);
%>