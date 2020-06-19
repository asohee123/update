<%@page import="semi.util.StringUtil"%>
<%@page import="semi.dao.TagDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="semi.dao.ItemDao"%>
<%@page import="semi.vo.Item"%>
<%@page import="semi.dao.ProductDao"%>
<%@page import="semi.vo.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String saveDirectory = "C:\\Projects\\web_workspace\\semi-project\\WebContent\\resources";
	int maxPostSize = 10485760;
	String encoding = "utf-8";
	
	
	MultipartRequest mr = new MultipartRequest(request, saveDirectory, maxPostSize, encoding, new DefaultFileRenamePolicy());
	
	// 상품등록 register
	String productName = mr.getParameter("productname");
	int price = Integer.parseInt(mr.getParameter("price"));
	int discountPrice = Integer.parseInt(mr.getParameter("discountprice"));
	int point = Integer.parseInt(mr.getParameter("point"));
	String description = StringUtil.strWithBr(mr.getParameter("description"));
	int categoryNo = Integer.parseInt(mr.getParameter("category"));
	
	Product product = new Product();
	product.setProductName(productName);
	product.setPrice(price);
	product.setDiscountPrice(discountPrice);
	product.setPoint(point);
	product.setDescription(description);
	product.setCategoryNo(categoryNo);
	
	ProductDao productDao = new ProductDao();
	productDao.insertProduct(product);
	
	int lastProductNo = productDao.getLastProductNo();
	
	// 상품 이미지 등록	
	String productImg = mr.getFilesystemName("productimg");
	productDao.insertImage(productImg, lastProductNo);
	
	// 상품재고 register
	int[] stock = new int[6]; 
	stock[0] = Integer.parseInt(mr.getParameter("mb"));
	stock[1] = Integer.parseInt(mr.getParameter("mw"));
	stock[2] = Integer.parseInt(mr.getParameter("lb"));
	stock[3] = Integer.parseInt(mr.getParameter("lw"));
	stock[4] = Integer.parseInt(mr.getParameter("xb"));
	stock[5] = Integer.parseInt(mr.getParameter("xw"));
	
	ItemDao itemDao = new ItemDao();
	itemDao.insertStock(stock, lastProductNo);
	
	// 태그 register
	List<String> tags = new ArrayList<String>();
	tags.add(mr.getParameter("tag1"));
	tags.add(mr.getParameter("tag2"));
	tags.add(mr.getParameter("tag3"));
	tags.add(mr.getParameter("tag4"));
	
	TagDao tagDao = new TagDao();
	tagDao.insertTag(tags, lastProductNo);
	
	response.sendRedirect("../home.jsp");
%>