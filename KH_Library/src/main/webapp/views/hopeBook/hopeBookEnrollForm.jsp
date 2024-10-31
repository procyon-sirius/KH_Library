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
            <table>
            	<thead>
            		<tr>
            			<th>신청자</th>
            			<th>희망 도서</th>
            		</tr>
            	</thead>
            </table>
        </div>
        
    </div>
    <%@include file="/views/common/footer.jsp" %>
</body>
</html>