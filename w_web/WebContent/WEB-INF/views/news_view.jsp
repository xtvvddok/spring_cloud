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
		<meta charset="utf-8" />
		<meta http-equiv ="proma" content = "no-cache"/>
		 <meta http-equiv="cache-control" content="no cache" />
		 <meta http-equiv="expires" content="0" />
		<title>首页</title>
	<link href="${root }/resources/css/style.css" rel="stylesheet" type="text/css" />
<%-- 	<link href="${root }/resources/css/buttons.css" rel="stylesheet" type="text/css" /> --%>
<%-- 	<link rel="stylesheet" href="${root }/resources/assets/css/bootstrap.min.css" /> --%>
	<link rel="stylesheet" href="${root}/resources/imgJs/css/images.css" />
	<script type="text/javascript" src="${root }/resources/js/jquery-2.1.4.min.js"></script>
	<script type="text/javascript" src="${root}/resources/imgJs/images.1.0.js"></script>
	<style type="text/css">
	.btn_img{
	    width: 137px;
	    height: 34px;
	    background: url('${root}/resources/images/add.png') no-repeat;
	    font-size: 14px;
	    font-weight: bold;
 	    color: #fff; 
	    cursor: pointer;
	}
	label{
		text-align: left;
	}
	</style>
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">表单</a></li>
    </ul>
    </div>
    <div class="formbody">
    <div class="formtitle"><span>基本信息</span></div>
    <form id="form">

    <ul class="forminfo">
    <li><label >咨询标题</label><input name="title" type="text" class="dfinput" /><i>标题不能超过30个字符</i></li>
    <li>
    	<label style="height:230px;">导航图</label>
		<input name="" id="checkfile" type="button" class="btn" style="overflow:hidden" value="选择图片"/>
		<span id="divimg" class="div_list divimg divli" style="background:	#F8F8F8;"></span>
	</li>
	<li>
    	<label style="height:230px;">头图</label>
		<input name="" id="checkfile1" type="button" class="btn" style="overflow:hidden" value="选择图片"/>
		<span id="divimg1" class="div_list divimg divli" style="background:	#F8F8F8;"></span>
	</li>
    <li><label>&nbsp;</label></li>
     <li><label>&nbsp;</label><input name="" type="button" class="btn" value="确认保存" onclick="savenews();"/></li>
    </ul>
     </form>
    </div>
   
</body>
<script type="text/javascript">
var file = $("#divimg").Imagefile({
	checkfile:'checkfile',
	btn:false,
	title:false,
	model:"single",
	value:"navigational"
	
});
var file1 = $("#divimg1").Imagefile({
	checkfile:'checkfile1',
	btn:false,
	title:false,
	model:"single",
	value:"topimage"
});
function savenews(){
	alert($("form").serialize());
	$.ajax({
	   type: "POST",
	   url:"${root}/manage/saveNews",
	   data:$("form").serialize(),
	   success: function(data) {
		   var json = eval('(' + data + ')');
		   if(json.status="1"){
			   alert(json.msg);
// 			   var order_no = json.result.order_no;
// 			   window.location.href="${root}/interface/api/getOrderPayList?order_no="+order_no;
		   } else {
			   alert(json.msg);
		   }
		   
	   }
 	});
}
</script>
</html>
