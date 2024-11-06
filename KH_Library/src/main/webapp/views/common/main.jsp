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
	}
	
	.index-content-block {
		height: 500px;
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
	#recommend-book-area h2{
		text-align: center;
		margin: 50px 0;
	}
	.recommend-book{
		display : inline-block;
		border : 2px solid lightgray;
		border-radius: 5px;
		padding : 10px;
		margin : 0 10px;
	}
	@media ( min-width :1180px) {
		.recommend-book{
			display : inline-block;
			margin : 0 calc((100% - 1000px) / 10);
		}
	}
	.recommend-cover{
		height: 250px;
		width : 180px;
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
</head>

<body>
	<div id="index-body">
		<div id="index-content-block1" class="index-content-block">
			<div class="index-content-inner">main div1</div>
		</div>
		<div id="index-content-block2" class="index-content-block index-bgc">
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
						$("#recommend-book-area").html("<h2>인기 도서</h2>")
						for(var b of result){
							var book = $("<div>").addClass("recommend-book");
							book.append($("<input>",{
								type : "hidden",
								name : "bookId",
								value : b.bookId
								}));
							book.append($("<img>",{
								src : "${contextPath}/resources/img/"+b.bookId+".gif"
							}).addClass("recommend-cover rec-book-info"));
							book.append($("<div>").addClass("recommend-title rec-book-info").text(b.bookTitle));
							book.append($("<div>").addClass("recommend-author").text(b.bookAuthor));
							$("#recommend-book-area").append(book);
						}
					},
					error : function(){
						console.log("통신오류");
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
		<div id="index-content-block3" class="index-content-block">
			<div class="index-content-inner">main div3</div>
		</div>
		<div id="index-content-block4" class="index-content-block index-bgc">
			<div class="index-content-inner">main div4</div>
		</div>
	</div>
</body>

</html>