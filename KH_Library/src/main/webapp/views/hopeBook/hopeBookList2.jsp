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
	th{
		background-color: #C4D3E8;
	}
	.trBackground {
    	background-color: #cccccc;
	}
	.thtd th, .thtd td {
    	padding-top: 20px !important;
    	padding-bottom: 20px !important;
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
			<table class="table thtd" style="width: 90%;" id="hopeListTable" align="center">
				<thead>
					<tr>
						<th width="8%"></th>
						<th width="13%">신청인</th>
						<th width="50%">신청 도서 제목</th>
						<th width="12%">신청일</th>
						<th width="7%">
							<select id="sort" name="sort">
								<option value="aOrder" ${oder == 'aOrder' ? 'selected' : ''}>최신순</option>
								<option value="dOrder" ${oder == 'dOrder' ? 'selected' : ''}>오래된순</option>
							</select>
						</th>
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
										<td>
											<!-- ${h.userId } -->
											<c:choose>
											<c:when test="${loginUser.userId eq 'admin' }">
												${h.userId }
											</c:when>
											<c:otherwise>
												<script>
							                        var userId = "${h.userId}";
							                        document.write(userId.substring(0, 3) + "*".repeat(userId.length - 3));
							                    </script>
						                    </c:otherwise>
						                    </c:choose>
										</td>
										<td>${h.hopeTitle }</td>
										<td>${h.hopeDate }</td>
										<td style="text-align: center;">
											<img src="<c:url value='/resources/hopeImg/hopelistUnlock.png' />" alt="공개 이미지" style="width: 15px; height: 15px;">
										</td>
									</tr>
								</c:when>
								<c:otherwise>
									<tr class="${h.hopeStatus eq 'Y' && loginUser.userId eq 'admin' ? 'trBackground' : ''}">
										<td>${h.hopeNum }</td>
										<td>
											<!-- ${h.userId } -->
											<c:choose>
											<c:when test="${loginUser.userId eq 'admin' }">
												${h.userId }
											</c:when>
											<c:otherwise>
												<script>
							                        var userId = "${h.userId}";
							                        document.write(userId.substring(0, 3) + "*".repeat(userId.length - 3));
							                    </script>
						                    </c:otherwise>
						                    </c:choose>
										</td>
										<td>${h.hopeTitle }</td>
										<td>${h.hopeDate }</td>
										<!-- <td><p style="color: red">비공개</p></td> -->
										<td style="text-align: center;">
											<img src="<c:url value='/resources/hopeImg/hopelistLock.png' />" alt="비공개 이미지" style="width: 15px; height: 15px;">
										</td>
									</tr>
								</c:otherwise>
								</c:choose>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
			
			<input type="hidden" id="currentPage" value="${pi.currentPage}" />
			<script>
				$("#hopeListTable>tbody>tr").click(function(){
					//console.log($(this));
					var hopeNum = $(this).children().first().text();
					//console.log(hopeNum);
					var currentPage = $("#currentPage").val();
					//console.log(currentPage);
					var oder = $("#sort").val();
					//console.log(oder);
					
					//location.href = "detail.ho?hopeNum="+hopeNum;
					location.href = "detail.ho?hopeNum="+hopeNum + "&sort=" + oder + "&currentPage=" + currentPage;
							
				});
			</script>
			
			<br><br>
			
			<div align="center" class="">
				<c:if test="${pi.currentPage != 1 }">
					<button class="btn btn-outline-primary" onclick="location.href='select.ho?sort=${oder }&currentPage=${pi.currentPage-1}'">이전</button>
				</c:if>
				
				<c:forEach var="i" begin="${pi.startPage }" end="${pi.endPage }">
					<c:choose>
						<c:when test="${i != pi.currentPage }">
							<button class="btn btn-outline-primary" onclick="location.href='select.ho?sort=${oder }&currentPage=${i}'">${i }</button>
						</c:when>
						<c:otherwise>
							<button class="btn btn-primary" disabled>${i }</button>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<c:if test="${pi.currentPage != pi.maxPage }">
					<button class="btn btn-outline-primary" onclick="location.href='select.ho?sort=${oder }&currentPage=${pi.currentPage+1}'">다음</button>
				</c:if>
			</div>
			
		</div>
		
		<script>
			$("#sort").change(function(){
				var oder = $(this).val();
				//console.log(oder);
				var currentPage = $("#currentPage").val();
				//console.log(currentPage);
				
				//location.href = "select.ho?sort="+oder+"&currentPage="+currentPage;
				location.href = "select.ho?sort=" + oder + "&"+"currentPage=" + currentPage;

			});
		</script>

	</div>
	<%@include file="/views/common/footer.jsp"%>
</body>
</html>