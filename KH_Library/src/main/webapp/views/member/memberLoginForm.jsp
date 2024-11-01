<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <style>
        .outer{
            background-color:white;
    	    color:black;
    	    width: 1000px;
    	    margin: auto;
    	    margin-top: 200px;
    
        }
        .login-area{

            border: 1px solid black;
            width: 500px;
            height: 400px;
            border-radius: 12px;
    
        }
        #id-area{
            border: 1px solid black;
            width: 350px;
            height: 45px;
            margin-top: 80px;
        }
        #pw-area{
            border: 1px solid black;
            width: 350px;
            height: 45px;
        }
        #userId,#userPwd{
            width: 340px;
            height: 43px;
            border:none;
        }
        #loginBtn{
            width: 350px;
            height: 45px;
            border-radius: 12px;
        }
        
    </style>
</head>
<body>

 <div class="outer" align="center">
        <h1 align="center">회원 로그인</h1>
    
    
    <div class="login-area">
        
        <form action="" method="" id="login_form">
            <div id="id-area">
                <input type="text" id="userId" name="" placeholder="아이디">
            </div>
            <div id="pw-area">
                <input type="pasword" id="userPwd" name="" placeholder="비밀번호">
            </div>
            <br>
            <button id="loginBtn">로그인</button>
            <div id="searchArea">
                <a href="">아이디찾기</a> 
                <a href="">비밀번호찾기</a>
                <a href="">회원가입</a>
            </div>

        </form>


    	</div>
   
    </div>


</body>
</html>