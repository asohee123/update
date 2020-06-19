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
</head>
<body>
<div class="container">
   <div class="row">
      <div class="col-6">
         <h3>기본 탭</h3>
         <ul class="nav nav-tabs">
            <li class="nav-item"><a class="nav-link active" data-toggle="tab" href="#detail-box">상세정보</a></li>
            <li class="nav-item"><a class="nav-link"		data-toggle="tab" href="#review-box">사용후기</a></li>
            <li class="nav-item"><a class="nav-link" 		data-toggle="tab" href="#qna-box">질문/답변</a></li>
         </ul>
         <div class="tab-content">
	         <div class="tab-pane container" id="detail-box">
	         	<h4>상세정보</h4>
	         	<p>집가고싶다.집가고싶다.집가고싶다.집가고싶다.집가고싶다.집가고싶다.집가고싶다.집가고싶다.집가고싶다.집가고싶다.집가고싶다.집가고싶다.집가고싶다.</p>
	         </div>
	         <div class="tab-pane container" id="review-box">
	         	<h4>사용후기</h4>
	         	<p>집가고싶다.집가고싶다.집가고싶다.집가고싶다.집가고싶다.집가고싶다.집가고싶다.집가고싶다.집가고싶다.집가고싶다.집가고싶다.집가고싶다.집가고싶다.</p>
	         </div>
	         <div class="tab-pane container" id="qna-box">
	         	<h4>질문/답변</h4>
	         	<p>집가고싶다.집가고싶다.집가고싶다.집가고싶다.집가고싶다.집가고싶다.집가고싶다.집가고싶다.집가고싶다.집가고싶다.집가고싶다.집가고싶다.집가고싶다.</p>
	         </div>
         </div>
      </div>
      <div class="col-6">
         <h3>기본 탭</h3>
         <ul class="nav nav-tabs nav-justified">
            <li class="nav-item"><a class="nav-link active">상세정보</a></li>
            <li class="nav-item"><a class="nav-link">사용후기</a></li>
            <li class="nav-item"><a class="nav-link">질문/답변</a></li>
         </ul>
      </div>
   </div>
</div>
</body>
</html>