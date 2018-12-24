<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%> 
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
		<meta charset="utf-8">
		<link rel="stylesheet" href="resources/front/css/common.css" />
		<link rel="stylesheet" href="resources/front/css/skin.css" />
		<title>404报错页面</title>
	</head>
	<body class="bg-404">
<!-- 		<a href="index.html" class="return404">返回首页</a> -->
			404报错页面
	</body>
</html>

	