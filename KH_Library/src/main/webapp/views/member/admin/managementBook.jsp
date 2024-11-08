<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#management-book-area {
	overflow-x: auto;
	white-space: nowrap;
}
.insert-span>input{
	outline : none;
}
thead td>select, thead td>input {
	width: 100%;
}

#m-search-wrap{
	float : right;
}
#management-book-search{
	height: 30px;
	width: 1050px;
	margin: 0 auto;
}
#management-book-table {
	border : 2px solid black;
	margin: 0 auto;
	width: 1050px;
	table-layout: fixed;
	white-space: nowrap;
}
#management-book-table td {
	padding: 0 5px;
	white-space: nowrap;
	overflow: hidden;
	text-overflow: ellipsis;
}
#management-book-table th, 
#management-book-table td {
	border : 1px solid black;
	text-align: center;
}
</style>
</head>
<body>
	<div id="management-book-area">
		<form action="">
			<div id=management-book-search>
				<button id="m-b-search-btn" title="상태값이 N인 모든 도서">모두 삭제</button>
				<button id="m-b-search-btn" title="선택한 도서중 상태값이 N인 도서">선택 삭제</button>
				<div id="m-search-wrap">
					<select name="management-search-category" id="management-search-category">
						<option value="BOOK_ID">도서번호</option>
						<option value="BOOK_TITLE">제목</option>
						<option value="BOOK_AUTHOR">저자</option>
						<option value="PUBLISH_DATE">출판년도</option>
						<option value="ENROLL_DATE">등록일</option>
						<option value="AGE_RANK">연령등급</option>
						<option value="STATUS">상태</option>
					</select> 
					<span class="insert-span">
						<input type="text" name="management-search-keyword">
					</span>
					<button type="button" id="m-b-search-btn" onclick="mbSearch();">검색</button>
					<button type="button" id="m-b-statusChange" title="상태가 Y,N인 경우만 가능">상태전환(Y/N)</button>
				</div>
				<script>
					$(function(){
						$("select[name=management-search-category]").change(function(){
							var category = $(this).val();
							
							$(".insert-span").empty();
							
							if(category=="ENROLL_DATE"){
								var enroll = $("<input>").attr("name","management-search-keyword").attr("type","date");
								$(".insert-span").append(enroll);
							}else if(category=="AGE_RANK"){
								var age = $("<select>").attr("name","management-search-keyword");
								age.append($("<option>").val("A").text("A(전연령)"));
								age.append($("<option>").val("T").text("T(청소년)"));
								age.append($("<option>").val("R").text("R(성인)"));
								$(".insert-span").append(age);
							}else if(category=="STATUS"){
								var status = $("<select>").attr("name","management-search-keyword");
								status.append($("<option>").val("Y").text("Y(대출가능)"));
								status.append($("<option>").val("N").text("N(이용불가)"));
								status.append($("<option>").val("B").text("B(대출중)"));
								status.append($("<option>").val("R").text("R(예약중)"));
								$(".insert-span").append(status);
							}else{
								var input = $("<input>").attr("name","management-search-keyword").attr("type","text");
								$(".insert-span").append(input);
							}
						});
					});
				</script>
			</div>
			<table id="management-book-table">
				<colgroup>
					<col style="width: 40px;">
					<col style="width: 100px;">
					<col style="width: 400px;">
					<col style="width: 140px;">
					<col style="width: 100px;">
					<col style="width: 120px;">
					<col style="width: 100px;">
					<col style="width: 50px;">
				</colgroup>
				<thead>
					<tr>
						<th><input type="checkbox" name="m-b-checkBox" id="m-b-checkAll"></th>
						<th>도서번호</th>
						<th>제목</th>
						<th>저자</th>
						<th>출판년도</th>
						<th>등록일</th>
						<th>연령등급</th>
						<th>상태</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="b">
						<tr>
							<td><input type="checkbox" name="m-b-checkbox"></td>
							<td class="m-bid"><a>${b.bookId }</a></td>
							<td><a>${b.bookTitle }</a></td>
							<td><a>${b.bookAuthor }</a></td>
							<td><a>${b.publishDate }</a></td>
							<td><a>${b.enrollDate }</a></td>
							<td><a>${b.ageRank }</a></td>
							<td><a>${b.status }</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</form>
		<script>
			$(function(){
				//전체선택 눌렀을시
				$("#m-b-checkAll").click(function(){
					if($("#m-b-checkAll").prop("checked")){
						$("input[name=m-b-checkbox]").prop("checked",true);
					}else{
						$("input[name=m-b-checkbox]").prop("checked",false);
					}
				});
				//전체 선택후 하나 해제했을때 전체선택 풀리게
				$("#management-book-table").on("change","input[name=m-b-checkbox]",function(){
					if($(this).prop("checked")==false){
						$("#m-b-checkAll").prop("checked",false);
					}
				});
				
				//상태전환 눌렀을시
				$("#m-b-statusChange").click(function(){
					$("input[name=m-b-checkbox]:checked").each(function(){
						var bookId = $(this).parents("tr").find(".m-bid").text();
						$.ajax({
							url : "deleteBook.ma"
							
						});
					});
				});
			})
		</script>
		<script>
			function mbSearch(){
				var category = $("select[name=management-search-category]").val();
				var input = $(".insert-span").children().val();
				
				if(category == 'ENROLL_DATE'){
					var regex = /^\d{2}\/(0[1-9]|1[0-2])\/(0[1-9]|[12][0-9]|3[01])$/;
					input = input.substr(2);
					input = input.replace(/-/g, '/');
				}else{
	            	var regex = /^[a-zA-Z0-9가-힣]+$/;
				}
				
	            if (regex.test(input)) {
	            	
	            	$.ajax({
	            		url : "searchBook.ma",
	            		data : {
	            			category : $("select[name=management-search-category]").val(),
	            			keyword : input
	            		},
	            		success : function(list){
	            			$("#management-book-table tbody").empty();
	            			if(list==""){
	            				var tr = $("<tr>");
	            				tr.append($("<td>").attr("colspan","8").append($("<a>").text("해당되는 도서가 없습니다.")));
	            				$("#management-book-table tbody").append(tr);
	            			}else{
		            			for(var b of list){
		            				var enroll = b.enrollDate;
		            				var str = enroll.substr(-4);
		            				enroll = enroll.replace(/월 /g,'-');
		            				enroll = enroll.replace(/, /g,'-');
		            				enroll = enroll.slice(0,-5);
		            				str = str+"-"+enroll;
		            				
		            				var tr = $("<tr>");
		            				tr.append($("<td>").append($("<input>").attr("type","checkbox").attr("name","m-b-checkbox")));
		            				tr.append($("<td>").append($("<a>").text(b.bookId)));
		            				tr.append($("<td>").append($("<a>").text(b.bookTitle)));
		            				tr.append($("<td>").append($("<a>").text(b.bookAuthor)));
		            				tr.append($("<td>").append($("<a>").text(b.publishDate)));
		            				tr.append($("<td>").append($("<a>").text(str)));
		            				tr.append($("<td>").append($("<a>").text(b.ageRank)));
		            				tr.append($("<td>").append($("<a>").text(b.status)));
		            				$("#management-book-table tbody").append(tr);
		            			}
	            			}
	            		},
	            		error : function(){
	            			console.log("error:ajax");
	            		}
	            	});
	            	
	            }
			}
		</script>
	</div>
</body>
</html>
