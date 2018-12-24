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
		<link rel="stylesheet" href="${root}/resources/imgJs/css/images.css" />
		<script type="text/javascript" src="${root}/resources/imgJs/images.1.0.js"></script>
	</head>
	<body >
		<div class="main-content-inner">
			<div class="breadcrumbs ace-save-state" id="breadcrumbs">
				<ul class="breadcrumb">
					<li>
						<i class="ace-icon fa fa-home home-icon"></i>
						<a href="#">控制台</a>
					</li>
					<li class="active">资讯</li>
					<li class="active">编辑</li>
				</ul><!-- /.breadcrumb -->
			</div>
			<div class="page-content">
				<div class="row">
					<div class="col-xs-12">
						<form class="form-horizontal" role="form">
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" >标题</label>
								<div class="col-sm-9">
									<input type="text" id="title" name="title" placeholder="咨询询标题" class="col-xs-10 col-sm-5" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" >导航图</label>
								<div class="col-sm-4">
									<div align="center" class="div_list">
										<button type="button"  id="checkfile">选择图片</button>
									</div>
									<div id="divimg" class="div_list divimg" ></div>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" >头图</label>
								<div class="col-sm-4">
									<div align="center" class="div_list">
										<button type="button"  id="checkfile1">选择图片</button>
									</div>
									<div id="divimg1" class="div_list divimg" ></div>
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-10" align="center">
									<button type="button" class="btn btn-primary btn-sm" style="text-shadow: black 5px 3px 3px;" onclick="addNews();">
										保存
									</button>
								</div>
							</div>
						</form>
					</div><!-- /.col -->
				</div><!-- /.row -->
			</div><!-- /.page-content -->
		</div>
		<script>
		//单图模式。加载本地数据，无操作按钮
		var file1 = $("#divimg").Imagefile({
			checkfile:'checkfile',
			btn:false,
			title:false,
			model:"single"
		});
	
		var file2 = $("#divimg1").Imagefile({
			checkfile:'checkfile1',
			btn:false,
			title:false,
			model:"single"
		});
		</script>
		
	</body>
</html>