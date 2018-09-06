<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<meta charset="utf-8" />
<title>echarts-map3</title>

<head>

<style type="text/css">
	.mapContainer {
		display: grid;
		height: 100vh;
		width: 100vw;
		grid-template-rows: 100%;
		grid-template-columns: 100%;
	}
	/*mapDemo1      */
	#mapDemo1 {
		width: 100%;
		height: 100%;
	}
</style>

<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery-3.2.1.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/echarts.min.js"></script>
</head>

<body>

	<p>echarts-map3</p>
	<br />
	<!-- 建立一个有高度和宽度的dom(建议div) -->

	<div class="mapContainer">
		<div id="mapDemo1"></div>
	</div>
</body>
<script type="text/javascript">
$(function(){  
    paintMap1();  
});  
function paintMap1(){  
    var mapChart = echarts.init($('#mapDemo1')[0]);  
    $.get('map/china.json', function (chinaJson) {  
        echarts.registerMap('china', chinaJson);  
        mapChart.setOption({  
            series: [{  
                type: 'map',  
                map: 'china'  
            }]  
        });  
    });  
}  
</script>
</html>
