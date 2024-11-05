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
        <h1>회원가입</h1 align="center">


            <div class="enroll-area">
            <br>    
            <form action="${contextPath}/insert.me" id="enroll_form" method="post">
            
                <table width="780px" height="480px">
                    <tr>
                        <td width="120px">* 아이디</td>
                        <td width="170px"><input type="text" id="userId" name="userId" required> </td>
                        <td width="70px"><button type="button"> 중복확인</button></td>
                        <td><span><small> ※ '영소문자', '숫자' 로 이루어진 6~12자 이내 </small></span></td> 
                    </tr>
                    <tr>
                        <td>* 비밀번호</td>
                        <td><input type="password" id="userPwd" name="userPwd" required></td>
                        <td colspan="2"><span><small> ※ 8~20자리의 영문,숫자,특수문자를 3가지를 모두 포함하여 입력 </small></span></td>
                    </tr>
                    <tr>
                        <td>* 비밀번호 확인</td>
                        <td><input type="password" required></td>
                    </tr>
                    <tr>
                        <td>*이름</td>    
                        <td><input type="text" id="userName" name="userName" required></td>
                    </tr>
                    <tr>
                        <td>*생년월일</td>
                        <td><input type="text" name="userNno" placeholder="주민번호 앞 6자리 입력" required></td>
                        
                    </tr>
                    <tr>
                        <td>&nbsp;&nbsp;전화번호</td>
                        <td><input type="text" name="phone" placeholder="-포함해서 입력" > </td>
                    </tr>
                    <tr>
                        <td>&nbsp;&nbsp;이메일</td>
                        <td><input type="email" name="email" ></td>
                    </tr>
                    <tr>
                        <td>&nbsp;&nbsp;주소</td>
                        <td><input type="text" name="address"  > </td>
                    </tr>
                </table>
                <br><br>

                <div align="center">
                    <button type="submit">회원가입</button>
                    <button>초기화</button>
                </div>

            </form>
        </div>  

    </div>
	

	

</body>
</html>