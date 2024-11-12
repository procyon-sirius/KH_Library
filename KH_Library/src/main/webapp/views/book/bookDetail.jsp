<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
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
    
    #myChart{
    	scale:80%;
    }
    
    #text-border{
    	width: 100%;
    }
    
    #text-border th{
    	text-align: center;
    }
    
    #text-border td{
    	padding: 10px 10px;
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
			<form class="book-rent-form" action="" method="post">
				<input type="hidden" name="bookId" value="${b.bookId}">
				<input type="hidden" name="userNo" value="${loginUser.userNo}">
	            <table id="book-table">
	                <tr>
	                    <td rowspan="8" width="200px" height="300px"><img src="${contextPath }/resources/img/${b.imgName}" id="bookImg"></td>
	                </tr>
	                <tr>
	                    <th>책 제목 : </th>
	                    <td id="bookt">
	                    	${b.bookTitle }
	                    	(<c:forEach items="${biList }" var="c" >
		                    	 ${c.categoryName }
		                     </c:forEach>)
	                    </td>
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
					<th>대출/예약 :&nbsp;</th> 
					<td class="search-table-right">
					<c:if test="${not empty loginUser }">
							<button type="button"class="btn btn-success search-table-btn rent-btn">대출</button>
							
							<button type="button"class="btn btn-primary search-table-btn reserve-btn">예약</button>
					</c:if>
					</td>
					<script>
						function reserveDisabled() {
							$(".search-table-right").last().find(".reserve-btn").removeClass("btn-primary");
							$(".search-table-right").last().find(".reserve-btn").addClass("btn-secondary");
						}
						function rentDisabled() {
							$(".search-table-right").last().find(".rent-btn").removeClass("btn-success");
							$(".search-table-right").last().find(".rent-btn").addClass("btn-secondary");
						}
					</script>
				</tr>
					<tr>
						<th>도서현황 :</th>
						<td class="book-status"></td>
						<c:choose>
							<c:when test="${b.status eq 'Y'}">
								<script>
									reserveDisabled();
									$("#book-table").last().find(".book-status").text("대출가능");
									$("#book-table").last().find(".book-status").css("color","green");
								</script>
							</c:when>
							<c:when test="${b.status eq 'B'}">
								<script>
									rentDisabled();
									$("#book-table").last().find(".book-status").text("예약가능");
									$("#book-table").last().find(".book-status").css("color","skyblue");
								</script>
							</c:when>
							<c:when test="${b.status eq 'R'}">
								<script>
									reserveDisabled();
									rentDisabled();
									$("#book-table").last().find(".book-status").text("예약중");
								</script>
							</c:when>
							<c:otherwise>
								<script>
									reserveDisabled();
									rentDisabled();
									$("#book-table").last().find(".book-status").text("이용불가");
									$("#book-table").last().find(".book-status").css("color", "red");
								</script>
							</c:otherwise>
						</c:choose>
					</tr>
				</table>
	        </form> 
	           
	            <br><br>
	            <table border="1" id="text-border">
	                <tr>
	                    <th width="100px">줄거리</th>
	                    <td width="500px" height="100px">${b.summary }</td>
	                </tr>
	            </table>
	            <br><br>
	            <div align="center">
	            	<b>연령대별 누적 대출</b>
				  <canvas id="myChart"></canvas>
				</div>
			

				
				<script>
				  const ctx = document.getElementById('myChart');
				
				  new Chart(ctx, {
				    type: 'bar',
				    data: {
				      labels: ['10대', '20대', '30대', '40대', '50대', '60대'],
				      datasets: [{
				        label: '대출 권수',
				        data: [12, 19, 3, 5, 2, 3],
				        borderWidth: 1
				      }]
				    },
				    options: {
				      scales: {
				        y: {
				        	suggestedMin: 0,
			                suggestedMax: 30
				        }
				      }
				    }
				  });
				  
				  $(function(){
						$(".rent-btn").click(function(){
							if($(this).closest("#book-table").find(".book-status").text()=="대출가능"){
								$(this).closest(".book-rent-form").attr("action","${contextPath}/rent.bk");
								$(this).closest(".book-rent-form").submit();
							};
						});
						$(".reserve-btn").click(function(){
							if($(this).closest("#book-table").find(".book-status").text()=="예약가능"){
								$(this).closest(".book-rent-form").attr("action","${contextPath}/reserve.bk");
								$(this).closest(".book-rent-form").submit();
							};
						});
					});
				</script>
        </div>
    </div>
    <%@include file="/views/common/footer.jsp" %>
</body>
</html>