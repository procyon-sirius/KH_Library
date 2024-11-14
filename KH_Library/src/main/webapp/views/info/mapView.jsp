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
			
			<div id="map" style="width: 100%; height: 500px;"></div> 
	
	
			<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=c455d1def298ac100bf896a06a4bf4b5"></script>
			<script type="text/javascript">
			
				var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
				var options = { //지도를 생성할 때 필요한 기본 옵션
					center: new kakao.maps.LatLng(37.533808, 126.8968323), //지도의 중심좌표.
					level: 3 //지도의 레벨(확대, 축소 정도)
				};
			
				var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴
				
				
				
				var coords = new kakao.maps.LatLng(37.533808, 126.8968323);
			
			    // 결과값으로 받은 위치를 마커로 표시합니다
			    var marker = new kakao.maps.Marker({
			        map: map,
			        position: coords
			    });
			
			    // 인포윈도우로 장소에 대한 설명을 표시합니다
			    var infowindow = new kakao.maps.InfoWindow({
			        content: '<div style="width:150px;text-align:center;padding:6px 0;">KH Library</div>'
			    });
			    infowindow.open(map, marker);
			
			    // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
			    map.setCenter(coords);
			</script>
			
        </div>
    </div>
    <%@include file="/views/common/footer.jsp" %>
</body>
</html>