<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="/views/common/menubar.jsp" %>
    <div class="center-img">
        <img src="https://www.wallpaperuse.com/wallp/84-842169_m.jpg">
    </div>
    <div id="body-wrap">
		<%@include file="/views/common/sideMenu.jsp" %>
		
        <div id="content-area">
            <h2>도서 신청</h2>
            <table border="1">
            	<thead>
            		<tr>
            			<th>신청자</th>
            			<tb>bre*****</tb>
            			<th>신청일</th>
            			<td>2024-11-11</td>
            		</tr>
            	</thead>
            	<tbody>
            		<tr>
            			<th>희망 도서</th>
            			<td>책 먹는 여우</td>
            		</tr>
            		<tr>
            			<th>신청 이유</th>
            		</tr>
            		<tr>
            			<td>
							<input type="text">
						</td>
            		</tr>
            	</tbody>
            </table>
        </div>
        
    </div>
    <%@include file="/views/common/footer.jsp" %>
</body>
</html>