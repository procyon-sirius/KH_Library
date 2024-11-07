
<%@page import="com.kh.member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>     
 
 <%
		String contextPath = request.getContextPath();
		
		//로그인 유저 정보 추출하기
		Member loginUser = (Member)session.getAttribute("loginUser");
		
		//loginUser에 담긴 데이터
		//로그인 전 : null
		//로그인 후 : 로그인한 회원정보를 담은 Member객체
		
		//알림메시지 추출하기
		String alertMsg = (String)session.getAttribute("alertMsg");
	%>   
   
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    

    <!--
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
    -->

    <title>index</title>

    <!-- 헤더 영역 -->
    <style>
        * {
            box-sizing: border-box;
            margin: 0;
            padding: 0;
        }

        /* ===== header ===== */
        #header {
            width: 100%;
            height: 140px;
            background-color: white;
            position: fixed;
            z-index : 10;
        }

        #index-title {
            font-size: 32px;
        }

        #header>div {
            height: 70px;
        }

        #header-top {
            border-bottom: 1px solid rgb(238, 238, 238);
        }

        /* 브라우저 width가 800px보다 작을경우 : 고정*/
        #header-top-inner {
            width: 740px;
            height: 100%;
        }

        /* 브라우저 width가 800px보다 클 경우 : 가변크기 지정*/
        @media(min-width:800px) {
            #header-top-inner {
                width: 95%;
            }
        }

        /* 브라우저 width가 1500px보다 클 경우 : 고정*/
        @media(min-width:1500px) {
            #header-top-inner {
                width: 1400px;
            }
        }



        #index-title {
            margin-top: 10px;
        }

        #index-title a {
            color: rgb(0, 0, 0);
            text-decoration: none;
            font-weight: 600;
        }

        #header-top-inner>div {
            display: inline-block;
            vertical-align: bottom;
        }

        #header-top-left {
            width: 270px;
        }

        #header-top-right {
            margin-top: 20px;
            float: right;
        }

        #header-top-right li {
            float: left;
            list-style-type: none;
            width: 90px;
        }

        #header-top-right button {
            width: 70px;
            height: 30px;
            font-size: 14px;
            background-color: white;
            border: 2px solid rgb(160, 160, 160);
            border-radius: 60px;
            transition: all 0.3s;
            color: rgb(160, 160, 160);
        }

        #header-top-right button:hover {
            width: 70px;
            height: 30px;
            color: navy;
            border: 2px solid navy;
            border-radius: 60px;
            cursor: pointer;
            transition: all 0.3s;
        }
		#menu-admin-page-btn{
            color: navy;
		}
        #header-top-search-icon {
            text-decoration: none;
            font-size: 30px;
            color: black;
        }

        /* ===== menubar ===== */
        #menubar {
            width: 100%;
            height: 100%;
        }

        /* 브라우저 width가 800px보다 작을경우 : 고정*/
        #navi {
            width: 740px;
        }
        .submenu-text{
            color: black;
            font-size: 15px;
            font-weight: bold;
        }

        .submenu-text:hover {
            color: rgb(0, 0, 180);
        }
		.menu-title{
            font-size: 18px;
            font-weight: 600;
		}
        /* 브라우저 width가 800px보다 클 경우 : 가변크기 지정*/
        @media(min-width:800px) {
            #navi {
                width: 95%;
            }
        }

        /* 브라우저 width가 1500px보다 클 경우 : 고정*/
        @media(min-width:1500px) {
            #navi {
                width: 1400px;
            }
        }

        #menubar ul {
            list-style-type: none;
            height: 100%;
        }

        #menubar a {
            text-decoration: none;
        }

        .menu-title {
            line-height: 70px;
            color: black;
        }

        #navi>li {
            float: left;
            /*옆으로 나열시키기*/
            width: 20%;
            /*각 li요소 폭 조절 */
            height: 100%;
            text-align: center;
            /*그 영역 안에서 텍스트 가운데 정렬*/
            position: relative;
        }

        #navi>li>a:hover {
            color: rgb(0, 0, 180);
        }

        #background_menu_mask {
            position: fixed;
            border-top: 2px solid rgb(238, 238, 238);
            left: 0;
            width: 100vw;
            height: 300px;
            margin-top: 70px;
            background-color: rgb(255, 255, 255);
            display: none;
        }

        .sub_menu {
        	position : relative;
            display: none;
        }

        .sub_menu>li {
            margin-bottom: 20px;
        }

        

        .sub_menu_mask{
            border-top: 2px solid rgb(238, 238, 238);
            position: absolute;
            width: 100%;
            height: 300px;
            display: none;
        }
        .menu-mouseEnter {
            border-top: 3px solid navy;
            width: 100%;
            height: 300px;
            margin-top: -1px;
            background-color: rgb(230, 230, 230);
        }



        /* 메인페이지 배경 이미지 */

        .center-img {
            /*메인이미지 높이 (세부페이지 기본값)*/
            height: 400px;
            padding-top: 140px;
            white-space: nowrap;
            overflow: hidden;
            white-space: nowrap;
        }

        .index {
            /*메인이미지 높이 (메인페이지 전용)*/
            height: 600px;
        }

        .center-img>img {
            width: 100%;
            height: 100%;
            object-fit: cover;
        }
    </style>


    <!-- 검색 모달창 -->
    <style>
        #search-modal {
            position: fixed;
            width: 300px;
            padding: 15px;
            background-color: white;
            border: 1px solid gray;
            border-radius: 15px;
            top: 60px;
            left: 65%;
            z-index: 15;
            display: none;
        }

        #modal-search-box {
            border: 1px solid lightgray;
            border-radius: 5px;
        }

        #modal-search-box a {
            color: black;
            text-decoration: none;
        }

        #modal-search-box>p {
        }

        #header-top-search-icon:hover {
            cursor: pointer;
        }
        #search-icon{
			float : right;
            font-size: 30px;
        }
		#search-icon:hover{
            cursor: pointer;
		}
        #modal-search-input {
            border: 0;
            width: 200px;
            padding : 4px;
            outline: 0;
        }

        .modal-header p {
            font-size: 14px;
            color: blue;
            margin-bottom: 5px;
        }
    </style>
	<style>
        /* 브라우저 width가 800px보다 작을경우 : 고정*/
        #body-wrap {
            border: 2px solid orange;
            width: 740px;
            height: fit-content;
            margin: 0 auto;
            padding: 100px 0;
            overflow: hidden;
        }

        /* 브라우저 width가 800px보다 클 경우 : 가변크기 지정*/
        @media(min-width:800px) {
            #body-wrap {
                width: 95%;
            }
        }

        /* 브라우저 width가 1500px보다 클 경우 : 고정*/
        @media(min-width:1500px) {
            #body-wrap {
                width: 1400px;
            }
        }

        .center-img {
            /*메인이미지 높이 (세부페이지 기본값)*/
            height: 400px;
            padding-top: 140px;
            white-space: nowrap;
            overflow: hidden;
            white-space: nowrap;
        }

        .index {
            /*메인이미지 높이 (메인페이지 전용)*/
            height: 600px;
        }

        .center-img>img {
            width: 100%;
            height: 100%;
            object-fit: cover;
        }

        #body-wrap>div {
            float: left;
        }

        #side-menu-area {
            width: 200px;
            height: 500px;
            margin-right: 20px;
        }

        #content-area {
            border: 1px solid blue;
            width: calc(100% - 220px);
            height: fit-content;
        }
		
	</style>
    <script>
        $(function () {
            $("#navi>li").hover(function () {
                $("#background_menu_mask").show();
                $(".sub_menu").show();
                $(".sub_menu_mask").show();
                $(this).find(".sub_menu_mask").addClass("menu-mouseEnter");
            }, function () {
                $(".sub_menu_mask").removeClass("menu-mouseEnter");
                $(".sub_menu_mask").hide();
                $(".sub_menu").hide();
                $(this).find(".sub_menu_mask").hide();
                $("#background_menu_mask").hide();
            });
        });
    </script>
