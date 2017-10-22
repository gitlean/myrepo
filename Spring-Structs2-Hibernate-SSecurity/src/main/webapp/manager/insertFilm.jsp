<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8" %>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>添加影片</title>
  </head>
  <body>
    <s:form action="/film/insertFilm" method="post">
    	<s:textfield name="fname" value="" />
    	<s:submit value=" 添加 "></s:submit>
    </s:form>
  </body>
</html>