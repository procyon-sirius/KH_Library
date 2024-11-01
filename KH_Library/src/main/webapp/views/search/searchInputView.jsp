<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    #main-search-area{
        border: 2px solid green;
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
            <div id="main-search-area" align="center">

                <h2>통합검색</h2>
                <form action="">
                    <input type="text">
                    <a id="search-icon" class="material-icons" data-toggle="modal" data-target="#myModal">search</a>
                    
                    <a id="search-icon" class="material-icons" data-toggle="modal" data-target="#myModal">filter_list</a>
                
                    <div id="search-filter-area">
                        <select name="search-select" id="search-select">
                            <option value="all">통합</option>
                            <option value="title">제목</option>
                            <option value="author">저자</option>
                        </select>
                        <br>
                        카테고리
                        <input type="checkbox" name="search-category">1
                        <input type="checkbox" name="search-category">2
                        <input type="checkbox" name="search-category">3
                        <input type="checkbox" name="search-category">4
                        <input type="checkbox" name="search-category">5
                        <input type="checkbox" name="search-category">6
                    </div>
                
                </form>
                
            </div>
        </div>
    </div>
    <%@include file="/views/common/footer.jsp" %>
</body>
</html>