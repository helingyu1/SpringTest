<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'user_logon.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script src="http://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>
 
	
  </head>
  
  <body>
     请输入个人信息info：  
	    <FORM id="form1" action="user/logon.do" method=post> 
	    <table border=1>    
	    <tr>
	        <td><font size=2>用户名：</font></td>
	        <td><Input type="text" name="username"></td>
	       </tr>   
	    <tr>
	    <td><font size=2>密码：</font></td>
	        <td><Input type="password" name="password"></td>       
	    </tr>    
	  </table> <BR>
	  <Input type="submit" name="b" value="登录"> </FORM> 
	  ${message}
  </body>
</html>
