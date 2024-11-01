<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

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

		<div id="content-area" align="center">
			<h2>도서 신청 현황</h2>
			<form action="/insert.ho" method="get">
				<input type="hidden" name="hopeUser" value="1">
				<table border="1">
					<tr>
						<th>신청인</th>
						<td>
							${h.hopeUser }
						</td>
						<td>
							${h.hopeDate }
						</td>
						<td>
							<c:choose >
								<c:when test="${h.hopePublic == 'Y'}">
									<p style="color: green">공개</p>
								</c:when>
								<c:otherwise>
									<p style="color: red">비공개</p>
								</c:otherwise>
							</c:choose>
							
						</td>
					</tr>
					<tr>
						<th>희망 도서</th>
						<td>
							${h.hopeTitle }
						</td>
						<th>도서 저자</th>
						<td>
							${h.hopeAutor }
						</td>
					</tr>
					<tr>
						<th>신청 이유</th>
					</tr> 
					<tr>
						<td colspan="4">
							${h.hopeContent }
						</td>
					</tr>
				</table>
				<br>
				<button id="deleteList">신청 취소</button>
				<button type="submit" value="check">신청 확인</button>
			</form>
		</div>
		
		<script>
			
		</script>

	</div>
	<%@include file="/views/common/footer.jsp"%>
</body>
</html>