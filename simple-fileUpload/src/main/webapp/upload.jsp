<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
	
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>file upload demo</title>
</head>
<body>
	<form action="FileUpload" method="post"
		enctype="multipart/form-data">
		<table width="31%" border="0" align="center">
			<tr bgcolor="#CCCCCC">
				<th height="26">请选择要上传的附件：</th>
			</tr>
			<tr>
				<td><label>上传文件</label><input type="file" name="file" /></td>
			</tr>
			<tr bgcolor="#CCCCCC">
				<td height="23"><input type="submit" name="submit" value="上传"></td>
			</tr>
		</table>
	</form>
	<%
        if (request.getAttribute("result") != null) {
            out.println("<script>alert('" + request.getAttribute("result") + "');</script>");
        }
    %>
</body>
</html>