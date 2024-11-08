<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KH Library</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<style>
	.member{
		text-align: right;
	}
	.member-list {
		width: 100%;
		table-layout : fixed;
		white-space: nowrap;
	}
	.member-list th,td{
		font-size: 13px;
		border: 1px solid black;
		table-layout : fixed;
		white-space: nowrap;
		overflow: hidden;
		text-overflow: ellipsis;
	}
	.member-list>tbody>tr>td,th{
		text-align: center;
	}
</style>
<body>

	<div class="member">
		<div class="member-controller">
			<select name="user" id="user">
				<option value="userId">아이디</option>
				<option value="userName">이름</option>
			</select>
			<input type="text" id="search">
			<button id="sbtn">조회</button>
			<button id="yn" onclick="yn();">상태값(Y/N)</button>
		</div>
		<br>
		<table class="member-list">
			<thead>
				<tr>
					<th style="width:5%"><input type="checkbox" name="all" id="all"></th>
					<th style="width:5%">회원번호</th>
					<th style="width:10%">회원아이디</th>
					<th style="width:10%">회원비밀번호</th>
					<th style="width:5%">회원명</th>
					<th style="width:5%">생년월일</th>
					<th style="width:10%">전화번호</th>
					<th style="width:10%">이메일</th>
					<th style="width:10%">주소</th>
					<th style="width:8%">회원가입일</th>
					<th style="width:8%">정보수정일</th>
					<th style="width:9%">최대대출권수</th>
					<th style="width:5%">상태값</th>
				</tr>
			</thead>
			<c:choose>
				<c:when test="${empty list}">
					<tr>
						<td  align="center" colspan="13"> 검색 결과가 존재하지 않습니다.</td> 
					</tr>
				</c:when>
				<c:otherwise>
					<tbody>
							
					</tbody>
				</c:otherwise>
			</c:choose>
		</table>
	</div>
	<script>
		$(function() {
			$("input[name=all]").click(function(){
				if($(this).prop("checked")==true){
					$("input[name=one]").prop("checked",true);
				}else{
					$("input[name=one]").prop("checked",false);
				}
			})
			
			
			/*
			$(".member-list").on("click","input[name=one]",function(){
				console.log($(this).parents("tr").find("th"));
				console.log($(this).parents("tr").find("#st").text());
			});
			*/
		});
		
		$("#sbtn").click(function(){
			
			var category = $("select[name=user]").val();
			var search = $("#search").val();
			console.log(category);
			console.log(search);
			
			$.ajax({
				url : "find.me",
				data : {
					category : category
				},
				success : function(find){
					
				},
				error : function(){
					
				}
			});
		});
	</script>
	<script>
		$(function(){
			updatelist();
		});
		
		
		function updatelist(){
			
			$.ajax({
				url : "mlist.me",
				success : function(list){
					var tr = "";
					
					for(var m of list){
						tr += "<tr>"
							+"<td><input type='checkbox' id='one' name='one'></td>"
							+"<th>"+m.userNo+"</th>"
							+"<td>"+m.userId+"</td>"
							+"<td>"+m.userPwd+"</td>"
							+"<td>"+m.userName+"</td>"
							+"<td>"+m.userNno+"</td>"
							+"<td>"+m.phone+"</td>"
							+"<td style='font-size: 10px'>"+m.email+"</td>"
							+"<td style='font-size: 10px'>"+m.address+"</td>"
							+"<td>"+m.enrollDate+"</td>"
							+"<td>"+m.modifyDate+"</td>"
							+"<td>"+m.rentLimit+"</td>"
							+"<td id='st'>"+m.status+"</td>"
					}
					$(".member-list tbody").html(tr);
				},
			 error : function(){
				console.log("fail");
			 }
				
			});
		}
		
		
		function yn(){
			$("input[name=one]").each(function(){
				if($(this).prop("checked")== true){
					var userno = $(this).parents("tr").find("th").text();
					var st = $(this).parents("tr").find("#st").text();
					
						$.ajax({
							url : "delete.me",
							type : "post",
							data : {
								userNo : userno,
								status : st
							},
							success : function(yn){
	
								if(yn=='o'){
									alert("변경완료");
								}else{
									alert("변경실패")
								}
								updatelist();
							},
							error : function(){
								
							}
							});
				}else{
					return false;
				}
			});
		}
	</script>

</body>
</html>