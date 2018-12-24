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
<meta charset="utf-8" />
<meta http-equiv="proma" content="no-cache" />
<meta http-equiv="cache-control" content="no cache" />
<meta http-equiv="expires" content="0" />
<title>首页</title>
<%-- 	<link href="${root }/resources/css/style.css" rel="stylesheet" type="text/css" /> --%>
<%-- <link href="${root }/resources/css/buttons.css" rel="stylesheet" type="text/css" /> --%>
<%-- <link rel="stylesheet" href="${root }/resources/assets/css/bootstrap.min.css" /> --%>
<link href="http://cdn.bootcss.com/twitter-bootstrap/2.0.4/css/bootstrap.min.css" rel="stylesheet">
<link href="http://cdn.bootcss.com/twitter-bootstrap/2.0.4/css/bootstrap-responsive.min.css" rel="stylesheet">
<link rel="stylesheet" href="${root}/resources/imgJs/css/images.css" />
<script type="text/javascript"
	src="${root }/resources/js/jquery-2.1.4.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${root}/resources/imgJs/jquery-ui.js"></script>

<style>
body {
/* 	padding-top: 60px; */
	/* 60px to make the container go all the way to the bottom of the topbar */
/* 	padding-bottom: 10px; */
}

#components {
	min-height: 600px;
}

#target {
	min-height: 200px;
	border: 1px solid #ccc;
	padding: 5px;
	padding-bottom:25px;
}

#target .component {
	border: 1px solid #fff;
}

#temp {
	width: 500px;
	background: white;
	border: 1px dotted #ccc;
	border-radius: 10px;
}

.popover-content form {
	margin: 0 auto;
	width: 213px;
}

.popover-content form .btn {
	margin-right: 10px
}

#source {
	min-height: 500px;
}
.place {
	height: 40px;
	background: url(${root }/resources/images/righttop.gif) repeat-x;
}

.place span {
	line-height: 40px;
	font-weight: bold;
	float: left;
	margin-left: 12px;
}

.placeul li {
	float: left;
	line-height: 40px;
	padding-left: 7px;
	padding-right: 12px;
	background: url(${root }/resources/images/rlist.gif) no-repeat right;
}

.placeul li:last-child {
	background: none;
}
.tmp{
	margin-bottom: 5px;
	padding-top: 2px;
	padding-bottom: 2px;
}
.tmpclick{
	border:2px dashed #D8D8D8; 
}
/* .right_btn { */
/*   position: relative; */
/*   right: 2px; */
/*   top: 5px; */
/* } */
/* .right_btn{ */
/* 	position: absolute; */
/* 	bottom: 0; */
/* 	right: 0; */
/* 	width: 200px; */
/* 	text-align: center; */
/* 	line-height: 25px; */
/* 	background-color: rgba(0, 0, 0, 0.5); */
/* 	border-radius: 0 0 15px 15px; */
/* } */
/* .divbtn{ */
/* 	position: fixed ; */
/* 	top:25px; */
/* 	z-index: 999; */
/* } */
.btn-list{
	margin-bottom: 3px;
}
</style>
</head>

