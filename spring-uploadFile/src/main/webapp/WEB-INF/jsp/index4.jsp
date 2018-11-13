<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<!--  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
-->
<title>Insert title here</title>
<link href="<%=path%>/js/jquery-easyui-1.6.7/themes/default/easyui.css" rel="stylesheet" type="text/css" />
<link href="<%=path%>/js/jquery-easyui-1.6.7/themes/icon.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="<%=path%>/js/jquery-3.2.1.js"></script>

<script type="text/javascript" src="<%=path%>/js/jquery-easyui-1.6.7/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/jquery-easyui-1.6.7/easyui-lang-zh_CN.js"></script>



<script type="text/javascript" src="<%=path%>/js/jquery.ocupload-1.1.2.js"></script>

</head>
<body>
<button type="button" id="uploadExcel"">上传Excel</button>
</br>
<!-- 
<input type="button" value="上传" onclick="clickSth()"/>
 -->
</body>
<script type="text/javascript">


function clickSth(){
	alert("Hello kittykittykitty");
	
	
}

$("#uploadExcel").upload({
    
	action:'${pageContext.request.contextPath}/file/upload/WesternMedicine', //表单提交的地址 onSelect :
	
	//name:"myFile",                                //name 默认为file
	//enctype: 'multipart/form-data',                 //mime类型，使用默认就好;enctype默认提交方式为multipart/form-data
	//params: {}，  　　　　　　　　　　　　　　                                   //请求时额外传递的参数，默认是为空的  
	
	
	////提交表单之后  ，此处不正常工作
	onComplete:function(response){
		//alert("数据导入!");
		$.messager.alert("提示","文件上传成功","info");
		
	},
	onSelect:function(){
		//alert(this.action());
		
		//alert(this.name());
		
	    //选中文件关闭自动提交
		this.autoSubmit=false; 
	    //判定文件格式 
	    //var filename=this.filename();  //返回当前选择的文件名称 (ps：我使用这个方法没好使，自己写了一个获取文件的名的方法)
	   
		//var filename=$("[name = '"+this.name()+"']").val();  //
		
		//alert("filename"+filename);
	    var regex=/^.*\.(?:xls|xlsx)$/;

		//通过文件后缀名规定文件类型的正则;
	    if(regex.test($("[name = '"+this.name()+"']").val())){
	        //满足正则表达式
			this.submit();
	    }else{
	    	//alert("wrong file name");
	        $.messager.alert("警告！","请选择Excel文件(以xls|xlsx结尾)","warning");
	    }
	}
	
});

</script>
</html>