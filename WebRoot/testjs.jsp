<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>这是一个测试页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
	<script type="text/javascript">
		function testAjaxS(){
		alert("hahah");
		var dt = {
			name:"helingyu",
			age:25
		};
		 $.ajax({ 
		 	type:"POST",
		  	url:"http://localhost:8080/Spring/timeline/showFocusTL",
		  	dataType : "JSON",
		  	contentType:"application/json;charset=UTF-8",
		  	data:JSON.stringify(dt), 
		   	success:function(data){//返回json结果 
		   	
		  	}
		   });
		  }
	</script>

  </head>
  
  <body onload="testAjaxS()">
    
  </body>
</html>
