<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
		String contextPath = request.getContextPath();
	
		String alertMsg = (String)session.getAttribute("alertMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.outer {
	background-color: white;
	color: black;
	width: 1000px;
	margin: auto;
	margin-top: 200px;
}

.login-area {
	border: 1px solid cadetblue;
	width: 500px;
	height: 400px;
	border-radius: 12px;
}

#id-area {
	border: 1px solid black;
	width: 350px;
	height: 45px;
	border-radius: 12px;
	margin-top: 80px;
}

#pw-area {
	border: 1px solid black;
	width: 350px;
	height: 45px;
	border-radius: 12px;
}

#userId, #userPwd {
	width: 340px;
	height: 43px;
	border-radius: 12px;
	border: none;
}

#loginBtn {
	width: 350px;
	height: 45px;
	border-radius: 12px;
	background-color: cadetblue;
}
</style>
</head>
<body>	
	<%
	pageContext.setAttribute("scope", "page Scope");
	%>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<script>
		var msg = "${alertMsg}";
		//null이 아닐경우에 alert 띄워주기
		if(msg!=""){
			alert(msg);
			//알림창을 띄우고 메시지 지워주기 (안지우면 메뉴바 뜰때마다 알림창 뜸)
			<%session.removeAttribute("alertMsg");%>
		}
	</script>
	<div class="outer" align="center">
		<h1 align="center">회원 로그인</h1>


		<div class="login-area">

			<form action="${contextPath}/login.me" method="post" id="login_form">
				<input type="hidden" name="beforeUrl" value="${beforeUrl}">
				<div id="id-area">
					<input type="text" id="userId" name="userId" placeholder="아이디">
				</div>
				<div id="pw-area">
					<input type="password" id="userPwd" name="userPwd"
						placeholder="비밀번호">
				</div>
				<br>
				<button type="submit" id="loginBtn">로그인</button>
				<div id="searchArea">
					<a href="">아이디찾기</a> <a href="">비밀번호찾기</a> <a href="">회원가입</a>
				</div>

			</form>


		</div>

	</div>


</body>
</html>