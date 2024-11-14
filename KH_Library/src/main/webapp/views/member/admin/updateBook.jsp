<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 정보 수정</title>
<style>
	#book-insert-table{
		width : 800px;
		margin : 0 auto;
	}
	
	#book-insert-table th{
		width: 350px;
		height: 400px;
	}
	#insert-book-img{
		width: 100%;
	}
	#book-insert-table td>input,
	#book-insert-table td>select,
	#book-insert-table td>textarea{
		width: 99%;
		outline : none;
		border : 0;
		margin-left : 1px;
	}
	#book-insert-table td>textarea{
		height : 300px;
	}
	#insertBook-area{
		margin: 0 auto;
		text-align: center;
		width : fit-content;
		height : fit-content;
	}
	#insert-book-btn-area button{
		margin: 10px 0;
		margin-left : 10px;
		padding: 0 10px;
		float : right;
	}
</style>
</head>
<body>
	<div id="insertBook-area">
		<h2>도서 정보 수정</h2>
	<form action="updateBook.ma" method="post" enctype="multipart/form-data">
		<input type="hidden" name="bookId" value="${book.bookId}">
		<input type="hidden" name="imgName" value="${book.imgName}">
		<table id="book-insert-table" border="1">
			<tr>
				<th rowspan="7" id="preview-book-thumbnale">
					<img alt="책 표지" id="insert-book-img" src="${contextPath}/resources/img/${book.imgName}">
				</th>
				<td style="width : 100px">
					제목
				</td>
				<td>
					<input type="text" name="title" value="${book.bookTitle }" required>
				</td>
			</tr>
			<tr>
				<td>
					저자
				</td>
				<td>
					<input type="text" name="author" value="${book.bookAuthor}" required>
				</td>
			</tr>
			<tr>
				<td>
					출판사
				</td>
				<td>
					<input type="text" name="publisher" value="${book.publisher}" required>
				</td>
			</tr>
			<tr>
				<td>
					출판년도
				</td>
				<td>
					<input type="text" accept="image/*" name="publishDate" placeholder="년도 4자리" value="${book.publishDate}" required>
				</td>
			</tr>
			<tr>
				<td>
					연령등급
				</td>
				<td>
					<select name="age">
						<option value="A">A(전연령)</option>
						<option value="T">T(청소년)</option>
						<option value="R">R(성인)</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>
					카테고리
				</td>
				<td style="white-space : normal;">
					<c:forEach items="${category}" var="c">
						<div style="float:left">
							<input type="checkbox" name="book-category" style="margin:0 10px" value="${c.categoryNo}">${c.categoryName}
						</div> 
			        </c:forEach>
				</td>
			</tr>
			<tr>
				<td rowspan="2">
					요약
				</td>
				<td rowspan="2">
					<textarea style="resize:none" name="summary">${book.summary}</textarea>
				</td>
			</tr>
			<tr>
				<td>
					<input type="file" name="upload-book-img" onchange="loadThumbnail(this);">
				</td>
			</tr>
		</table>
		<div id="insert-book-btn-area">
			<button type="submit" onclick="return checkCategory();">수정</button>
			<button type="button" onclick="back();">뒤로</button>
		</div>
	</form>
	<script>
		//저장된 카테고리 불러오기
		$(function(){
			var str = "${bookCategory}";
			var category = str.split(",");
			for(var c of category){
				$("input[name=book-category][value="+c+"]").prop("checked",true);
			}
			$("select[name=age]").val("${book.ageRank}").prop("selected", true);
		})
	</script>
	<script>
		//카테고리 미지정과 다른 카테고리는 동시에 선택될 수 없음
		$(function(){
			$("#book-insert-table").on("click","input[name=book-category]",function(){
				if($(this).val() == 0){
					$(this).parent().siblings().find("input[name=book-category]").prop("checked",false);
				}else{
					$(this).parents("td").find("input[name=book-category]").first().prop("checked",false);
				}
			})
		})
	</script>
	<script>
		//뒤로가기
		function back(){
			location.href="${contextPath}/management.bk"
		}
		//카테고리 한개 이상 체크했는지 확인
		function checkCategory(){
			var count = $("input[name=book-category]:checked").length;
			if(count==0){
				alert("카테고리는 최소 1개가 선택되어야 합니다.")
				return false;
			}
		};
		//책표지 이미지 미리보기 함수
		function loadThumbnail(inputFile){
			if(inputFile.files.length == 1){
				//파일 정보 읽기 전용 객체 생성
				var reader = new FileReader();
				//FileReadr의 readAsDataURl(파일) 메소드로 파일을 읽어 고유 url을 반환
				//등록한 파일정보는 inputFile.files속성의 0번 인덱스에 등록됨
				reader.readAsDataURL(inputFile.files[0]);
				
				//reader객체가 해당 파일 정보를 읽어오는 시점 :onload
				//파일정보에서 result속성에 담긴 url을 읽어옴
				reader.onload = function(e){
					$("#insert-book-img").attr("src",e.target.result);
					
				};
			}else{
				$("#insert-book-img").removeAttr("src");
			}
		}
	</script>
	</div>
</body>
</html>