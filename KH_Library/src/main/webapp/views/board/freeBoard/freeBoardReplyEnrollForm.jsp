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
.info {
	margin-left: 20px;
}

.insert {
	margin-left: 1000px;
}

.category {
	margin-left: -900px;
	font-size: 16px;
}

.content {
	background-color: rgba(128, 128, 128, 0.233);
	font-family: sans-serif;
	font-size: 18px;
	width: 100%;
	height: 300px;
	resize: none;
}

.cell {
	padding-left: 5px; /* 등록일과 날짜 사이의 여백 조절 */
}

.separator {
	display: inline-block;
	margin: 0 10px;
}

.content {
	background-color: rgba(128, 128, 128, 0.233);
	border-radius: 10px;
}

pre {
	font-family: sans-serif;
	font-size: 18px;
	color: #333;
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
			<p>
				<% Board fb = (Board) request.getAttribute("freeBoard"); %>
				<% int currentPage = (int)request.getAttribute("currentPage"); %>
			
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
			</div>

			<br> <br> <br>

			<div class="noticeDetail">

				<h4 align="center"><%=fb.getBoardTitle()%></h4>
				<br>
				<hr class="boarder">
				<br> <br>

				<table class="info">
					<tr>
						<td>등록일:</td>
						<td class="cell"><%=fb.getDate()%></td>
						<td class="separator">|</td>
						<td>조회수:</td>
						<td class="cell"><%=fb.getCount()%></td>
					</tr>
				</table>


				<br> <br>

				<div class="content"
					style="background-color: rgba(211, 211, 211, 0.171);">
					<%=fb.getBoardContent()%>
				</div>
				<br><br>

				<form action="<%=contextPath%>/insert.FBrp" method="post">
					<div class="qnaDetail">
						<input type="hidden" name="boardNo" value="<%=fb.getBoardNo()%>" />
						<% int writerNo = loginUser.getUserNo();%>
						<input type="hidden" name="writerNo" value="<%=writerNo%>" />
						<textarea class="content" name="content" placeholder="내용을 입력하세요."
							required="required"></textarea>
						<br> <br> <br>
						<button type="submit" class="list">등록하기</button>
						<a href="/library/freeBoard?currentPage=<%=currentPage %>"
							class="list">목록으로</a>
					</div>	
				</form>

			</div>
		</div>
	</div>	
<%@include file="/views/common/footer.jsp"%>
</body>
</html>