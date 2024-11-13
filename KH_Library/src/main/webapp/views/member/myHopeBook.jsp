<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table{
	margin-left: 120px;
	width : 900px;
	height: 120px;
	text-align: center;

}

th{
	background-color: cadetblue;
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
        	<h2 align="center">나의 도서 신청 현황</h2>
			<br><br>
			<table id="hopeListTable" border="1">
				<thead>
					<tr>						
						<th width="10%" height="60px">신청인</th>
						<th width="51%">신청 도서 제목</th>
						<th width="12%">신청일</th>
						<th width="12%">신청상태</th>
					</tr>
				</thead>
				<tbody>
					<tr>						
						<td></td>
						<td></td>
						<td></td>
						<td>처리중<br><button type="button">신청 취소</button></td>
					</tr>													
				</tbody>
			</table>	
        
            
        </div>
    </div>
    <%@include file="/views/common/footer.jsp" %>

</body>
</html>