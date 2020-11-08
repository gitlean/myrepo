<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	队列：
	<form action="${pageContext.request.contextPath}/activemq/queue" method="GET">
		message: <input type="text" name="message"> <br /> <input
			type="submit" value="提交" />
	</form>
	<br /> 
	Topic：
	<form action="${pageContext.request.contextPath}/activemq/topic" method="GET">
		message: <input type="text" name="message"> <br /> <input
			type="submit" value="提交" />
	</form>
</body>
</html>