
<%@page import="com.kh.board.model.vo.Board"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<% // 조회된 목록 선언
 ArrayList<Board> freeBoard = (ArrayList<Board>)request.getAttribute("freeBoard"); %>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<!-- Popper JS -->
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
.category {
	margin-left: -950px;
	font-size: 16px;
}

.separator {
	display: inline-block;
	margin: 0 5px;
}

.boarder {
	border: none; /* 기본 테두리 제거 */
	background-color: #333333c4;
}

.list {
	color: #333;
	border: 1px solid #3333335d;
	border-radius: 5px;
	padding: 5px 20px;
	font-size: 16px;
	cursor: pointer;
	position: relative;
	left: 500px;
}

.fbList tr {
	height: 100px;
	border-top: 1px solid #ddd;
	border-bottom: 1px solid #ddd;
	border-left: none;
	border-right: none;
}

.fbList td:nth-child(1), td:nth-child(3), td:last-child {
	padding-left: 10px
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
				sidemenu.siblings("ul").children().eq(3).addClass("menu-click");
			})
		</script>
		<div id="content-area">
			<p>
			<div align="center">
				<h2>자유게시판</h2>
				<br>
				<br>
				<br>

				<table class="category">
					<tr>
						<td><a href="/library">Home</a></td>
						<td class="separator">></td>
						<td>소통공간</td>
						<td class="separator">></td>
						<td>자유게시판</td>
					</tr>
				</table>

				<%if(loginUser!=null) { %>

				<div align="center">
					<br> <a
						href="<%=contextPath %>/insert.fb?currentPage=${pi.currentPage}"
						class="list">글작성</a>
				</div>

				<%} %>
				<hr class="boarder">
				<table border="1px" class="fbList" style="border: none;">
					<thead>
						<tr>
							<th width="150">번호</th>
							<th width="600">제목</th>
							<th width="150">작성자</th>
							<th width="150">작성일</th>
							<th width="150">조회수</th>
						</tr>
					</thead>
					<tbody>

						<%if(freeBoard.isEmpty()) {%>
						<tr>
							<td colspan="6">게시글이 없습니다.</td>
						</tr>
						<%}else {
			                		for( Board fb : freeBoard ) {	
			                			
			                			String userId = fb.getUserNo();
	                					String maskedId = userId.substring(0, userId.length() - 3).replaceAll(".", "*") + userId.substring(userId.length() - 3);
			                %>
						<tr>
							<td width="150"><%=fb.getBoardNo() %></td>
							<td width="600"><%=fb.getBoardTitle() %></td>
							<td width="150"><%=maskedId %></td>
							<td width="150"><%=fb.getDate() %></td>
							<td width="150"><%=fb.getCount() %></td>
						</tr>
						<%} %>
						<%} %>
					</tbody>
				</table>
			</div>

			<br>
			<br>
			<br>
			<div align="center" class="pageBtn">

				<c:if test="${pi.currentPage != 1 }">
					<button
						onclick="location.href='freeBoard?currentPage=${pi.currentPage-1}'">이전</button>
				</c:if>

				<c:forEach var="i" begin="${pi.startPage }" end="${pi.endPage }">
					<c:choose>
						<c:when test="${i !=pi.currentPage }">
							<button onclick="location.href='freeBoard?currentPage=${i}'">${i }</button>
						</c:when>
						<c:otherwise>
							<button disabled>${i }</button>
						</c:otherwise>
					</c:choose>
				</c:forEach>

				<c:if test="${pi.currentPage != pi.maxPage }">
					<button
						onclick="location.href='freeBoard?currentPage=${pi.currentPage+1}'">다음</button>
				</c:if>
			</div>


			<script>
				$(function(){
					
					$(".fbList>tbody>tr").click(function(){
						
						var nno = $(this).children().first().text();
						
						location.href="/library/detail.fb?nno="+nno+"&currentPage=${pi.currentPage}";
					});
				});
				
			</script>

		</div>

		</p>
	</div>
	</div>
	<%@include file="/views/common/footer.jsp"%>

</body>
</html>