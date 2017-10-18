<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@page contentType="text/html;charset=GB2312"%>

<html>
<head>
<title>转换器示范</title>
</head>
<f:view>
	<body>
		设定的日期是：
		<b> <h:outputText value="#{user.date}">
				<f:convertDateTime pattern="dd/MM/yyyy" />
			</h:outputText>
		</b>
		<h:form>
			<h:inputText id="dateField" value="#{user.date}">

				<f:convertDateTime pattern="yyyyMMdd" />
			</h:inputText>
			<h:message for="dateField" style="color:red" />
			<br>
			<h:commandButton value="送出" action="show" />
		</h:form>
</f:view>
</body>
</html>
