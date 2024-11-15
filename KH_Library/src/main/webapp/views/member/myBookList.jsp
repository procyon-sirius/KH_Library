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
	height:550px;
}
#detail-list{
	border-top:3px solid black;
	border-bottom:3px solid black;
	height:32px;
}
.book-list{
	margin-left: 32px;
	width : 1100px;
	height : 110px;
	text-align : center;
}
th{
	background-color: rgb(156, 183, 199);

}
#reserve-area{
	border:1px solid black;
	height:550px;
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
		<script>
			$(function(){
				console.log();
				var sidemenu = $(".side-title-menu").eq(4);
				sidemenu.siblings("ul").children().show();
				sidemenu.siblings("ul").children().eq(2).addClass("menu-click");
			})
		</script>
        <div id="content-area">
          <h1 align="center">대출현황</h1>    
          <div id="rent-area">
          <br>
          	
          	<table border="1" id="rentTable" class="book-list">
          		<thead>
          			<tr>         				
          				<th width="90px" height="40px">책 고유번호</th>
          				<th width="510px">책 제목</th>
          				<th width="120px">저자</th>
          				<th width="170px">출판사</th>
          				<th width="120px">반납예정일</th>
          				<th width="150px">반납 및 연기</th>       				
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
          				<td height="50px">${r.bookId}</td>
          				<td>${r.bookTitle}</td>
          				<td>${r.bookAuthor }</td>
          				<td>${r.publisher}</td>
          				<td>${r.returnDate }</td>
          				<td><button type="button" class="reBook">반납</button>
          					<button type="button" class="deBook">반납연기</button>	</td>
          							       								       				      					
          			</tr>
          		   </c:forEach>
          		  </c:otherwise>
          		 </c:choose>  
          			       			      		      		
          		</tbody>	
          		    		         	
          	</table>
          	  
		  </div>
		  <script>
		  	$(function(){
		  		
		  		$("#rentTable").on("click","button[class^=re]",function(){
		  			
					//console.log($(this).parent().siblings().first().text());
						
		  			var bookId = $(this).parent().siblings().first().text();
		  			
  				  if(confirm("정말 반납하시겠습니까? 반납후 복구는 불가능합니다.")){
		  			  
		  			  location.href="${contextPath}/reBook.me?bookId="+bookId;
		  		  }
	  				  			  			
		  		});
		  		
		  		$("#rentTable").on("click","button[class^=de]",function(){
		  			
					//console.log($(this).parent().siblings().first().text());
														  			
		  			var bookId = $(this).parent().siblings().first().text();
		  			
					if(confirm("반납 연기하시겠습니까? 연기는 한번만 가능하고 7일 연기됩니다.")){
						
						location.href="${contextPath}/deBook.me?bookId="+bookId;
														
		  			}
	  							
		  		});
		  			
		  	});	
		  		 	  				  
		  </script>
			  
		  
		  <br>
		  <h1 align="center">예약현황</h1>
		  <div id="reserve-area">
		  	 <br>
          	
          	<table border="1" id="reserveTable" class="book-list">
          		<thead>
          			<tr>
          				<th width="90px" height="40px">책 고유번호</th>
          				<th width="480px">책 제목</th>
          				<th width="150px">저자</th>
          				<th width="150px">출판사</th>
          				<th>대출버튼</th>
          				<th>예약 취소</th>
          			</tr>
          		</thead>	
          		<tbody>
          		<c:choose>
          		  <c:when test="${empty reList }">
          		  <tr>
          		  	   <td colspan="6">예약정보가 없습니다.</td>
          		  </tr>
          		  </c:when>
          		 <c:otherwise> 	   
          		  <c:forEach var="c" items="${reList}">
          			<tr>
          				<td height="50px">${c.bookId}</td>
          				<td>${c.bookTitle}</td>
          				<td>${c.bookAuthor}</td>
          				<td>${c.publisher}</td>
          				<td>
	          				<c:choose>
	          					<c:when test="${r.returnBook eq 'Y' }">
	          						<button type="button" id="reserveRent">대출</button>
	          					</c:when>
	          					<c:otherwise>
	          						<button type="button" disabled>대출불가</button>
	          					</c:otherwise>
	          				</c:choose>
          				</td>
          				<td><button type="button" id="cancle">예약취소</button></td>          					
          			</tr>
          		   </c:forEach>
          		  </c:otherwise>
          		 </c:choose>  
          			       			      		       		
          		</tbody>	
          		    		
          	
          	</table>
          	<form action="${contextPath }/rent.bk" method="post" name="reserveRentForm">
          		<input type="hidden" name="userNo" value="${loginUser.userNo }">
          		<input type="hidden" name="bookId" value="">
          	</form>
		  </div>
		  
		  <script>
		  	$(function(){
		  		
		  		$("#reserveTable").on("click","#cancle",function(){
		  			
		  			//console.log($(this).parent().siblings().first().text());
					
		  			var bookId = $(this).parent().siblings().first().text();
		  			
					if(confirm("예약 취소하시겠습니까? ")){
		  			}
		  		});
		  	});
		  
		  
		  </script>
		  <script>
		  	$(function(){
		  		$("#reserveTable>tbody>tr").on("click","#reserveRent", function(){
		  			var bookId = $(this).parents("tr").children().first().text();
		  			
		  			$("input[name=bookId]").val(bookId);
		  			
		  			$("form").submit();
		  		})
		  	})
		  </script>
        </div>
    </div>
    <%@include file="/views/common/footer.jsp" %>
	
</body>
</html>