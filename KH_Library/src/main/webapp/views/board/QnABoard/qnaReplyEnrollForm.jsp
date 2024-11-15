<%@page import="com.kh.board.model.vo.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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

.list {
	color: #333;
	border: 1px solid #3333335d;
	border-radius: 5px;
	padding: 5px 20px;
	font-size: 16px;
	cursor: pointer;
	position: relative;
	left: 520px;
}

.content {
	background-color: rgba(128, 128, 128, 0.233);
	font-family: sans-serif;
	font-size: 18px;
	width: 100%;
	height: 300px;
	resize: none;
}

.separator {
	display: inline-block;
	margin: 0 5px;
}
</style>
</head>
<body>
	<% Board q = (Board) request.getAttribute("q"); %>
	<%@include file="/views/common/menubar.jsp"%>
	<div class="center-img">
		<img src="https://www.wallpaperuse.com/wallp/84-842169_m.jpg">
	</div>
	<div id="body-wrap">
		<%@include file="/views/common/sideMenu.jsp"%>
		<div id="content-area">
			<div align="center">

				<h2>QnA게시판</h2>
				<br> <br> <br>

				<table class="category">
					<tr>
						<td><a href="/library">Home</a></td>
						<td class="separator">></td>
						<td>소통공간</td>
						<td class="separator">></td>
						<td>문의게시판</td>
					</tr>
				</table>
				<br> <br>
				<h5>QnA 답변작성하기</h5>
			</div>
				<table class="info">
					<tr>
						<td>등록일:</td>
						<td class="cell"><%=q.getDate()%></td>
						<td class="separator">|</td>
						<td>조회수:</td>
						<td class="cell"><%=q.getCount()%></td>
					</tr>
				</table>

				<br><br>

				<div class="content"
					style="background-color: rgba(211, 211, 211, 0.171);">
					<%=q.getBoardContent()%>
				</div>
				<br><br>
				
			

			<form action="<%=contextPath%>/insert.rp" method="post">
				<div class="qnaDetail">
					<input type="hidden" name="boardNo" value="${boardNo }" /> <br>
					<br> <br>

					<textarea class="content" name="content" placeholder="내용을 입력하세요."
						required="required"></textarea>

					<br> <br> <br>
					<button type="submit" class="list">등록하기</button>
					<a href="/library/qnaBoard?currentPage=1" class="list">목록으로</a>
				</div>
			</form>

		</div>
	</div>
	<%@include file="/views/common/footer.jsp"%>

</body>
</html>