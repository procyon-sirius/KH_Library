<%@page import="java.util.ArrayList"%>
<%@page import="com.kh.board.model.vo.Notice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<% // 조회된 목록 선언
ArrayList<Notice> list = (ArrayList<Notice>)request.getAttribute("list"); %>

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

.noticeList tr {
	height: 100px;
	border-top: 1px solid #ddd;
	border-bottom: 1px solid #ddd;
	border-left: none;
	border-right: none;
}

.noticeList td:nth-child(1), td:nth-child(3), td:last-child {
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
				sidemenu.siblings("ul").children().eq(0).addClass("menu-click");
			})
		</script>
		<div id="content-area">
			<div align="center">
				<h2>공지사항</h2>
				<br> <br> <br>

				<table class="category">
					<tr>
						<td><a href="/library">Home</a></td>
						<td class="separator">></td>
						<td>소통공간</td>
						<td class="separator">></td>
						<td>공지사항</td>
					</tr>
				</table>

				<%if(loginUser!=null && loginUser.getUserId().equals("admin")) { %>

				<div align="center">
					<br> <a href="<%=contextPath %>/insert.no?currentPage=${pi.currentPage}" class="list">글작성</a>
				</div>

				<%} %>

				<hr class="boarder">


				<table border="1px" class="noticeList" style="border: none;">
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

						<%if(list.isEmpty()) {%>
						<tr>
							<td colspan="6">공지사항이 없습니다.</td>
						</tr>
						<%}else {
			                		for( Notice n: list) {	
			                %>
						<tr>
							<td width="150"><%=n.getNoticeNo() %></td>
							<td width="600"><%=n.getNoticeTitle() %></td>
							<td width="150"><%=n.getUserNo() %></td>
							<td width="150"><%=n.getDate() %></td>
							<td width="150"><%=n.getNumber() %></td>
						</tr>
						<%} %>
						<%} %>

					</tbody>
				</table>
			

			<script>
					$(function(){
						
						$(".noticeList>tbody>tr").click(function(){
							var nno = $(this).children().first().text();
							location.href="detail.no?nno="+nno+"&currentPage=${pi.currentPage}";
							
						});
					});
					
				</script>

			<br> <br> <br>
			<div align="center" class="pageBtn">

				<c:if test="${pi.currentPage != 1 }">
					<button
						onclick="location.href='notice?currentPage=${pi.currentPage-1}'">이전</button>
				</c:if>

				<c:forEach var="i" begin="${pi.startPage }" end="${pi.endPage }">
					<c:choose>
						<c:when test="${i !=pi.currentPage }">
							<button onclick="location.href='notice?currentPage=${i}'">${i }</button>
						</c:when>
						<c:otherwise>
							<button disabled>${i }</button>
						</c:otherwise>
					</c:choose>
				</c:forEach>

				<c:if test="${pi.currentPage != pi.maxPage }">
					<button
						onclick="location.href='notice?currentPage=${pi.currentPage+1}'">다음</button>
				</c:if>
			</div>

			</div>
		</div>
	</div>
	<%@include file="/views/common/footer.jsp"%>

</body>
</html>