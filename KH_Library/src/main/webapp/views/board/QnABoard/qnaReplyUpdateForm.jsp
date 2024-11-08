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
		
		
		.title {
		    width: 100%;            
		    height: 40px;           
		    background-color: rgba(128, 128, 128, 0.233);          
		    border: 1px solid #black; 
		    padding: 8px;           
		    font-size: 16px;       
		}
		
		
		
		.content{
			background-color: rgba(128, 128, 128, 0.233);
			font-family: sans-serif;
			font-size: 18px;
			color: #333;
			width: 100%;
			height: 800px;
			resize: none;
			
		}
		
		
		.separator {
			display: inline-block;
			margin: 0 5px;
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
							<br> <br>
							<h5>QnA 답변수정하기</h5>
													
					 </div>        	
			        		
	        		<hr class="boarder">
	      
    	<form action="<%=contextPath%>/update.rp" method="post">
			
			<div class="qnaDetail">
				<input type="hidden" name="boardNo" value="${boardNo }"/>
				<br>
				<hr class="boarder">
				<br><br>
	
				<textarea class="content" name="content" placeholder="내용을 입력하세요." required="required" ></textarea>
	
				<hr>
	
				<br> <br> <br> <button type="submit" class="list">수정하기</button>
				<a href="/library/qnaBoard" class="list">목록으로</a>
				<hr>
		</form>	
				
			</p>
	    </div>
   </div>
   <%@include file="/views/common/footer.jsp" %>
   
</body>
</html>