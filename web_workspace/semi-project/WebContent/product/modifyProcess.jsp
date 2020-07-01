<%@page import="semi.util.NumberUtil"%>
<%@page import="semi.dao.TagDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="semi.dao.ItemDao"%>
<%@page import="semi.dao.ProductDao"%>
<%@page import="semi.vo.Product"%>
<%@page import="semi.util.StringUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	int productNo = Integer.parseInt(request.getParameter("productno"));

	String productName = request.getParameter("productname");
	int price = Integer.parseInt(request.getParameter("price"));
	int discountPrice = Integer.parseInt(request.getParameter("discountprice"));
	String description = StringUtil.strWithBr(request.getParameter("description"));
	
	Product product = new Product();
	product.setProductName(productName);
	product.setPrice(price);
	product.setDiscountPrice(discountPrice);
	product.setDescription(description);
	
	ProductDao productDao = new ProductDao();
	productDao.updateProduct(product, productNo);
	
	int[] stock = new int[6]; 
	stock[0] = NumberUtil.stringToInt(request.getParameter("mb"));
	stock[1] = NumberUtil.stringToInt(request.getParameter("mw"));
	stock[2] = NumberUtil.stringToInt(request.getParameter("lb"));
	stock[3] = NumberUtil.stringToInt(request.getParameter("lw"));
	stock[4] = NumberUtil.stringToInt(request.getParameter("xb"));
	stock[5] = NumberUtil.stringToInt(request.getParameter("xw"));
	System.out.println(stock[0]);
	
	ItemDao itemDao = new ItemDao();
	stock[0] += itemDao.getItemBySizeAndColor(productNo, "black", "M").getStock();
	stock[1] += itemDao.getItemBySizeAndColor(productNo, "white", "M").getStock();
	stock[2] += itemDao.getItemBySizeAndColor(productNo, "black", "L").getStock();
	stock[3] += itemDao.getItemBySizeAndColor(productNo, "white", "L").getStock();
	stock[4] += itemDao.getItemBySizeAndColor(productNo, "black", "XL").getStock();
	stock[5] += itemDao.getItemBySizeAndColor(productNo, "white", "XL").getStock();
	System.out.println(stock[0]);
	itemDao.updateStock(stock, productNo);
	
	List<String> tags = new ArrayList<String>();
	tags.add(request.getParameter("tag1"));
	tags.add(request.getParameter("tag2"));
	tags.add(request.getParameter("tag3"));
	tags.add(request.getParameter("tag4"));
	
	TagDao tagDao = new TagDao();
	tagDao.deleteTag(productNo);
	tagDao.insertTag(tags, productNo);
	
	response.sendRedirect("detail.jsp?productno=" + productNo);
%>