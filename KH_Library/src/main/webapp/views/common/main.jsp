<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 전체 -->
<style>
	* {
		box-sizing: border-box;
	}
	
	#index-body {
		width: 100%;
		height: fit-content;
		margin: 0 auto;
		padding: 50px 0;
		overflow: hidden;
		z-index : 0;
	}
	.index-content-block {
		height: 600px;
	}
	
	.index-bgc {
		background-color: rgb(230, 239, 255);
	}
	
	
	/* 브라우저 width가 800px보다 작을경우 : 고정*/
	.index-content-inner {
		width: 740px;
		height: 100%;
		margin: 0 auto;
		white-space : nowrap;
  		overflow: hidden;
	}
	
	
	/* 브라우저 width가 800px보다 클 경우 : 가변크기 지정*/
	@media ( min-width :800px) {
		.index-content-inner {
			width: 95%;
		}
	}
	
	/* 브라우저 width가 1500px보다 클 경우 : 고정*/
	@media ( min-width :1500px) {
		.index-content-inner {
			width: 1400px;
		}
	}
</style>

<!-- 구역1 -->
	<!-- 공지 -->
<style> 
	#index-content-top{
		width: 100%;
		height: 100%;
		white-space: nowrap;
		overflow: hidden;
	}
	#main-notice-area{
		float: left;
		margin-top: 100px;
		width: 850px;
		height: 400px;
		text-align: center;
	}
	.index-top-btn-area{
		height: 50px;
	}
	.index-top-btn-area>h3{
		float: left;
		font-weight: 600;
	}
	.index-top-btn-area>a{
		margin-right: 10px;
		font-size: 25px;
		float: right;
	}
	.index-top-btn-area>a:hover{
		color: navy;
		cursor: pointer;
	}
	#notice-table-area{
		background-color: white;
		border-radius: 15px;
		width: 850px;
		height: 300px;
		text-align: center;
	}
	#main-notice-table{
		border: 1px solid white;
		margin: auto;
		border-radius: 15px;
		width: 800px;
	}
	
	#main-notice-table th,
	#main-notice-table td{
		border-bottom: 1px solid lightgray;
		height: 60px;
	}
	#main-notice-table>tbody a:hover{
		cursor: pointer;
		text-decoration: underline;
	}

</style>
	<!-- 신간 -->
<style>
	@font-face {
		font-family: 'Tenada';
		src: url('https://fastly.jsdelivr.net/gh/projectnoonnu/noonfonts_2210-2@1.0/Tenada.woff2') format('woff2');
		font-weight: normal;
		font-style: normal;
	}	
	#month-newBook-area{
		position: relative;
		display: inline-block;
		margin-top: 100px;
		margin-left: 50px;
		width: 450px;
		height: 400px;
		text-align: center;
	}
	#newBook-table-area{
		border-radius: 15px;
		width: 450px;
		height: 300px;
		text-align: center;
	}
	#new-book{
		width: 200px;
		height: 300px;
		border: 1px solid gray;
		box-shadow: 0px 0px 2px gray;
	}

	#new-text{
		font-size: 25px;
		font-family: 'Tenada';
		padding-left: 250px;
		opacity: 0;
	}

	#month-newBook-area:hover #new-book{
		animation : ani-new1 2s forwards; 
	}

	#month-newBook-area:hover #new-text{
		animation : ani-new2 2s forwards; 
	}

	@keyframes ani-new1{
		0%{
        }100%{
            color: black;
            opacity: 1;
            transform: translateX(-90px);
			box-shadow: 0px 0px 10px darkgray;
        }
	}

	@keyframes ani-new2{
		0%{
        }100%{
            color: black;
            opacity: 1;
            transform: translateY(-160px);
        }
	}


</style>


<!-- 구역2 -->
<style>
	#recommend-book-area h1{
		text-align: center;
		margin: 70px 0;
	}
	.recommend-book{
		display : inline-block;
		border : 2px solid lightgray;
		border-radius: 5px;
		padding : 10px;
		margin : 0 10px;
	}
	@media ( min-width :1280px) {
		.recommend-book{
			display : inline-block;
			margin : 0 calc((100% - 1100px) / 10);
		}
	}
	
	.recommend-book:hover{
		background-color : white;
		box-shadow: 3px 3px 3px darkgray;
	}
	.recommend-cover{
		width : 200px;
		height : 275px;
		border: 1px solid lightgray;
	}
	.recommend-title{
		width : 180px;
		font-size : 16px;
		font-weight: 600;
		white-space: nowrap;
		overflow: hidden;
		text-overflow: ellipsis;
	}
	.recommend-author{
		width : 180px;
		font-size : 12px;
		color : rgb(100, 100, 100);
		white-space: nowrap;
		overflow: hidden;
		text-overflow: ellipsis;
	}
	.rec-book-info:hover{
		cursor: pointer;
		text-decoration: underline;
	}
	.sizeUp{
  		transform: scale(1.08);
		transition-property: all;
		transition-duration: 0.3s;
	}
