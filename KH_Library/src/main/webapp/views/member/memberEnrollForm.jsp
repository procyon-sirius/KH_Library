<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%
		String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

<style>
        .outer{
            margin-top: 50px;
            
        }

        .enroll-area{
            border: 1px solid cadetblue;
            width: 800px;
            height: 630px;
            border-radius: 12px;
        }

        input{
            border :1px solid rgb(201, 188, 188);
            border-radius: 4px;
            height: 18px;
        }
   
    </style>

</head>
<body>
	<%
	pageContext.setAttribute("scope", "page Scope");
	%>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	
	<div class="outer" align="center">
        <br>
        <h1 align="center">회원가입</h1 >


            <div class="enroll-area">
            <br>    
            <form action="${contextPath}/insert.me" id="enroll-form" method="post">
            
                <table width="780px" height="480px">
                    <tr>
                        <td width="120px">* 아이디</td>
                        <td width="170px"><input type="text" id="userId" name="userId" required> </td>
                        <td width="70px"><button type="button" onclick="idCheck();"> 중복확인</button></td>
                        <td><span><small> ※ 첫글자는 반드시 '영소문자'이고 '영소문자', '숫자' 로 이루어진 6~12자 이내 </small></span></td> 
                    </tr>
                    <tr>
                        <td>* 비밀번호</td>
                        <td><input type="password" id="userPwd" name="userPwd" required></td>
                        <td colspan="2"><span><small> ※ 8~20자리의 영문,숫자,특수문자를 3가지를 모두 포함하여 입력 </small></span></td>
                    </tr>
                    <tr>
                        <td>* 비밀번호 확인</td>
                        <td><input type="password" id="chkPwd" required></td>
                    </tr>
                    <tr>
                        <td>*이름</td>    
                        <td><input type="text" id="userName" name="userName" maxlength="6" required></td>
                    </tr>
                    <tr>
                        <td>*생년월일</td>
                        <td><input type="text" name="userNno" placeholder="주민번호 앞 6자리 입력" required></td>
                        
                    </tr>
                    <tr>
                        <td>*전화번호</td>
                        <td><input type="text" name="phone" placeholder="-포함해서 입력" required> </td>
                    </tr>
                    <tr>
                        <td>*이메일</td>
                        <td><input type="email" name="email" required></td>
                    </tr>
                    <tr>
                        <td>*주소</td>
                        <td><input type="text" name="address" required> </td>
                    </tr>
                </table>
                <br><br>

                <div align="center">
                    <button type="submit" id="enroll" onclick="return pwdCheck();" disabled >회원가입</button>
                    <button type="reset" onclick="again();">초기화</button>
                </div>

            </form>
        </div>  

    </div>
    	
    	<script>
    	  	
    	  function pwdCheck(){
    		  
    		  var userPwd = document.getElementById("userPwd").value;
    		  var chkPwd = document.getElementById("chkPwd").value;
    		  var userId = document.getElementById("userId").value;  		  
    		  var idForm = /^[a-z]+[0-9a-z]{6,12}$/;
    		  var pwdForm = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,20}$/;

    		  if(!idForm.test(userId)){
    			  
    			  alert("아이디 형식이 올바르지 않습니다.");
    			  $("userId").focus();
    			  return false; 				  
    		  }
    		  
    		  if(!pwdForm.test(userPwd)){
    			  
    			  alert("비밀번호 형식이 올바르지 않습니다.");
    			  $("userPwd").focus();
    			  return false;
    		  }
    		 		  
    		  if(userPwd !=chkPwd){
    			  alert("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
    			  $("userPwd").focus();
    			  return false;
    		  }
    		 
    	  }
    	  
    	  function idCheck(){
    		  
    		  var inputId = $("#userId");
    		  		  
    		  $.ajax({
    			  url : "${contextPath}/idCheck.me",
    			  data : {
    				  inputId : inputId.val()
    				  
    			  },
    			  success : function(result){
    				  
    				  if(result=='NNNNN'){
    					  alert("이미 존재하는 아이디입니다.")	  
    				  }else if(result=='NNNNY'){
    					  if(confirm("사용가능합니다. 정말 사용하시겠습니까?")) {
    						  
    						  $("#enroll").removeAttr("disabled");
    						  inputId.attr("readonly",true);
    						   						    
    					  }else{
    						  inputId.focus();
    					  }
    				  }
    				  
    			  },
    			  error : function(){
    				  console.log("통신 실패")
    			  }
    			   			  
    		  });
    		  
    	  }
    	  function again(){
    		  
    		  var inputId = $("#userId");
    		  
    		  inputId.removeAttr("readonly");
   		    		  
    	  }
    	
    	</script>
    
	

	

</body>
</html>