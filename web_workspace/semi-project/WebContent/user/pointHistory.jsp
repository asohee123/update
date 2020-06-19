<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <title>Bootstrap 4 Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
	<div class="row">
		<div class="col-12">
			<div class="navi text-center" >
				<%@ include file="/common/loginProcess.jsp" %>
    			<%@ include file="../common/navibar.jsp" %>
    		</div>
		</div>
	</div>
	<div class="row">
		<div class="col-12">
			<div class="header text-center">
				<div class="row">
					<div class="col-12 pb-3 h2">
						포인트사용이력
					</div>
				</div>
   				<div class="row">
   					<div class="col-12 pb-3">
   						<div class="row">
   							<div class="col-3"></div>
   							<div class="col-6">
   								<div class="row">
   									<div class="col-8 my-auto">
   										유세민님은 현재 일반회원입니다.
   									</div>
   									<div class="col-4">
										<div class="row">
											<div class="col-12"><a class="text-dark" href="pointHistory.jsp">
												보유포인트
											</a></div>
										</div>
										<div class="row">
											<div class="col-12 pr-10">
												0point
											</div>
										</div>    									
   									</div>
   								</div>
   							</div>
   							<div class="col-3"></div>
   						</div>
   					</div>
   				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-2"></div>
		<div class="col-8 text-center">
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>주문날짜</th>
						<th>적립금</th>
						<th>관련주문</th>
					</tr>	
				</thead>
				<tbody>
					<tr>
						<td>1</td>
						<td>1</td>
						<td>1</td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="col-2"></div>
	</div>
	<div class="row">
		<div class="col-12">
			<ul class="pagination" style="justify-content: center;">
			  <li class="page-item"><a class="page-link" href="#">이전</a></li>
			  <li class="page-item"><a class="page-link" href="#">1</a></li>
			  <li class="page-item"><a class="page-link" href="#">2</a></li>
			  <li class="page-item"><a class="page-link" href="#">3</a></li>
			  <li class="page-item"><a class="page-link" href="#">다음</a></li>
			</ul>
		</div>
	</div>
	<div class="row">
		<div class="col-12">
			<div class="footer">
    			<%@ include file="../common/footer.jsp" %>
			</div>
		</div>
	</div>
</div>
</body>
</html>