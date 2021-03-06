<!-- https://wenku.baidu.com/view/e37a232676a20029bc642dea.html -->
<!-- ECharts 中的事件和行为-->

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

</head>

<body align="center">

	<p align="center">echarts-map8</p>
	<br />
	<!-- 建立一个有高度和宽度的dom(建议div) -->

	<div id="mainMap" align="center" style="width: 1000px; height: 800px"></div>
	
	
	
</body>
<script type="text/javascript">
	//用山东地图展示各个地市的人口数量
	$.get('map/shandong.json', function(mapJson) { //请求 "map/shandong.json"  返回数据 mapJson

		echarts.registerMap('shandong', mapJson); //"shandong"是标记作用还是必须是山东?  只是一个标记

		var chart = echarts.init(document.getElementById('mainMap'));//在id为mainMap的dom元素中显示地图

		option = {
			title : {
				text : '山东省地图',
				subtext : 'Data from www.census.gov',
				sublink : 'http://www.census.gov/popest/data/datasets.html',
				left : 'right'
			},
			
			tooltip : {
				trigger : 'item',
				formatter : function(params) {//回调函数，参数params具体格式参加官方API
					//鼠标放到某个地市上，显示这个地市的名称加人口数
					//例如 params.name：当前地市名称。params.value：你传入的json数据与当前地市匹配的一项。
					//params.data.value:你传入的json数据与当前地市匹配的一项中'value'对应的数据
					//return params.name + ":" + params.data.value;
					var mt=new Date();
					//console.log(mt+"-------->"+params.name+"---------->"+params.value);
					return params.name;
				}
			},

			toolbox : {
				show : true,
				//orient: 'vertical',
				left : 'left',
				top : 'top',
				feature : {
					dataView : {
						readOnly : false
					},
					restore : {},
					saveAsImage : {}
				}
			},
			//-------------------------------------------------

			series : [ {
				type : 'map',
				map : 'shandong',//要和echarts.registerMap（）中第一个参数一致
				label : {
					normal : {
						show : true
					},
					emphasis : {
						show : true
					}
				},
				data : []

			//人口数据：例如[{name:'济南',value:'100万'},{name:'菏泽'，value:'100万'}......]
			} ]

		}

		
		
		chart.on('click', function(params) {//回调函数，点击时触发，参数params格式参加官方API
			console.log(new Date()+"---------->click");
			alert(params.name);//弹出当前点击城市的名称
		});
		
		
		
		

		chart.setOption(option);

	});
	
	
	
	
</script>
</html>
