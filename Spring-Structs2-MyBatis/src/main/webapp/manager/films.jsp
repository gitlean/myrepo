<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>信息操作</title>
  </head>
  <body>
    <s:form action="/film/findFilm" method="post">
    	<s:submit value=" 获取所有影片信息 "></s:submit>
    </s:form>
    <a href="<%=basePath %>manager/insertFilm.jsp">添加影片信息</a><br />
    <s:if test="filmList != null">
    	<table border="1" width="40%">
    		<tr>
    			<th>序号</th><th>影片名</th><th>操作</th>
    		</tr>	
	    	<%-- 遍历影片信息 --%>
	    	<s:iterator var="film" value="filmList" status="st">
		    	<tr>
		    		<td><s:property value="#st.index+1" /></td>
		    		<td><s:property value="fname" /></td>
		    		<td>
		    			<s:url var="detailUrl" value="/film/detailFilm">
			                      		<s:param name="id" value="%{id}"/>
			                      	</s:url>
		    			<s:a href="%{detailUrl}">[修改]</s:a>&nbsp;
		    			<s:url var="deleteUrl" value="/film/deleteFilm">
			                      		<s:param name="id" value="%{id}"/>
			                      	</s:url>
		    			<s:a href="%{deleteUrl}">[删除]</s:a>
		    		</td>
		    	</tr>
			</s:iterator>
		</table>
    </s:if>
  </body>
</html>