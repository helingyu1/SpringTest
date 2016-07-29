<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'homepage.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript"
	src="https://code.jquery.com/jquery-2.2.0.min.js"></script>
<script type="text/javascript"
	src="http://ichord.github.io/Caret.js/src/jquery.caret.js"></script>
<script type="text/javascript" src="js/jquery.atwho.js"></script>
<!-- 
<link href="css/jquery.atwho.css" rel="stylesheet">-->
<script type="text/javascript">
	function show(div) {
		alert(div);
		document.getElementById(div).style.display = "block";
	}
	function disapear() {
		document.getElementById(div).style.display = "none";
	}
</script>

<script type="text/javascript">
	var arr = new Array();
	$(function() {
		getJson();
	});
	function getJson() {
		var mydata = "蛋花汤汤";
		$.ajax({
			type : 'POST',
			dataType : 'json',
			contentType : 'application/json',
			url : '/Spring/user/mentionlist.do',
			data : JSON.stringify(mydata),
			//data : mydata,
			success : function(data) {
				alert("成功了，哈哈哈" + data.length);
				var dataObj = eval(data);
				for ( var i = 0; i < dataObj.length; i++) {
					alert(dataObj[i].u_nick);
					window.arr.push(dataObj[i].u_nick);
				}
			}
		});
	}
	$(function() {
		alert(window.arr.length);
		$('#content').atwho({
			at : "@",
			data : [ 'Peter', 'Tom', 'Anne' ]
			//data : a.arr
		});
	});
</script>

</head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<body>
	您好，${sessionScope.username},欢迎来到^_^微博

	<form method="post" name="form1" action="blog/publish">
		<textarea id="content" cols="50" rows="3" name="ta1">输入微博内容
		</textarea>
		<input type="submit" value="发布" name="submit">
	</form>

	<form method="post" name="form2" action="user/searchUser">
		<input type="text" value="输入用户昵称" name="text1"> <input
			type="submit" value="搜索" name="search"> ${message }
	</form>

	<form method="post" name="form3" action="user/showFocus">
		<input type="submit" value="查看我的关注" name="focus">
	</form>

	<form method="post" name="form4" action="user/showFans">
		<input type="submit" value="查看我的粉丝" name="fans">
	</form>
	<ul>
		<c:forEach items="${sessionScope.blogList }" var="per"
			varStatus="status">
			<li><a href="/Spring/user/${per.b_uname}">${per.b_uname }</a><br>
				<p id="b_id">
					${per.b_time }<br>
				<p id="b_content">
					${per.b_content }<br>
				<p id="count">
					div${status.count }<br>
					<button name="keepBtn">收藏</button>
					<button name="turnBtn">转发</button>
					<button name="gdBtn">点赞</button>
				<div id="div${status.count }" style="display:none">
					<form name="form5" action="comment/${per.b_id }" method="post">
						<textarea rows="3" cols="50" name="comment">
			  				请输入评论内容
			  		</textarea>
						<input type="submit" name="submit" value="评论"
							onClick="disapear('div${status.count}')">
					</form>
				</div>
				<hr></li>
		</c:forEach>
	</ul>
</body>
</html>
