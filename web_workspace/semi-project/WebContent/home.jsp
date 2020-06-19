<%@page import="semi.vo.Tag"%>
<%@page import="semi.vo.Pagination"%>
<%@page import="semi.util.NumberUtil"%>
<%@page import="semi.dto.ProductDto"%>
<%@page import="semi.dao.ProductDao"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <title></title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" 
  integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
<style>
	p {
		font-size: 13px;
	}
	del {
		color:lightgray;
		font-size: 13px;
	}
	a {
		color: black;
	}
</style>
</head>
<body onload="deletebucket()">
<%
	ProductDao productDao = new ProductDao();
	int category = NumberUtil.stringToInt(request.getParameter("category"));
	
	// 페이징 처리
	int pageNo = NumberUtil.stringToInt(request.getParameter("page"), 1);
	int totalRows = productDao.getTotalRows(category);
	
	// new Pagination(한 페이지당 글 수, 블록당 페이지번호 수, 현재 페이지번호, 전체 게시글수)
	Pagination pagination = new Pagination(9, 5, pageNo, totalRows);

	List<ProductDto> products = productDao.getAllProducts(category, pagination.getBeginIndex(), pagination.getEndIndex());
%>
<%@ include file="/common/navibar.jsp" %>
<div class="container"> 
	<div class="row">		
	<%
		int count = 1;
		List<String> tags;
		for (ProductDto product : products) {
	%>
		<div class="col-sm-4 text-center">
	    	<a href="product/detail.jsp?productno=<%=product.getProductNo()%>"><img class="img-thumbnail" src="resources/<%=product.getImg()%>"></a>
	    	<p><a href="product/detail.jsp?productno=<%=product.getProductNo()%>"><%=product.getpName() %></a></p>
	<%
	    	if(count <= 3 && pageNo == 1) {
   	%>
	    	<span class="badge badge-pill badge-danger">New</span>
   	<%
	    	}
			++count;
   	%>
   	<%
			tags = productDao.getTagsByProductNo(product.getProductNo());
			for(String tag : tags) {
	   			if("EARLYBIRD OPEN".equals(tag) || "TIME SALE".equals(tag)) {
   	%>
   			<span class="badge badge-pill badge-danger"><%=tag %></span>
   	<%
	   			} else if("주인장 추천".equals(tag) || "자체제작".equals(tag)) {
   	%>
   			<span class="badge badge-pill badge-dark"><%=tag %></span>
   	<%
				}   	
			}
   	%>
	    	<p><a href="product/detail.jsp?productno=<%=product.getProductNo()%>"><%=product.getDescription() %></a></p>
	    	<del><%=NumberUtil.numberWithComma(product.getPrice()) %> won</del>
	    	<p><%=NumberUtil.numberWithComma(product.getDiscountPrice()) %> won</p>
	    </div> 
    <%
		}
    %>	
  	</div>  	
  	
  	<!-- Pagination -->
  	<div class="row justify-content-center">
  		<ul class="pagination">
  		<%
				if (pagination.getPageNo() > 1) {
		%>
				<li class="page-item"><a class="page-link" href="home.jsp?page=<%=pagination.getPageNo() - 1 %>&category=<%=category%>">Previous</a></li>
		<%
				}
		%>
		
		<%
				for (int num=pagination.getBeginPage(); num<=pagination.getEndPage(); num++) {
		%>
				<li class="page-item <%=num==pageNo ? "active" : "" %>"><a class="page-link" href="home.jsp?page=<%=num%>&category=<%=category%>"><%=num %></a></li>
		<%
				}
		%>		
		
		<%
				if (pagination.getPageNo() < pagination.getTotalPages()) {
		%>
				<li class="page-item"><a class="page-link" href="home.jsp?page=<%=pagination.getPageNo() + 1 %>&category=<%=category%>">Next</a></li>
		<%
				}
		%>
			
		</ul>
  	</div>
  	<div class="row justify-content-end">
	  	<div style="background-color:#2196F3 ; width: 50px; height: 50px; padding-left: 4px; border-radius: 10px">
	  		<a href="#"><i class="fas fa-chevron-up fa-3x" style="color:white;"></i></a>
	  	</div>
  	</div>
</div>
<%@ include file="/common/footer.jsp" %>

<script type="text/javascript">
	function deletebucket() {
		
		var bucketNumber = 0;
	
		var xhr = new XMLHttpRequest();
		
		xhr.open("GET", "order/bucketDelete.jsp?bucketno=" + bucketNumber);
		
		xhr.send();
		
	}
</script>
</body>
</html>