<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KH Library</title>
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
			<%@include file="/views/search/searchBar.jsp"%>
		</div>
	</div>
	<%@include file="/views/common/footer.jsp"%>
</body>
</html>