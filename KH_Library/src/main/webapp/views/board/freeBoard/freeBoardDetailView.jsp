<%@page import="com.kh.board.model.vo.Reply"%>
<%@page import="com.kh.board.model.vo.Board"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<!-- Popper JS -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

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
	
.reply{
	font-size:16px;
}

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
			<p>
				<% Board fb = (Board) request.getAttribute("freeBoard"); %>
				<% ArrayList<Board> preNnext = (ArrayList<Board>) request.getAttribute("preNnext");%>
				<% int currentPage = (int)request.getAttribute("currentPage"); %>
				<% ArrayList<Reply> fbR = (ArrayList<Reply>)request.getAttribute("fbReply"); %>
			
			<div align="center">

				<h2>공지사항</h2>
				<br>
				<br>
				<br>
				<table class="category">
					<tr>
						<td><a href="/library">Home</a></td>
						<td class="separator">></td>
						<td>소통공간</td>
						<td class="separator">></td>
						<td>자유게시판</td>
					</tr>
				</table>
			</div>

			<br> <br> <br>

			<div class="noticeDetail">

				<h4 align="center"><%=fb.getBoardTitle()%></h4>
				<br>
				<hr class="boarder">
				<br> <br>

				<table class="info">
					<tr>
						<td>등록일:</td>
						<td class="cell"><%=fb.getDate()%></td>
						<td class="separator">|</td>
						<td>조회수:</td>
						<td class="cell"><%=fb.getCount()%></td>
					</tr>
				</table>


				<% String writerNo = fb.getUserNo();
			if(loginUser!=null && loginUser.getUserId().equals(writerNo)) {%>
				<table class="insert">
					<tr>
						<td>
							<button type="button" class="m"
								onclick="location.href='${contextPath}/update.fb?nno=<%=fb.getBoardNo()%>&currentPage=<%=currentPage%>'">수정하기</button>
						</td>
						<td class="separator">|</td>
						<td>
							<button type="button" class="m" id="deleteBtn"
								onclick="location.href='${contextPath}/delete.fb?nno=<%=fb.getBoardNo()%>&currentPage=<%=currentPage%>'">
								삭제하기</button>
						</td>
					</tr>
				</table>
				<%} %>

				<br> <br>

				<pre class="content">
					
					<%=fb.getBoardContent()%>
									
				</pre>

				<hr>


				<br> <br> <br> <a
					href="/library/freeBoard?currentPage=<%=currentPage %>"
					class="list">목록으로</a>
				<%if(loginUser!=null) { %>
				<a
					href="<%=contextPath %>/insert.FBrp?boardNo=<%=fb.getBoardNo()%>&currentPage=<%=currentPage %>"
					class="list">댓글작성</a>
				<%} %>

				<br> <br>

				<%for(Reply r : fbR) { 
					String id = r.getUserNo();
					String maskedBid = id.substring(0, id.length() - 3).replaceAll(".", "*") + id.substring(id.length() - 3);
				
				%>
				<table class="bnnlist">
					<tr>
						<hr>
						<td><%=r.getReplyNo() %></td>
						<td><%=maskedBid %></td>
						<td id="fContent"><b><%=r.getReplyContent() %></b></td>
						<td><%=r.getDate() %></td>

						<%if(loginUser.getUserId().equals(id)){ %>
						<td>
							<button type="button" class="m" id="mBtn"
								data-rno="<%=r.getReplyNo() %>"
								data-content="<%=r.getReplyContent() %>">수정하기</button>
						</td>
						<td>
							<button type="button" class="m" id="deleteReplyBtn"
								data-rno="<%=r.getReplyNo() %>">삭제하기</button>
						</td>
						<%} %>
					</tr>
				</table>
				<%} %>


				<hr>
				<br> <br>
				<table class="bnnlist">

					<%
						if (preNnext.size() == 1) {
						%>

					<%
							if (preNnext.get(0).getPosition().equals("next")) {
							%>

					<tr>
						<td>▼</td>
						<td>다음글</td>
						<td><a
							href="/library/detail.fb?nno=<%=preNnext.get(0).getBoardNo()%>&currentPage=<%=currentPage %>">
								<%=preNnext.get(0).getBoardTitle()%>
						</a></td>
					</tr>

					<%
							} else {
							%>

					<tr>
						<td>▲</td>
						<td>이전글</td>
						<td><a
							href="/library/detail.fb?nno=<%=preNnext.get(0).getBoardNo()%>&currentPage=<%=currentPage %>">
								<%=preNnext.get(0).getBoardTitle()%>
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
							href="/library/detail.fb?nno=<%=preNnext.get(0).getBoardNo()%>&currentPage=<%=currentPage %>">
								<%=preNnext.get(0).getBoardTitle()%>
						</a></td>

					</tr>
					<tr>
						<td>▼</td>
						<td>다음글</td>
						<td><a
							href="/library/detail.fb?nno=<%=preNnext.get(1).getBoardNo()%>&currentPage=<%=currentPage %>">
								<%=preNnext.get(1).getBoardTitle()%>
						</a></td>
					</tr>

					<%
						}
						%>
				</table>
				<br> <br>


				<script>
				
		
					$(function() {
						
						
						// 댓글수정
						$(document).on("click","#mBtn",function(){
							
							$(this).find("#deleteReplyBtn").hide();
							
							var rno = $(this).attr("data-rno");
							// console.log(replyNo);
							var reply = $(this).attr("data-content");
							// console.log(reply);
							var replyList = $(this).closest(".bnnlist");
							// console.log(replyList);
							replyList.siblings(".bnnlist").hide();
							
				    	    // 텍스트 영역 생성
				    	    var textarea = $("<textarea>");
				    	    textarea.attr("placeholder",reply);
							
							var b = replyList.find("b")
							b.replaceWith(textarea);
							
							
							$(".bnnlist button").click(function(){
								var t = $(textarea);
								t.prop("readonly", true);
								var changed = t.val();
								
								
						 		 $.ajax({
									url : '${contextPath}/update.frp',
									type : "post",
									data : {
										rno : rno,
										changed : changed
									},
									success : function(result){
								  		if(result.status=="success"){
											alert(result.message);
											window.location.href = '${contextPath}/freeBoard?currentPage=${currentPage}'; 
											
										}else{
											alert(result.message);
										}
										
									},
									error : function(){
										console.log("통신오류");
									}
									
								});  
								
							});
							
						});
						
						
						
						

							// 댓글삭제
							$(document).on("click", "#deleteReplyBtn", function() {
								var replyNo = $(this).attr("data-rno");
								console.log(replyNo);	
								
								if (confirm("정말 삭제하시겠습니까?")) {

									var form = $("<form>", {
										method : "POST",
										action : "${contextPath}/delete.frp"
									});

									var inputEl = $("<input>", {
										type : "hidden",
										name : "replyNo",
										value : replyNo

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