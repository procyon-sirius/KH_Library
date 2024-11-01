<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    #book-table{
        text-align: left;
    }

    #rentBtn{
        border-radius: 10px;
        width: 70px;
        height: 30px;
        font-size: 16px;
    }

    #bookImg{
        width :170px;
        height: 250px;
        padding-left: 10px;
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
            
            <h2 align="center">책 상세 내용</h2>
            <br><br>

            <table id="book-table">
                <tr>
                    <td rowspan="8" width="200px" height="300px"><img src="../../resources/img/${b.bookId }.gif" id="bookImg"></td>
                </tr>
                <tr>
                    <th>책 제목 : </th>
                    <td>${b.bookTitle }</td>
                </tr>
                <tr>
                    <th>저자 : </th>
                    <td>${b.bookAuthor }</td>
                </tr>
                <tr>
                    <th>출판사 : </th>
                    <td>${b.publisher }</td>
                </tr>
                <tr>
                    <th>출판일 : </th>
                    <td>${b.publishDate }</td>
                </tr>
                <tr>
                    <th>입고일 : </th>
                    <td>${b.enrollDate }</td>
                </tr>
                <tr>
                    <th>대출/예약 : </th>
                    <td style="padding-left: 10px;">
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
                <tr>
                    <th>도서현황 : </th>
                    <c:choose>
                    	<c:when test="${b.status eq 'Y' }">
		                    <td>대출 가능</td>
                    	</c:when>
                    	<c:when test="${b.status eq 'B' }">
		                    <td>예약 완료</td>
                    	</c:when>
                    	<c:when test="${b.status eq 'R' }">
		                    <td>예약 가능</td>
                    	</c:when>
                    	<c:otherwise>
                    		<td>이용 불가</td>
                    	</c:otherwise>
                    </c:choose>
                </tr>
            </table>
            <br><br>
            <table border="1" id="text-border">
                <tr>
                    <th width="100px">줄거리</th>
                    <td width="500px" height="100px">거북이가 이김</td>
                </tr>
            </table>
            <br><br>
            <div>연령별 대출수 막대그래프 들어갈 곳</div>


            
            
            
            
            
        </div>
    </div>
    <%@include file="/views/common/footer.jsp" %>
</body>
</html>