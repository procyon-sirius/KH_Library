<%@page import="com.kh.hopeBook.model.vo.HopeBook"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%--<% String alertMsg = (String)session.getAttribute("alertMsg"); --%>
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
	th, td{
		padding-left: 3px;
	}
	th{
		background-color: #C4D3E8;
	}
	.trBackground {
    background-color: #cccccc;
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
			<br><br>
			<table class="table" style="width: 70%;" id="hopeListTable" align="center">
				<thead>
					<tr>
						<th width="5%"></th>
						<th width="10%">신청인</th>
						<th width="55%">신청 도서 제목</th>
						<th width="12%">신청일</th>
						<th width="8%"></th>
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
									<tr class="${h.hopeStatus eq 'Y' && loginUser.userId eq 'admin' ? 'trBackground' : ''}">
										<td>${h.hopeNum }</td>
										<td>${h.userId }</td>
										<td>${h.hopeTitle }</td>
										<td>${h.hopeDate }</td>
										<td><p style="color: green">공개</p></td>
									</tr>
								</c:when>
								<c:otherwise>
									<tr class="${h.hopeStatus eq 'Y' && loginUser.userId eq 'admin' ? 'trBackground' : ''}">
										<td>${h.hopeNum }</td>
										<td>${h.userId }</td>
										<td>${h.hopeTitle }</td>
										<td>${h.hopeDate }</td>
										<td><p style="color: red">비공개</p></td>
									</tr>
								</c:otherwise>
								</c:choose>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
			
			
			<script>
				$("#hopeListTable>tbody>tr").click(function(){
					//console.log($(this));
					var hopeNum = $(this).children().first().text();
					//console.log(hopeNum);
							
					location.href = "detail.ho?hopeNum="+hopeNum;
							
				});
			</script>
			
			<br><br>
			<div align="center" class="">
				<c:if test="${pi.currentPage != 1 }">
					<button class="btn btn-outline-primary" onclick="location.href='select.ho?currentPage=${pi.currentPage-1}'">이전</button>
				</c:if>
				
				<c:forEach var="i" begin="${pi.startPage }" end="${pi.endPage }">
					<c:choose>
						<c:when test="${i != pi.currentPage }">
							<button class="btn btn-outline-primary" onclick="location.href='select.ho?currentPage=${i}'">${i }</button>
						</c:when>
						<c:otherwise>
							<button class="btn btn-primary" disabled>${i }</button>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<c:if test="${pi.currentPage != pi.maxPage }">
					<button class="btn btn-outline-primary" onclick="location.href='select.ho?currentPage=${pi.currentPage+1}'">다음</button>
				</c:if>
			</div>
			
		</div>
		
		<%-- 
		<script>
			var message = '<%= alertMsg %>';
			if(message != "null"){
				alert(message);
				    		
				<%session.removeAttribute("alertMsg");%>
			}
		</script>
		--%>
		

	</div>
	<%@include file="/views/common/footer.jsp"%>
</body>
</html>