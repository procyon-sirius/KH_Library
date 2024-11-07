<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div style="display : none;">
		<%@include file="/views/common/menubar.jsp" %>
	</div>
	<h2>ERROR : ${errorMsg}</h2>
	<a href="${contextPath}">메인으로</a>
</body>
</html>