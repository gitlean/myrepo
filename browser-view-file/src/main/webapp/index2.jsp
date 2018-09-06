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
<title>Welcome index2</title>
</head>
<body>

<p>已知资源绝对路径，可通过此种方式下载</p>
<a onclick="exportWord()" style="cursor:pointer;">下载/查看</a>

</body>
<script type="text/javascript">
function exportWord(){//文件路径可作为参数传过来
	    //var url='<%=basePath%>excelDownloadManager/exportWord';
		alert("开发中...");
		//$(location).attr("href",url);
	}
</script>


</html>