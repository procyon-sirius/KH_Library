<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<!-- Popper JS -->
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<style>
#content-area>div {
	box-sizing: border-box;
}

#category-list {
	height: 50px;
}

#detail-list {
	height: 60px;
}

/*----------------*/
#category-list>div {
	height: 100%;
	float: left;
	border-bottom: 2px solid black;
}

#category-area {
	width: 80%;
}

#cbtn-area {
	width: 20%;
	padding-top: 5px;
	padding-right: 5px;
}

#cbtn-area>button {
	float: right;
}
/*----------------*/
#detail-list {
	border-bottom: 2px solid black;
}

#detail-list>div>select {
	float: right;
}

#detail-list>div {
	height: 100%;
	float: left;
}

#age-rank {
	width: 70%;
	padding-top: 17px;
}

#order-area {
	width: 30%;
	padding-top: 10px;
	right: 0;
}

#category-list {
	font-weight: bold;
	margin: 0px;
	padding: 0px;
	list-style-type: none;
}

#category, #order, #ud {
	vertical-align: middle;
	height: 40px;
	width: 100px;
	font-size: 15px;
	border-radius: 10px;
}

#search, #rentBtn {
	height: 30px;
	width: 50px;
	font-size: 15px;
}

#detail-list {
	list-style-type: none;
}

.book-list #title:hover {
	text-decoration: underline;
	cursor: pointer;
}

.book-list #book-img:hover {
	cursor: pointer;
}

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

.search-table-btn {
	width: 80%;
	margin: 5px auto;
}

.pagingbar button {
	padding: 0 8px;
	border-radius: 30px;
	background-color: white;
	border: 2px solid rgb(160, 160, 160);
	color: rgb(160, 160, 160);
}

.pagingbar button:hover {
	border: 2px solid black;
	color: black;
}

