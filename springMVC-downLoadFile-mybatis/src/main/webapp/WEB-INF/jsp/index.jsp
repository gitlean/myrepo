<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<% 
	String path=request.getContextPath();
	String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.2.1.js"></script>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>welcome</title>
</head>


<body>
	<h1>Welcome You!</h1>
	<br/>
	<p>直接下载，不保存到服务器</p>
	<input type="button" value="下载Excel" onclick="downFile()"/>
	<br/>
	<br/>
	<br/>
	<p>下面的按钮是先把excel保存服务器，再下载到本地</p>
	
	
	<input type="button" value="下载Excel2" onclick="downFile2()"/>
</body>

<script type="text/javascript">
	function downFile() {
		var url='<%=basePath%>excelDownloadManager/exportExcel';
		//alert(url);
		$(location).attr("href",url);
	}
	
	function downFile2() {
		var url='<%=basePath%>excelDownloadManager2/exportExcel2';
		//alert(url);
		$(location).attr("href",url);
	}
</script>
</html>