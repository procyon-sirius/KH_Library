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
        width: 80px;
        height: 40px;
        font-size: 20px;
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
                    <td rowspan="8" width="200px" height="300px"><img src="../../resources/img/10/1000.gif" id="bookImg"></td>
                    
                </tr>
                <tr>
                    <th>책 제목 : </th>
                    <td>토끼와 거북이</td>
                </tr>
                <tr>
                    <th>저자 : </th>
                    <td>미상</td>
                </tr>
                <tr>
                    <th>출판사 : </th>
                    <td>어린이출판사</td>
                </tr>
                <tr>
                    <th>출판일 : </th>
                    <td>201010</td>
                </tr>
                <tr>
                    <th>입고일 : </th>
                    <td>2024-10-31</td>
                </tr>
                <tr>
                    <th>대출/예약 : </th>
                    <td style="padding-left: 20px;"><button id="rentBtn">대출</button></td>
                </tr>
                <tr>
                    <th>도서현황 : </th>
                    <td>대출 중</td>
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