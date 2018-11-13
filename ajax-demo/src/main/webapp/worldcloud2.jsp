<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- https://blog.csdn.net/u013808809/article/details/78924725 -->
<title>ECharts</title>

<script src="<%=request.getContextPath()%>/js/jquery-3.2.1.js"></script>
<script src="<%=request.getContextPath()%>/js/echarts.min.js"></script>
<script src="<%=request.getContextPath()%>/js/china.js"></script>
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
        			        
        			        //shape: 'pentagon',   //五角
        			        //shape: 'circle',  //
        			        // shape: 'ellipse',//椭圆
        			        //shape: 'rectangle',
        			        shape:'smooth',
        			        
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
        			            {
        			                name: 'Sam S Club',
        			                value: 10000
        			                
        			            }, {
        			                name: 'Macys',
        			                value: 6181
        			            }, {
        			                name: 'Amy Schumer',
        			                value: 4386
        			            }, {
        			                name: 'Jurassic World',
        			                value: 4055
        			            }, {
        			                name: 'Charter Communications',
        			                value: 2467
        			            }, {
        			                name: 'Chick Fil A',
        			                value: 2244
        			            }, {
        			                name: 'Planet Fitness',
        			                value: 1898
        			            }, {
        			                name: 'Pitch Perfect',
        			                value: 1484
        			            }, {
        			                name: 'Express',
        			                value: 1112
        			            }, {
        			                name: 'Home',
        			                value: 965
        			            }, {
        			                name: 'Johnny Depp',
        			                value: 847
        			            }, {
        			                name: 'Lena Dunham',
        			                value: 582
        			            }, {
        			                name: 'Lewis Hamilton',
        			                value: 555
        			            }, {
        			                name: 'KXAN',
        			                value: 550
        			            }, {
        			                name: 'Mary Ellen Mark',
        			                value: 462
        			            }, {
        			                name: 'Farrah Abraham',
        			                value: 366
        			            }, {
        			                name: 'Rita Ora',
        			                value: 360
        			            }, {
        			                name: 'Serena Williams',
        			                value: 282
        			            }, {
        			                name: 'NCAA baseball tournament',
        			                value: 273
        			            }, {
        			                name: 'Point' ,
        			                value: 273
        			            }, {
        			                name: 'Point Break',
        			                value: 265
        			            }]
        			    }
        			    ]
        		};
            
            
            myChart.setOption(option);
           
        </script>

</body>
</html>