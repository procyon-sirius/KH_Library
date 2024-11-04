<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
      
       #qnaBoard{
          margin-top: 300px;
          align: center;
       }	
	
	</style>

	
</head>
<body>
	
	<!--  
	<%@include file="/views/common/menubar.jsp" %>
	-->
	
    <div id="qnaBoard">
        <h2>문의 게시판</h2>
        <br>
        <h5>home>소통공간>문의 게시판</h5>

        <br><br>

        <div align="center" >
            <table border="1px" class="qnaList">
                <thead>
                    <tr>
                        <th width="150">번호</th>
                        <th width="350">제목</th>            
                        <th width="150">작성자</th>
                        <th width="150">작성일</th>
                        <th width="150">첨부</th>
                        <th width="150">조회수</th>
                        <th> <button onclick="test();">클릭하시오.</button> </th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td width="150">1 </td>
                        <td width="350">1번 공지글입니다.</td>
                        <td width="150">내용</td>
                        <td width="150">조회수</td>
                        <td width="150">작성일</td>
                        <td width="150">상태값</td>
                    </tr>
                    <tr>
                        <td width="150">2 </td>
                        <td width="350">2번 공지글입니다.</td>
                        <td width="150">내용</td>
                        <td width="150">조회수</td>
                        <td width="150">작성일</td>
                        <td width="150">상태값</td>
                    </tr> 
                    <tr>
                        <td width="150">3 </td>
                        <td width="350">3번 공지글입니다.</td>
                        <td width="150">내용</td>
                        <td width="150">조회수</td>
                        <td width="150">작성일</td>
                        <td width="150">상태값</td>
                    </tr>
                    
                    <tr>
                        <td width="150">4 </td>
                        <td width="350">4번 공지글입니다.</td>
                        <td width="150">내용</td>
                        <td width="150">조회수</td>
                        <td width="150">작성일</td>
                        <td width="150">상태값</td>
                    </tr>
                    
                </tbody>
            </table>
        </div>    
	</div>
	
	
	<script>
		
				
		function test(){
			
			console.log("whndsgh");
			console.log($(".qnaList>tbody>tr"));
			
		}
			
		
		$(function(){
			
			$(".qnaList>tbody>tr").click(function(){
				
				console.log($(this));
				
				var bno = $(this).children().first().text();
				
				
				location.href="/QnADetailController.bo?bno="+bno;
			});
			
		
	
		
		
		});
		
		
		
		
	
	</script>
	
	
	
	
</body>
</html>