<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String saveDirectory = "c:files";
	int maxPostSize = 1024*1024*10;
	String encoding = "utf-8";
	
	// MultipartRequest 객체
	// * cos.jar 라이브러리에서 첨부파일 업로드를 지원하는 클래스다.
	// * 첨부파일이 저장될 디렉토리, 최대 업로드 사이즈, 문자인코딩 방식을 지정하면 
	// 	  객체 생성시 첨부파일이 지정된 디렉토리에 자동으로 저장된다.
	// * 요청파라미터값을 조회하는 기능과 파일이름을 조회하는 기능을 제공한다.
	// * 요청파라미터값을 조회하는 기능
	//		String getParameter(String name)
	//		String[] getParameterValues(String name)
	// * 파일명을 조회하는 기능
	//		String getFilesystemName(String name)
	//		String getOriginalFileName(String name)
	MultipartRequest mr = new MultipartRequest(request, saveDirectory, maxPostSize, encoding);
	
	String title = mr.getParameter("title");
	String filename = mr.getFilesystemName("upfile");
	
	System.out.println("제목 : " + title + "이름 : " + filename);
%>