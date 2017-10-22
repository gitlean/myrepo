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
    <title>修改影片</title>
  </head>
  <body>
    <s:form action="/film/updateFilm" method="post">
    	<s:hidden name="id" />
    	<s:textfield name="fname" />
    	<s:submit value=" 修改 "></s:submit>
    </s:form>
  </body>
</html>