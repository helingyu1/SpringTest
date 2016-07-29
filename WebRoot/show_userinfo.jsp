<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'show_userinfo.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    以下是查到的用户信息 <br>
    用户昵称：${user.u_nick }<br>
    用户年龄：${user.u_age }<br>
    用户性别：${user.u_sex }<br>
    用户邮箱：${user.u_email }<br>
    用户手机：${user.u_phone }<br>
	 <form action="user/addFocus" method="post">
 		<input type="submit" value="加为关注" >
    </form>
    <a href="/Spring/homepage.jsp" >返回首页</a>
  </body>
</html>
