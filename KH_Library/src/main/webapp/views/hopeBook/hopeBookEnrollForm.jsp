<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">

<style>

	#content-area table{
		border : 1px solid;
	}
	#content-area textarea{
		width: 100%;
		box-sizing: border-box;
	}
</style>

</head>
<body>
	<%@include file="/views/common/menubar.jsp"%>
	<div class="center-img">
		<img src="https://www.wallpaperuse.com/wallp/84-842169_m.jpg">
	</div>
	<div id="body-wrap">
		<%@include file="/views/common/sideMenu.jsp"%>

		<div id="content-area"align="center">
			<h2>도서 신청</h2>
			<br><br>
			<form action="/insert.ho" method="post">
				<input type="hidden" name="hopeUser" value="${loginUser.userNo }">
				
				<table class="table table-bordered" style="width: 70%;" align="center">
					<tr>
						<th>희망 도서</th>
						<td>
							<input class="form-control" type="text" name="hopeTitle">
						</td>
					</tr>
					<tr>
						<th>도서 저자</th>
						<td>
							<input class="form-control" type="text" name="hopeAutor">
						</td>
					</tr>
					<tr>
						<th>신청 이유</th>
						<td align="right">
							<select name="hopePublic">
								<option value="Y">공개</option>
								<option value="N">비공개</option>
							</select>
						</td>
					</tr> 
					<tr>
						<td colspan="2">
							<textarea class="form-control" name="hopeContent" rows="10" style="resize: none" required></textarea>
						</td>
					</tr>
				</table>
				<button type="submit">신청하기</button>
				<input type="reset" value="취소">
			</form>
		</div>

	</div>
	<%@include file="/views/common/footer.jsp"%>
</body>
</html>