<%@page import="java.util.ArrayList"%>
<%@page import="com.kh.board.model.vo.Notice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% // 조회된 목록 선언
ArrayList<Notice> list = (ArrayList<Notice>)request.getAttribute("list"); %>  
    
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
	     
	      #noticeList{
	         margin-top: 300px;
	         align: center;
	      }	
	      
	      
	      .category {
			margin-left: -1050px;
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
						
			      
	      
	
	</style>


</head>
<body>
	
	<!--  
	<%@include file="/views/common/menubar.jsp" %>
	-->
	
    <div id="noticeList">

        

        <br><br>

        <div align="center" >
        
  	        	<h2>공지사항</h2>
  	        	<br><br><br>
        
		       	<table class="category">
					<tr>
						<td><a href="/library">Home</a></td>
						<td class="separator">></td>
						<td>소통공간</td>
						<td class="separator">></td>
						<td>공지사항</td>
					</tr>
				</table>
		        	
        		
        		<hr class="boarder">
        
        
            <table border="1px" class="noticeList">
                <thead>
                    <tr>
                        <th width="150">번호</th>
                        <th width="350">제목</th>            
                        <th width="150">작성자</th>
                        <th width="150">작성일</th>
                        <th width="150">첨부</th>
                        <th width="150">조회수</th>
                    </tr>
                </thead>
                <tbody>
               
                <%if(list.isEmpty()) {%>
                	<tr>
                		<td colspan="6">공지사항이 없습니다.</td>
                	</tr>
                <%}else {
                		for( Notice n: list) {	
                %>
                    <tr>
                        <td width="150"><%=n.getNoticeNo() %></td>
                        <td width="500"><%=n.getNoticeTitle() %></td>
                        <td width="150"><%=n.getUserNo() %></td>
                        <td width="150"><%=n.getDate() %></td>
                         <td width="150">첨부파일</td>
                        <td width="150"><%=n.getNumber() %></td>
                    </tr>
      				  <%} %>
      			<%} %>
                    
                </tbody>
            </table>
        </div>    
	</div>
	
	
	<script>
		
		$(function(){
			
			$(".noticeList>tbody>tr").click(function(){
				
				console.log($(this));
				
				var nno = $(this).children().first().text();
				
				
				location.href="/library/detail.no?nno="+nno;
			});
			
		
	
		
		
		});
		
		
		
		
	
	</script>
	
	
</body>
</html>