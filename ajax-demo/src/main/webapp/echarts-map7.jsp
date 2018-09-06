<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<meta charset="utf-8" />
<title>echarts-map</title>

<head>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery-3.2.1.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/echarts.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/china.js"></script>
</head>

<body>

	<p>echarts-map7</p>
	<br />
	<!-- 建立一个有高度和宽度的dom(建议div) -->
	<div id="container" style="width: 1000px; height: 800px"></div>


</body>
<script type="text/javascript">
	//container 为div的id 
	var dom = document.getElementById("container");
	//得到echarts的实例对象
	var myChart = echarts.init(dom);
	//关键是配置项
	var option = {

		series : [ {
			name : '网点个数',
			//series[i]-map:系列列表。每个系列通过 type 决定自己的图表类型,此处是地图类型
			type : 'map',
			//这里是'china',及因为js中注册的名字，如果是上海市，则该出需pName 指的是'shanghai'
			mapType : pName,
			//地图区域的多边形 图形样式，有 normal 和 emphasis 两个状态
			itemStyle : {
				//normal 是图形在默认状态下的样式；
				normal : {
					show : true,
					areaColor : "#CECECE",
					borderColor : "#FCFCFC",
					borderWidth : "1"
				},
				//emphasis 是图形在高亮状态下的样式，比如在鼠标悬浮或者图例联动高亮时。
				emphasis : {
					show : true,
					areaColor : "#C8A5DF",
				}
			},
			//图形上的文本标签，可用于说明图形的一些数据信息
			label : {
				normal : {
					show : true
				},
				emphasis : {
					show : true
				}
			},

		} ],
		title : {
			text : pName,
			left : 'center'
		}
	};
	//使用刚指定的配置项和数据显示图表。
	myChart.setOption(option);
</script>
</html>
