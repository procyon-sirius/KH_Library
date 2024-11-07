<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>
<style>
    #admin-page-area>h2{
        text-align: center;
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
            <div id="admin-page-area">
                <h2>관리자 페이지</h2>
                <div id="admin-btn-area">
                    <button id="admin-fnc1">도서관리</button>
                    <button id="admin-fnc2">회원관리</button>
                    <button id="admin-fnc3">게시판관리</button>
                </div>
                <div class="admin-content-area">
                    <c:choose>
                        <c:when test="">
    
                        </c:when>
                        <c:when test="">
    
                        </c:when>
                        <c:when test="">
    
                        </c:when>
                        <c:otherwise>
                            
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </div>
    </div>
    <%@include file="/views/common/footer.jsp" %>
</body>
</html>