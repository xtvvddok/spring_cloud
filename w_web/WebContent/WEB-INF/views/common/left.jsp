<%@page contentType="text/html; charset=UTF-8" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("root", path);  
%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<title>首页</title>
		<link href="${root }/resources/css/style.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${root }/resources/js/jquery-2.1.4.min.js"></script>
		<script type="text/javascript">
		$(function(){	
			//导航切换
			$(".menuson li").click(function(){
				$(".menuson li.active").removeClass("active")
				$(this).addClass("active");
			});
			
			$('.title').click(function(){
				var $ul = $(this).next('ul');
				$('dd').find('ul').slideUp();
				if($ul.is(':visible')){
					$(this).next('ul').slideUp();
				}else{
					$(this).next('ul').slideDown();
				}
			});
		})	
		</script>
</head>

<body style="background:#f0f9fd;">
	<div class="lefttop"><span></span>通讯录</div>
    
    <dl class="leftmenu">
        
    <dd>
    <div class="title">
    <span><img src="${root }/resources/images/leftico01.png" /></span>管理信息
    </div>
    	<ul class="menuson">
        <li class="active"><cite></cite><a href="index.html" target="rightFrame">首页模版</a><i></i></li>
        <li ><cite></cite><a href="${root }/manage/news_list" target="rightFrame">资讯列表</a><i></i></li>
        <li ><cite></cite><a href="${root }/manage/activity_list" target="rightFrame">活动列表</a><i></i></li>
        <li ><cite></cite><a href="${root }/manage/city_list" target="rightFrame">城市概况</a><i></i></li>
        <li ><cite></cite><a href="${root }/manage/news_list" target="rightFrame">精彩路线</a><i></i></li>
<%--         <li><cite></cite><a href="imgtable.html" target="rightFrame">图片数据表</a><i></i></li> --%>
<%--         <li><cite></cite><a href="form.html" target="rightFrame">添加编辑</a><i></i></li> --%>
<%--         <li><cite></cite><a href="imglist.html" target="rightFrame">图片列表</a><i></i></li> --%>
<%--         <li><cite></cite><a href="imglist1.html" target="rightFrame">自定义</a><i></i></li> --%>
<%--         <li><cite></cite><a href="tools.html" target="rightFrame">常用工具</a><i></i></li> --%>
<%--         <li><cite></cite><a href="filelist.html" target="rightFrame">信息管理</a><i></i></li> --%>
<%--         <li><cite></cite><a href="tab.html" target="rightFrame">Tab页</a><i></i></li> --%>
<%--         <li><cite></cite><a href="error.html" target="rightFrame">404页面</a><i></i></li> --%>
        </ul>    
    </dd>
        
    
<!--     <dd> -->
<!--     <div class="title"> -->
<%--     <span><img src="${root }/resources/images/leftico02.png" /></span>其他设置 --%>
<!--     </div> -->
<!--     <ul class="menuson"> -->
<%--         <li><cite></cite><a href="#">编辑内容</a><i></i></li> --%>
<%--         <li><cite></cite><a href="#">发布信息</a><i></i></li> --%>
<%--         <li><cite></cite><a href="#">档案列表显示</a><i></i></li> --%>
<!--         </ul>      -->
<!--     </dd>  -->
    
    
<%--     <dd><div class="title"><span><img src="${root }/resources/images/leftico03.png" /></span>编辑器</div> --%>
<!--     <ul class="menuson"> -->
<%--         <li><cite></cite><a href="#">自定义</a><i></i></li> --%>
<%--         <li><cite></cite><a href="#">常用资料</a><i></i></li> --%>
<%--         <li><cite></cite><a href="#">信息列表</a><i></i></li> --%>
<%--         <li><cite></cite><a href="#">其他</a><i></i></li> --%>
<!--     </ul>     -->
<!--     </dd>   -->
    
    
<%--     <dd><div class="title"><span><img src="${root }/resources/images/leftico04.png" /></span>日期管理</div> --%>
<!--     <ul class="menuson"> -->
<%--         <li><cite></cite><a href="#">自定义</a><i></i></li> --%>
<%--         <li><cite></cite><a href="#">常用资料</a><i></i></li> --%>
<%--         <li><cite></cite><a href="#">信息列表</a><i></i></li> --%>
<%--         <li><cite></cite><a href="#">其他</a><i></i></li> --%>
<!--     </ul> -->
<!--     </dd>    -->
    </dl>
</body>
</html>