<body>
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">首页</a></li>
			<li><a href="#">图片列表</a></li>
		</ul>
	</div>
	<div class="container">
		<div class="row clearfix">
			<div class="span6">
				<div class="clearfix">
					<h2>资讯内容</h2>
					
					<hr>
					<div id="build" >
						<input type="hidden" id="n_id" name="n_id" value='${news.id }' />
						<form id="target" class="form-horizontal" >
							
							<legend class="valtype" data-valtype="text" style="text-align: center">${news.title }</legend>
							<c:forEach var="content" items="${contents}">
								<c:if test="${content.type==1 }">
									<div style=" position: relative;"  align="center" class="ui-state-default tmp">
										<img alt="" src="${content.content }" width="350px;" height="190px;" class="tmpimg">
										<input name="content" type="hidden" value="${content.content }">
										<input name="type" type="hidden" value="1">
										<input name="id" type="hidden" value="${content.id }">
										<div style="text-align: center; position:absolute;width: 60px;left:-68px; top:-2px;display:none;z-index: 99" class="makebtn">
											<button type="button" class="btn btn-default btn-xs btn-list btn-img-check" style="width: 60px;"><span class="glyphicon glyphicon-picture"></span>选择</button>
											<button type="button" class="btn btn-default btn-xs btn-list btn-img-remove" style="width: 60px;"><span class="glyphicon glyphicon-picture"></span>删除</button>
										</div>
									</div>
								</c:if>
								<c:if test="${content.type ==2 }">
									<div  style=" position: relative;"  align="center" class="ui-state-default textdiv tmp">
										<div style="width:350px;min-height:15px;border:1px solid  #F0F0F0;text-align: left;font-size: 15px; " class="textcontent"  contenteditable=true >
										${content.content }
										</div>
										<input name="content" type="hidden" value="${content.content }">
										<input name="type" type="hidden" value="2">
										<input name="id" type="hidden" value="${content.id }">
										<div style="text-align: center; position:absolute;width: 60px;left:-68px; top:-2px;display:none;z-index: 99" class="makebtn">
											<div class="btn-group-vertical">
												<button type="button" class="btn btn-default btn-text-empty" style="width: 60px;">清空</button>
												<button type="button" class="btn btn-default btn-text-remove" style="width: 60px;">删除</button>
											</div>
										</div>
									</div>
								</c:if>
							</c:forEach>
						</form>
					</div>
				</div>
				<span>
					<button type="button" onclick="sortdiv(1);" id="startsort" class="btn btn-default btn-xs sortdiv"><span class="glyphicon glyphicon-picture"></span>开始排序</button>
					<button type="button" onclick="sortdiv(2);" id="endsort" style="display:none;" class="btn btn-danger btn-xs sortdiv"><span class="glyphicon glyphicon-picture"></span>锁定排序</button>
					&nbsp;&nbsp;<label id="starttext" style="color: red;">注：【开始排序】后无法编辑内容，【锁定排序】即可</label>
				</span>
				<div style="text-align: center;width:100%" >
					<button type="button" onclick="save()"  class="btn btn-primary btn-sm">保存</button>
				</div>
			</div>
		   <div class="span6">
            <h2>元素</h2>
            <hr>
            <ul id="myTab" class="nav nav-tabs">
				<li class="active">
					<a href="#home" data-toggle="tab">
						 图片设置
					</a>
				</li>
				<li><a href="#ios" data-toggle="tab">文字设置</a></li>
			</ul>
			<div id="myTabContent" class="tab-content">
				<div class="tab-pane fade in active" id="home">
					<button type="button" onclick="addimage();" id="addimage" class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-picture"></span>图片</button>
					<input type="file" id="addimagefile"  style="display:none;" onclick="selectImage();" multiple="multiple">
				</div>
				<div class="tab-pane fade" id="ios">
					<button type="button" onclick="addtext();" class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-picture"></span>文字</button>
				</div>
			</div>
           </div>
			<!-- row -->
		</div>
	</div>
		<!-- /container -->
	<div id="imagetmp" style="display:none;  position: relative;"  align="center" class="ui-state-default">
		<img alt="" src="" width="350px;" height="190px;" >
		<input name="content" type="hidden">
		<input name="type" type="hidden" value="1">
		<input name="id" type="hidden" value="0">
		<div style="text-align: center; position:absolute;width: 60px;left:-68px; top:-2px;display:none;z-index: 99" class="makebtn">
			<button type="button" class="btn btn-info btn-xs btn-list btn-img-check" style="width: 60px;"><span class="glyphicon glyphicon-picture"></span>选择</button>
			<button type="button" class="btn btn-info btn-xs btn-list btn-img-remove" style="width: 60px;"><span class="glyphicon glyphicon-picture"></span>删除</button>
		</div>
	</div>
	<div id="texttmp" style="display:none; position: relative;"  align="center" class="ui-state-default textdiv">
		<div style="width:350px;min-height:15px;border:1px solid  #F0F0F0;text-align: left;font-size: 15px; " class="textcontent"  contenteditable=true >
		</div>
		<input name="content" type="hidden">
		<input name="type" type="hidden" value="2">
		<input name="id" type="hidden" value="0">
		<div style="text-align: center; position:absolute;width: 60px;left:-68px; top:-2px;display:none;z-index: 99" class="makebtn">
				<div class="btn-group-vertical">
				<button type="button" class="btn btn-default btn-text-empty" style="width: 60px;">清空</button>
				<button type="button" class="btn btn-default btn-text-remove" style="width: 60px;">删除</button>
<!-- 				<div class="btn-group-vertical"> -->
<!-- 					<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown"> -->
<!-- 						设置 -->
<!-- 						<span class="caret"></span> -->
<!-- 					</button> -->
<!-- 					<ul class="dropdown-menu"> -->
<!-- 						<li><a href="#">下拉链接 1</a></li> -->
<!-- 						<li><a href="#">下拉链接 2</a></li> -->
<!-- 					</ul> -->
<!-- 				</div> -->
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">

function setTextValue(){
	$("#target").find(".textdiv").each(function(){
		$(this).find("input[name='content']").val($(this).find(".textcontent").html());
	})
}
function checkNull(){
	var flag = true;
	$("#target").find(".textcontent").each(function(){
		var html = $(this).html().replace(/[\r\n]/g, "");
		if(html == "" || html == null){
			flag = false;
		}
	});
	return flag;
}

