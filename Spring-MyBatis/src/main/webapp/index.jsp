<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="com.xxx.pojo.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.xxx.service.*"%>
<%@ page import="org.springframework.context.*"%>
<%@ page
	import="org.springframework.web.context.support.WebApplicationContextUtils"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<!-- JSP获取spring 的容器ApplicationContext -->
<!-- http://hw1287789687.iteye.com/blog/1943433 -->
<%
	ServletContext context = request.getSession().getServletContext();
	ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(context);
	FilmService service = (FilmService) ctx.getBean("filmService");
	//4、显示所有电影信息  
	List<Film> filmList = service.getAllFilm();
	for (Film filmObj : filmList) {

		System.out.println("电影ID：" + filmObj.getId() + " 电影名：" + filmObj.getFname());
	}
%>

<body>

</body>
</html>