</head>

<body>
    <%pageContext.setAttribute("scope","page Scope");%>
	<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
	<script>
		var msg = "${alertMsg}";
		//null이 아닐경우에 alert 띄워주기
		if(msg!=""){
			alert(msg);
			//알림창을 띄우고 메시지 지워주기 (안지우면 메뉴바 뜰때마다 알림창 뜸)
			<%session.removeAttribute("alertMsg");%>
		}
	</script>
    <!-- 모달 검색창 -->
    <div id="search-modal">
        <div class="search-div">
            <div class="modal-content">

                <!-- Modal Header -->
                <div class="modal-header">
                    <p class="modal-title">간편 검색</p>
                </div>

                <!-- Modal body -->
                <div class="modal-body">
                    <div id="modal-search-box">
                    	<form action="list.se" id="modal-search-form">
                        	<input type="hidden" name="search-keyword-category" value="all">
                        	<input type="text" name="search-keyword" placeholder="검색어 입력" id="modal-search-input">
                        	<input type="hidden" name="currentPage" value="1">
                        	<a id="search-icon" class="material-icons" data-toggle="modal" data-target="#myModal">search</a>
                    	</form>
                        
                    	<script>
                    		$(function(){
                    			$("#search-icon").click(function(){
                    				var keyword = $("#modal-search-form").find("input[name=search-keyword]").val();
                    				if(!(keyword=="" || keyword==" ")){
                    					console.log("submit")
                    					$("#modal-search-form").submit();
                    				}
                    			})
                    		})
                    	</script>
                    </div>
                </div>

            </div>
        </div>
    </div>
    <div id="header">
        <div id="header-top" align="center">
            <div id="header-top-inner">
                <div id="header-top-left"></div>
                <div id="index-title" align="center">
                    <a href="${contextPath}">KH Library</a>
                </div>
                <div id="header-top-right">
                    <ul>
                        <li>
                            <p id="header-top-search-icon" class="material-icons">search</p>
                            <script>
                                $(function () {
                                    $("#header-top-search-icon").click(function () {
                                        if ($("#search-modal").css("display") == "none") {
                                            $("#search-modal").css("display", "block");
                                        } else {
                                            $("#search-modal").css("display", "none");
                                        }
                                    });
                                })
                            </script>
                        </li>
                        <li>
                        	<c:choose>
                        		<c:when test="${empty loginUser}">
                       				<button type="button" onclick="loginPage();">로그인</button>
                        		</c:when>
                        		<c:when test="${loginUser.userId eq 'admin'}">
                       				<button type="button" onclick="adminPage();" id="menu-admin-page-btn">관리자</button>	
                        		</c:when>
                        		<c:otherwise>
                        			${loginUser.userName }님 
                        		</c:otherwise>
                       		</c:choose>
                        </li>
                        <li>
                        <c:choose>
                        		<c:when test="${empty loginUser}">
                       				<button type="button" onclick="enrollPage();">회원가입</button>	
                        		</c:when>
                        		<c:otherwise>
                        			<button type="button" onclick="logoutPage();">로그아웃</button>
                        		</c:otherwise>
                       	</c:choose>
                       	</li>
                    </ul>
                    <script>
                    		function adminPage(){
                    			location.href="${contextPath}/admin.me";
                    			//관리자 페이지
                    			
                    		}
                        	function loginPage(){
                        		
                        		location.href="${contextPath}/login.me";

                        	}                       
                        	function enrollPage(){

                        		location.href="${contextPath}/enrollForm.me";

                        	}
                        	function logoutPage(){
                        		
                        		location.href="${contextPath}/logout.me";

                        	}
                    </script> 
                </div>
            </div>
        </div>
        <div id="header-down">
            <div id="menubar" align="center">
                <div id="background_menu_mask"></div>
                <ul id="navi">
                    <li>
                        <a href="${contextPath }/insert.ho" class="menu-title">도서신청</a>
                        <div class="sub_menu_mask">
                            <ul class="sub_menu"><br>
                                <li><a href="${contextPath }/insert.ho"  class="submenu-text">도서 신청</a></li>
                                <li><a href="${contextPath }/select.ho?currentPage=1"  class="submenu-text">도서 신청 현황</a></li>
                            </ul>
                        </div>
                    </li>
                    <li>
                        <a href="${contextPath }/input.se" class="menu-title">자료 검색</a>
