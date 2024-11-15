<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
	
 <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

<style>
#mypage-area{
	width :1160px;
	height :500px;	
}
h1{
   margin-left: 120px;	
 } 
 
#myInfo{
   width: 900px;
   height: 300px;
   margin-top: 22px;
   margin-left: 120px;
   font-size : 17px
}
input{
    border :1px solid rgb(201, 188, 188);
    border-radius: 4px;
    height: 22px;    
 } 

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
		<script>
			$(function(){
				console.log();
				var sidemenu = $(".side-title-menu").eq(4);
				sidemenu.siblings("ul").children().show();
				sidemenu.siblings("ul").children().eq(0).addClass("menu-click");
			})
		</script>
      <div id="content-area">
       <br>
       <h1>나의 정보</h1>
             	   
       <div id="mypage-area">
       <form action="${contextPath}/mypage.me" method="post">      
        <table border="1" id="myInfo"> 
            <tr align="center">	
                <td width="150px" ><b>성명</b></td>
                <td width="320px" ><input type="text" name="userName" value="${loginUser.userName}"></td>
                <td width="150px"><b>아이디</b></td>
                <td width="320px"><input type="text" name="userId" value="${loginUser.userId}" readonly></td>           	
            </tr>
            <tr align="center">
                <td><b>생년월일</b></td>
                <td>${loginUser.userNno }</td>
                <td><b>휴대폰 번호</b></td>
                <td><input type="text" name="phone" value="${loginUser.phone}"></td> 
            </tr>
            <tr align="center">
                <td><b>이메일</b></td>
                <td><input type="email" name="email" value="${loginUser.email}"></td>
                <td><b>주소</b></td>
                <td><input type="text" name="address" value="${loginUser.address}"></td> 
            </tr>
                      	      
        </table>
        <br>
                
        <div align="center" id="update-button">
        	<button type="submit" class="btn btn-info">정보변경</button>
        	<button type="button" data-toggle="modal" data-target="#updatePwd" class="btn btn-success">비밀번호 변경</button>
        	<button type="button" data-toggle="modal" data-target="#deleteMember" class="btn btn-danger">회원탈퇴</button>             
        </div>
        <br><br>
        </form>
        
        <!-- 비밀번호 변경용 모달 영역 -->
        <div class="modal" id="updatePwd">
        	<div class="modal-dialog">
        	   <div class="modal-content">
        	   
        	   	<!-- Modal Header -->
        	   	<div class="modal-header">
        	   		<h4 class="modal-title">비밀번호 변경</h4>
        	   		<button type="button" class="close" data-dismiss="modal">&times;</button>       	   	       	    	   	
        	   	</div>
        	   	
        	   	<!-- Modal body -->
        	   	<div class="modal-body" align="center">
        	   	   <form action="${contextPath}/updatePwd.me" method="post">
        	   	   	<input type="hidden" name="userId" value="${loginUser.userId}">
        	   	   	
        	   	   	<table>
        	   	   		<tr>
        	   	   			<td width="170px">현재 비밀번호</td>
        	   	   			<td><input type="password" name="userPwd" required></td>
        	   	   		</tr>
        	   	   		<tr>
        	   	   			<td>변경할 비밀번호</td>
        	   	   			<td><input type="password" name="pwdUpdate" id="pwdUpdate" required></td>
        	   	   		</tr>
        	   	   		
        	   	   		<tr>
        	   	   			<td>변경할 비밀번호 확인</td>
        	   	   			<td><input type="password" id="pwdCheck" required></td>
        	   	   		</tr>
        	   	   					        	   	     	   	   	       	   	   	
        	   	   	</table>
        	   	   	<br>
        	   	   	
        	   	   	<button type="submit" onclick=" return chkPwd();" class="btn btn-secondary">비밀번호 변경</button>
        	   	           	   	       	   	          	   	           	   	   
        	   	   </form>
        	   	        	   	        	   	
        	   	</div>
        	   	<script>
        	   		function chkPwd(){
        	   			
        	   			var pwdUpdate = $("#pwdUpdate").val();
        	   			var pwdCheck = $("#pwdCheck").val();
        	   			      	   		       	   			
        	   			if(pwdUpdate != pwdCheck){
        	   				alert("변경할 비밀번호와 비밀번호 확인이 일치하지 않습니다.");
        	   				return false;
        	   				
        	   			}
        	   		        	   			        	   	       	   			        	   			        	   			       	   			
        	   		}
        	   	
        	   	</script>
        	          	   
        	   </div>
        	
        	</div>
                
        </div>
        
        <!-- 회원탈퇴용 모달 영역 -->
        <div class="modal" id="deleteMember">
        	<div class="modal-dialog">
        		<div class="modal-content">
        		
        			<!-- Modal Header -->
        			<div class="modal-header">
        				<h4 class="modal-title">회원탈퇴</h4>
        				<button type="button" class="close" data-dismiss="modal">&times;</button>
        				        			
        			</div>
        			
        			<!-- Modal body -->
        			<div class="modal-body" align="center">
        				<form action="${contextPath}/del.me" method="post">
        					<input type="hidden" name="userId" value="${loginUser.userId}">
        					<table>
        						<tr>
        							<td width="170px">현재 비밀번호</td>
        							<td><input type="password" name="userPwd" required></td>
        							
        						</tr>
        					</table>
        					<br>
        					
        					<button type="submit" class="btn btn-danger">회원 탈퇴</button>
        				
        				</form>
        			        			
        			</div>
        			<script>
        			
        			
        			</script>
        		        		        		     		
        		</div>
        	
        	</div>
               
        </div>
                              
    
        </div>
                                           
                                             
       </div>
    </div>
    <%@include file="/views/common/footer.jsp" %>

</body>
</html>