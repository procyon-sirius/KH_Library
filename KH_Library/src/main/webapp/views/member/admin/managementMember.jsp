<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KH Library</title>
</head>
<body>
	<%@include file="/views/common/menubar.jsp" %>
    <div class="center-img">
        <img src="https://www.wallpaperuse.com/wallp/84-842169_m.jpg">
    </div>
    <div id="body-wrap">
		<%@include file="/views/common/sideMenu.jsp" %>
        <div id="content-area">
            <div>
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
           	   </tr>
            </div>
        </div>
    </div>
    <%@include file="/views/common/footer.jsp" %>
</body>
</html>