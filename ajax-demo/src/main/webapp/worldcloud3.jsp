<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- https://blog.csdn.net/qq_35052627/article/details/71082499?utm_source=blogxgwz3 -->
<title>ECharts</title>

<script src="<%=request.getContextPath()%>/js/jquery-3.2.1.js"></script>
<script src="<%=request.getContextPath()%>/js/echarts.min.js"></script>

<script src="<%=request.getContextPath()%>/js/worldcloud.js"></script>
<style>
#china-map {
	width: 1000px;
	height: 1000px;
	margin: auto;
}
</style>
</head>
<body>

	<!-- 建立一个有高度和宽度的dom(建议div) -->
	<div id="container" style="width: 1000px; height: 800px"></div>


	<script>
			//var cloud= [ { name: '苏州', value: 10000, }, { name: '无锡', value: 6181 }, { name: '南京', value: 6181 }];  //传入的cloud参数为字符云的数据，类型为json数组。
	
            var myChart = echarts.init(document.getElementById('container'));
            
            
        	var option = {
        			tooltip : {},
        			series: [
        			    {
        			   type: 'wordCloud',
        			        gridSize: 2,
        			        sizeRange: [12, 50],
        			        rotationRange: [-90, 90],
        			        shape: 'pentagon',
        			        textStyle: {
        			            normal: {
        			                color: function () {
        			                    return 'rgb(' + [
        			                            Math.round(Math.random() * 255),
        			                            Math.round(Math.random() * 255),
        			                            Math.round(Math.random() * 255)
        			                        ].join(',') + ')';
        			                }
        			            },
        			            emphasis: {
        			                shadowBlur: 10,
        			                shadowColor: '#333'
        			            }
        			        },
        			        data: [
        			        	{"name": "云图","value": "200"},
        			        	{"name": "是个啥","value": "156"},
        			        	{"name": "他啥都不是","value": "122"},
        			        	{"name": "就是他呆子","value": "119"},
        			        	{"name": "傻子和疯子","value": "108"},
        			        	{"name": "营养快线","value": "101"},
        			        	{"name": "哈哈哈到家","value": "96"},
        			        	{"name": "瑞士军刀","value": "84"},
        			        	{"name": "DW情侣对表","value": "58"},
        			        	{"name": "清风抽纸","value": "55"},
        			        	{"name": "OPPO R9S","value": "46"},
        			        	{"name": "这一刻更清晰","value": "28"},
        			        	{"name": "呵呵旧宫style","value": "27"},
        			        	{"name": "债券评级","value": "26"}
        			        	]
        			    }
        			    ]
        		};
            
            
            myChart.setOption(option);
           
        </script>

</body>
</html>