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
	<link href="${root }/resources/css/buttons.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" href="${root }/resources/assets/css/bootstrap.min.css" />
	<link rel="stylesheet" href="${root}/resources/imgJs/css/images.css" />
	<script type="text/javascript" src="${root }/resources/js/jquery-2.1.4.min.js"></script>
	<script type="text/javascript" src="${root}/resources/imgJs/images.1.0.js"></script>
	<style type="text/css">

	label{
		text-align: left;
	}
	.div_unit {
			padding: 5px;
			width: 300px;
			height: 190px;
			margin: 5px;
			position: relative;
			display: inline-block;
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
	<input type="hidden" name="id" value="${city.id}">
	<input type="hidden" id="city_code" name="city_code" value="${city_code }">
    <ul class="forminfo">
    <li><label >活动标题</label><input name="title" type="text" class="dfinput" value="${city.title }"/><i>标题不能超过30个字符</i></li>
    <li>
    	<label style="height:230px;">背景图</label>
		<input name="" id="checkfile1" ref-id='divimg2' type="button" class="btn" style="overflow:hidden" value="选择图片" onclick="clickImage(this)"/>
		<span id="divimg2" class="div_list divimg divli" style="background:	#F8F8F8;width:350px;height:190px;">
			<img alt="" src="${city.topimage }" width="340px;" height="180px;" >
		</span>
	</li>
    <li>
    	<label style="height:230px;">简介</label>
		<textarea rows="5" cols="" style="width:350px;border: 1px; background-color: #ffffff" name="summary">${city.summary}</textarea>
	</li>
	
    <li><label>&nbsp;</label></li>
     <li><label>&nbsp;</label><input name="" type="button" class="btn" value="确认保存" onclick="savenews();"/></li>
    </ul>
     </form>
<!--      <input type="file" id=""> -->
     <input type="file" id="addimagefile"  style="display:none;" onclick="selectImage();" >
    </div>
   
</body>
<script type="text/javascript">
// var file = $("#divimg").Imagefile({
// 	checkfile:'checkfile',
// 	btn:false,
// 	title:false,
// 	model:"single",
// 	image:'${news.navigational}'
// 	//value:"navigational"
	
// });
// alert('${news.topimage}');
// var file1 = $("#divimg1").Imagefile({
// 	checkfile:'checkfile1',
// 	btn:false,
// 	title:false,
// 	model:"single",
// 	image:'${news.topimage}'
// 	//value:"topimage"
// });
// var IMGID = null;
function clickImage(obj){
// 	IMGID = $(obj).attr("ref-id");
	var input = document.getElementById("addimagefile");
	input.click();
};
function  selectImage(){
    var input = document.getElementById("addimagefile");
//	    var divimg = document.getElementById("divimg");
    if (typeof (FileReader) === 'undefined') {
        result.innerHTML = "抱歉，你的浏览器不支持 FileReader，请使用现代浏览器操作！";
        input.setAttribute('disabled', 'disabled');
        alert("抱歉，你的浏览器不支持 FileReader，请使用现代浏览器操作！");
    } else {
    	input.addEventListener('change', readFile, false);
    }
}
function readFile(){
    for(i = 0;i<this.files.length;i++){
        var file = this.files[i];
        //判断是否是图片类型
        if (!/image\/\w+/.test(file.type)) {
            alert("只能选择图片");
            return false;
        }
        var name = file.name;
        var reader = new FileReader();
        reader.readAsDataURL(this.files[i]);
        var name = this.files[i].name;
        reader.onload = function (e) { 
	        addElementImg(this.result); //参数1：选择图片的base64值 (String)  参数2：title新增图片默认是空    参数3：ID新增图片ID为0
	    }
   	}
}

function addElementImg(base64) {
	$("#divimg2").empty();
	var html = '';
	html+='<img alt="" src="'+base64+'"  width="340px;" height="180px;">';
	html+='<input type="hidden" name="topimage" value="'+base64+'">'
	$("#divimg2").append(html);
	
}


function savenews(){
	$.ajax({
	   type: "POST",
	   url:"${root}/manage/saveActivity",
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
