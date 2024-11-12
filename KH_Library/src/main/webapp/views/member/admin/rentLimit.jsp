<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

	#rent-limit{
		margin: 0 auto;
		text-align: center;
		width : fit-content;
		height : fit-content;
	}

</style>
</head>
<body>
	<div id="rent-limit">
		<h2>도서 최대 대출 권수 변경</h2>
	<form action="" method="post">
		<table id="book-limit-table" border="1">
			<tr>
				<th>회원번호</th>
				<td></td>
				<th>회원아이디</th>
				<td></td>
				<th>회원명</th>
				<td></td>
			</tr>
			<tr>
				<th>총 대출 수</th>
				<td></td>
				<th>최대대출권수</th>
				<td></td>
			</tr>
		</table>
		<div id="confirm">
			<button type="submit">등록하기</button>
		</div>
		<button type="reset">취소</button>
	</form>
	<script>
		
	</script>
	</div>
</body>
</html>