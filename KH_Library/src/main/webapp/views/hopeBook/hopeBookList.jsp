<%@page import="com.kh.hopeBook.model.vo.HopeBook"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% String alertMsg = (String)session.getAttribute("alertMsg"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

<style>
	table{
		width: 90%;
	}
</style>

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
							<c:forEach var="h" items="${list }">
								<c:choose>
								<c:when test="${h.hopePublic == 'Y'}">
									<tr class="publicY">
										<td>${h.hopeNum }</td>
										<td>${h.hopeUser }</td>
										<td>${h.hopeTitle }</td>
										<td>${h.hopeDate }</td>
										<td>
											<c:choose >
												<c:when test="${h.hopePublic == 'Y'}">
													<p style="color: green">공개</p>
												</c:when>
												<c:otherwise>
													<p style="color: red">비공개</p>
												</c:otherwise>
											</c:choose>
										</td>
									</tr>
								</c:when>
								<c:otherwise>
									<tr class="publicN">
										<td>${h.hopeNum }</td>
										<td>${h.hopeUser }</td>
										<td>${h.hopeTitle }</td>
										<td>${h.hopeDate }</td>
										<td>
											<c:choose >
												<c:when test="${h.hopePublic == 'Y'}">
													<p style="color: green">공개</p>
												</c:when>
												<c:otherwise>
													<p style="color: red">비공개</p>
												</c:otherwise>
											</c:choose>
										</td>
									</tr>
								</c:otherwise>
								</c:choose>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
			
			
			<c:choose>
				<c:when test="${loginUser != null && loginUser.getUserId().equals('admin') || loginUser.getUserId().equals(h.hopeUser)}">
					<script>
						$("#hopeListTable>tbody>tr").click(function(){
							//console.log($(this));
							var hno = $(this).children().first().text();
							//console.log(hno);
							
							location.href = "detail.ho?hno="+hno;
							
						});
					</script>
				</c:when>
				<c:otherwise>
					<script>
						$("#hopeListTable>tbody>.publicY").click(function(){
							//console.log($(this));
							var hno = $(this).children().first().text();
							//console.log(hno);
							
							location.href = "detail.ho?hno="+hno;
							
						});
						
						$("#hopeListTable>tbody>.publicN").click(function(){
							alert("비공개 글입니다.");
						});
					</script>
				</c:otherwise>
			</c:choose>
			
			
			<div align="center" class="">
				<c:if test="${pi.currentPage != 1 }">
					<button onclick="location.href='select.ho?currentPage=${pi.currentPage-1}'">이전</button>
				</c:if>
				
				<c:forEach var="i" begin="${pi.startPage }" end="${pi.endPage }">
					<c:choose>
						<c:when test="${i != pi.currentPage }">
							<button onclick="location.href='select.ho?currentPage=${i}'">${i }</button>
						</c:when>
						<c:otherwise>
							<button disabled>${i }</button>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				
				<c:if test="${pi.currentPage != pi.maxPage }">
					<button onclick="location.href='select.ho?currentPage=${pi.currentPage+1}'">다음</button>
				</c:if>
			</div>
			
		</div>
		
		<script>
			var message = '<%= alertMsg %>';
			if(message != "null"){
				alert(message);
				    		
				<%session.removeAttribute("alertMsg");%>
			}
		</script>
		
		

	</div>
	<%@include file="/views/common/footer.jsp"%>
</body>
</html>