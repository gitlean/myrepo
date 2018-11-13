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
	src="<%=request.getContextPath()%>/static/js/highcharts/modules/wordcloud.js"></script>


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
		var text = 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean bibendum erat ac justo sollicitudin, quis lacinia ligula fringilla. Pellentesque hendrerit, nisi vitae posuere condimentum, lectus urna accumsan libero, rutrum commodo mi lacus pretium erat. Phasellus pretium ultrices mi sed semper. Praesent ut tristique magna. Donec nisl tellus, sagittis ut tempus sit amet, consectetur eget erat. Sed ornare gravida lacinia. Curabitur iaculis metus purus, eget pretium est laoreet ut. Quisque tristique augue ac eros malesuada, vitae facilisis mauris sollicitudin. Mauris ac molestie nulla, vitae facilisis quam. Curabitur placerat ornare sem, in mattis purus posuere eget. Praesent non condimentum odio. Nunc aliquet, odio nec auctor congue, sapien justo dictum massa, nec fermentum massa sapien non tellus. Praesent luctus eros et nunc pretium hendrerit. In consequat et eros nec interdum. Ut neque dui, maximus id elit ac, consequat pretium tellus. Nullam vel accumsan lorem.';
		
		//var text = '在教育部要求高校要杜绝“水课”，严把质量关之后，我国高校开始在“严出”上采取行动。但是，不少舆论担心这是“应景式”从严，只抓几个淘汰不合格学生的典型。我国大学要普遍实行“严出”教育模式，必须深入推进学校办学改革，为“严出”模式提供制度保障。';
		var lines = text.split(/[,\. ]+/g), data = Highcharts.reduce(lines,
				function(arr, word) {
					var obj = Highcharts.find(arr, function(obj) {
						return obj.name === word;
					});
					if (obj) {
						obj.weight += 1;
					} else {
						obj = {
							name : word,
							weight : 1
						};
						arr.push(obj);
					}
					return arr;
				}, []);

		Highcharts.chart('container', {
			series : [ {
				type : 'wordcloud',
				data : data,
				name : 'Occurrences'
			} ],
			title : {
				text : 'Wordcloud of Lorem Ipsum'
			}
		});
	});
</script>
</html>