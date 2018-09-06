<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<meta charset="utf-8" />
<title>echarts-map</title>

<head>
<script src="<%=request.getContextPath()%>/js/jquery-3.2.1.js"></script>
<script src="<%=request.getContextPath()%>/js/echarts.min.js"></script>
<script src="<%=request.getContextPath()%>/js/china.js"></script>

</head>

<body>

	<p>echarts-map</p>
	<br />
	<!-- 建立一个有高度和宽度的dom(建议div) -->

	<div id="mainMap" style="width: 1000px; height: 800px"></div>

</body>
<script type="text/javascript">
	$(function() {

		// 基于准备好的dom，初始化echarts实例
		var myChart3 = echarts.init(document.getElementById('mainMap'));
		var option = {
			title : {
				text : '各地区上交数据情况',
				subtext : '实时统计',
				x : 'center'
			},
			tooltip : {
				trigger : 'item'
			},
			legend : {
				orient : 'vertical',
				x : 'left',
				data : [ '上交不合格区县数', '上交合格区县数', '上交总区县数' ]
			},
			dataRange : {
				min : 0,
				max : 50,
				x : 'left',
				y : 'bottom',
				text : [ '高', '低' ], // 文本，默认为数值文本
				calculable : true
			},
			toolbox : {
				show : true,
				orient : 'vertical',
				x : 'right',
				y : 'center',
				feature : {
					mark : {
						show : true
					},
					dataView : {
						show : true,
						readOnly : false
					},
					restore : {
						show : true
					},
					saveAsImage : {
						show : true
					}
				}
			},
			roamController : {
				show : true,
				x : 'right',
				mapTypeControl : {
					'china' : true
				}
			},
			series : [ {
				name : '上交不合格区县数',
				type : 'map',
				mapType : 'china',
				roam : false,
				itemStyle : {
					normal : {
						label : {
							show : true
						}
					},
					emphasis : {
						label : {
							show : true
						}
					}
				},
				data : [ {
					name : '河北',
					value : count3bh
				}, {
					name : '辽宁',
					value : count8bh
				}, {
					name : '黑龙江',
					value : count1bh
				}, {
					name : '湖南',
					value : count2bh
				},

				{
					name : '甘肃',
					value : count5bh
				},

				{
					name : '内蒙古',
					value : count7bh
				},

				{
					name : '吉林',
					value : count4bh
				},

				{
					name : '贵州',
					value : count6bh
				},

				]
			}, {
				name : '上交合格区县数',
				type : 'map',
				mapType : 'china',
				itemStyle : {
					normal : {
						label : {
							show : true
						}
					},
					emphasis : {
						label : {
							show : true
						}
					}
				},
				data : [ {
					name : '河北',
					value : count3h
				}, {
					name : '辽宁',
					value : count8h
				}, {
					name : '黑龙江',
					value : count1h
				}, {
					name : '湖南',
					value : count2h
				},

				{
					name : '甘肃',
					value : count5h
				},

				{
					name : '内蒙古',
					value : count7h
				},

				{
					name : '吉林',
					value : count4h
				},

				{
					name : '贵州',
					value : count6h
				},

				]
			}

			]
		};

		myChart3.setOption(option);
	});
</script>
</html>
