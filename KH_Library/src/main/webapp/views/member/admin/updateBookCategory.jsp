<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
* {
	box-sizing: border-box;
	margin: 0;
	padding: 0;
}

.u-b-c-table-div {
	width: fit-content;
	height: 600px;
	margin: 0 auto;
}

.u-b-c-table-div>table {
	float: left;
}

#update-b-c-table {
	border: 2px solid black;
	width: 500px;
}

#update-b-c-table th, #update-b-c-table td {
	text-align: center;
	border: 1px solid black;
}

#update-b-c-table thead {
	border: 2px solid black;
}

#u-b-c-btn-div {
	height: 30px;
	margin-bottom: 5px;
}

#u-b-c-btn-div button {
	padding: 0 5px;
}

#u-b-c-btn-div2 {
	float: right;
}
#u-b-c-insertRow{
	border-top : 0px;
	width : 100%;
	color : blue;
	font-weight: 600;
	font-size : 18px;
}
.u-b-c-deleteRow{
	border : 0;
	width : 100%;
	background-color : white;
	color : red;
	font-weight: 600;
	font-size : 18px;
}
#u-b-c-btn-div2 button {
	margin-left: 8px;
}
</style>
</head>
<body>
	<div id="update-book-category-area">
		<div class="u-b-c-table-div">
			<div id="u-b-c-btn-div">
				<button id="u-b-c-undo">초기화</button>
				<div id="u-b-c-btn-div2">
					<button id="u-b-c-insert">추가</button>
					<button id="u-b-c-delete">삭제</button>
				</div>
			</div>
			<table id="update-b-c-table">
				<thead>
					<tr>
						<th width="50px"><input type="checkbox" name="delete-b-c-checkAll"></th>
						<th width="225px">카테고리 번호</th>
						<th width="225px">카테고리 이름</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${category}" var="c">
						<tr>
							<c:choose>
								<c:when test="${c.categoryNo == 0}">
									<th></th>
									<th>${c.categoryNo}</th>
									<th>${c.categoryName}</th>
								</c:when>
								<c:otherwise>
									<td><input type="checkbox" name="delete-b-c-checkbox"></td>
									<td class="u-b-c-cno">${c.categoryNo}</td>
									<td>${c.categoryName}</td>
								</c:otherwise>
							</c:choose>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div>
				<button id="u-b-c-insertRow">+</button>
			</div>
			<button id="test">test</button>
			<script>
				$(function(){
					$("#test").click(function(){
						$(".u-b-c-deleteRow").each(function(){
							var cno = $(this).parent().siblings().first().text();
							var cname = $(this).parent().siblings().last().children().val();
							
							console.log(cno);
							console.log(cname);
							
							
						})
					})
					
					
					//추가
					$("#u-b-c-insert").click(function() {
						var count = 0;
						var cnt = 0;
						var length = $(".u-b-c-deleteRow").length;
						$(".u-b-c-deleteRow").each(function(){
							var cno = $(this).parent().siblings().first().text();
							var cname = $(this).parent().siblings().last().children().val();
							console.log(cname);
							if(cname != ""){
								$.ajax({
									url : "${contextPath}/insertBookCategory.ma",
									data : {
										insertCategoryNo : cno,
										insertCategoryName : cname
									},
									type : "post",
									success : function(result){
										if(result==0){
											cnt++;
										}else{
											count++;
										}
									},
									error : function(){
										console.log("error:ajax:insertBookCategory");
										cnt++;
									},
									complete : function(){
										if(count+cnt == length){
											alert(count+"개의 카테고리가 추가되었습니다.");
											location.href="${contextPath}/updateBookCategory.ma";
										}
									}
								})
							}

							
						})
						
					})
					
					//삭제
					$("#u-b-c-delete").click(function() {
						var length = $("input[name=delete-b-c-checkbox]:checked").length;
						if(prompt(length+"개의 카테고리가 선택되었습니다. \n삭제후 되돌릴 수 없습니다. \n삭제하려면 remove를 입력하세요.")=="remove"){

							
							var arr = [];
							$("input[name=delete-b-c-checkbox]:checked").each(function(){
								console.log($(this).parent().siblings().first().text());
								arr.push($(this).parent().siblings().first().text());
							})
							console.log(arr);
							
							
								$.ajax({
									url : "${contextPath}/deleteBookCategory.ma",
									type : "post",
									data : {
										deleteCategoryNo : arr.join(",")
									},
									success : function(result){
										alert(result+"개의 카테고리가 삭제되었습니다.");
									},
									error : function(){
										console.log("error:ajax:insertBookCategory");
									},
									complete : function(){
										location.href="${contextPath}/updateBookCategory.ma";
									}
								})
							
						}else{
							alert("취소되었습니다.");
						}
					})
				});
			</script>

			<script>
				//행추가(+)
				$("#u-b-c-insertRow").click(function() {
					var tr = $("<tr>")
					tr.append($("<td>").append($("<button>").addClass("u-b-c-deleteRow").text("-")));
					var cno = Number($("#update-b-c-table>tbody").find(".u-b-c-cno").last().text());
					cno += 10;
					tr.append($("<td>").addClass("u-b-c-cno").text(cno));
					tr.append($("<td>").append($("<input>").attr({
						type : "text",
						name : "insert-categoryName"
					})));
					$("#update-b-c-table").append(tr);
				})
				
				//행삭제(-)
				$("#update-b-c-table").on("click", ".u-b-c-deleteRow", function() {
					$(this).closest("tr").remove();
				})

				$("#u-b-c-undo").click(function() {
					location.href = "${contextPath}/updateBookCategory.ma";
				})
			</script>
			<script>
				$(function() {
					//전체선택 눌렀을시
					$("input[name=delete-b-c-checkAll]").click(
							function() {
								if ($("input[name=delete-b-c-checkAll]").prop("checked")) {
									$("input[name=delete-b-c-checkbox]").prop("checked", true);
								} else {
									$("input[name=delete-b-c-checkbox]").prop("checked", false);
								}
							});
					//전체 선택후 하나 해제했을때 전체선택 풀리게
					$("#update-b-c-table").on("change","input[name=delete-b-c-checkbox]",function() {
						if ($(this).prop("checked") == false) {
							$("input[name=delete-b-c-checkAll]").prop("checked", false);
						}
					});
				})
			</script>
		</div>
	</div>

</body>
</html>