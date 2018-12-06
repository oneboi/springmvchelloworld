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
  <form  action="upload2"  method="post" enctype="multipart/form-data">
  <div class="form-group">
    <label for="name">名称</label>
    <input type="text" class="form-control" id="name"  name="name" placeholder="请输入名称">
  </div>
<div class="form-group">
    <label for="inputfile">文件输入</label>
    <input type="file" id="inputfile" name="upload">
    <p class="help-block">这里是块级帮助文本的实例。</p>
  </div>
 
  <button type="submit" class="btn btn-default">提交</button>
  <img	src="uploads/4CA8DA3339734026A90A77408973802B_bg_zc.jpg">
</form>
   
  </body>
</html>
