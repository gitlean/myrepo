<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/digitalScroll.js"></script>


<title>数字滚动效果</title>
</head>
<body>
	<div id="total">
		下载量：<span class="t_num"></span>次
	</div>

	<div id="aaa"></div>
</body>

<script type="text/javascript">
	//首先来写一个函数show_num()，该函数用来实现动态滚动数字。我们将统计数字n进行拆分成一个个单独的数字，这些数字用<i></i>包围，通过调用插件backgroundPosition将图片定位到对应的每个数字上。
	function show_num(n) {
		sum = sum + 5;
		console.log(n);
		var it = $(".t_num1 i");
		var len = String(n).length;
		for (var i = 0; i < len; i++) {
			if (it.length <= i) {
				$(".t_num1").append("<i></i>");
			}
			var num = String(n).charAt(i);
			//根据数字图片的高度设置相应的值
			var y = -parseInt(num) * 58;
			var obj = $(".t_num1 i").eq(i);
			obj.animate({
				backgroundPosition : '(0 ' + String(y) + 'px)'
			}, 'slow', 'swing', function() {
			});
		}
		$("#cur_num").val(n);
	}

	//我们通过ajax获取后台最新的下载次数。下面的代码是一个常见的jQuery的ajax请求，通过post请求到data.php，data.php获取最新的下载次数，处理成功后则得到下载次数：data.count，然后调用show_num()实现数字滚动。 
	function getdata() {
		$.ajax({
			url : "${pageContext.request.contextPath}/org/roll.do",
			type : 'POST',
			dataType : "json",
			cache : false,
			timeout : 10000,
			error : function() {
			},
			success : function(data, status) {
				show_num(data.count);

			}
		});
	}

	//最后，我们在页面加载完后要初始化数据，然后每隔3秒钟执行一次ajax请求，更新下载次数：
	$(function() {
		getdata();
		setInterval('getdata()', 3000);//每隔3秒执行一次 
	});
</script>

</html>