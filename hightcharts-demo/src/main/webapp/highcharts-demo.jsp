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
	src="<%=request.getContextPath()%>/static/js/jquery/jquery-3.2.1.js"></script>

</head>
<body>

	<input type="button" value="点击我!" onclick="clickMe()" />
	<!-- 注意click是保留字段 -->
	<br />
	<div id="container"
		style="min-width: 310px; max-width: 800px; height: 400px; margin: 0 auto"></div>

	<p>------------------------------------------------------------------------------------------------------------------------------------------------</p>

	<div id="container2"
		style="min-width: 310px; max-width: 800px; height: 400px; margin: 0 auto"></div>

</body>
<script type="text/javascript">
	//原生js调用
	function clickMe() {
		//alert("Got it...");
		console.log("Got it...");
		Highcharts.chart('container', {
			chart : {
				type : 'bar'
			},
			title : {
				text : 'Stacked bar chart'
			},
			xAxis : {
				categories : [ 'Apples', 'Oranges', 'Pears', 'Grapes',
						'Bananas' ]
			},
			yAxis : {
				min : 0,
				title : {
					text : 'Total fruit consumption'
				}
			},
			legend : {
				reversed : true
			},
			plotOptions : {
				series : {
					stacking : 'normal'
				}
			},
			series : [ {
				name : 'John',
				data : [ 5, 3, 4, 7, 2 ]
			}, {
				name : 'Jane',
				data : [ 2, 2, 3, 2, 1 ]
			}, {
				name : 'Joe',
				data : [ 3, 4, 4, 2, 5 ]
			} ]
		});

	}
	//jquery调用
	$(function() {
		
		//$('#container2').highcharts({ });  //这种形式调用有问题  ??? 
		Highcharts.chart('container2', {
			chart : {
				type : 'bar'
			},
			title : {
				text : 'Stacked bar chart'
			},
			xAxis : {
				categories : [ 'Apples', 'Oranges', 'Pears', 'Grapes',
						'Bananas' ]
			},
			yAxis : {
				min : 0,
				title : {
					text : 'Total fruit consumption'
				}
			},
			legend : {
				reversed : true
			},
			plotOptions : {
				series : {
					stacking : 'normal'
				}
			},
			series : [ {
				name : 'John',
				data : [ 5, 3, 4, 7, 2 ]
			}, {
				name : 'Jane',
				data : [ 2, 2, 3, 2, 1 ]
			}, {
				name : 'Joe',
				data : [ 3, 4, 4, 2, 5 ]
			} ]
		});
					
	});
</script>
</html>