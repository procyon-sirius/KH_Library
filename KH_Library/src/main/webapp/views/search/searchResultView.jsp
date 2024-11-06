<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<!DOCTYPE html>
	<html>

	<head>
		<meta charset="UTF-8">
		<title>KH Library</title>
		<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
		<!-- Popper JS -->
    	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
		<!-- Latest compiled JavaScript -->
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
		<style>
			.search-result-block {
				width: 100%;
				height: 300px;
				border-bottom: 1px solid lightgray;
			}

			.search-result-block table {
				width: 100%;
				margin-top: 40px;
				font-size: 20px;
				white-space: noWrap;
			}

			.search-book-title {
				white-space: normal;
				min-width: 600px;
				max-width: 600px;
			}

			.search-result-block img {
				width: 150px;
			}

			.search-table-right {
				width: 100px;
				min-width: 100px;
				max-width: 100px;
				text-align: center;
			}
			.search-table-btn{
				width: 80%;
				margin: 5px auto;
				z-index: -1;
			}
			.book-info:hover{
				cursor: pointer;
			}
			.atag{
				text-decoration: none;
				color : black;
			}
			.atag:hover{
				color : black;
				text-decoration: underline;
			}
			.pagingbar button{
				padding : 0 8px;
				border-radius: 30px;
				background-color: white;
				border: 2px solid rgb(160, 160, 160);
				color: rgb(160, 160, 160);
			}
			.pagingbar button:hover{
				border: 2px solid black;
				color: black;
			}
			#pagingbar-select{
				border: 2px solid black;
				color: black;
			}
		</style>
	</head>

	<body>
		<%@include file="/views/common/menubar.jsp" %>
			<div class="center-img">
				<img src="https://www.wallpaperuse.com/wallp/84-842169_m.jpg">
			</div>
			<div id="body-wrap" style="border : 0">
				<%@include file="/views/common/sideMenu.jsp" %>
					<div id="content-area" style="border : 0">
						<%@include file="/views/search/searchBar.jsp"%>
						<c:choose>
							<c:when test="${empty searchResult}">
								<div style="border-bottom:1px solid lightgray;"><br>"${keyword}"에 대한 검색 결과가 존재하지 않습니다.<br><br></div>
							</c:when>
							<c:otherwise>
								<div style="border-bottom:1px solid lightgray;"><br>"${keyword}"에 대한 검색 결과입니다.<br><br></div>
								<c:forEach items="${searchResult}" var="r">
									<form class="book-rent-form" action="" method="post">
										<div class="search-result-block">
											<div>
												<input type="hidden" name="bookId" value="${r.bookId}">
												<input type="hidden" name="userNo" value="${loginUser.userNo}">
												<table>
													<tr>
														<td rowspan="5" style="width:160px">
															<img class="book-img book-info" src="${contextPath }/resources/img/${r.bookId}.gif">
														</td>
													</tr>
													<tr>
														<td class="search-book-title"><a class="book-info atag">${r.bookTitle}</a></td>
														<td class="search-table-right book-status" rowspan="5"></td>
														<td class="search-table-right" rowspan="5">
															<c:if test="${not empty loginUser }">
																<button type="button" class="btn btn-success search-table-btn rent-btn">대출</button> <br>
																<button type="button" class="btn btn-primary search-table-btn reserve-btn">예약</button>
															</c:if>
														</td>
														<script>
															function reserveDisabled(){
																$(".search-table-right").last().find(".reserve-btn").removeClass("btn-primary");
																$(".search-table-right").last().find(".reserve-btn").addClass("btn-secondary");
															}
															function rentDisabled(){
																$(".search-table-right").last().find(".rent-btn").removeClass("btn-success");
																$(".search-table-right").last().find(".rent-btn").addClass("btn-secondary");
															}
														</script>
														<c:choose>
															<c:when test="${r.status eq 'Y'}">
																<script>
																	reserveDisabled();
																	$(".search-result-block").last().find(".book-status").text("대출가능");
																	$(".search-result-block").last().find(".book-status").css("color","green");
																</script>
															</c:when>
															<c:when test="${r.status eq 'B'}">
																<script>
																	rentDisabled();
																	$(".search-result-block").last().find(".book-status").text("예약가능");
																	$(".search-result-block").last().find(".book-status").css("color","skyblue");
																</script>
															</c:when>
															<c:when test="${r.status eq 'R'}">
																<script>
																	reserveDisabled();
																	rentDisabled();
																	$(".search-result-block").last().find(".book-status").text("예약중");
																</script>
															</c:when>
															<c:otherwise>
																<script>
																	reserveDisabled();
																	rentDisabled();
																	$(".search-result-block").last().find(".book-status").text("이용불가");
																	$(".search-result-block").last().find(".book-status").css("color","red");
																</script>
															</c:otherwise>
														</c:choose>
													</tr>
													<tr>
														<td>${r.bookAuthor}</td>
													</tr>
													<tr>
														<td>${r.publisher}</td>
													</tr>
													<tr>
														<td>${r.publishDate} | ${r.enrollDate}</td>
													</tr>
												</table>
											</div>
										</div>
									</form>
								</c:forEach>
							</c:otherwise>
						</c:choose>
						
						<c:choose>
							<c:when test="${not empty searchResult}">
								<br>
								<div class="pagingbar" align="center">
                
					                <c:if test="${pi.currentPage != 1 }">
					                    <button onclick="changePage(${pi.currentPage-1});">이전</button>
					                </c:if>
					                
					                
					                <c:forEach var="i" begin="${pi.startPage }" end="${pi.endPage }">
					                    <c:choose>
					                        <c:when test="${i !=pi.currentPage }">
					                            <button onclick="changePage(${i});">${i}</button>
					                        </c:when>
					                        <c:when test="${i eq pi.currentPage }">
					                            <!-- 현재 페이지 버튼 비활성화 -->
					                            <button id="pagingbar-select">${i}</button>
					                        </c:when>
					                    </c:choose>
					                </c:forEach>
					                
					                <c:if test="${pi.currentPage != pi.maxPage }">
					                    <button onclick="changePage(${pi.currentPage+1})">다음</button>
					                </c:if>
					                
					            </div>
							</c:when>
							<c:otherwise></c:otherwise>
						</c:choose>
					</div>
					<script>
						function changePage(i){
							var url = location.href
							var cPageLength = ("${pi.currentPage}").length;
							var temp = url.slice(0,-cPageLength);
							location.href = temp + i;
						};
						$(function(){
							$(".book-info").click(function(){
								var bookId = $(this).closest(".search-result-block").find("input[name=bookId]").val();
								location.href="${contextPath}/detail.bk?bookId="+bookId;
							});
							$(".rent-btn").click(function(){
								if($(this).closest(".search-result-block").find(".book-status").text()=="대출가능"){
									$(this).closest(".book-rent-form").attr("action","${contextPath}/rent.bk");
									$(this).closest(".book-rent-form").submit();
								};
							});
							$(".reserve-btn").click(function(){
								if($(this).closest(".search-result-block").find(".book-status").text()=="예약가능"){
									$(this).closest(".book-rent-form").attr("action","${contextPath}/reserve.bk");
									$(this).closest(".book-rent-form").submit();
								};
							});
						});
					</script>
			</div>
			<%@include file="/views/common/footer.jsp" %>
	</body>

	</html>