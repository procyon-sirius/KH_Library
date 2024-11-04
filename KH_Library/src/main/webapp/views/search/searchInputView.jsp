<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#main-search-area {
	border-bottom: 2px solid green;
}
#search-bar{
	border: 2px solid lightgray;
	width : 450px;
	margin : 20px 0;
	padding: 10px;
}
#search-select{
	font-size: 16px;
	height: 30px;
	border: 0;
	outline-style: none;
	border-right: 2px solid lightgray;
	margin-right: 10px;
	padding-right: 10px;
}
#search-filter-area{
	display : none;
}
option{
	border-radius: 0;
}
#main-search-input{
	font-size: 16px;
	width : 250px;
	height : 30px;
	border: 0;
	outline: none;
}
.icons{
	border : 0;
	background-color: rgba(0, 0, 0, 0);
	height: 30px;
	width : 30px;
	vertical-align: bottom;
}
.icons:hover{
	cursor: pointer;
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
			<div id="main-search-area" align="center">

				<h2>통합검색</h2>
				<form id="main-search-form" action="list.se">
					<div id=search-bar>
					<select name="search-keyword-category" id="search-select">
						<option value="all">통합</option>
						<option value="title">제목</option>
						<option value="author">저자</option>
					</select> 
					
					<input type="text" id="main-search-input" name="search-keyword"> 
					<button type="submit" class="material-icons icons" onclick="return sEmptyCk();">search</button>
					<button type="button" id="main-search-filter-icon" class="material-icons icons">filter_list</button>

					
					</div>
					<div id="search-filter-area">
						카테고리 &nbsp;<br>
						<c:forEach items="${bookCategoryList}" var="c">
							<input type="checkbox" name="search-book-category" value="${c.categoryNo}">${c.categoryName} &nbsp;
                       	</c:forEach>
					</div>
					<br>
				</form> 
				<script>
					$(function(){
						$("#main-search-filter-icon").click(function(){
							$("#search-filter-area").toggle();
						});
					});
					function sEmptyCk(){
						if($("#main-search-input").val()==""){
							console.log("공백");
							return false;
						}
					}
				</script>
			</div>
		</div>
	</div>
	<%@include file="/views/common/footer.jsp"%>
</body>
</html>