function save(){
	setTextValue();
	alert($("#target").serializeJson());
	if(checkNull()){
		$.ajax({
		   type: "POST",
		   url:"${root}/manage/saveNewsContent",
		   //contentType : 'application/json;charset=utf-8', //设置请求头信息
   	       //dataType:"json", 
		   //data:$("#target").serializeJson(),
		   data:{
			   n_id:$("#n_id").val(),
			   json : $("#target").serializeJson()
		   },
		   success: function(data) {
			   var json = eval('(' + data + ')');
			   if(json.status="1"){
				   alert(json.msg);
				   location.reload();
			   } else {
				   alert(json.msg);
			   }
			   
		   }
	 	});
	} else {
		alert("请完善内容");
	}
}
var btn_obj;
$(document).on("click",".btn-img-check",function(){
// 	$(this).parent().parent().remove();
	btn_obj = $(this).parent().parent();
// 	addimage();
	
	var input = document.getElementById("addimagefile");
	input.click();
});
$(document).on("click",".btn-text-remove",function(){
	$(this).parent().parent().parent().remove();
});
$(document).on("click",".btn-text-empty",function(){
	$(this).parent().prev().html("");
	var obj = $("#target").clone();
	$("#target").empty();
	$("#target").append($(obj).html());
});
$(document).on("click",".btn-img-remove",function(){
	$(this).parent().parent().remove();
});


function sortdiv(num){
	if(num == 1){
		$(".tmp").addClass("tmpclick");
	 	$("#target").sortable("enable");
	 	$("#target").disableSelection();
	 	$("#startsort").hide();
	 	$("#endsort").show();
	 	$('.makebtn').hide();
	} else {
		$(".tmp").removeClass("tmpclick");
		$("#target").enableSelection();
		$("#target").sortable("disable");
		$("#startsort").show();
	 	$("#endsort").hide();
	 	$('.makebtn').hide();
	}
}


// function clicktext(obj){
// 	$(obj)[0].focus();
// 	var result=$(obj).html();
//     $(obj).html("");
//     $(obj).html(result);
// };



function addtext(){
	var img = $("#texttmp").clone();
	img.attr("id","");
	img.addClass("tmp");
	img.show();
	$("#target").append(img);
}
function addimage(){
	btn_obj = null;
	var input = document.getElementById("addimagefile");
	input.click();
}

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
	if(btn_obj == null){
		var img = $("#imagetmp").clone();
		img.attr("id","");
		img.addClass("tmp");
		img.find("input[name='content']").val(base64);
		img.find("img").attr("src",base64);
		img.find("img").addClass("tmpimg");
		img.show();
		$("#target").append(img);
	} else {
		btn_obj.find("img").attr("src",base64);
		btn_obj.find("input[name='content']").val(base64);
	}
}


$(document).on("click",".tmp",function(){
	var obj = $(this);
	$(this).addClass("tmpclick");
	$(this).find('.makebtn').show();
	$(".tmp").each(function(){
		if(!obj.is($(this))){
			$(this).removeClass("tmpclick");
			$(this).find('.makebtn').hide();
		}
	});
});
$(document).click(function (e) {
	 var e = e || window.event; //浏览器兼容性   
     var elem = e.target || e.srcElement;  
     while (elem) { //循环判断至跟节点，防止点击的是div子元素   
     	 if($(elem).hasClass("tmp") || $(elem).hasClass("tmpimg") ||$(elem).hasClass("sortdiv")){
     		 return;
     	 }
         elem = elem.parentNode;  
     }  
     $(".tmp").removeClass("tmpclick");
     $('.makebtn').hide();
});
 
$(function() {
	$("#target").sortable();
	$("#target").sortable("disable");
	$("#target").enableSelection();
// 	$("#target").find("div").disableSelection();
// 	$("#target").draggable("destory");
});

</script>
<script type="text/javascript">
(function($){
    $.fn.serializeJson = function(){
        var jsonData1 = {};
        var serializeArray = this.serializeArray();
        // 先转换成{"id": ["12","14"], "name": ["aaa","bbb"], "pwd":["pwd1","pwd2"]}这种形式
        $(serializeArray).each(function () {
            if (jsonData1[this.name]) {
                if ($.isArray(jsonData1[this.name])) {
                    jsonData1[this.name].push(this.value);
                } else {
                    jsonData1[this.name] = [jsonData1[this.name], this.value];
                }
            } else {
                jsonData1[this.name] = this.value;
            }
        });
        // 再转成[{"id": "12", "name": "aaa", "pwd":"pwd1"},{"id": "14", "name": "bb", "pwd":"pwd2"}]的形式
        var vCount = 0;
        // 计算json内部的数组最大长度
        for(var item in jsonData1){
            var tmp = $.isArray(jsonData1[item]) ? jsonData1[item].length : 1;
            vCount = (tmp > vCount) ? tmp : vCount;
        }
        if(vCount > 1) {
            var jsonData2 = new Array();
            for(var i = 0; i < vCount; i++){
                var jsonObj = {};
                for(var item in jsonData1) {
                    jsonObj[item] = jsonData1[item][i];
                }
                jsonData2.push(jsonObj);
            }
            return JSON.stringify(jsonData2);
        }else{
            return "[" + JSON.stringify(jsonData1) + "]";
        }
       };
  })(jQuery); 
</script>
</html>
