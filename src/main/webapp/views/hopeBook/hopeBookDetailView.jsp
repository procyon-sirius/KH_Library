<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">

<style>
	#content-area textarea{
		width: 100%;
		box-sizing: border-box;
	}
	p{
		text-align: right;
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
			<h2>도서 신청 상세</h2>
			<br><br>
			 
			 <c:if test="${h.hopePublic == 'N' && loginUser.userId != 'admin' && h.userId != loginUser.userId }">
				 <script type="text/javascript">
				 	alert("비공개 글입니다.");
				 	history.back();
				 </script>
			 </c:if>
			 
				<input type="hidden" name="hopeNum" value="${h.hopeNum }">
				<table class="table table-bordered" style="width: 70%;" align="center">
					<tr>
						<th>신청인</th>
						<td colspan="2">
							<!-- ${h.userId } -->
							<c:choose>
								<c:when test="${loginUser.userId eq 'admin' }">
									${h.userId }
								</c:when>
								<c:otherwise>
									<script>
								        var userId = "${h.userId}";
								        document.write(userId.substring(0, 3) + "*".repeat(userId.length - 3));
							        </script>
						        </c:otherwise>
							 </c:choose>
						</td>
						
						<td>
							<p>${h.hopeDate }</p>
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
						<td colspan="3">
							<c:choose>
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
						<td colspan="4" height="100px">
							<textarea class="form-control" rows="10" cols="100%" style="resize: none;" readonly>${h.hopeContent }</textarea>
						</td>
					</tr>
					<tr>
						<td colspan="4">
							<c:choose>
								<c:when test="${h.hopeStatus == 'N' }">
									<p>신청중</p>
								</c:when>
								<c:otherwise>
									<c:choose>
										<c:when test="${loginUser != null && loginUser.userId == 'admin' }">
											<p style="color: green">확인완료</p>
										</c:when>
										<c:otherwise>
											<p style="color: green">신청완료</p>
										</c:otherwise>
									</c:choose>
									
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
				</table>
				<br>
			
			<c:if test="${h.hopeStatus eq 'N' && loginUser != null && (loginUser.userId eq 'admin' || loginUser.userNo eq h.hopeUser)}">
				<button class="btn btn-outline-danger" onclick="deleteHope();">신청 취소</button>
			</c:if>
			
			<c:if test="${h.hopeStatus eq 'Y' && loginUser != null && loginUser.userId eq 'admin' }">
				<button class="btn btn-outline-danger" onclick="deleteHope();">신청 삭제</button>
			</c:if>
			
			<c:if test="${h.hopeStatus == 'N' && loginUser != null && loginUser.userId == 'admin' }">
				<button class="btn btn-outline-danger" type="button" onclick="checkHope();">신청 확인</button>
			</c:if>
			<button class="btn btn-outline-primary" onclick="location.href='${contextPath}/select.ho?currentPage=${currentPage}'">목록으로</button>
		</div>
		
		<script>
			function deleteHope(){
				if(confirm("게시물이 삭제됩니다. 복구가 불가능합니다.")){
					$("<form>",{method : "POST",
								action : "${contextPath}/delete.ho"
					}).append($("<input>",{type : "hidden",
										   name : "hopeNum",
										   value : "${h.hopeNum}"
										}),
							  $("<input>", {type: "hidden",
								            name: "currentPage",
								            value: "${currentPage}"
								        })
					).appendTo("body").submit();
				}
			}
			
			function checkHope(){
				if(confirm("확인 완료 처리를 하시겠습니까?")){
					$("<form>",{method : "POST",
								action : "${contextPath}/checkHope.ho"
					}).append($("<input>", {type: "hidden",
							                name: "hopeNum",
							                value: "${h.hopeNum}"
							            }),
							  $("<input>", {type: "hidden",
							                name: "currentPage",
							                value: "${currentPage}"
							            })
		            ).appendTo("body").submit();
				}
			}
		</script>

	</div>
	<%@include file="/views/common/footer.jsp"%>
</body>
</html>