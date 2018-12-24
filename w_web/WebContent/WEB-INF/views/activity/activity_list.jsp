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
				<li class="click" onclick="addnews();"><span><img src="${root}/resources/images/t01.png" /></span>添加</li>
<%-- 				<li class="click"><span><img src="${root}/resources/images/t02.png" /></span>修改</li> --%>
<%-- 				<li><span><img src="${root}/resources/images/t03.png" /></span>删除</li> --%>
<%-- 				<li><span><img src="${root}/resources/images/t04.png" /></span>统计</li> --%>
			</ul>


			<ul class="toolbar1">
				<li><span><img src="${root}/resources/images/t05.png" /></span>设置</li>
			</ul>

		</div>
<!-- 		 <table class="imgtable"> -->
<!-- 		 </table> -->
		 
		 <table class="table table-hover " id="tabletemp" data-pagination="true" >  
		      <thead> 
			        <tr>
<!-- 			        	<th data-field="id" data-checkbox="true" data-valign="middle"></th> -->
			        	<th data-field="state" data-checkbox="true"></th>
						<th data-field="id" data-align="left" data-visible="false">ID</th>
			        	<th data-field="topimage" data-align="center" data-formatter="showimg"  data-width="120" data-valign="middle">头图</th>
			            <th data-field="title" data-align="center" data-formatter="showtitle"  data-valign="middle" data-width="200">标题</th>
			            <th data-field="status" data-align="center" data-formatter="showstatus"  data-valign="middle" data-width="60">状态</th>
			            <th data-field="create_time" data-align="center"   data-valign="middle" data-width="120">创建时间</th>
			            <th data-field="create_user" data-align="center"   data-valign="middle" data-width="120">创建人</th>
			            <th data-field="pub_time" data-align="center"   data-valign="middle" data-width="120">发布时间</th>
			            <th data-field="pub_user" data-align="center"   data-valign="middle" data-width="120">发布人</th>
						<th data-field="make" data-align="center"  data-formatter="makeFormatter"  data-width="230" data-valign="middle">操作</th>
			        </tr>
			 </thead>
		     <tbody>  
		     </tbody>
		</table>  
		
	</div>
	
</body>
<script>
		function addnews(){
			window.location.href = '${root}/manage/activity_view?city=${city_code}';
		}
		$(function(){
// 			alert(1);
			initTable();
		});
		function initTable(){
		    //先销毁表格  
		    $("#tabletemp").bootstrapTable('destroy');  
		    //初始化表格,动态从服务器加载数据  
		    $("#tabletemp").bootstrapTable({  
		        method: "get",  //使用get请求到服务器获取数据  
		        url: '${root}/manage/activity_page', //获取数据的Servlet地址  
		        striped: true,  //表格显示条纹  
		        pagination: true, //启动分页  
		        pageSize: 10,  //每页显示的记录数  
		        pageNumber:1, //当前第几页  
		        pageList: [5, 10, 15, 20, 25],  //记录数可选列表  
		        search: false,  //是否启用查询  
		        sidePagination: "server", //表示服务端请求  
		        //设置为undefined可以获取pageNumber，pageSize，searchText，sortName，sortOrder  
		        //设置为limit可以获取limit, offset, search, sort, order  
		        queryParamsType : "undefined",   
		        queryParams: function queryParams(params) {   //设置查询参数  
		        	 var param = {    
				              pid: params.pageNumber,    
				              psize: params.pageSize,
				              city:'${city_code}'
				          };    
				          return param;   
		          return param;      
//		         queryParams:queryParams
		        },
		         onLoadSuccess: function(data){  //加载成功时执行  
// 		         	alert(data.total);
		         }
//		         onLoadError: function(){  //加载失败时执行  
//		         	alert("加载数据失败");  
//		         }  
		      });  
		  }  
		function showimg(value, row, index){
			return '<img src="'+value+' " width="100px" height="80px;" style="margin: 5px 10px 5px 0;" class="img"/ >';
		}
		function showtitle (value, row, index){
			var v = value;
			if(value.lenght > 20){
				v = v.substring(0,20)+"...";
			} 
			return "<p>"+v+"</p>";
		}
		function showstatus(value, row, index){
			if(value==0){
				return '<label style="color: red;"><b>未发布</b></label>';
			} else if(value==1){
				return '<label style="color: greed;"><b>发布</b></label>';
			}
		}
		/***
		 * 操作按钮
		 */
		function makeFormatter(value, row, index) {
			var html = "";
			if(row.status == '0'){
				html+='<button type="button" onclick="pubOrDown(\''+row.id+'\',1)" class="btn btn-success btn-xs"><span class="glyphicon glyphicon-arrow-up"></span>发布 </button>&nbsp;';
			}
			if(row.status == '1'){
				html+='<button type="button" onclick="pubOrDown(\''+row.id+'\',0)" class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-arrow-down"></span>下架 </button>&nbsp;';
			}
			html+='<button type="button" onclick="view(\''+row.id+'\')" class="btn btn-info btn-xs"><span class="glyphicon glyphicon-search"></span> 编辑  </button>&nbsp;';
			html+='<button type="button" onclick="del(\''+row.id+'\')" class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-remove-circle"></span>删除</button>&nbsp;';
			html+='<button type="button" onclick="contentManage(\''+row.id+'\')" class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-picture"></span>内容</button>&nbsp;'
// 			html+='<button type="button" onclick="view(\''+row.id+'\')" class="btn btn-info btn-xs"><span class="glyphicon glyphicon-search"></span> 预览  </button>';
			return html;
		}
		function contentManage(id){
			window.location.href = '${root}/manage/activity_content_list?n_id='+id;
		}
		function view(id){
			window.location.href = '${root}/manage/activity_view?city=${city_code}&id='+id;
		}
		function pubOrDown(id,num){
			$.ajax({
			   type: "POST",
			   url:"${root}/manage/pubActivityOrDown",
			   data:{
				   id:id,
				   status:num
			   },
			   success: function(data) {
				   var json = eval('(' + data + ')');
				   if(json.status="1"){
					   alert(json.msg);
					   initTable();
				   } else {
					   alert(json.msg);
				   }
				   
			   }
		 	});
		}
		function del(id){
			$.ajax({
			   type: "POST",
			   url:"${root}/manage/activity_del",
			   data:{
				   id:id
			   },
			   success: function(data) {
				   var json = eval('(' + data + ')');
				   if(json.status="1"){
					   alert(json.msg);
					   initTable();
				   } else {
					   alert(json.msg);
				   }
				   
			   }
		 	});
		}
		</script>
</html>