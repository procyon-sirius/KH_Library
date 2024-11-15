<%@page import="java.util.ArrayList"%>
<%@page import="com.kh.board.model.vo.Notice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



<!DOCTYPE html>
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<!-- Popper JS -->
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>


<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
.info {
	margin-left: 20px;
}

.insert {
	margin-left: 1000px;
}

.category {
	margin-left: -900px;
	font-size: 16px;
}

.boarder {
	border: none; /* 기본 테두리 제거 */
	height: 1px; /* 두께 조절 */
	background-color: #333333c4;
}

.cell {
	padding-left: 5px; /* 등록일과 날짜 사이의 여백 조절 */
}

.separator {
	display: inline-block;
	margin: 0 10px;
}

.content {
	background-color: rgba(128, 128, 128, 0.233);
	border-radius: 10px;
}

pre {
	font-family: sans-serif;
	font-size: 18px;
	color: #333;
}

.list {
	color: #333;
	border: 1px solid #3333335d;
	border-radius: 5px;
	padding: 5px 20px;
	font-size: 16px;
	cursor: pointer;
	position: relative;
	left: 500px;
}

.bnnlist {
	margin-left: 20px;
}

.bnnlist td {
	padding: 20px;
}

.m {
	color: #333;
	border: none;
	border-radius: 5px;
	font-size: 16px;
	cursor: pointer;
	position: relative;
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
		<div id="content-area">
			<% Notice n = (Notice) request.getAttribute("notice"); %>
			<% ArrayList<Notice> preNnext = (ArrayList<Notice>) request.getAttribute("preNnext");%>
			<% int currentPage = (int)request.getAttribute("currentPage"); %>

			<div align="center">

				<h2>공지사항</h2>
				<br> <br> <br>
				<table class="category">
					<tr>
						<td><a href="/library">Home</a></td>
						<td class="separator">></td>
						<td>소통공간</td>
						<td class="separator">></td>
						<td>공지사항</td>
					</tr>
				</table>
			</div>

			<br> <br> <br>

			<div class="noticeDetail">
				<h4 align="center"><%=n.getNoticeTitle()%></h4>
				<br>
				<hr class="boarder">
				<br> <br>

				<table class="info">
					<tr>
						<td>등록일:</td>
						<td class="cell"><%=n.getDate()%></td>
						<td class="separator">|</td>
						<td>조회수:</td>
						<td class="cell"><%=n.getNumber()%></td>
					</tr>
				</table>


				<%if(loginUser!=null && loginUser.getUserId().equals("admin")) {%>
				<table class="insert">
					<tr>
						<td><button type="button" class="m"
								onclick="location.href='<%=contextPath %>/update.no?nno=<%=n.getNoticeNo()%>&currentPage=${currentPage}'">수정하기</button></td>
						<td class="separator">|</td>
						<td><button type="button" class="m" id="deleteBtn">삭제하기</button>
						</td>
					</tr>
				</table>
				<%} %>
				
				<!-- 첨부파일이 있는 경우에만 보여주기 -->
				<td colspan="3"><c:choose>
						<c:when test="${empty at }">
							&nbsp;&nbsp;&nbsp;&nbsp;첨부파일이 없습니다
						</c:when>
						<c:otherwise>
							<!-- 다운로드 속성 추가 -->
							&nbsp;&nbsp;&nbsp;&nbsp;<a download href="${contextPath }${at.filePath}/${at.changeName}">${at.originName }</a>
						</c:otherwise>
					</c:choose></td>

				<br><br>

				<pre class="content">
					
					<%=n.getNoticeContent()%>
					
					통합회원 시스템 점검작업으로 인하여 
					공공도서관 지원서비스 책바다 서비스/ 공공도서관 기술지원센터 회원가입, 로그인, 
				
					아이디/비밀번호 찾기에 대한 서비스가 원활하지 않을수 있습니다.
			
	
					ㅇ 점검일시: 2023년 12. 07.(목) 오후 6시 ~2023년 12. 08.(금) 오전 12시
					ㅇ 점검서비스 : KH도서관 통합회원시스템
	
	
					※ 작업상황에 따라 서비스 중단시간은 변동될 수 있사오니 양해 부탁드립니다.
									
				</pre>
				<hr>

				<br> <br> <br> <a
					href="/library/notice?currentPage=<%=currentPage %>" class="list">목록으로</a>
				<br> <br>
				<hr>


				<table class="bnnlist">

					<%
						if (preNnext.size() == 1) {
						%>

					<%
							if (preNnext.get(0).getPostPostion().equals("next")) {
							%>

					<tr>
						<td>▼</td>
						<td>다음글</td>
						<td><a
							href="/library/detail.no?nno=<%=preNnext.get(0).getNoticeNo()%>&currentPage=<%=currentPage %>">
								<%=preNnext.get(0).getNoticeTitle()%>
						</a></td>
					</tr>

					<%
							} else {
							%>

					<tr>
						<td>▲</td>
						<td>이전글</td>
						<td><a
							href="/library/detail.no?nno=<%=preNnext.get(0).getNoticeNo()%>&currentPage=<%=currentPage %>">
								<%=preNnext.get(0).getNoticeTitle()%>
						</a></td>
					</tr>

					<%
							}
							%>


					<%
						} else {
						%>

					<tr>
						<td>▲</td>
						<td>이전글</td>
						<td><a
							href="/library/detail.no?nno=<%=preNnext.get(0).getNoticeNo()%>&currentPage=<%=currentPage %>">
								<%=preNnext.get(0).getNoticeTitle()%>
						</a></td>

					</tr>
					<tr>
						<td>▼</td>
						<td>다음글</td>
						<td><a
							href="/library/detail.no?nno=<%=preNnext.get(1).getNoticeNo()%>&currentPage=<%=currentPage %>">
								<%=preNnext.get(1).getNoticeTitle()%>
						</a></td>
					</tr>

					<%
						}
						%>
				</table>
				<br> <br>


				<script>
				
					$(function(){
						
						$("#deleteBtn").click(function(){
							
							if(confirm("정말 삭제하시겠습니까?")){
								
								/* var form = $("<form>");
								form.attr("method", "POST").attr("action","${contextPath}/delete.no"); */
								
								
								var form = $("<form>", {
									method : "POST",
									action : "${contextPath}/delete.no"
								});

								
								var inputEl = $("<input>", {
									type : "hidden",
									name : "noticeNo",
									value : <%= n.getNoticeNo() %>
									
								});
			
								form.append(inputEl);

								$("body").append(form);
								form.submit();	
								
								
							};
						});
					});
				
				</script>
			</div>


		</div>
	</div>
	<%@include file="/views/common/footer.jsp"%>
</body>
</html>