<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<!DOCTYPE html>
	<html>

	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
		<!-- Popper JS -->
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
		<!-- Latest compiled JavaScript -->
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
		<style>
			.search-result-block {
				width: 100%;
				height: 300px;
				border-top: 1px solid lightgray;
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
			}
		</style>
	</head>

	<body>
		<%@include file="/views/common/menubar.jsp" %>
			<div class="center-img">
				<img src="https://www.wallpaperuse.com/wallp/84-842169_m.jpg">
			</div>
			<div id="body-wrap">
				<%@include file="/views/common/sideMenu.jsp" %>
					<div id="content-area">
						<c:choose>
							<c:when test="${empty searchResult}">
								"${keyword}"에 대한 검색 결과가 존재하지 않습니다.
							</c:when>
							<c:otherwise>
								"${keyword}"에 대한 검색 결과입니다. <br><br>
								<c:forEach items="${searchResult}" var="r">
									<div class="search-result-block">
										<div>
											<table>
												<tr>
													<td rowspan="5" style="width:160px">
														<img src="../../resources/img/${r.bookId}.gif">
													</td>
												</tr>
												<tr>
													<td class="search-book-title">${r.bookTitle}</td>
													<td class="search-table-right" rowspan="5">
														${r.status}
													</td>
													<td class="search-table-right" rowspan="5">
														<button type="button" class="btn btn-primary search-table-btn">대출</button> <br>
														<button type="button" class="btn btn-secondary search-table-btn">예약</button>
													</td>
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
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</div>
			</div>
			<%@include file="/views/common/footer.jsp" %>
	</body>

	</html>