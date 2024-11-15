<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.list-area {
	width: 100%;
	margin: auto;
	display: grid;
	grid-template-columns: repeat(3, 1fr); /* 한 줄에 3개씩 배치 */
	justify-items: left; /* 요소를 가운데 정렬 */
}

.item {
	width: 300px;
	margin: 20px;
	display: flex;
	flex-direction: column; /* 세로로 이미지와 텍스트 배치 */
	align-items: left;
}

.thumbnail {
	border: 1px soild white;
	width: 300px;
	height: 400px;
	margin: 50px;
	background-color: rgba(128, 128, 128, 0.24);
	border-radius: 20px;
}

.left-align {
	margin-top: -30px;
	margin-left: 50px;
}

.bookC {
	margin-top: 10px;
	border-radius: 10px;
}

.thumbnail:hover {
	cursor: pointer;
	opacity: 0.7;
}

.pageBtn button {
	border: none;
	width: 50px;
	height: 50px;
	background-color: gainsboroy;
}
</style>

</head>
<body>

	<%@include file="/views/common/menubar.jsp"%>
	<div class="center-img">
		<img src="https://www.wallpaperuse.com/wallp/84-842169_m.jpg">
	</div>
	<div id="body-wrap">
		<%@include file="/views/common/sideMenu.jsp"%>
		<script>
			$(function(){
				console.log();
				var sidemenu = $(".side-title-menu").eq(3);
				sidemenu.siblings("ul").children().show();
				sidemenu.siblings("ul").children().eq(2).addClass("menu-click");
			})
		</script>
		<div id="content-area">


			<div class="outer">
				<h2 align="center">한줄평</h2>
				<br>
				<script>
				$(function(){
					
					$(".thumbnail").click(function(){
						
						var bno = $(this).find("input[type=hidden]").val();
						location.href = '${contextPath}/detail.cm?bno='+bno+'&currentPage=${pi.currentPage}';
						
					});
				});
			</script>

				<div class="list-area">
					<c:forEach items="${list }" var="b">
						<div class="item">
							<div class="thumbnail" align="center">
								<input type="hidden" value="${b.bookId }">
								<!-- 글번호 숨겨넣기 -->
								<img class="bookC" src="/library/resources/img/${b.bookId}.gif"
									width="280px" height="380px">
							</div>
							<p class="left-align">
								<b>${b.bookTitle }</b> <br> ${b.bookAuthor }
							</p>
						</div>
					</c:forEach>


					<br> <br> <br>
					<div align="center" class="pageBtn">
						<c:if test="${pi.currentPage != 1 }">
							<button
								onclick="location.href='commentBoard?currentPage=${pi.currentPage-1}'">이전</button>
						</c:if>

						<c:forEach var="i" begin="${pi.startPage }" end="${pi.endPage }">
							<c:choose>
								<c:when test="${i !=pi.currentPage }">
									<button onclick="location.href='commentBoard?currentPage=${i}'">${i }</button>
								</c:when>
								<c:otherwise>
									<button disabled>${i }</button>
								</c:otherwise>
							</c:choose>
						</c:forEach>

						<c:if test="${pi.currentPage != pi.maxPage }">
							<button
								onclick="location.href='commentBoard?currentPage=${pi.currentPage+1}'">다음</button>
						</c:if>
					</div>


				</div>
			</div>
		</div>
	</div>
	<%@include file="/views/common/footer.jsp"%>


</body>
</html>