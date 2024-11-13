<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#mypage-area{
	border: 1px solid black;
	width :630px;
	height :670px;
}
h1{
   margin-left: 19px;	
 }
p{
 margin-top: 12px;
 margin-left: 25px;
 font-size: 22px;
}  
table{
   border: 1px solid black;
   margin-top: 22px;
   margin-left: 60px;
   font-size : 19px
}
input{
    border :1px solid rgb(201, 188, 188);
    border-radius: 4px;
    height: 22px;
 }
#update-button{
	margin-left: 190px;
	
}
#myservice{
	height : 120px;
	margin-left: 25px;
}
#myservice>ul>li{
	border :1px solid black;
	float : left;
	list-style-type: none;
	width : 150px;
	height : 60px;
	margin-left: 29px;
	padding-top: 8px;
	padding-left: 8px;
	position: relative;
}
#myservice>ul>li>a>span {
	position: absolute;
	top : 9px;
	right : 22px;
	font-size : 27px
}
#content-area{
	position: relative;
}
#recommend-book {
 	border: 1px solid black;
 	width :500px;
	height :650px;
 	float : right;
 	position: absolute;
 	top: 65px;
 	left : 650px;	 	
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
            <h1>나만의 서재</h1>
            <br>
             	   
       <div id="mypage-area">
       <form action="${contextPath}/mypage.me" method="post">
       <p><b>내 정보</b></p> 
        <table height="400px"> 
            <tr align="center">	
                <td width="190px" ><b>성명</b></td>
                <td width="320px" ><input type="text" name="userName" value="${loginUser.userName}"></td>           	
            </tr>
            <tr align="center">
                <td><b>아이디</b></td>
                <td><input type="text" name="userId" value="${loginUser.userId}" readonly></td>
            </tr>
            <tr align="center">
                <td><b>생년월일</b></td>
                <td>${loginUser.userNno }</td>
            </tr>
            <tr align="center">
            	<td><b>휴대폰 번호</b></td>
            	<td><input type="text" name="phone" value="${loginUser.phone}"></td>
			<tr align="center">
				<td><b>이메일</b></td>
				<td><input type="email" name="email" value="${loginUser.email}"></td>
			<tr align="center">
				<td><b>주소</b></td>
				<td><input type="text" name="address" value="${loginUser.address}"></td>	      
        </table>
        <br>
        
        <div id="update-button">
        	<button type="submit">정보변경</button>
        	<button type="button">비밀번호 변경</button>
        	<button type="button">회원탈퇴</button>             
        </div>
        <br>
        </form>
        <div id="myservice">
        	<h4>*서비스 이용 현황</h4>
        	<br>	
          <ul>
          	<li><a href="">대출중인<br>도서<span>0</span>
          		</a>
          	</li>
        	<li><a href="">예약중인<br>도서<span>0</span>
        		</a>
        	</li>
        	<li><a href="">신청중인<br>희망도서<span>0</span>
        		</a>
        	</li>     
          </ul>	
        	
        		                
        </div>
    
        </div>
        <div id="recommend-book">
        
        
        </div>
        
      
                              
        
            
                                             
       </div>
    </div>
    <%@include file="/views/common/footer.jsp" %>

</body>
</html>