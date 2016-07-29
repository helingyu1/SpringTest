<%@ page language="java" contentType="text/html; charset=utf-8"
      pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Pushlet Test</title>
<meta http-equiv="pragma" content="no-cache"> 
<meta http-equiv="cache-control" content="no-cache">
<base href="<%=request.getContextPath()%>">
 <script type="text/javascript" src="/Spring/ajax-pushlet-client.js"></script>
      
      <script type="text/javascript">
          //初始化pushlet客户端
           PL._init();
        //设定运行时显示调试信息，不需要时，直接删掉即可
          // PL.setDebug(true);
        //设定监听主题：/guoguo/helloworld，与服务器端的主题完全一致
           PL.joinListen('/hly/helloworld');
        //接收到事件后，显示服务器信息
           function onData(event) {
           		alert(event.get("hw"));
           }
      </script>
</head>
<body>
      <h1>Pushlet Test</h1>
</body>
</html>