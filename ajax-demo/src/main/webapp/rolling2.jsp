<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<meta charset="utf-8" />
<title>文字滚动</title>
<style>
#all{
	width: 100%;
	margin: 0 auto;
	background: #ffffff;
}
#all .t_num i {
	width: 33px;
	height: 47px;
	display: inline-block;
	background: url(img/number1.png) no-repeat;
	background-position: 0 0;
}
</style>

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/digitalScroll.js"></script>
<script type="text/javascript">
var sum = 13000;
$(function() {
	setInterval('getdata()',1000);
});

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
			show_num1(data.count);

		}
	});
}



function show_num1(n) {
	sum=sum+5;
	console.log(n);
	var it = $(".t_num1 i");
	var len = String(n).length;
	for(var i = 0; i < len; i++) {
		if(it.length <= i) {
			$(".t_num1").append("<i></i>");
		}
		var num = String(n).charAt(i);
		//根据数字图片的高度设置相应的值
		var y = -parseInt(num) * 58;
		var obj = $(".t_num1 i").eq(i);
		obj.animate({
			backgroundPosition: '(0 ' + String(y) + 'px)'
		}, 'slow', 'swing', function() {});
	}
	$("#cur_num").val(n);
}
</script>
</head>

<body>

<div id="all">
	<span class="t_num t_num1"></span>
</div>

</body>
</html>
