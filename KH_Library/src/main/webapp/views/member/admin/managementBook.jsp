<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#management-book-area{
	}
	#management-book-table{
		width: 100%;
		table-layout : fixed;
		white-space: nowrap;
	}
	#management-book-table td{
		table-layout : fixed;
		white-space: nowrap;
		overflow: hidden;
		text-overflow: ellipsis;
	}
</style>
</head>
<body>
	book
	<div id="management-book-area">
		<form action="">
		<table id="management-book-table" border="1">
			<thead>
				<tr>
					<th colspan="2">
						<select>
							<option value="bookId">도서번호</option>
							<option value="title">제목</option>
							<option value="author">저자</option>
							<option value="publish">출판년도</option>
							<option value="enroll">등록일</option>
							<option value="age">연령등급</option>
							<option value="status">상태</option>
						</select>
					</th>
				</tr>
				<tr>
					<th style="width:5%">선택</th>
					<th style="width:10%">도서번호</th>
					<th style="width:35%">제목</th>
					<th style="width:20%">저자</th>
					<th style="width:10%">출판년도</th>
					<th style="width:10%">등록일</th>
					<th style="width:5%">연령등급</th>
					<th style="width:5%">상태</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><input type="checkbox" name="management-select-book"></td>
					<td><a>tttttttttttttttt</a></td>
					<td><a>eeeeeeeeeeeeeeee</a></td>
					<td><a>ssssssssssssssss</a></td>
					<td><a>tttttttttttttttt</a></td>
					<td><a>tttttttttttttttt</a></td>
					<td><a>tttttttttttttttt</a></td>
				</tr>
			</tbody>
		</table>
		
		</form>
	</div>
</body>
</html>