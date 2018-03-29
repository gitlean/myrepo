<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery-3.2.1.js"></script>


<body>
	<p>输入1是成功，其他失败</p>
	<br/>
	<input type="text" name="uname" id="username">
	<input type="button" value="click" onclick="sendMsg()"/>
	<br/>
	<div id="result"></div>

</body>



<script type="text/javascript">
	function sendMsg() {
		//alert("aaaaaaaaa");

		$.ajax({
			type : "POST", //method   提交方式 
			url : "${pageContext.request.contextPath}/org/doDelete.do",//路径 

			data : {
				//"param1" : "${org.id}"
				"param1" : $("#username").val(), //<input 用().val();其他用 ().text() 
				"param2" : "22222",
			},//数据，这里使用的是Json格式进行传输 

			 //服务器返回数据的类型，例如xml,String,Json等
			dataType:'json',

			//请求成功后的回调函数。
			success : function(data,status) {//返回数据根据结果进行相应的处理 
				alert("status----->"+status);
				//alert("----->"+data);
				if (data.success) {

					$("#result").text("成功");

				} else {
					$("#result").text("失败");
				}
			}

		});

		//---------------------------------------------

	}
</script>

</html>