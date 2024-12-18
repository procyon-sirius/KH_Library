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
			
			<!-- 필터 -->
			<c:if test="${loginUser eq null }">
				<script type="text/javascript">
			        if (confirm("회원만 이용할 수 있습니다. 로그인 페이지로 이동하시겠습니까?")) {
			            location.href = "${contextPath}/login.me";
			        } else {
			            history.back();
			        }
			    </script>
			</c:if>
			
			<br><br>
			<form action="/insert.ho" method="post">
				<input type="hidden" name="hopeUser" value="${loginUser.userNo }">
				
				<table class="table table-bordered" style="width: 70%;" align="center">
					<tr>
						<th>희망 도서</th>
						<td>
							<input class="form-control" type="text" name="hopeTitle" required>
						</td>
					</tr>
					<tr>
						<th>도서 저자</th>
						<td>
							<input class="form-control" type="text" name="hopeAutor" required>
						</td>
					</tr>
					<tr>
						<th>신청 이유</th>
						<td align="right">
							<select  class="custom-select" aria-label="Default select example" style="width: 100px;" name="hopePublic">
								<option value="Y" selected>공개</option>
								<option value="N">비공개</option>
							</select>
						</td>
					</tr> 
					<tr>
						<td colspan="2">
							<textarea class="form-control" name="hopeContent" rows="10" style="resize: none"></textarea>
						</td>
					</tr>
				</table>
				<br>
				<button class="btn btn-outline-primary" type="submit">신청하기</button>
				<button class="btn btn-outline-primary" onclick="history.back();">뒤로가기</button>
			</form>
		</div>

	</div>
	<%@include file="/views/common/footer.jsp"%>
</body>
</html>