#pagingbar-select {
	border: 2px solid black;
	color: black;
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
		<div id="content-area">

			<h2 align="center">카테고리 검색</h2>
			<br>
			<br>

			<div class="list-area">
				<form id="category-search-form"
					action="${contextPath }/changeCategory.bk">
					<div id="category-list">
						<div id="category-area">
							카테고리 : <select name="categoryNo" id="category">
								<option value="0">전체</option>
								<c:forEach items="${bci }" var="c">
									<option value="${c.categoryNo }">${c.categoryName }</option>
								</c:forEach>
							</select>
						</div>
						<c:if test="${cno ne ''}">
							<script>
								$("select[name=categoryNo]").val("${cno}")
										.prop("selected", true);
							</script>
						</c:if>
						<div id="cbtn-area">
							<button type="button" id="search">조회</button>
							<script>
								$("#search")
										.click(
												function() {
													$("#category-search-form")
															.find(
																	"input[name=currentPage]")
															.val(1);
													$("#category-search-form")
															.submit();
												});
							</script>
						</div>
					</div>

					<div id="detail-list">
						<div id="age-rank">
							<input type="radio" name="age" value="IN('A','T','R')"><label for="IN('A','T','R')">전체도서</label> &nbsp; 
							<input type="radio" name="age" value="T"><label for="T">청소년도서</label> &nbsp; 
							<input type="radio" name="age" value="A"><label for="A">어린이도서</label> &nbsp;
						</div>
						<div id="order-area">
							<select name="order" id="order">
								<option value="BOOK_TITLE">도서이름</option>
								<option value="BOOK_AUTHOR">작가이름</option>
								<option value="PUBLISH_DATE">발행연도</option>
								<option value="ENROLL_DATE">등록일</option>
							</select> &nbsp; 
							<select name="ud" id="ud">
								<option value="desc">내림차순</option>
								<option value="asc">오름차순</option>
							</select>

						</div>
					</div>
					<input type="hidden" name="currentPage" value="${pi.currentPage }">
					<!--  
					<input type="hidden" name="categoryNo" value="${c.categoryNO }">
					<input type="hidden" name="age" value="${age }">
					<input type="hidden" name="order" value="${order }">
					<input type="hidden" name="ud" value="${ud }">
					-->
				</form>
				<c:choose>
					<c:when test="${cno ne ''}">
						<script>
							$("input[name=age][value=${age}]").prop("checked",
									true);
							$("select[name=ud]").val("${ud}").prop("selected",
									true);
							$("select[name=order]").val("${order}").prop(
									"selected", true);
						</script>
					</c:when>
					<c:otherwise>
						<script>
							$("input[name=age][value=Z]").prop("checked", true);
							//console.log($("input[name=age]"))
						</script>
					</c:otherwise>
				</c:choose>
			</div>
			<br>
			<br>
			<div class="book-list">
				<c:choose>
					<c:when test="${empty list}">
		                      검색 결과가 존재하지 않습니다.
		                </c:when>
					<c:otherwise>
						<c:forEach var="b" items="${list}">
							<div class="search-result-block">
								<div>
									<input type="hidden" name="bookId" value="${b.bookId }">
									<table>
										<tr>
											<td rowspan="5" style="width: 160px" id="book-img"><img
												name="book-img"
												src="${contextPath }/resources/img/${b.bookId}.gif"></td>
										</tr>
										<tr>
											<td class="search-book-title" id="title">${b.bookTitle}</td>
											<td class="search-table-right" rowspan="5">${b.status}</td>
											<td class="search-table-right" rowspan="5">
												<button type="button"
													class="btn btn-primary search-table-btn">대출</button> <br>
												<button type="button"
													class="btn btn-secondary search-table-btn">예약</button>
											</td>
										</tr>
										<tr>
											<td>${b.bookAuthor}</td>
										</tr>
										<tr>
											<td>${b.publisher}</td>
										</tr>
										<tr>
											<td>${b.publishDate}| ${b.enrollDate}</td>
										</tr>
									</table>
								</div>
							</div>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</div>

			<script>
				$(".book-list #book-img").click(
						function() {
							//console.log($(this).parent().parent().parent().parent().find("input[type=hidden]").val());
							var bookId = $(this)
									.closest(".search-result-block").find(
											"input[name=bookId]").val();

							location.href = '${contextPath}/detail.bk?bookId='
									+ bookId;

						});

				$(".book-list #title").click(
						function() {

							var bookId = $(this)
									.closest(".search-result-block").find(
											"input[name=bookId]").val();

							location.href = '${contextPath}/detail.bk?bookId='
									+ bookId;

						});
			</script>

			<br> <br>
			<c:choose>
				<c:when test="${not empty list}">
					<br>
					<div class="pagingbar" align="center">
						<input type="hidden" name="categoryNo" value="${c.categoryNo }">

						<c:if test="${pi.currentPage != 1 }">
							<button onclick="changePage(${pi.currentPage-1});">이전</button>
						</c:if>


						<c:forEach var="i" begin="${pi.startPage }" end="${pi.endPage }">

							<c:choose>
								<c:when test="${i !=pi.currentPage }">
									<button
										onclick="changePage(${i});">${i }</button>
								</c:when>
								<c:when test="${i eq pi.currentPage }">
									<!-- 현재 페이지 버튼 비활성화 -->
									<button id="pagingbar-select">${i}</button>
								</c:when>
							</c:choose>
						</c:forEach>

						<c:if test="${pi.currentPage != pi.maxPage }">
							<button
								onclick="changePage(${pi.currentPage+1})">다음</button>
						</c:if>

					</div>
				</c:when>
			</c:choose>
		</div>
		<script>
			function changePage(i){
				var url = location.href
				var cPageLength = ("${pi.currentPage}").length;
				var temp = url.slice(0,-cPageLength);
				location.href = temp + i;
			};
		</script>
	</div>
	<%@include file="/views/common/footer.jsp"%>
</body>
</html>