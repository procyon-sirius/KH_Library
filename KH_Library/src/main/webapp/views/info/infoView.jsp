<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<style>
	@font-face {
	    font-family: 'STUNNING-Bd';
	    src: url('https://fastly.jsdelivr.net/gh/projectnoonnu/2410-2@1.0/STUNNING-Bd.woff2') format('woff2');
	    font-weight: normal;
	    font-style: normal;
	}
	#content-area{
		font-family: 'STUNNING-Bd';
	}
	#title{
		font-weight: bolder;
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
			
			<h1 id="title">KH도서관에 오신 것을 환영합니다.</h1>  
			<br>
			<br>
			2024년 11월 15일 데모 사이트 완성
			
        </div>
    </div>
    <%@include file="/views/common/footer.jsp" %>
</body>
</html>