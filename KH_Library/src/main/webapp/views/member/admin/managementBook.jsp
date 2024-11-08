<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

thead td>select, thead td>input {
	width: 100%;
}
#management-book-search{
	border : 1px solid green;
	height: 30px;
	width: 1050px;
	margin: 0 auto;
}
#m-search-wrap{
	float : right;
}
.insert-span>input{
	outline : none;
}
#management-book-table {
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

#management-book-table th, #management-book-table td {
	text-align: center;
}
</style>
</head>
<body>
	<div id="management-book-area">
		<form action="">
			<div id=management-book-search>
				<div id="m-search-wrap">
					<select name="management-search-category" id="management-search-category">
						<option value="bookId">도서번호</option>
						<option value="title">제목</option>
						<option value="author">저자</option>
						<option value="publish">출판년도</option>
						<option value="enroll">등록일</option>
						<option value="age">연령등급</option>
						<option value="status">상태</option>
					</select> 
					<span class="insert-span"><input type="text" name="management-search-keyword">
					</span>
					<button id="m-b-search-btn">검색</button>
				</div>
				<script>
					$(function(){
						$("select[name=management-search-category]").change(function(){
							var category = $(this).val();
							
							$(".insert-span").empty();
							
							if(category=="enroll"){
								var enroll = $("<input>").attr("name","management-search-keyword").attr("type","date");
								$(".insert-span").append(enroll);
							}else if(category=="age"){
								var age = $("<select>").attr("name","management-search-keyword");
								age.append($("<option>").val("A").text("A(전연령)"));
								age.append($("<option>").val("T").text("T(청소년)"));
								age.append($("<option>").val("R").text("R(성인)"));
								$(".insert-span").append(age);
							}else if(category=="status"){
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
			<table id="management-book-table" border="1">
				<colgroup>
					<col style="width: 50px;">
					<col style="width: 100px;">
					<col style="width: 400px;">
					<col style="width: 100px;">
					<col style="width: 100px;">
					<col style="width: 150px;">
					<col style="width: 100px;">
					<col style="width: 50px;">
				</colgroup>
				<thead>
					<tr>
						<th>선택</th>
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
					<tr>
						<td><input type="checkbox" name="management-select-book"></td>
						<td><a>1000</a></td>
						<td><a>rkioasdgohaodsfieaijgvisjdoilkfagoisdjogasoogdzjsghbknzxnvdfafje</a></td>
						<td><a>아무개</a></td>
						<td><a>2024</a></td>
						<td><a>2024-11-01</a></td>
						<td><a>A</a></td>
						<td><a>Y</a></td>
					</tr>
				</tbody>
			</table>

		</form>
	</div>
</body>
</html>
