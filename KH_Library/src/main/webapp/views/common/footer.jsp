<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    
    
    <style>
        #footer {
            width: 100%;
            height: 200px;
            background-color: rgb(16, 49, 114);
        }
        
        #text{
        	padding-top: 50px;
            color: white;
        }
        
        #top-btn{
        	margin-bottom: 0px;
        	float: right;
        }
        
        #top{
        	width: 45px;
        	height: 45px;
        	font-size : 18px;
        	font-weight: bold;
        	color: rgb(0, 0, 0);
        	background-color: rgb(255, 255, 255);
        	border-radius: 30px;
        	text-decoration: none;
            border: none;
        }
        
        
    </style>
</head>
<body>
    <div id="footer">
   		<div align="center" id="text">
   			KH도서관 03965 서울특별시 영등포구 선유동2로 57 이레빌딩(구관) 19F, 20F 전화번호 : 012-3456-7890 <br> <br>
							Copyright(c) All Rights Reserved
   		</div>
   		
   		<div id="top-btn" align="center">
   			<input type="button" id="top" value="TOP" onClick="javascript:window.scrollTo(0,0)" />
   		</div>

		
    </div>
</body>
</html>