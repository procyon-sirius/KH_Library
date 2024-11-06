<%@page import="com.kh.board.model.vo.Reply"%>
<%@page import="com.kh.board.model.vo.Board"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.kh.board.model.vo.Notice"%>
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
		
		
		.separator {
			display: inline-block;
			margin: 0 5px;
		}
		
		.boarder {
			border: none; /* 기본 테두리 제거 */
			background-color: #333333c4;
		}
		
		
		.regular tr{
			height: 100px
		}
		
		
		pre {
		 	text-align: left; /* 텍스트 정렬 */
			padding: 10px;
			font-family: sans-serif;
			font-size: 18px;
			color: #333;
		}
		
		
		.answer {
		    display: none; /* 초기에는 보이지 않도록 설정 */
		}
		
		.aList{
			display: none;
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

				<p>
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
					 </div>        	
			        		
			        		<hr class="boarder">
			        
			        (글번호, 글카테고리,글제목, 처리상태, 작성자(아이디 뒤에 마스킹),작성일, 조회수) 
			          <table class="regular">
		                    <tr>
		                    	<th colspan="7">Q . 자주하는 질문</th>
		                    </tr>
		                    
		                    <tr>
		                    	<td colspan="5">[자료대출] 연장신청은 어떻게 하나요?</td>
		                    	<td colspan="2" ><button class="q">▼</button> </td>
		                    </tr>
		                    
		                    <tr>
					           <td class="answer" colspan="7"> 
					           	공공도서관 자료에 한해 반납일 하루전까지 연장신청 가능합니다. <br>
								로그인 > 책 서비스 > 내정보 > 신청내역확인 > 신청진행도서에 연장신청 버튼을 누르시거나 도서관에 요청하시기 바랍니다. 
					           </td>         
		                    </tr>
	                   	</table>
	                   	
	                     <table border="1px" class="qnalist">
			                <thead>
			                    <tr>
			                        <th width="150">번호</th>
			                        <th width="150">QnA</th>
			                        <th width="400">제목</th>            
			                        <th width="150">작성자</th>
			                        <th width="150">작성일</th>
			                        <th width="150">첨부</th>
			                        <th width="150">조회수</th>
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
			                			
			                %>
							                    <tr class="qList">
							                        <td width="150"><%=b.getBoardNo() %></td>
							                        <td width="150"><b>Q</b></td>
							                        <td width="500"><%=b.getBoardTitle() %></td>
							                        <td width="150"><%=b.getUserNo() %></td>
							                        <td width="150"><%=b.getDate() %></td>
							                        <td width="150">첨부파일</td>
							                        <td width="150"><%=b.getCount() %></td>
							                        <td colspan="2" ><button class="qListb" data-boardno="<%=b.getBoardNo() %>">▼</button> </td>
							                    </tr>
							                    <tr class="aList" data-boardno="<%=b.getBoardNo() %>">
							                        <td width="150"><%=r.getBoardNo() %></td>
							                        <td width="150"><b>A</b></td>
							                        <td width="500"><%=r.getReplyContent() %></td>
							                        <td width="150"><%=r.getUserNo() %></td>
							                        <td width="150"><%=r.getDate() %></td>
							                    </tr>
			                    		<%} %>
			                    		
			                    	 <%} if(Reply==false){%>
			                    		
		                   				<tr>
					                        <td width="150"><%=b.getBoardNo() %></td>
					                        <td width="150"><b>A</b></td>
					                        <td width="500"><%=b.getBoardTitle() %></td>
					                        <td width="150"><%=b.getUserNo() %></td>
					                         <td width="150"><%=b.getDate() %></td>
					                        <td width="150">첨부파일</td>
					                        <td width="150"><%=b.getCount() %></td>
					                    </tr>
	                    		
	                    			  <%} %>
			      				  <%} %>
			      			<%} %>
			                </tbody>
			            </table>
				
				
				
				<script>
				
				
					$(function(){
						
							$(".q").click(function(){
								
									console.log($(".q"));
								
								 $(".answer").toggle();
								
							});
							
							
							$(".qListb").click(function(){
								 var boardNo = $(this).data("boardno");
								$(".aList[data-boardno='" + boardNo + "']").toggle();
							
						});
						
					});
					
				</script>
			</p>
	    </div>
   </div>
   <%@include file="/views/common/footer.jsp" %>
   
</body>
</html>