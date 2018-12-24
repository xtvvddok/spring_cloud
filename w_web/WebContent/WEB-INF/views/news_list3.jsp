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
		<link rel="stylesheet" href="${root }/resources/assets/css/bootstrap.min.css" />
		<link rel="stylesheet" href="${root }/resources/assets/css/bootstrap-table.css" class="loadfile"/>
		<script type="text/javascript" src="${root }/resources/js/jquery-2.1.4.min.js"></script>
		<script src="${root}/resources/assets/js/bootstrap.min.js" class="loadfile"></script>
		<script src="${root}/resources/assets/js/bootstrap-table.min.js" class="loadfile"></script>
		<script src="${root}/resources/assets/js/bootstrap-table.js" class="loadfile"></script>
		<script src="${root}/resources/assets/js/bootstrap-table-zh-CN.js" class="loadfile" ></script>
	
	</head>
	<body >
<!-- 		<div class="main-container ace-save-state" id="main-container"> -->
<!-- 			<div class="main-content"> -->
				<div class="main-content-inner">
					<div class="breadcrumbs ace-save-state" id="breadcrumbs">
						<ul class="breadcrumb">
							<li>
								<i class="ace-icon fa fa-home home-icon"></i>
								<a href="#">控制台</a>
							</li>
							<li>
								<a href="#">咨询</a>
							</li>
							
						</ul><!-- /.breadcrumb -->
					</div>
					<div class="page-content">
						<div class="page-header">
<!-- 							<button class="btn btn-primary"> -->
<!-- 							<i class="ace-icon fa fa-plus-square bigger-160"></i> -->
<!-- 							新增 -->
<!-- 							</button> -->
							
						<button type="button" class="btn btn-primary btn-sm" style="text-shadow: black 5px 3px 3px;" onclick="addNews();">
						  <span class="glyphicon glyphicon-plus"></span> 新增
						</button>
						</div><!-- /.page-header -->
						
						<div class="row">
							<div class="col-xs-12">
								<table class="table table-hover" id="tabletemp" data-pagination="true" >  
								      <thead> 
									        <tr>
									        	<th data-field="id" data-checkbox=true ></th>
									            <th data-field="title" data-align="center" data-formatter="info_invoice" data-valign="middle" >标题</th>
									            <th data-field="navigational" data-align="center" data-formatter="get_invoice" data-valign="middle" >导航图</th>
									            <th data-field="topimage" data-align="center" data-formatter="status_invoice"  data-width="200" data-valign="middle">头图</th>							            												            							            								            
<!-- 									            <th data-field="make" data-align="center"  data-formatter="make"  data-width="150" data-valign="middle">操作</th> -->
									        </tr>
									 </thead>
								     <tbody>  
								     </tbody>
								</table>  
								<!-- PAGE CONTENT ENDS -->
							</div><!-- /.col -->
						</div><!-- /.row -->
					</div><!-- /.page-content -->
				</div>
<!-- 			</div>/.main-content -->
<!-- 			</div> -->
		
		
	</body>
	<script >
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
		        url: '${root}/manage/news_page', //获取数据的Servlet地址  
		        striped: true,  //表格显示条纹  
		        pagination: true, //启动分页  
		        pageSize: 4,  //每页显示的记录数  
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
				          };    
				          return param;   
		          return param;      
//		         queryParams:queryParams
		        }
//		         onLoadSuccess: function(data){  //加载成功时执行  
//		         	document.getElementById("orderNum").innerText = data.total;
//		         },  
//		         onLoadError: function(){  //加载失败时执行  
//		         	alert("加载数据失败");  
//		         }  
		      });  
		  }  
		</script>
</html>