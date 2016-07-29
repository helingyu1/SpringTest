<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>at.js demo</title>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/jquery.atwho.css">

<script type="text/javascript"
	src="https://code.jquery.com/jquery-2.2.0.min.js"></script>
<script type="text/javascript"
	src="http://ichord.github.io/Caret.js/src/jquery.caret.js"></script>
<script type="text/javascript" src="js/jquery.atwho.js"></script>
<script type="text/javascript">
	$(function() {
		alert("111");
		$('.inputor').atwho({
			at : "@",
			data : [ "aaa", "bbb", "ccc","呵呵呵" ]
		});
	});
</script>
</head>
<body>
	<input id="inputor" class="inputor" name="at"
		style="width:1000px;height:30px;" />
</body>
</html>
