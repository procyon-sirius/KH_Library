<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    #content-area>div{
        box-sizing: border-box;
    }

    .list-area{
        margin: auto;
    }

    .list-area>div{
        width: 100%;
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
    }
    
    .book-list-text{
    	width:900;
    	font-size: 20px;
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
                            <option value="all">전체</option>
                            <option value="10">동화</option>
                            <option value="20">문학</option>
                            <option value="30">과학</option>
                            <option value="40">역사</option>
                            <option value="50">경제</option>
                            <option value="60">자기계발</option>
                      </select>
                    </div>
                    <div id="cbtn-area">
                        <button id="search">조회</button>
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

            <table class="book-list">
            	<thead>
            		<tr>
            			<td></td>
            			<td></td>
            			<td></td>
            		</tr>
            	</thead>
            	<tbody>
	            	<c:choose>
		                <c:when test="${empty list}">
		                    <tr>
		                        <td colspan="3" align="center">조회 결과 없음</td>
		                    </tr>
		                </c:when>
		                <c:otherwise>
		                    <c:forEach var="b" items="${list}">
		                        <tr>
		                           <td rowspan="5" width="200"><img width="150px" height="200px" src="../../resources/img/${b.bookId }.gif" id="bookImg"></td>
		                           <td width="900"></td>
		                           <td rowspan="5" width="100"> 
		                               <c:choose>
		                                   <c:when test="${b.status eq 'Y' }">
		                                       <button id="rentBtn">대출</button>
		                                   </c:when>
		                                   <c:when test="${b.status eq 'B' }">
		                                       <button id="rentBtn" disabled>예약</button>
		                                   </c:when>
		                                   <c:when test="${b.status eq 'R' }">
		                                       <button id="rentBtn">예약</button>
		                                   </c:when>
		                                   <c:otherwise>
		                                       <button id="rentBtn">점검중</button>
		                                   </c:otherwise>
		                               </c:choose>
		                           </td>
		                        </tr>
		                        <tr style="font-size: 20px; text-align: left;" id="title">
		                            <th>${b.bookTitle}</th>
		                        </tr>
		                        <tr class="book-list-text">
		                            <td>${b.bookAuthor }</td>
		                        </tr>
		                        <tr class="book-list-text">
		                            <td>${b.publisher }</td>
		                        </tr>
		                        <tr class="book-list-text">
		                            <td>${b.publishDate } | ${b.enrollDate } </td>
		                        </tr>
		                        <tr class="book-list-text">
		                            <td></td>
		                        </tr>
		                    </c:forEach>
		                </c:otherwise>
	            	</c:choose>
            	</tbody>
            </table>

            <script>
                $(".book-list>tr>#bookImg").click(function(){

                    var bno = $(this);

                    location.href='/library/detail.bk?bno='+bno;

                });

                $(".book-list>#title").click(function(){

                    var bno = $(this).text();

                    location.href='/library/detail.bk?bno='+bno;

                });
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