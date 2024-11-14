<%@page import="com.kh.board.model.vo.Board"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



<!DOCTYPE html>
<html>
<head>
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


<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">

.insert {
	margin-left: 1000px;
}

.category {
	margin-left: -900px;
	font-size: 16px;
}

.separator {
	display: inline-block;
	margin: 0 10px;
}

.title {
	width: 100%;
	height: 40px;
	background-color: rgba(128, 128, 128, 0.233);
	border: 1px solid #black;
	padding: 8px;
	font-size: 16px;
}

.content {
	background-color: rgba(128, 128, 128, 0.233);
	font-family: sans-serif;
	font-size: 18px;
	color: #333;
	width: 100%;
	height: 800px;
	resize: none;
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

</style>
</head>
<body>

	<%@include file="/views/common/menubar.jsp"%>
	<div class="center-img">
		<img src="https://www.wallpaperuse.com/wallp/84-842169_m.jpg">
	</div>
	<div id="body-wrap">
		<%@include file="/views/common/sideMenu.jsp"%>
		<div id="content-area">

			<% Board fb = (Board) request.getAttribute("Board"); %>


			<div align="center">
				<h2>공지사항</h2>
				<br>
				<br>
				<br>
				<table class="category">
					<tr>
						<td><a href="/library">Home</a></td>
						<td class="separator">></td>
						<td>소통공간</td>
						<td class="separator">></td>
						<td>공지사항</td>
					</tr>
				</table>
			</div>

			<br> <br> <br>

			<form action="<%=contextPath%>/insert.no" method="post" id="enroll" enctype="multipart/form-data">
				<div class="noticeDetail">
					<input type="hidden" name="currentPage" value="${currentPage}">
					<input type="text" name="title" class="title" required="required"
						placeholder="제목을 입력하세요."></input> <br>
					<br>
					<input type="file" name="uploadFile">
					<br>
					<textarea class="content" name="content" placeholder="내용을 입력하세요."
						required="required"></textarea>
					<br> <br> <br>
					<button type="submit" class="list">등록하기</button>
					<a href="/library/notice?currentPage=${currentPage }" class="list">목록으로</a>
				</div>	
			</form>
		
	</div>
	</div>

	<%@include file="/views/common/footer.jsp"%>
</body>
</html>