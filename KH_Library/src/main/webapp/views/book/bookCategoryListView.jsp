<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<!-- Popper JS -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<style>
    #content-area>div{
        box-sizing: border-box;
    }

   


    #category-list{
        height: 50px;
    }

    #detail-list{
        height: 60px;
    }

    /*----------------*/

    #category-list>div{
        height: 100%;
        float: left;
        border-bottom: 2px solid black;
    }

    #category-area{
        width: 80%;
    }

    #cbtn-area{
        width: 20%;
        padding-top: 5px;
        padding-right: 5px;
    }

    #cbtn-area>button{
        float: right;
    }
    /*----------------*/
    #detail-list{
        border-bottom: 2px solid black;
    }

    #detail-list>div>select{
        float: right;
    }
    #detail-list>div{
        height: 100%;
        float: left;
    }
    #age-rank{
        width: 70%;
        padding-top: 17px;
    }

    #order-area{
        width: 30%;
        padding-top: 10px;
        right: 0;
    }

    

    #category-list{

        font-weight: bold;

        margin: 0px;
        padding: 0px;
        list-style-type: none;
    }

    #category,#order, #desc{
        vertical-align: middle;
        height: 40px;
        width: 100px;
        font-size: 15px;
        border-radius: 10px;
    }

    #search, #rentBtn{
        height: 30px;
        width: 50px;
        font-size: 15px;


    }
    #detail-list{
        list-style-type: none;
    }

    .age-rank{
        border: none;
        font-size: 15px;
    }

    .age-rank:hover{
        text-decoration: underline;
    }

    .book-list #title:hover{
        text-decoration: underline;
        cursor: pointer;
    }
    
    .book-list #book-img:hover{
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
            
            <h2 align="center">카테고리 검색</h2>
            <br><br>
	            <div class="list-area">
	                <div id="category-list">
	                    <div id="category-area">
	                        카테고리 : <select name="category" id="category">
				                            	<option value="0" >전체</option>
				                           <c:forEach items="${bci }" var="c">
					                           <option value="${c.categoryNo }">${c.categoryName }</option>
				                           </c:forEach>
				                     </select>
	                    </div>
	                    <div id="cbtn-area">
	                        <button id="search" onclick="changeCategory();">조회</button>
	                    </div>
	                </div>
	             
	                <div id="detail-list">
	                    <div id="age-rank">
	                        <button class="age-rank">전체도서</button> |
	                        <button class="age-rank">일반도서</button> |
	                        <button class="age-rank">청소년도서</button> |
	                        <button class="age-rank">어린이도서</button>
	                    </div>
	                    <div id="order-area">
	                        <select name="order" id="order">
	                            <option value="book-title">도서이름</option>
	                            <option value="book-title">작가이름</option>
	                            <option value="book-title">발행연도</option>
	                            <option value="book-title">등록일</option>
	                        </select>
	                        <select name="desc" id="desc">
	                            <option value="desc">내림차순</option>
	                            <option value="asc">오름차순</option>
	                        </select>
	                    </div>
	                </div>
	            </div>
	            <br><br>
				<div class="book-list">
	            	<c:choose>
		                <c:when test="${empty list}">
		                      검색 결과가 존재하지 않습니다.
		                </c:when>
		                <c:otherwise>
		                    <c:forEach var="b" items="${list}">
		                        <div class="search-result-block">
									<div>
										<input type="hidden" name="bno" value="${b.bookId }">
										<table>
												<tr>
													<td rowspan="5" style="width:160px" id="book-img">
														<img src="../../resources/img/${b.bookId}.gif">
													</td>
												</tr>
												<tr>
													<td class="search-book-title" id="title">${b.bookTitle}</td>
													<td class="search-table-right" rowspan="5">
														${b.status}
													</td>
													<td class="search-table-right" rowspan="5">
														<button type="button" class="btn btn-primary search-table-btn">대출</button> <br>
														<button type="button" class="btn btn-secondary search-table-btn">예약</button>
													</td>
												</tr>
												<tr>
													<td>${b.bookAuthor}</td>
												</tr>
												<tr>
													<td>${b.publisher}</td>
												</tr>
												<tr>
													<td>${b.publishDate} | ${b.enrollDate}</td>
												</tr>
										</table>
									</div>
								</div>
		                    </c:forEach>
		                </c:otherwise>
	            	</c:choose>
				</div>

            <script>
	            $(".book-list #book-img").click(function(){
					//console.log($(this).parent().parent().parent().parent().find("input[type=hidden]").val());
	            	var bno = $(this).closest(".search-result-block").find("input[type=hidden]").val();

	                location.href='${contextPath}/detail.bk?bno='+bno;
	
	            });

                $(".book-list #title").click(function(){

                	var bno = $(this).closest(".search-result-block").find("input[type=hidden]").val();

                    location.href='${contextPath}/detail.bk?bno='+bno;

                });
                
                function changeCategory(){
                	
                	$.ajax({
                		url : "changeCategory.bk",
                		data : {
                			categoryNo : $("#category").val()
                		},
                		success : function(list){
                			
                			console.log("t");
                			$(".book-list").html("");
                			
                		},
                		error : function(){
                			console.log("f");
                		}
                	});
                	
                	
                }
                
               
            </script>
            
            <br> <br>

            <div align="center">
                
                <c:if test="${pi.currentPage != 1 }">
                    <button onclick="location.href='clist.bk?currentPage=${pi.currentPage-1}'">이전</button>
                </c:if>
                
                
                <c:forEach var="i" begin="${pi.startPage }" end="${pi.endPage }">
                
                    <c:choose>
                        <c:when test="${i !=pi.currentPage }">
                            <button onclick="location.href='clist.bk?currentPage=${i}'">${i }</button>
                        </c:when>
                        <c:otherwise>
                            <!-- 현재 페이지 버튼 비활성화 -->
                            <button disabled>${i }</button>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
                
                <c:if test="${pi.currentPage != pi.maxPage }">
                    <button onclick="location.href='clist.bk?currentPage=${pi.currentPage+1}'">다음</button>
                </c:if>
                
            </div>
            
            

          
        </div>
    </div>
    <%@include file="/views/common/footer.jsp" %>
</body>
</html>