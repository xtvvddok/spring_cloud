<%@page contentType="text/html; charset=UTF-8"%>
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

<link rel="stylesheet" href="${root }/resources/assets/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="${root }/resources/assets/css/bootstrap-table.css"
	class="loadfile" />
	<link href="${root }/resources/css/style.css" rel="stylesheet" type="text/css" />
	<link href="${root }/resources/pagin/style.css" rel="stylesheet" type="text/css" />
		<link href="${root }/resources/css/buttons.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" href="${root }/resources/assets/css/bootstrap.min.css" />
<script type="text/javascript"
	src="${root }/resources/js/jquery-2.1.4.min.js"></script>
<script src="${root}/resources/assets/js/bootstrap.min.js"
	class="loadfile"></script>
<script src="${root}/resources/assets/js/bootstrap-table.min.js"
	class="loadfile"></script>
<script src="${root}/resources/assets/js/bootstrap-table.js"
	class="loadfile"></script>
<script src="${root}/resources/assets/js/bootstrap-table-zh-CN.js"
	class="loadfile"></script>
<script src="${root}/resources/pagin/pagination.min.js"
	class="loadfile"></script>
	<style type="text/css">
		
	</style>
<script>

$(function(){	
//导航切换
	$(".imglist li").click(function(){
		$(".imglist li.selected").removeClass("selected")
		$(this).addClass("selected");
	})	
})	
</script>
<script type="text/javascript">


	</script>
</head>
<body>
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">首页</a></li>
			<li><a href="#">图片列表</a></li>
		</ul>
	</div>
	<div class="rightinfo" align="center" style="text-align: center;">
	
	<input type="hidden" id="id" value="${id }">
	<input type="hidden" id="city_code" value="${city_code }">
	<ul class="imglist" style="margin-left: 20%;">
	
    <li class="selected" onclick="viewtype(1);">
    <span><img src="${root}/resources/images/img01.png" /></span>
    <label style="font-size: 24px;color:#428bca"><strong>咨询管理</strong></label>
    </li>
    
    <li onclick="viewtype(2);">
    <span><img src="${root}/resources/images/img02.png" /></span>
  	<label style="font-size: 24px;color:#428bca"><strong>活动管理</strong></label>
    </li>
    
    <li onclick="viewtype(3);">
    <span><img src="${root}/resources/images/img03.png" /></span>
   	<label style="font-size: 24px;color:#428bca"><strong>路线管理</strong></label>
    </li>
    
    <li onclick="viewtype(4);">
    <span><img src="${root}/resources/images/img04.png" /></span>
    <label style="font-size: 24px;color:#428bca"><strong>简介管理</strong></label>
    </li>
    
    <li >
    <span><img src="${root}/resources/images/img05.png" /></span>
   <label style="font-size: 24px;color:#428bca"><strong>预览</strong></label>
    </li>
    </ul>
    </div>
        
    <div class="leftinfo">
    	<div class="listtitle"><a href="#" class="more1">更多</a>数据统计</div>
    </div>
</body>
<script>
function viewtype(num){
// 	alert(num);
	var city_code = '${city_code}';
	if(num == 1){
		window.location.href = '${root}/manage/news_list?city='+city_code;
	}
	if(num == 2){
		window.location.href = '${root}/manage/activity_list?city='+city_code;
	}
	if(num == 4){
		window.location.href = '${root}/manage/menu_list?city='+city_code;
	}
}
</script>
</html>