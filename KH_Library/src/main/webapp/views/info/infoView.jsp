<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KH Library>도서관 안내</title>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<style>
	@font-face {
	    font-family: 'STUNNING-Bd';
	    src: url('https://fastly.jsdelivr.net/gh/projectnoonnu/2410-2@1.0/STUNNING-Bd.woff2') format('woff2');
	    font-weight: normal;
	    font-style: normal;
	}
	#content-area{
		font-family: 'STUNNING-Bd';
	}
	#title{
		font-weight: bolder;
	}
	
	.contents{
		font-family: 'STUNNING';
		font-size: 20px;
		margin-left: -220px;     
	
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
		<script>
			$(function(){
				console.log();
				var sidemenu = $(".side-title-menu").eq(2);
				sidemenu.siblings("ul").children().show();
				sidemenu.siblings("ul").children().eq(0).addClass("menu-click");
			})
		</script>
        <div id="content-area">
			
			<h1 id="title">KH도서관에 오신 것을 환영합니다.</h1>  
			<br>
			<br>
				<img id="titleImg" src="/library/views/info/info.jpg" width="800" height="300">
			
			<pre class="contents">
				
				KH도서관은 1984. 10월에 개관하여 장서 16만여권과 비도서 8천여점을 소장하고 있으며, 
				디지털산업단지로 변모하고 있는 지역여건을 반영하여 IT자료를 특화자료로 수집하여 제공하고 있습니다.
	
				그 외에도 종합자료실, 어린이자료실, 디지털·간행물실과 열람실 등을 갖추어 지역주민의 독서활동을 지원하고, 
				다양한 독서문화프로그램을 운영함으로써 지역주민의 평생학습과 자기계발을 위해 노력하고 있습니다.
				
				첨단문명을 지향하는 21세기 지식기반사회는 다양성과 개성을 갖춘 "창의 융합형 인재"를 필요로 하고 있습니다.
				
				복잡하고 빠르게 변화하는 현대사회에 적응하기 위해 우리는 생애에 걸쳐 새로운 지식을 습득하고, 
				필요한 지식을 자율적으로 충족해야 하는 시대에 살고 있습니다.
				
				4차 산업혁명시대를 맞아 자신의 꿈과 끼를 찾아서 열정적으로 노력하고 행복한 미래를 준비하는 
				지역주민을 위해 우리 KH도서관이 함께 하겠습니다.
				
				여러분들의 소중한 꿈이 영글어 꽃 피울 수 있게, 보다 편안하고 친근한 도서관이 되도록 직원 모두 열심히 노력하겠습니다.
				
				지역주민 여러분의 많은 관심과 성원을 부탁드립니다.
				
				감사합니다.
				
				
				
				- 서울특별시교육청 KH도서관장
			
					
			</pre>
			
        </div>
    </div>
    <%@include file="/views/common/footer.jsp" %>
</body>
</html>