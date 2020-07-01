sample4.jsp

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
      <div class="col-12">
         <h1>EL에서 3항 연산자 사용하기</h1>
      </div>
   </div>

   <div class="row">
      <div class="col-12">
         <form>
            <div class="form-group">
               <label>카테고리</label>
               <select name="cat">
                  <option value="">선택하세요</option>
                  <option value="local" ${param.category eq 'local' ? 'selected' : ''}>국내도서</option>
                  <option value="foreign" ${param.category eq 'foreign' ? 'selected' : ''}>외국도서</option>
                  <option value="ebook" ${param.category eq 'ebook' ? 'selected' : ''}>전자책</option>
                  <option value="ticket" ${param.category eq 'ticket' ? 'selected' : ''}>티켓</option>
               </select>
            </div>
         </form>
      </div>
   </div>
   
   <div class="row">
      <div class="col-12">
         <ul class="list-group">
            <li class="list-group-item ${param.category eq 'local' ? 'active' : ''}"><a href="sample4.jsp?category=local">국내도서</a></li>
            <li class="list-group-item ${param.category eq 'foreign' ? 'active' : ''}"><a href="sample4.jsp?category=foreign">외국도서</a></li>
            <li class="list-group-item ${param.category eq 'ebook' ? 'active' : ''}"><a href="sample4.jsp?category=ebook">전자책</a></li>
            <li class="list-group-item ${param.category eq 'ticket' ? 'active' : ''}"><a href="sample4.jsp?category=ticket">티켓</a></li>
         </ul>
      </div>
   </div>
</div>
</body>
</html>