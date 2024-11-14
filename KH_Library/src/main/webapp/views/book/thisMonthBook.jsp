<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<style>
    #content-area{
        position: relative;
    }

    #area{
        margin-left: 200px;
        position: relative;
        display: flex;
        flex-wrap: nowrap;  
    }

    #book-area{
        margin: auto;
        margin-left: 100px;
        position: relative;
        width:350px;
        height: 450px;
        overflow: hidden;
        z-index: 1;
    }

    #book-img{
        position: absolute;
        width: 100%;
        height: 100%;
        object-fit: cover;
        border: 1px solid lightgray;
    }

    #text-area{
        margin: auto;
        margin-right: 150px;
        position: relative;
        width: 400px;
        height: 500px;
        overflow: hidden;
        z-index: 0;
    }

    .book{
        display: inline-block;
    }

    #book-table{
        padding-top: 20px;
        margin-right: 50px;
        position: absolute;
        display: flex;
        align-items: center;
        justify-content: center;
        color: white;
        opacity: 0;

        font-family: 'STUNNING-Bd';
    }
    
    #content-area:hover #book-area{
        animation: ani1 3s 1s forwards;
    }

    #content-area:hover #book-table{
        animation: ani2 3s 1s forwards;
    }

    @keyframes ani1{
        0%{
        }20%{
            scale: 110%;
        }100%{
            scale: 110%;
            transform: translateX(-100px);
            box-shadow: 0px 0px 20px rgb(100, 100, 100);
        }
    }

    @keyframes ani2{
        0%{
        }100%{
            color: black;
            opacity: 1;
            transform: translateX(10px);
        }
    }

    @font-face {
    font-family: 'STUNNING-Bd';
    src: url('https://fastly.jsdelivr.net/gh/projectnoonnu/2410-2@1.0/STUNNING-Bd.woff2') format('woff2');
    font-weight: normal;
    font-style: normal;
    }   

    @font-face {
        font-family: 'Danjo-bold-Regular';
        src: url('https://fastly.jsdelivr.net/gh/projectnoonnu/noonfonts_2307-1@1.1/Danjo-bold-Regular.woff2') format('woff2');
        font-weight: normal;
        font-style: normal;
    }

    #title{
        font-family: 'Danjo-bold-Regular';
        font-size: 40px;
    }

    #dbtn{
        border-radius: 20px;
        width: 100px;
        height: 50px;
    }

    #dbtn:hover{
        background-color: rgb(222, 222, 222);
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
            
        	<h2 align="center" id="title">이달의 책</h2>
        	<br><br>

            <br> 
			<div id="area">
                <div class="book" id="book-area">
                    <img id="book-img" name="book-img" src="${contextPath }/resources/img/${b.imgName}">
    
                </div>            
                <div class="book" id="text-area"> 
                    <table id="book-table">
                        <tr style="font-size: 20px">
                            <th width="50px">제목</th>
                            <td width="350px"> ${b.bookTitle } </td>
                        </tr>
                        <tr style="font-size: 20px">
                            <th width="50px">작가</th>
                            <td width="250px"> ${b.bookAuthor } </td>
                        </tr>
                        <tr>
                            <td>
                                <br>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                ${b.summary }
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">
                            <br> <br>
                                <button id="dbtn" onclick="detail();">자세히보기</button>
                            </td>
                            
                        </tr>
                    </table>          
                </div>
            </div>
            
            <script>
				function detail(){					
					location.href = '${contextPath}/detail.bk?bookId='+ ${b.bookId};
				}
			</script>

			
	            
        </div>
    </div>
    <%@include file="/views/common/footer.jsp" %>
</body>
</html>