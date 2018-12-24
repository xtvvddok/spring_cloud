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
		.cib{
            padding: 5px 8px;
        }
        .cib input{
            vertical-align: bottom;
            height: 20px;
            color: #567e84;
            margin: 2px 0px;
        }
        .cib button{
            vertical-align: bottom;
            height: 26px;
            cursor: pointer;
            background-color: #cbefff;
            border: 1px solid #44a8d6;
            color: #567e84;
            margin: 2px 0px;
        }
        .desc{
            padding-left: 8px;
            color: #657e9a;
        }
        .classlist li .lright{
        	width:120px ;
        }
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

	<div class="rightinfo">
    
    <div class="tools">
    
    	<ul class="toolbar">
        <li class="click" onclick="window.location.href = '${root}/manage/city_view'"><span><img src="${root}/resources/images/t01.png" /></span>添加</li>
        <li class="click"><span><img src="${root}/resources/images/t02.png" /></span>修改</li>
        <li><span><img src="${root}/resources/images/t03.png" /></span>删除</li>
        <li><span><img src="${root}/resources/images/t04.png" /></span>统计</li>
        </ul>
        
        
        <ul class="toolbar1">
        <li><span><img src="${root}/resources/images/t05.png" /></span>设置</li>
        </ul>
    
    </div>
    
    
    
    <ul class="classlist">
<!--     <li> -->
<%--     <span><img src="${root}/resources/images/001.jpg" /></span> --%>
<!--     <div class="lright"> -->
<!--     <label style="font-size: 24px"><strong>成都</strong></label> -->
<!--     <p>资讯：共35章<br />活动：7条<br />简介：6篇<br />路线：5条</p> -->
<!--     <a class="enter">进入城市</a> -->
<!--     </div> -->
<!--     </li> -->
    
<!--     <li> -->
<%--     <span><img src="${root}/resources/images/001.jpg" /></span> --%>
<!--     <div class="lright"> -->
<!--     <label style="font-size: 24px"><strong>德阳</strong></label> -->
<!--     <p>资讯：共35章<br />活动：7条<br />简介：6篇<br />路线：5条</p> -->
<!--     <a class="enter">进入城市</a> -->
<!--     </div> -->
<!--     </li> -->
    </ul>
    
    <div class="clear"></div>
<!--     <div class="pagin"> -->
<!--     	<div class="message">共<i class="blue">1256</i>条记录，当前显示第&nbsp;<i class="blue">1&nbsp;</i>页</div> -->
<!--         <ul class="paginList"> -->
<!--         <li class="paginItem"><a href="javascript:;"><span class="pagepre"></span></a></li> -->
<!--         <li class="paginItem"><a href="javascript:;">1</a></li> -->
<!--         <li class="paginItem current"><a href="javascript:;">2</a></li> -->
<!--         <li class="paginItem"><a href="javascript:;">3</a></li> -->
<!--         <li class="paginItem"><a href="javascript:;">4</a></li> -->
<!--         <li class="paginItem"><a href="javascript:;">5</a></li> -->
<!--         <li class="paginItem more"><a href="javascript:;">...</a></li> -->
<!--         <li class="paginItem"><a href="javascript:;">10</a></li> -->
<!--         <li class="paginItem"><a href="javascript:;"><span class="pagenxt"></span></a></li> -->
<!--         </ul> -->
<!--     </div> -->
	<div id="pagination_10"></div>
    
    
    <div class="tip">
    	<div class="tiptop"><span>提示信息</span><a></a></div>
        
      <div class="tipinfo">
        <span><img src="${root}/resources/images/ticon.png" /></span>
        <div class="tipright" >
        <p>是否确认对信息的修改 ？</p>
        <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
        </div>
        </div>
        
        <div class="tipbtn">
        <input name="" type="button"  class="sure" value="确定" />&nbsp;
        <input name="" type="button"  class="cancel" value="取消" />
        </div>
    
    </div>
    
    
    
    
    </div>
	
</body>
<script>


$(function(){
	getData(1,8);
	
});
// function getParam(){
// 	var val = $("#pagination_10").pagination("getPage");
// }
function getData(pid,psize){
	$.ajax({
		   type: "POST",
		   url:"${root}/manage/city_index_page",
		   data:{
			   pid:pid,
			   psize:psize
		   },
		   success: function(data) {
			   var json = eval('(' + data + ')');
// 			   inittable
// 			   var rows = json.rows;
			   var html = inittable(json.rows);
			   $(".classlist").empty();
			   $(".classlist").append(html);
			   initpagin(json.total,pid,psize);
		   }
	 	});
}
function inittable(rows){
	var html='';
	for(var i = 0;i < rows.length;i++){
		html+='<li>';
		html+='<span><img src="'+rows[i].topimage+'" style="width:126px;height:106px;"/></span>';
		html+='<div class="lright" >';
		html+='<label style="font-size: 24px"><strong>'+rows[i].city_name+'</strong></label>';
		html+='<p>资讯：共'+rows[i].newsnum+'章<br />活动：共'+rows[i].citivitynum+'条<br />简介：共'+rows[i].menunum+'篇<br />路线：共'+rows[i].tournum+'条</p>';
		html+='<a class="enter" onclick="viewCity(\''+rows[i].id+'\',\''+rows[i].city_code+'\')">进入城市</a>';
		html+='</div>';
		html+='</li>';   
	}
	return html;
}

function viewCity(id,code){
	window.location.href = '${root}/manage/console?id='+id+"&city="+code;
}
function initpagin(total,pid,psize){
// 	var html='';
// 	html+='<div class="message">共<i class="blue">'+total+'</i>条记录，当前显示第&nbsp;<i class="blue">1&nbsp;</i>页</div>';
// 	html+='<ul class="paginList">';
// 	html+='<li class="paginItem"><a href="javascript:;"><span class="pagepre"></span></a></li>';
// 	html+='<li class="paginItem"><a href="javascript:;"><span class="pagenxt"></span></a></li>';
	$("#pagination_10").pagination({
		pageSizeOpt: [{
	        'value': 8,
	        'text': '8条/页',
	        'selected': true
	    }, {
	        'value': 12,
	        'text': '12条/页'
	    }, {
	        'value': 16,
	        'text': '16条/页'
	    }],
	    css: 'css-2',
// 	    showPageNum:4,
	    totalPage: Math.ceil(total/8),
// 		totalPageText:'共'+total+'页',
// 	    isShowFL:false,
// 	    showPageNum:total,
// 		isShowPageSizeOpt:false,
// 		isShowTotalPage:ture,
	    callBack: function (currPage, pageSize) {
// 	    	alert(total);
	        //console.log('currPage:' + currPage + '     pageSize:' + pageSize);
// 	        alert(('currPage:' + currPage + '     pageSize:' + pageSize));
	       // alert(currPage+"-"+Math.ceil(total/pageSize));
	    	getData(currPage,pageSize);
	    	//$("#pagination").pagination("setPage", currPage, Math.ceil(total/pageSize));
	    }
	});
// 	alert();
}
</script>
</html>