</style>


<!-- 구역3 -->
<style>

</style>

</head>

<body>
	<div id="index-body">
		<div id="index-content-block1" class="index-content-block  index-bgc">
			<div class="index-content-inner">
				<div id="index-content-top">
					<div id="main-notice-area">
						<div class="index-top-btn-area">
							<h3>도서관 소식</h3>
							<a id="plusNotice">+</a>
						</div>
						<div id="notice-table-area">
							<table id="main-notice-table">
								<colgroup>
									<col width="150px">
									<col width="400px">
									<col width="200px">
								</colgroup>
								<thead>
									<tr>
										<th>공지</th>
										<th>제목</th>
										<th>날짜</th>
									</tr>
								</thead>
								<tbody>
								</tbody>
							</table>
						</div>
					</div>
					<div id="month-newBook-area">
						<div class="index-top-btn-area">
							<h3>신간 도서</h3>
							<a href="${contextPath }/mnewBook.bk?time=M&currentPage=1" style="text-decoration: none; color: black;">+</a>
						</div>
						<div id="newBook-table-area">
							
						</div>
					</div>
				</div>
			</div>
		</div>
		<script>
			$(function(){
				$("#main-notice-table>tbody").on("click", "a", function(){
					var nno = $(this).parents("tr").find("th").text();
					location.href="${contextPath}/detail.no?nno="+nno+"&currentPage=1"
				})
				$("#plusNotice").click(function(){
					location.href="${contextPath}/notice";
				})
			})
		</script>
		<script>
			$(function(){
				$.ajax({
					url : "${contextPath}/main.no",
					success : function(list){
						if(list.length == 0){
							var tr = $("<tr>");
							tr.append($("<td>").attr("colspan","3").text("공지사항이 없습니다."));
							$("#main-notice-table>tbody").append(tr);
						}else{
							for(var n of list){
								var tr = $("<tr>");
								tr.append($("<th>").text(n.noticeNo).append($("<input>").attr("type","hidden").val(n.noticeNo)));
								tr.append($("<td>").append($("<a>").text(n.noticeTitle)));
								tr.append($("<td>").text(n.date));
								$("#main-notice-table>tbody").append(tr);
							}
						}
					},
					error : function(){
						console.log("error:ajax:index-notice")
					}
				})
			});
		</script>
		<script>
			$(function(){
				$.ajax({
					url : "${contextPath}/mainbook.bk",
					success: function(b){
						console.log("success");
						var img = "";
						img = "<img id='new-book' name='new-book' src='${contextPath }/resources/img/"+b.imgName+"'>"
						  	+ "<p id='new-text'>"+b.bookTitle+"</p>"
						  	
						$("#newBook-table-area").html(img);
						
					},
					error: function(){
						console.log("fail");
					}
				});

			});

		</script>

		<div id="index-content-block2" class="index-content-block">
			<div class="index-content-inner">
				<div id="recommend-book-area">
				</div>
			</div>
		</div>
	
		<script>
			$(function(){
				$.ajax({
					url : "${contextPath}/recommend.bk",
					success : function(result){
						$("#recommend-book-area").html("<h1>인기 도서</h1>")
						if(result == null){
							$("#recommend-book-area").append("<div>등록된 도서가 없습니다.</div>")
						}else{
							for(var b of result){
								var book = $("<div>").addClass("recommend-book");
								book.append($("<input>",{
									type : "hidden",
									name : "bookId",
									value : b.bookId
									}));
								book.append($("<img>",{
									src : "${contextPath}/resources/img/"+b.imgName
								}).addClass("recommend-cover rec-book-info"));
								book.append($("<div>").addClass("recommend-title rec-book-info").text(b.bookTitle));
								book.append($("<div>").addClass("recommend-author").text(b.bookAuthor));
								$("#recommend-book-area").append(book);
							}
						}
					},
					error : function(){
						console.log("error:ajax");
					}
				});
				
				
			})
		</script>
		<script>
			$(function(){
				$("#recommend-book-area").on("click",".rec-book-info",function(){
					var bookId = $(this).closest(".recommend-book").find("input[name=bookId]").val();
					location.href = "${contextPath}/detail.bk?bookId="+bookId;
				});

				$("#recommend-book-area").on("mouseenter",".recommend-book", function(){
						$(this).addClass("sizeUp");
				});
				$("#recommend-book-area").on("mouseleave",".recommend-book", function(){
						$(this).removeClass("sizeUp");
				});
			})
		</script>
		<div id="index-content-block3" class="index-content-block  index-bgc">
			<div class="index-content-inner">최신 후기</div>
		</div>
	</div>
</body>

</html>