<<<<<<< HEAD

                        <div class="sub_menu_mask">
	                        <ul class="sub_menu"><br>
	                            <li><a href="${contextPath }/input.se">통합검색</a></li>
	                            <li><a href="${contextPath }/changeCategory.bk?currentPage=1&categoryNo=-1">카테고리 검색</a></li>
	                            <li><a href="${contextPath }/mnewBook.bk?time=M&currentPage=1">신규 도서</a></li>
	                            <li><a href="${contextPath }/">추천 도서</a></li>
	                        </ul>
	                    </div>

=======
                        <div class="sub_menu_mask">
                            <ul class="sub_menu"><br>
                                <li><a href="${contextPath }/input.se"  class="submenu-text">통합검색</a></li>
                                <li><a href="${contextPath }/changeCategory.bk?currentPage=1&categoryNo=-1"  class="submenu-text">카테고리 검색</a></li>
                                <li><a href="${contextPath }"  class="submenu-text">신규 도서</a></li>
                                <li><a href="${contextPath }"  class="submenu-text">추천 도서</a></li>
                            </ul>
                        </div>
>>>>>>> refs/remotes/origin/main
                    </li>
                    <li>
                        <a href="${contextPath }" class="menu-title">도서관 안내</a>
                        <div class="sub_menu_mask">
                            <ul class="sub_menu"><br>
                                <li><a href="${contextPath }" class="submenu-text">도서관 소개</a></li>
                                <li><a href="${contextPath }" class="submenu-text">오시는 길</a></li>
                            </ul>
                        </div>
                    </li>
                    <li>
                        <a href="${contextPath }" class="menu-title">소통공간</a>
                        <div class="sub_menu_mask">
                            <ul class="sub_menu"><br>
                                <li><a href="${contextPath }/notice"  class="submenu-text">공지 사항</a></li>
                                <li><a href="${contextPath }/qnaBoard"  class="submenu-text">문의 게시판</a></li>
                                <li><a href="${contextPath }/commentBoard"  class="submenu-text">한줄평</a></li>
                                <li><a href="${contextPath }/freeBoard"  class="submenu-text">자유게시판</a></li>
                            </ul>
                        </div>
                    </li>
                    <li>
                        <a href="${contextPath }" class="menu-title">나만의 서재</a>
                        <div class="sub_menu_mask">
                            <ul class="sub_menu"><br>
                            <li><a href="${contextPath}/mypage.me"  class="submenu-text">내 정보</a></li>
                                <li><a href="${contextPath }"  class="submenu-text">신청 내역</a></li>
                                <li><a href="${contextPath }"  class="submenu-text">도서 관리</a></li>
                            </ul>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</body>

</html>