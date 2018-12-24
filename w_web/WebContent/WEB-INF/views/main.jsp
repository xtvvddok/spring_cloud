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
		<link rel="stylesheet" href="${root }/resources/assets/css/bootstrap.min.css" />
		
		<link rel="stylesheet" href="${root }/resources/assets/font-awesome/4.5.0/css/font-awesome.min.css" />
		<link rel="stylesheet" href="${root }/resources/assets/css/fonts.googleapis.com.css" />
		<link rel="stylesheet" href="${root }/resources/assets/css/ace.min.css" class="ace-main-stylesheet" id="main-ace-style" />
		<link rel="stylesheet" href="${root }/resources/assets/css/ace-skins.min.css" />
		<link rel="stylesheet" href="${root }/resources/assets/css/ace-rtl.min.css" />
		<link href="${root}/resources/assets/css/sweetalert.css" rel="stylesheet" type="text/css">
		<script src="${root }/resources/assets/js/ace-extra.min.js"></script>
	</head>

	<body class="no-skin" >
		<div id="navbar" class="navbar navbar-default          ace-save-state">
			<div class="navbar-container ace-save-state" id="navbar-container">
				<div class="navbar-header pull-left">
					<a href="index.html" class="navbar-brand">
						<small>
							<i class="fa fa-leaf"></i>
							微站管理平台
						</small>
					</a>
				</div>
				<div class="navbar-buttons navbar-header pull-right" role="navigation">
					<ul class="nav ace-nav">
						<li class="light-blue dropdown-modal">
							<a data-toggle="dropdown" href="#" class="dropdown-toggle">
								<img class="nav-user-photo" src="${root }/resources/assets/images/avatars/user.jpg" alt="Jason's Photo" />
								<span class="user-info">
									<small>Welcome,</small>
									管理员
								</span>

								<i class="ace-icon fa fa-caret-down"></i>
							</a>
							<ul class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
								<li>
									<a href="#">
										<i class="ace-icon fa fa-cog"></i>
										修改密码
									</a>
								</li>
								<li class="divider"></li>
								<li>
									<a href="#">
										<i class="ace-icon fa fa-power-off"></i>
										退出
									</a>
								</li>
							</ul>
						</li>
					</ul>
				</div>
			</div><!-- /.navbar-container -->
		</div>
		<div class="main-container ace-save-state" id="main-container">
			<div id="sidebar" class="sidebar responsive ace-save-state">
				<ul class="nav nav-list">
					<li class="active">
						<a href="javascript:void(0)" ahref="">
							<i class="menu-icon fa fa-tachometer"></i>
							<span class="menu-text">首页 </span>
						</a>

						<b class="arrow"></b>
					</li>
					<li class="">
						<a href="#" class="dropdown-toggle">
							<i class="menu-icon fa fa-list"></i>
							<span class="menu-text"> 资询管理 </span>
							<b class="arrow fa fa-angle-down"></b>
						</a>

						<b class="arrow"></b>
						<ul class="submenu">
							<li class="">
								<a href="javascript:void(0)" ahref="manage/news_list">
									<i class="menu-icon fa fa-caret-right"></i>
									资询
								</a>
								<b class="arrow"></b>
							</li>
						</ul>
					</li>
				</ul><!-- /.nav-list -->
				<div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
					<i id="sidebar-toggle-icon" class="ace-icon fa fa-angle-double-left ace-save-state" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
				</div>
			</div>
			<div class="main-content">
				<div class="main-content-inner">
					<div class="breadcrumbs ace-save-state" id="breadcrumbs">
						<ul class="breadcrumb">
							<li>
								<i class="ace-icon fa fa-home home-icon"></i>
								<a href="#">控制台</a>
							</li>
							<li class="active">Dashboard</li>
						</ul><!-- /.breadcrumb -->
					</div>
				</div>
			</div><!-- /.main-content -->

			<div class="footer">
				<div class="footer-inner">
					<div class="footer-content">
						<span class="bigger-120">
							<span class="blue bolder">Ace</span>
							Application &copy; 2013-2014
						</span>
						&nbsp; &nbsp;
						<span class="action-buttons">
							<a href="#">
								<i class="ace-icon fa fa-twitter-square light-blue bigger-150"></i>
							</a>

							<a href="#">
								<i class="ace-icon fa fa-facebook-square text-primary bigger-150"></i>
							</a>

							<a href="#">
								<i class="ace-icon fa fa-rss-square orange bigger-150"></i>
							</a>
						</span>
					</div>
				</div>
			</div>
			<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
				<i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
			</a>
		</div><!-- /.main-container -->
		<script src="${root }/resources/assets/js/jquery-2.1.4.min.js"></script>
		<script src="${root }/resources/assets/js/bootstrap.min.js"></script>
		<script src="${root }/resources/assets/js/jquery-ui.custom.min.js"></script>
		<script src="${root }/resources/assets/js/jquery.ui.touch-punch.min.js"></script>
		<script src="${root }/resources/assets/js/jquery.easypiechart.min.js"></script>
		<script src="${root }/resources/assets/js/jquery.sparkline.index.min.js"></script>
		<script src="${root }/resources/assets/js/jquery.flot.min.js"></script>
		<script src="${root }/resources/assets/js/jquery.flot.pie.min.js"></script>
		<script src="${root }/resources/assets/js/jquery.flot.resize.min.js"></script>
		<script src="${root }/resources/assets/js/ace-elements.min.js"></script>
		<script src="${root }/resources/assets/js/ace.min.js"></script>
		
		<script type="text/javascript">
			$("#sidebar").on("click","a", function (e) {
		        var url = $(this).attr("ahref");
		        if (typeof(url) != "undefined" && url != null && url !="") {
		        	getHtml('${root}/'+url);
		        }
		    });
			function getHtml(url){

// 				$(".main-content-inner").empty();
// // 				$("script").find(".loadfile").remove();
// 				$("script[class='loadfile']").each(function(){
// 					alert(1);
// 					alert($(this).attr("src"));
// 				});
// 				$.get(url,function(data){
// // 					location.reload();
// 					$(".main-content-inner").append(data);
// 				}); 
			}
		</script>
	</body>
</html>