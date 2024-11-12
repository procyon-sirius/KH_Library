<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

.list-area {
 	display: flex; /* 왼쪽 컨테이너 내에서 이미지와 텍스트를 가로로 배치 */
    align-items: flex-start;  /* 이미지와 텍스트 수직 중앙 정렬 */
}

.item{
   margin-right: 50px; /* 이미지와 텍스트 사이의 간격 */
}


.comment,.commentInput{
	width : 600px;
	height : 300px;
	background-color: rgba(128, 128, 128, 0.1);
	border-radius: 40px;
	padding-top : 50px;
    padding-left: 50px;          
    text-align: left;            
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
	
			<div class="outer">
		
			<h2 align="center">한줄평</h2>
			<br><br><br>
			
			<div class="list-area">
					<div class="item">
						<div class="thumbnail" align="center">
							<input type="hidden" value="${bno }"> <!-- 글번호 숨겨넣기 -->
							<img class="photo" class="bookC" src="/library/resources/img/${bno}.gif" width="280px" height="380px">
					</div>
			</div>	
			
			<div>
				<div id=bookInfo>
				<h4>${b.bookTitle }</h4> 
				
				  <%if(loginUser!= null) {%>
						<button class="commentW">후기작성</button>				  		
				  <%} %>
				
				<br>
				지은이 :&nbsp;&nbsp;${b.bookAuthor } <br>
				출판사 :&nbsp;&nbsp;${b.publisher } <br>
					<p>
					줄거리 요약 : demo------------------- <br>
					${b.summary }
					</p>
				</div>
				
				<br><br><br><br>
				<hr>
					이 책에 남긴 코멘트 : &nbsp;&nbsp;${rCount }개
				<br><br>
				
				
				<input class=commentInput style="display: none;">
				</input> <br><br>
				<button id="submit" style="display: none;">작성하기</button>
				<button id="back" style="display: none;">뒤로가기</button>
				
				<br><br>				
				<c:if test="${not empty rlist}">
				    <c:forEach var="r" items="${rlist}">
						<br><br>
						<div class=comment>
							 NO :&nbsp;&nbsp;${r.replyNo}&nbsp; |&nbsp;&nbsp;
							 작성자 :&nbsp;&nbsp;${r.userNo}&nbsp; |&nbsp;&nbsp;
							 작성일 :&nbsp;&nbsp;${r.date}
							 <br> <br>
							 <h5>
							 ${r.replyContent} 
							 </h5>
						</div>	
				    </c:forEach>
				</c:if>
				<c:if test="${empty rlist}">
				    <p>댓글이 없습니다.</p>
				</c:if>
				
				
				

			</div>
			
			
			<script>
				$(function(){
					$(".commentW").click(function(){
						$(".commentInput").show(); 
						$("#submit").show();
						$("#back").show();
						$(".commentW").hide();
						
						$("#back").click(function(){
							history.back();
						});	
						
						$("#submit").click(function(){
							$.ajax({
								url : '${contextPath}/insert.cm', 
								data : {
									bookNo : ${b.bookId},
									writerNo : ${loginUser.userNo},
									comment : $(".commentInput").val()
								},
								success : function(result){
									if(result.status=="success"){
										alert(result.message);
										$(".commentInput").hide(); 
										$("#submit").hide();
										$("#back").hide();
										
									}else{
										alert(result.message);
									}
								},
								error : function(){
									console.log("통신 오류");
								},
								
							});
						});
					});
				});
			
			
			</script>
			
						
	
	
	
			</div>
		</div>
    </div>
    <%@include file="/views/common/footer.jsp" %>
	

</body>
</html>