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

	<p align="center">echarts-map10</p>
	<br />
	<!-- 建立一个有高度和宽度的dom(建议div) -->

	<div id="mainMap" align="center" style="width: 1000px; height: 800px"></div>
	
	<div id="changeId">
		<input type="button" value="返回" onclick="changeView()" />
	</div>
	
</body>
<script type="text/javascript">
	$(function() {
		
		init();

	});

	function init() {
		//用山东地图展示各个地市的人口数量
		$.get('map/china.json', function(mapJson) { //请求 "map/shandong.json"  返回数据 mapJson

			echarts.registerMap('china', mapJson);

			var chart = echarts.init(document.getElementById('mainMap'));//在id为mainMap的dom元素中显示地图

			option = {

				tooltip : {
					trigger : 'item',
					formatter : function(params) {//回调函数，参数params具体格式参加官方API
						//鼠标放到某个地市上，显示这个地市的名称加人口数
						//例如 params.name：当前地市名称。params.value：你传入的json数据与当前地市匹配的一项。
						//params.data.value:你传入的json数据与当前地市匹配的一项中'value'对应的数据
						//return params.name + ":" + params.data.value;
						var mt = new Date();
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
					map : 'china',//要和echarts.registerMap（）中第一个参数一致
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
				console.log(new Date() + "---------->click");
				//alert(params.name);//弹出当前点击城市的名称
				showProvince(params.name);

			});

			chart.setOption(option);

		});
	}

	function changeView(){
		init();
	}
	
	
	//---------------------------------------------------------------------------------------------
	function showProvince(pName) {
		var t = convertpName(pName);
		var mapName = 'map/' + t + '.json';
		console.log(mapName);
		$.get(mapName, function(mapJson) { //请求 "map/shandong.json"  返回数据 mapJson

			echarts.registerMap('province', mapJson);

			var chart = echarts.init(document.getElementById('mainMap'));//在id为mainMap的dom元素中显示地图

			option = {

				tooltip : {
					trigger : 'item',
					formatter : function(params) {//回调函数，参数params具体格式参加官方API

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
					map : 'province',//要和echarts.registerMap（）中第一个参数一致
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

			chart.setOption(option);

		});
	}

	function convertpName(pName) {

		//华北
		//华北地区包括：北京市、天津市、河北省、山西省和内蒙古自治区中部即锡林郭勒盟、乌兰察布市、包头市和呼和浩特市等四盟(市)。
		//政治上一般上把整个内蒙古都列入华北地区。
		if (pName == '北京') {
			return 'beijing';
		}
		if (pName == '天津') {
			return 'tianjin';
		}
		if (pName == '河北') {
			return 'hebei';
		}
		if (pName == '山西') {
			return 'shan1xi';
		}
		if (pName == '内蒙古') {
			return 'neimenggu';
		}

		//东北
		if (pName == '辽宁') {
			return 'liaoning';
		}
		if (pName == '吉林') {
			return 'jilin';
		}
		if (pName == '黑龙江') {
			return 'heilongjiang';
		}

		//华东七省市
		if (pName == '上海') {
			return 'shanghai';
		}
		if (pName == '江苏') {
			return 'jiangsu';
		}
		if (pName == '浙江') {
			return 'zhejiang';
		}

		if (pName == '安徽') {
			return 'anhui';
		}
		if (pName == '福建') {
			return 'fujian';
		}
		if (pName == '江西') {
			return 'jiangxi';
		}
		if (pName == '山东') {
			return 'shandong';
		}

		//中南六省区
		//如今更多使用细分的华中地区、华南地区
		if (pName == '河南') {
			return 'henan';
		}
		if (pName == '湖北') {
			return 'hubei';
		}
		if (pName == '湖南') {
			return 'hunan';
		}
		if (pName == '广东') {
			return 'guangdong';
		}
		if (pName == '广西') {
			return 'guangxi';
		}
		if (pName == '海南') {
			return 'hainan';
		}

		//西南地区
		if (pName == '重庆') {
			return 'chongqing';
		}
		if (pName == '四川') {
			return 'sichuan';
		}
		if (pName == '贵州') {
			return 'guizhou';
		}
		if (pName == '云南') {
			return 'yunnan';
		}

		if (pName == '西藏') {
			return 'xizang';
		}

		//西北地区
		if (pName == '陕西') {
			return 'shan3xi';
		}
		if (pName == '甘肃') {
			return 'gansu';
		}
		if (pName == '青海') {
			return 'qinghai';
		}
		if (pName == '宁夏') {
			return 'ningxia';
		}
		if (pName == '新疆') {
			return 'xinjiang';
		}

		//港澳台
		if (pName == '香港') {
			return 'hongkong';
		}
		if (pName == '澳门') {
			return 'macau';
		}
		if (pName == '台湾') {
			return 'taiwan';
		}

		return 'china';
	}
</script>
</html>
