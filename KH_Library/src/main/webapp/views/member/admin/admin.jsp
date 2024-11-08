<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>
<style>
	*{
		box-sizing : border-box;
		margin : 0;
		padding : 0;
	}
	#admin-page-area{
		position: relative;
	}
    #admin-page-area>h2{
        text-align: center;
    }
    #admin-btn-area{
    	text-algin: center;
    	white-space : nowrap;
    	overflow : hidden;
    }
    .admin-menu-button{
    	margin : 0 calc(25% / 6);
    	width : 25%;
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
                <h2>관리자 페이지</h2><br>
                <div id="admin-btn-area">
                	<input type="hidden" name="admin-mode" value="default">
                    <button id="admin-fnc1" class="admin-menu-button">도서관리</button>
                    <button id="admin-fnc2" class="admin-menu-button">회원관리</button>
                    <button id="admin-fnc3" class="admin-menu-button">게시판관리</button>
                    <script>
                    	$(".admin-menu-button").click(function() {
							$("input[name=admin-mode]").val($(this).text());
							var mode = $("input[name=admin-mode]").val();
							if(mode == "도서관리"){
								var url = ".bk"
							}else if(mode == "회원관리"){
								var url = ".me"
							}else if(mode == "게시판관리"){
								var url = ".bo"
							}
							location.href = "${contextPath}/management"+url;
						})
                    </script>
                </div>
                <br>
                <div class="admin-content-area">
                    <c:choose>
                        <c:when test="${mode == 'book'}">
                        	<jsp:include page="/views/member/admin/managementBook.jsp"/>
                        </c:when>
                        <c:when test="${mode == 'member'}">
                        	<jsp:include page="/views/member/admin/managementMember.jsp"/>
                        </c:when>
                        <c:when test="${mode == 'board'}">
                        	<jsp:include page="/views/member/admin/managementBoard.jsp"/>
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