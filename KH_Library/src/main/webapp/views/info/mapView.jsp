<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>오시는 길</title>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<style>

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
			
			<div id="map" style="width: 500px; height: 400px;"></div>
			

			
        </div>
    </div>
    <%@include file="/views/common/footer.jsp" %>
</body>
</html>