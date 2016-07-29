<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showfans.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  
  <body>
    粉丝查询成功： <br>
    <table>
    	<tr><th>粉丝昵称</th></tr>
    	<c:forEach var="per" items="${list}">
    		<tr><td><a href="">${per.u_nick }</a></td></tr>
    	</c:forEach>
    </table>
    <a href="/Spring/homepage.jsp">返回</a>
  </body>
</html>
