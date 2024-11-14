<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

    <title>index</title>
    <style>
        * {
            box-sizing: border-box;
            margin: 0;
            padding: 0;
        }
    </style>

    <!-- 페이지 콘텐츠 영역 -->
    <style>
        /* ===== 사이드 메뉴 ===== */
        #side-menu ul {
            list-style: none;
        }

        #side-menu a {
            text-decoration: none;
            font-size: 14px;
            font-weight: 600;
        }

        .side-title-menu {
            color: black;
        }

        .side-title-menu:hover {
            cursor: pointer;
        }

        #side-navi {
            border-bottom: 1px solid rgb(230, 230, 230);
        }

        #side-navi>li {
            border-top: 1px solid rgb(230, 230, 230);
            padding-top: 15px;
        }

        .side-sub-menu {
            margin-top: 15px;
        }

        .side-sub-menu-li {
            background-color: rgb(245, 245, 250);
            padding: 5px 0;
            display: none;
        }

        .side-sub-menu-li:hover {
            background-color: rgb(238, 238, 245);
            padding: 5px 0;
        }

        .side-sub-menu a:hover {
            color: rgb(0, 0, 170);
            cursor: pointer;
        }

        .menu-click {
            background-color: rgb(232, 232, 240);
        }
    </style>
    <script>
        $(function () {
            $(".side-sub-menu a").click(function () {
                $(".side-sub-menu li").removeClass("menu-click");
                $(this).parent().addClass("menu-click");
            });
            $(".side-title-menu").click(function () {
                $($(this).parent()).siblings().find(".side-sub-menu-li").slideUp();
                $(this).siblings("ul").children().slideToggle();
            });
        });
    </script>
</head>

<body>
        <div id="side-menu-area">
            <div id="side-menu" align="center">
                <ul id="side-navi">
                    <li>
                        <a class="side-title-menu">도서신청</a>
                        <ul class="side-sub-menu">
                            <li class="side-sub-menu-li"><a>도서 신청</a></li>
                            <li class="side-sub-menu-li"><a>도서 신청 현황</a></li>
                        </ul>
                    </li>
                    <li>
                        <a class="side-title-menu">자료 검색</a>
                        <ul class="side-sub-menu">
                            <li class="side-sub-menu-li"><a>통합검색</a></li>
                            <li class="side-sub-menu-li"><a>카테고리 검색</a></li>
                            <li class="side-sub-menu-li"><a>신규 도서</a></li>
                            <li class="side-sub-menu-li"><a>추천 도서</a></li>
                        </ul>
                    </li>
                    <li>
                        <a class="side-title-menu">도서관 안내</a>
                        <ul class="side-sub-menu">
                            <li class="side-sub-menu-li"><a>도서관 소개</a></li>
                            <li class="side-sub-menu-li"><a>오시는 길</a></li>
                        </ul>
                    </li>
                    <li>
                        <a class="side-title-menu">소통공간</a>
                        <ul class="side-sub-menu">
                            <li class="side-sub-menu-li"><a>공지 사항</a></li>
                            <li class="side-sub-menu-li"><a>문의 게시판</a></li>
                            <li class="side-sub-menu-li"><a>한줄평</a></li>
                            <li class="side-sub-menu-li"><a>자유게시판</a></li>
                        </ul>
                    </li>
                    <li>
                        <a class="side-title-menu">나만의 서재</a>
                        <ul class="side-sub-menu">
                            <li class="side-sub-menu-li"><a>내 정보</a></li>
                            <li class="side-sub-menu-li"><a>신청 내역</a></li>
                            <li class="side-sub-menu-li"><a>도서 관리</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
</body>

</html>