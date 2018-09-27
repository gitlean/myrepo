<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>welcome</title>
</head>
<body>
<input type="button" value="please click" onclick="sendMsg()"/>

</body>

<script type="text/javascript">
function sendMsg2(){
	alert("Got it...");
}

function sendMsg(){
	alert("Got it...");
	// 初始化一个 WebSocket 对象
	var ws = new WebSocket("ws://localhost:8080/spring-websocket-demo/myHandler");

	// 建立 web socket 连接成功触发事件
	ws.onopen = function () {
	  // 使用 send() 方法发送数据
	  ws.send("发送数据"); //使用连接发送数据
	  alert("客户端数据发送中...");
	};

	// 接收服务端数据时触发事件
	ws.onmessage = function (evt) {
	  var received_msg = evt.data;
	  //alert("服务端发来的数据已接收...");
	  console.log("服务端发来的数据已接收...");
	};

	// 断开 web socket 连接成功触发事件
	ws.onclose = function () {
	  alert("连接已关闭...");
	};

}
</script>

</html>