<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<%@page contentType="text/html; charset=UTF-8"%>
<%@page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("root", path);  
%>

<html >
<head>

<title>首页</title>
</head>
<frameset rows="88,*" cols="*" frameborder="no" border="0" framespacing="0">

  <frame src="${root }/manage/top" name="topFrame" scrolling="no" noresize="noresize" id="topFrame" title="topFrame" />
  <frameset cols="187,*" frameborder="no" border="0" framespacing="0">
    <frame src="${root }/manage/left" name="leftFrame" scrolling="no" noresize="noresize" id="leftFrame" title="leftFrame" />
    <frame src="${root }/manage/index" name="rightFrame" id="rightFrame" title="rightFrame" />
  </frameset>
  <noframes>
<body>
</body>
</noframes>
</frameset>

</html>
