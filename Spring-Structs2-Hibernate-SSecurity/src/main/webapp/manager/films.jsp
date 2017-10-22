<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
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
	<!-- 添加影片操作，登录帐号具备ROLE_ADMIN权限或者ROLE_ADD_FILM权限可以执行 -->
	<security:authorize ifAnyGranted="ROLE_ADMIN,ROLE_ADD_FILM">
		<a href="<%=basePath %>manager/insertFilm.jsp">添加影片信息</a>
		<br />
	</security:authorize>

	<s:if test="filmList != null">
		<table border="1" width="40%">
			<tr>
				<th>序号</th>
				<th>影片名</th>
				<th>操作</th>
			</tr>
			<%-- 遍历影片信息 --%>
			<s:iterator var="film" value="filmList" status="st">
				<tr>
					<td><s:property value="#st.index+1" /></td>
					<td><s:property value="fname" /></td>
					<td>
						<!-- 修改影片操作，登录帐号具备ROLE_ADMIN权限或者ROLE_UPDATE_FILM权限可以执行 --> 
						<security:authorize
							ifAnyGranted="ROLE_ADMIN,ROLE_UPDATE_FILM">
							<s:url var="detailUrl" value="/film/detailFilm">
								<s:param name="id" value="%{id}" />
							</s:url>
							<s:a href="%{detailUrl}">[修改]</s:a>&nbsp;
	    				</security:authorize> 
	    			
	    				<!-- 删除影片操作，登录帐号具备ROLE_ADMIN权限或者ROLE_DELETE_FILM权限可以执行 --> 
	    				<security:authorize
							ifAnyGranted="ROLE_ADMIN,ROLE_DELETE_FILM">
							<s:url var="deleteUrl" value="/film/deleteFilm">
								<s:param name="id" value="%{id}" />
							</s:url>
							<s:a href="%{deleteUrl}">[删除]</s:a>
						</security:authorize>
					</td>
				</tr>
			</s:iterator>
		</table>
	</s:if>
</body>
</html>