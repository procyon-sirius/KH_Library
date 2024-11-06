<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.list-area{
		width: 100%;
		margin: auto;
		display: grid;
		grid-template-columns: repeat(3, 1fr); /* 한 줄에 3개씩 배치 */
		gap: 20px; /* 요소 간 간격 설정 */
		justify-items: center; /* 요소를 가운데 정렬 */
	
	}
	
	
	.item {
		width: 300px;
		margin: 20px;
		display: flex;
		flex-direction: column; /* 세로로 이미지와 텍스트 배치 */
		align-items: left;
	}
	
	.thumbnail{
		border : 1px soild white;
		width : 300px;
		height: 400px;
		margin : 50px;
		background-color: rgba(128, 128, 128, 0.24);
		border-radius: 20px;	
	
	}
	

	.left-align {
		margin-top: -30px;
		margin-left: 50px;
	}

	.bookC{
		margin-top: 10px;
		border-radius: 10px;
	}

	.thumbnail:hover{
		cursor : pointer;
		opacity : 0.7;
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
			<br>
			
			<c:if test="${loginUser != null }">
				<div align="center">
					<button class="btn btn-info" onclick="location.href='${contextPath}/insert.th'">글작성</button>			
				</div>
			</c:if>
			
			
			<script>
				$(function(){
					
					$(".thumbnail").click(function(){
						
						console.log($(this).children().first().val());
						// ㄴ = console.log($(this).find("input[type=hidden]").val());
						
						// 글번호 추출
						var bno = $(this).find("input[type=hidden]").val();
						location.href = '${contextPath}/detail.th?bno='+bno;
						
					});
					
				});
			
			</script>
			
			<div class="list-area">
				<c:forEach items="${list }" var="b">
					<div class="item">
						<div class="thumbnail" align="center">
							<input type="hidden" value="${b.boardNo }"> <!-- 글번호 숨겨넣기 -->
							<img class="bookC" src="/library/resources/img/1000.gif" width="280px" height="380px">
						</div>
							<p class="left-align" >
								<b> 채식주의자 </b> <br>
								한강
							</p>
					</div>			
				</c:forEach>
	
	
				<div class="item">
					<div class="thumbnail" align="center">
						<input type="hidden" value="${b.boardNo }"> <!-- 글번호 숨겨넣기 -->
						<img class="bookC" src="/library/resources/img/1001.gif" width="280px" height="380px">
					</div>
						<p class="left-align" >
							<b> 채식주의자 </b> <br>
							한강
						</p>
				</div>	
	
				<div class="item">
					<div class="thumbnail" align="center">
						<input type="hidden" value="${b.boardNo }"> <!-- 글번호 숨겨넣기 -->
						<img class="bookC" src="/library/resources/img/1002.gif" width="280px" height="380px">
					</div>
						<p class="left-align" >
							<b> 채식주의자 </b> <br>
							한강
						</p>
				</div>	
	
				<div class="item">
					<div class="thumbnail" align="center">
						<input type="hidden" value="${b.boardNo }"> <!-- 글번호 숨겨넣기 -->
						<img class="bookC" src="/library/resources/img/1003.gif" width="280px" height="380px">
					</div>
						<p class="left-align" >
							<b> 채식주의자 </b> <br>
							한강
						</p>
				</div>	
	
				<div class="item">
					<div class="thumbnail" align="center">
						<input type="hidden" value="${b.boardNo }"> <!-- 글번호 숨겨넣기 -->
						<img class="bookC" src="/library/resources/img/1004.gif" width="280px" height="380px">
					</div>
						<p class="left-align" >
							<b> 채식주의자 </b> <br>
							한강
						</p>
				</div>	
	
	
				<div class="item">
					<div class="thumbnail" align="center">
						<input type="hidden" value="${b.boardNo }"> <!-- 글번호 숨겨넣기 -->
						<img class="bookC" src="/library/resources/img/1005.gif" width="280px" height="380px">
					</div>
						<p class="left-align" >
							<b> 채식주의자 </b> <br>
							한강
						</p>
				</div>	
	
	
				<div class="item">
					<div class="thumbnail" align="center">
						<input type="hidden" value="${b.boardNo }"> <!-- 글번호 숨겨넣기 -->
						<img class="bookC" src="/library/resources/img/1006.gif" width="280px" height="380px">
					</div>
						<p class="left-align" >
							<b> 채식주의자 </b> <br>
							한강
						</p>
				</div>	
	
	
	
	
			</div>
	
	
			<script>
		/* 		document.querySelectorAll('.thumbnail').forEach(thumbnail => {
				thumbnail.addEventListener('mouseenter', function() {
					const textElement = document.createElement('div');
					textElement.className = 'hover-text';
					textElement.innerText = "Hovered Text"; // 표시할 텍스트
					textElement.style.position = 'absolute';
					textElement.style.top = '50%';
					textElement.style.left = '50%';
					textElement.style.transform = 'translate(-50%, -50%)';
					textElement.style.backgroundColor = 'rgba(255, 255, 255, 0.8)';
					textElement.style.padding = '5px';
					textElement.style.borderRadius = '5px';
					thumbnail.appendChild(textElement);
				});
	
				thumbnail.addEventListener('mouseleave', function() {
					const textElement = thumbnail.querySelector('.hover-text');
					if (textElement) {
						thumbnail.removeChild(textElement);
					}
				});
			}); */
	
			</script>
	
		</div>
    </div>
    <%@include file="/views/common/footer.jsp" %>
	

</body>
</html>