<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'user_register.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <script type="text/javascript">
  	function check()
  	{
  		var username = document.form1.username.value;
	 	var email = document.form1.email.value;
	 	var age = document.form1.age.value;
	 	var phone = document.form1.phone.value;
	 	var password = document.form1.password.value;
	 	var password2 = document.form1.password2.value;
	 	if(username==""||email==""||age==""||phone==""||password==""||password2==""){
	 		alert("输入信息不能为空！");
	 		return false;
	 	}else if(password!=password2){
	 		alert("两次输入密码不一致");
	 		return false;
	 	}
	 	return true;
  	}
  
  </script>
  
  <body>
   	 请注册：  
	    <FORM id="form1" name="form1" action="user/register" method=post onsubmit="return check()"> 
	    <table border=1>    
	    <tr>
	        <td><font size=2>用户名：</font></td>
	        <td><Input type="text" name="username"></td>
	       </tr>   
	    <tr>
	    <td><font size=2>密码：</font></td>
	        <td><Input type="password" name="password"></td>       
	    </tr> 
	    <tr>
	    <td><font size=2>确认密码：</font></td>
	        <td><Input type="password" name="password2"></td>       
	    </tr>   
	    <tr>
	    <td><font size=2>性别：</font></td>      
	    <td><Input type="text" name="sex"></td>       
	    </tr>
	    <tr>
	    <td><font size=2>昵称：</font></td>      
	    <td><Input type="text" name="nick"></td>       
	    </tr>      
	    <tr>
	    <td><font size=2>年龄：</font></td>       
	    <td><Input type="text" name="age"></td>       
	    </tr> 
	    <tr>
	    <td><font size=2>邮箱：</font></td>       
	    <td><Input type="text" name="email"></td>       
	    </tr>
	    <tr>
	    <td><font size=2>手机：</font></td>       
	    <td><Input type="text" name="phone"></td>       
	    </tr>      
	  </table> <BR>
	  <Input type="submit" name="b" value="注册"> </FORM> 
  </body>
</html>
