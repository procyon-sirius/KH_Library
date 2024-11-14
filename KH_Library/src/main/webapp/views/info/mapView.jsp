<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<style>

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
			
			<div id="map" style="width: 500px; height: 400px;"></div>
			
			<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=7fa08141bb6b5c46aa34fc704a6d962a">
				var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
				var options = { //지도를 생성할 때 필요한 기본 옵션
					center: new kakao.maps.LatLng(33.450701, 126.570667), //지도의 중심좌표.
					level: 3 //지도의 레벨(확대, 축소 정도)
				};
	
				var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴
			</script>
			<script type="text/javascript" src="http://dapi.kakao.com/v2/maps/sdk.js?autoload=false"></script>
			<script type="text/javascript">
				kakao.maps.load(function() {
				    // v3가 모두 로드된 후, 이 콜백 함수가 실행됩니다.
				    var map = new kakao.maps.Map(node, options);
				});
			</script>
			
        </div>
    </div>
    <%@include file="/views/common/footer.jsp" %>
</body>
</html>