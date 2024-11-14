<%@page import="com.kh.common.PageInfo"%>
<%@page import="com.kh.board.model.vo.Reply"%>
<%@page import="com.kh.board.model.vo.Board"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% // 조회된 목록 선언(Q)
ArrayList<Board> blist = (ArrayList<Board>)request.getAttribute("bList"); %>  
<% // 조회된 목록 선언(A)
ArrayList<Reply> rList = (ArrayList<Reply>)request.getAttribute("rList"); %>
    
<!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <!-- Popper JS -->
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<style type="text/css">
        .category {
			margin-left: -950px;
			font-size: 16px;
			
		}
		
		.list {
			color: #333;
			border: 1px solid #3333335d;
			border-radius: 5px;
			padding: 5px 20px;
			font-size: 16px;
			cursor: pointer;
			position: relative;
			left: 520px;
		}
		
		.replyWriter{
			color: #333;
			border: 1px solid #3333335d;
			border-radius: 5px;
			width: 80px;
			height : 40px;
			font-size: 16px;
			cursor: pointer;
		}
		
		.separator {
			display: inline-block;
			margin: 0 5px;
		}
		
		.boarder {
			border: none; /* 기본 테두리 제거 */
			background-color: #333333c4;
		}
		
		
		.QnAList tr{
			height: 100px;
		    border-top: 1px solid #ddd;  
		  	border-bottom: 1px solid #ddd; 
		 	border-left: none; 
		  	border-right: none;
		}
		
		.QnAList td:nth-child(1),td:nth-child(5){
			padding-left: 15px;
		}
		
		.ox{
			padding-left: 25px;
		}
		
		.qListb{
			padding-left: 20px;
			text-align: left;
		}
		
		
		.qContent {
			   display: none;
		}
		
		.qContent td.no-border {
		    border: none !important;
		}
				
		#aList{
			height: 200px;
		    border-top: 1px solid #ddd;  
		  	border-bottom: 1px solid #ddd; 
		 	border-left: none; 
		  	border-right: none;	
		}
		
		#aList td:nth-child(3){
		  padding-right: 100px;
		  padding-top: 50px;    /* 텍스트 상단에 10px 여백 */
		  padding-bottom: 50px; /* 텍스트 하단에 10px 여백 */
		
		}
		.aListDml{
			padding-left: 50px;
		
		}
		
		.aList{
			display: none;
		}
		.pageBtn button{
		border: none;
	    width: 50px;   
   		height: 50px;
   		background-color: gainsboroy;   
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
			        <div align="center" >
			        	
			  	        	<h2>문의게시판</h2>
			  	        	<br><br><br>
			        
					       	<table class="category">
								<tr>
									<td><a href="/library">Home</a></td>
									<td class="separator">></td>
									<td>소통공간</td>
									<td class="separator">></td>
									<td>문의게시판</td>
								</tr>
							</table>
							
				   		 <%if(loginUser!=null) { %>
	
							<div align="center">
								<br>
								<a href="<%=contextPath %>/insert.qna" class="list">글작성</a>
							</div>
						<%} %>	
					 </div>        	
			        		
	        		<hr class="boarder">
	                     <table border="1px" class="qnalist">
			                <thead>
			                    <tr>
			                        <th width="150">번호</th>
			                        <th width="150">QnA</th>
			                        <th width="1200">제목</th>            
			                        <th width="150">작성자</th>
			                        <th width="200">작성일</th>
			                         <th colspan="2"></th>
			                        <th width="150">처리상태</th>
			                    </tr>
			                </thead>
			                <tbody>
			               
			                <%if(blist.isEmpty() || rList.isEmpty()) {%>
			                	<tr>
			                		<td colspan="6">문의사항이 없습니다.</td>
			                	</tr>
			                <%}else {
			                		for(Board b: blist) {	
			                			
			                			boolean Reply = false;
			                			
			                			for( Reply r: rList) {
			                			
			                				if(b.getBoardNo()==r.getBoardNo()){
			                					 Reply = true; 
			                				
			                					 // 아이디 선언
			                					 String boardId = b.getUserNo();
			                					 String maskedBid = boardId.substring(0, boardId.length() - 3).replaceAll(".", "*") + boardId.substring(boardId.length() - 3);
			                					 
			                					 String replyId = r.getUserNo();
			                					 String maskedRid = boardId.substring(0, replyId.length() - 3).replaceAll(".", "*") + replyId.substring(replyId.length() - 3);
			                					 
			                %>
							                    <tr class="qList">
							                        <td width="150"><%=b.getBoardNo() %></td>
							                        <td width="150"><b>Q</b></td>
							                        <td width="1200"><%=b.getBoardTitle() %></td>
							                        <td width="150"><%=maskedBid %></td>
							                        <td width="250"><%=b.getDate() %></td>
							                        <td colspan="2" ><button class="qListb" data-boardno="<%=b.getBoardNo() %>">▼</button> </td>
							                    	<td width="150" class="ox">O</td>
							                        
							                        <td class="aListDml">
					                        		    <%if(loginUser!=null && loginUser.getUserId().equals(b.getUserNo())) { %>
															<form action="<%=contextPath %>/update.qna">
																<input type="hidden" name="boardNo" value="<%=b.getBoardNo() %>">
																<input type="hidden" name="title" value="<%=b.getBoardTitle() %>">
																<input type="hidden" name="content" value="<%=b.getBoardContent() %>">
																<button type="submit" class="replyWriter" id="qnaUpdate">문의수정</button>
													 		</form>
												 			<form action="<%=contextPath %>/delete.qna" method="post">
																<input type="hidden" name="boardNo" value="<%=b.getBoardNo() %>">
																<button type="submit" class="replyWriter">문의삭제</button>
													 		</form>
													 		
													  	<%} %>
							                        </td>
							                    
							                    </tr>
							                    <tr class="qContent" data-boardno="<%=b.getBoardNo() %>">
							                    	<td colspan="7" class="no-border">ㄴ <%=b.getBoardContent() %></td>
							                    </tr>
							                    <tr class="aList" id="aList" data-boardno="<%=r.getBoardNo() %>">
							                        <td width="150"><%=r.getBoardNo() %></td>
							                        <td width="150"><b>A</b></td>
							                        <td width="1200"><%=r.getReplyContent() %></td>
							                        <td width="150"><%=maskedRid %></td>
							                        <td width="250"><%=r.getDate() %></td>
							                        
							                        <td class="aListDml">
					                        		    <%if(loginUser!=null && loginUser.getUserId().equals("admin")){ %>
															<form action="<%=contextPath %>/update.rp">
																<input type="hidden" name="boardNo" value="<%=b.getBoardNo() %>">
																<button type="submit" class="replyWriter">답변수정</button>
													 		</form>
												 			<form action="<%=contextPath %>/delete.rp" method="post">
																<input type="hidden" name="boardNo" value="<%=b.getBoardNo() %>">
																<button type="submit" class="replyWriter">답변삭제</button>
													 		</form>
													 		<form action="<%=contextPath %>/delete.all" method="post">
																<input type="hidden" name="boardNo" value="<%=b.getBoardNo() %>">
																<button type="submit" class="replyWriter">전체삭제</button>
													 		</form>
													 		
													  	<%} %>
							                        </td>
							                    </tr>
			                    		<%} %>
			                    		
			                    	 <%} if(Reply==false){
			                    	 		
			                    		 String boardId = b.getUserNo();
	                					 String maskedBid = boardId.substring(0, boardId.length() - 3).replaceAll(".", "*") + boardId.substring(boardId.length() - 3);
			                    	 	
			                    	 %>
			                    		
		                   				<tr>
					                        <td width="150"><%=b.getBoardNo() %></td>
					                        <td width="150"><b>Q</b></td>
					                        <td width="500"><%=b.getBoardTitle() %></td>
					                        <td width="150"><%=maskedBid  %></td>
					                        <td width="250"><%=b.getDate() %></td>
					                        <td colspan="2"></td>
					                        <td width="150" class="ox">X</td>
					                        
                      				        <td class="aListDml">
			                        		    <%if(loginUser!=null && loginUser.getUserId().equals(b.getUserNo())) { %>
													<form action="<%=contextPath %>/update.qna">
														<input type="hidden" name="boardNo" value="<%=b.getBoardNo() %>">
														<input type="hidden" name="title" value="<%=b.getBoardTitle() %>">
														<input type="hidden" name="content" value="<%=b.getBoardContent() %>">
														<button type="submit" class="replyWriter" id="qnaUpdate">문의수정</button>
											 		</form>
										 			<form action="<%=contextPath %>/delete.qna" method="post">
														<input type="hidden" name="boardNo" value="<%=b.getBoardNo() %>">
														<button type="submit" class="replyWriter">문의삭제</button>
											 		</form>
											 		
											  	<%} %>
					                        </td>
					                        
					                        <td>
					                        	  <%if(loginUser!=null && loginUser.getUserId().equals("admin")) { %>
														<form action="<%=contextPath %>/insert.rp">
															<input type="hidden" name="boardNo" value="<%=b.getBoardNo() %>">
															<button type="submit" class="replyWriter">답변작성</button>
												 		</form>
												  <%} %>
					                        </td>
					                    </tr>
		                    		
	                    			  <%} %>
			      				  <%} %>
			      			<%} %>
			      			
			      			
			                </tbody>
			            </table>
				
				
				<script>
					$(function(){
							
						   $(".qListb").click(function(){
						        var boardNo = $(this).data("boardno");
						        
						        // aList (답변 리스트) 토글
						        $(".aList[data-boardno='" + boardNo + "']").toggle();
						        
						        // 해당 boardNo와 관련된 no-border td 요소도 토글
						        $(".qContent[data-boardno='" + boardNo + "']").toggle();
						    });
					});
				</script>
				
			<br><br><br>
		    <div align="center" class="pageBtn">
                
                <c:if test="${pi.currentPage != 1 }">
                    <button onclick="location.href='qnaBoard?currentPage=${pi.currentPage-1}'">이전</button>
                </c:if>
                
                <c:forEach var="i" begin="${pi.startPage }" end="${pi.endPage }">
                    <c:choose>
                        <c:when test="${i !=pi.currentPage }">
                            <button onclick="location.href='qnaBoard?currentPage=${i}'">${i }</button>
                        </c:when>
                        <c:otherwise>
                            <button disabled>${i }</button>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
                
                <c:if test="${pi.currentPage != pi.maxPage }">
                    <button onclick="location.href='qnaBoard?currentPage=${pi.currentPage+1}'">다음</button>
                </c:if>
            </div>
				
				
				
				
				
	    </div>
   </div>
   <%@include file="/views/common/footer.jsp" %>
   
</body>
</html>