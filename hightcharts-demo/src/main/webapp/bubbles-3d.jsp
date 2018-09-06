<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>highcharts</title>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/static/js/highcharts/highcharts.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/static/js/highcharts/highcharts-more.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/static/js/jquery/jquery-3.2.1.js"></script>

</head>
<body>

	<div id="container"
		style="height: 400px; min-width: 310px; max-width: 600px; margin: 0 auto"></div>


</body>
<script type="text/javascript">
	//jquery调用
	$(function() {
		//$('#container2').highcharts({ });  //这种形式调用有问题  ??? 
		Highcharts.chart('container', {

		    chart: {
		        type: 'bubble',
		        plotBorderWidth: 1,
		        zoomType: 'xy'
		    },

		    title: {
		        text: 'Highcharts bubbles with radial gradient fill'
		    },

		    xAxis: {
		        gridLineWidth: 1
		    },

		    yAxis: {
		        startOnTick: false,
		        endOnTick: false
		    },

		    series: [{
		        data: [
		            [9, 81, 63],
		            [98, 5, 89],
		            [51, 50, 73],
		            [41, 22, 14],
		            [58, 24, 20],
		            [78, 37, 34],
		            [55, 56, 53],
		            [18, 45, 70],
		            [42, 44, 28],
		            [3, 52, 59],
		            [31, 18, 97],
		            [79, 91, 63],
		            [93, 23, 23],
		            [44, 83, 22]
		        ],
		        marker: {
		            fillColor: {
		                radialGradient: { cx: 0.4, cy: 0.3, r: 0.7 },
		                stops: [
		                    [0, 'rgba(255,255,255,0.5)'],
		                    [1, Highcharts.Color(Highcharts.getOptions().colors[0]).setOpacity(0.5).get('rgba')]
		                ]
		            }
		        }
		    }, {
		        data: [
		            [42, 38, 20],
		            [6, 18, 1],
		            [1, 93, 55],
		            [57, 2, 90],
		            [80, 76, 22],
		            [11, 74, 96],
		            [88, 56, 10],
		            [30, 47, 49],
		            [57, 62, 98],
		            [4, 16, 16],
		            [46, 10, 11],
		            [22, 87, 89],
		            [57, 91, 82],
		            [45, 15, 98]
		        ],
		        marker: {
		            fillColor: {
		                radialGradient: { cx: 0.4, cy: 0.3, r: 0.7 },
		                stops: [
		                    [0, 'rgba(255,255,255,0.5)'],
		                    [1, Highcharts.Color(Highcharts.getOptions().colors[1]).setOpacity(0.5).get('rgba')]
		                ]
		            }
		        }
		    }]

		});
	});
</script>
</html>