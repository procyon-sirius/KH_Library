<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KH Library</title>
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
	#content-area{
		text-align: center;
	}
	.select-time{
		border-top: 2px solid black;
		border-bottom: 1px solid gray;
		height: 60px;
		width:100%;
	}
	.select-time td{
		padding-top: 5px;
		padding-left:20px;
	}
	
	#btn{
		display :inline-block;
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
	
	.thumbnail{
		display: inline-block;
		width: 200px;
		height: 300px;
		position: relative;
		margin: 10px;
	}

	.thumbnail>#book-img{
		width: inherit;
		height: inherit;
		object-fit: cover;
	}

	.overlay{
		position: absolute;
		top: 0;
		left: 0;
		width: inherit;
        height: inherit;
        display: flex;
        justify-content: center;
        align-items: center;
        background: rgb(0, 0, 0, 0.5);
        opacity: 0;
        transition: opacity 0.2s;
	}

	.thumbnail:hover .overlay{
		opacity: 1;
		cursor: pointer;
	}

	.book-info{
		color: white;
		font-weight: bold;
		font-size: 17px;
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
           <h2 align="center">신규 도서</h2>
           <br>
           <div class="filter-div">
           	<form action="${contextPath }/newBook.bk?time='+ ${time}+'&currentPage=1" id="day-form">
		           <table class="select-time">
		           		<tr>
		           			<th>간편 검색</th>
		           			<td>
		           				<input type="radio" name="time" value="D"><label for="D">오늘</label> &nbsp;&nbsp; 
								<input type="radio" name="time" value="W"><label for="W">이번주</label> &nbsp;&nbsp;
								<input type="radio" name="time" value="M"><label for="M">이번달</label> &nbsp;&nbsp;
		           			</td>
		           		</tr>
		           </table>
		           <br>
		           <script>
		           		$("input[name=time][value=${time}]").prop("checked",true);
		           </script>
				   
		           <button type="submit" id="btn" class="btn btn-primary search">검색</button>
		           <input type="hidden" name="currentPage" value="${pi.currentPage}">
		           <script>
			           $("#btn").click(function() {
							$("#day-form").find("input[name=currentPage]").val(1);
							$("#day-form").submit();
						});
		           </script>
           	</form>
	       </div>
           	
			<br><br>
			
            <div class="book-list">
            	<c:choose>
	            	<c:when test="${empty list }">
	            		<div align="center">검색 결과가 존재하지 않습니다</div>
	            	</c:when>
	            	<c:otherwise>
			        	<c:forEach items="${list }" var="b">
				 			<div class="thumbnail">
				 				<input type="hidden" value="${b.bookId }" name="bookId">
				 				<input type="hidden" value="${b.bookTitle }" name="bookTitle">
				 				<input type="hidden" value="${b.bookAuthor }" name="bookAuthor">
				 				<img src="${contextPath }/resources/img/${b.imgName}"  id="book-img">
								<div class="overlay">
									<p class="book-info">
										제목 : ${b.bookTitle } <br>
										작가 : ${b.bookAuthor }
									</p>
								</div>
				 			</div>               	
			        	</c:forEach>
	            	</c:otherwise>
            	</c:choose>
           </div>

           <br> <br>
			<c:choose>
				
				<c:when test="${not empty list}">
					<br>
					<div class="pagingbar" align="center">

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
           
        <script>
			function changePage(i){
				var url = location.href
				var cPageLength = ("${pi.currentPage}").length;
				var temp = url.slice(0,-cPageLength);
				location.href = temp + i;
			};			

			$(".thumbnail .overlay").click(function() {

				var bookId = $(this).closest(".thumbnail").find("input[name=bookId]").val();
						
				location.href = '${contextPath}/detail.bk?bookId='+ bookId;
				
			});
		</script>
        </div>
    </div>
    <%@include file="/views/common/footer.jsp" %>
</body>
</html>