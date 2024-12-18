<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#rent-area{
	border:1px solid black;
	height:300px;
}
#detail-list{
	border-top:3px solid black;
	border-bottom:3px solid black;
	height:32px;
}
.rent-book{
	margin-left: 32px;
	width : 1100px;
	height : 90px;
	text-align : center;
}
#reserve-area{
	border:1px solid black;
	height:300px;
}


</style>
</head>
<body>
	<%@include file="/views/common/menubar.jsp" %>
    <div class="center-img">
        <img src="https://www.wallpaperuse.com/wallp/84-842169_m.jpg">
    </div>
    <div id="body-wrap">
		<%@include file="/views/common/sideMenu.jsp" %>
        <div id="content-area">
          <h1 align="center">대출현황</h1>    
          <div id="rent-area">
          <br>
          	<div id="detail-list">
          		<input type="checkbox" name="allCheck" id="allCheck">
          		<label for="allCheck">전체선택</label>
          	</div>
          	<br>
          	<table border="1" class="rent-book">
          		<thead>
          			<tr>
          				<th width="90px" height="40px">책 고유번호</th>
          				<th width="480px">책 제목</th>
          				<th width="150px">저자</th>
          				<th width="150px">출판사</th>
          				<th>반납예정일</th>
          				<th>반납및연기</th>
          			</tr>
          		</thead>	
          		<tbody>
          		<c:choose>
          		  <c:when test="${empty list }">
          		  <tr>
          		  	   <td colspan="6">대출정보가 없습니다.</td>
          		  </tr>
          		  </c:when>
          		 <c:otherwise> 	   
          		  <c:forEach var="r" items="${list}">
          			<tr>
          				<td>${r.bookId}</td>
          				<td>${r.bookTitle}</td>
          				<td>${r.bookAuthor }</td>
          				<td>${r.publisher}</td>
          				<td>${r.returnDate }</td>
          				<td><button type="button">반납</button>
          					<button type="button">반납연기</button></td>
          			</tr>
          		   </c:forEach>
          		  </c:otherwise>
          		 </c:choose>  
          			       			      		
         		
          		</tbody>	
          		    		
          	
          	</table>
            
			
		  </div>
		  <br>
		  <h1 align="center">예약현황</h1>
		  <div id="reserve-area">
		  </div>
        </div>
    </div>
    <%@include file="/views/common/footer.jsp" %>
	
</body>
</html>