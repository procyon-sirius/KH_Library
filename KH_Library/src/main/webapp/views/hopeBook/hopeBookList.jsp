<%@page import="com.kh.hopeBook.model.vo.HopeBook"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>


</head>
<body>
	<%@include file="/views/common/menubar.jsp"%>
	<div class="center-img">
		<img src="https://www.wallpaperuse.com/wallp/84-842169_m.jpg">
	</div>
	<div id="body-wrap">
		<%@include file="/views/common/sideMenu.jsp"%>

		<div id="content-area" align="center">
			<h2>도서 신청 현황</h2>
			<table id="hopeListTable" align="center" border="1">
				<thead>
					<tr>
						<th>신청번호</th>
						<th>신청인</th>
						<th>신청 도서 제목</th>
						<th>신청일</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${empty list }">
							<tr>
								<td colspan="5">신청된 도서가 없습니다.</td>
							</tr>
						</c:when>
						<c:otherwise>
							<c:forEach var="hl" items="${list }">
								<tr>
									<td>${hl.hopeNum }</td>
									<td>${hl.hopeUser }</td>
									<td>${hl.hopeTitle }</td>
									<td>${hl.hopeDate }</td>
									<td>
										<c:choose >
											<c:when test="${hl.hopePublic == 'Y'}">
												<p style="color: green">공개</p>
											</c:when>
											<c:otherwise>
												<p style="color: red">비공개</p>
											</c:otherwise>
										</c:choose>
									</td>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		</div>
		
		<script>
			$("#hopeListTable>tbody>tr").click(function(){
				//console.log($(this));
				
				var hno = $(this).children().first().text();
				//console.log(hno);
				
				location.href = "detail.ho?hno="+hno;
				
			});
		</script>

	</div>
	<%@include file="/views/common/footer.jsp"%>
</body>
</html>