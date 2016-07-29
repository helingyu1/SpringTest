<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="http://libs.baidu.com/jquery/2.0.0/jquery.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<title>Insert title here</title>
<script type="text/javascript">
	function ajaxTest() {
		var flag = 0;
		$.ajax({
			data : "name=" + $("#name").val(),
			type : "POST",
			dataType : 'json',
			url : "user1/login1.do",
			error : function(data) {
				alert("出错了！！:" + data.msg);
			},
			success : function(data) {
				//alert("success:" + data.msg);
				//if(flag!=data.flag)
					//alert("不一样！");
				$("#result").html(data.flag);
			}
		});
		setTimeout(ajaxTest,5000);
	}
</script>
</head>
<body>
	<input type="text" name="name" id="name" />
	<input type="submit" value="登录" onclick="ajaxTest();" />
	<div id="result"></div>
</body>
</html>
