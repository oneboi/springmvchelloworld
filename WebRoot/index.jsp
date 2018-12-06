<%@ page language="java" import="java.util.*"    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>springmvc demo</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
   <form role="form" action="user" method="post">
  <div class="form-group">
    <label for="name">用户名：</label>
    <input type="text" class="form-control"   name ="name" value="king" placeholder="请输入名称">
  </div>
   <div class="form-group">
    <label for="name">密码：</label>
    <input type="password" class="form-control"   name ="age" value="19" placeholder="请输入名称">
  </div>
  
  <div class="form-group">
    <label for="name">密码：</label>
    <input type="text" class="form-control"   name ="address.text"  value="云南"  placeholder="请输入名称">
  </div>
  
  <button type="submit" class="btn btn-default">提交</button>
</form>
   
  </body>
</html>
