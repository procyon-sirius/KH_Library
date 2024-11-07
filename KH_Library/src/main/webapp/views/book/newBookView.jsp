<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KH Library</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<!-- Popper JS -->
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<style>
	.select-time{
		border-top: 2px solid black;
		border-bottom: 1px solid gray;
		height: 60px;
		width:100%;
		text-align: center;
	}
	.select-time td{
		padding-top: 5px;
		padding-left:20px;
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
           <h2 align="center">신규 도서</h2>
           <br>
           <form action="${contextPath }/newBook.bk">
	           <table class="select-time">
	           		<tr>
	           			<th>간편 검색</th>
	           			<td>
	           				<input type="radio" name="time" value="D"><label for="D">오늘</label> &nbsp;&nbsp; 
							<input type="radio" name="time" value="W"><label for="W">이번주</label> &nbsp;&nbsp;
							<input type="radio" name="time" value="M"><label for="M">이번달</label> &nbsp;&nbsp;
	           			</td>
	           		</tr>
	           </table>
           </form>
           
           
           
        </div>
    </div>
    <%@include file="/views/common/footer.jsp" %>
</body>
</html>