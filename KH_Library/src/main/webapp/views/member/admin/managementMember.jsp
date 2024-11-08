<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KH Library</title>
</head>
<style>
.member-list {
	border: 1px solid black;
}
</style>
<body>

	<div class="member">
		<table class="member-list">

			<tr>
				<th>회원번호</th>
				<th>회원아이디</th>
				<th>회원비밀번호</th>
				<th>회원명</th>
				<th>생년월일</th>
				<th>전화번호</th>
				<th>이메일</th>
				<th>주소</th>
				<th>회원가입일</th>
				<th>정보수정일</th>
				<th>최대대출권수</th>
				<th>상태값</th>
				<th>삭제</th>
			</tr>

			<c:choose>
				<c:when test="${empty list}">
					<tr>
						<th align="center">조회 결과가 없습니다</th>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach items="${list }" var="m">
						<tr>
							<td>${m.userNo}</td>
							<td>${m.userId}</td>
							<td>${m.userPwd}</td>
							<td>${m.userName}</td>
							<td>${m.userNno}</td>
							<td>${m.phone}</td>
							<td>${m.email}</td>
							<td>${m.address}</td>
							<td>${m.enrollDate}</td>
							<td>${m.modifyDate}</td>
							<td>${m.rentLimit}</td>
							<td>${m.status}</td>
							<td><button id="del">삭제</button></td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</table>
	</div>
	<script>
		
	</script>

</body>
</html>