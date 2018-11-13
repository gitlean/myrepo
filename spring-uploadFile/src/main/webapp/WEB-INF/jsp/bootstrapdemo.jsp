<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!--  
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
-->
<title>BootStrap Demo</title>
 <!-- 引入 Bootstrap -->
<link href="<%=path%>/js/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet">
<!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
<script type="text/javascript" src="<%=path%>/js/jquery-3.2.1.js"></script>
<!-- 包括所有已编译的插件 -->
<script src="<%=path%>/js/bootstrap-3.3.7/js/bootstrap.min.js"></script>


<style>
 body {
	padding-top: 50px;
    padding-left: 50px;
}
</style>

</head>
<body>

<h1>Hello, world!</h1>

<p>https://getbootstrap.com/是官网</p>
<p>http://www.bootcss.com/ 是中文资源</p>
<p>https://github.com/twbs/bootstrap/releases</p>
<p>http://www.runoob.com/bootstrap/bootstrap-environment-setup.html</p>
<p>http://www.runoob.com/bootstrap/bootstrap-ui-editor.html |Bootstrap UI 编辑器</p>
<p>http://www.youzhan.org/</p>
<div class="navbar navbar-fixed-top navbar-inverse" role="navigation">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">Project name</a>
		</div>
		<div class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li class="active"><a href="#"><span class="glyphicon glyphicon-home"></span> Home</a></li>
				<li><a href="#shop"><span class="glyphicon glyphicon-shopping-cart"></span> Shop</a></li>
				<li><a href="#support"><span class="glyphicon glyphicon-headphones"></span> Support</a></li>
			</ul>
		</div><!-- /.nav-collapse -->
	</div><!-- /.container -->
</div>

<button type="button" id="uploadExcel" class="btn btn-primary disabled" data-btn-type="selectIcon">
         <i class="fa fa-mail-forward">&nbsp;上传Excel-（西药）</i>
</button>


</body>
</html>