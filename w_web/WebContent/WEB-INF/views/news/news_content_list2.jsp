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
<link href="${root }/resources/css/buttons.css" rel="stylesheet"
	type="text/css" />
<%-- <link rel="stylesheet" href="${root }/resources/assets/css/bootstrap.min.css" /> --%>
<link href="http://cdn.bootcss.com/twitter-bootstrap/2.0.4/css/bootstrap.min.css" rel="stylesheet">
<link
	href="http://cdn.bootcss.com/twitter-bootstrap/2.0.4/css/bootstrap-responsive.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="${root}/resources/imgJs/css/images.css" />
<script type="text/javascript"
	src="${root }/resources/js/jquery-2.1.4.min.js"></script>
<%-- 	<script type="text/javascript" src="${root}/resources/imgJs/images.1.0.js"></script> --%>

<style>
body {
	padding-top: 60px;
	/* 60px to make the container go all the way to the bottom of the topbar */
	padding-bottom: 10px;
}

#components {
	min-height: 600px;
}

#target {
	min-height: 200px;
	border: 1px solid #ccc;
	padding: 5px;
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
</style>
</head>

<body>
	<div class="container">
		<div class="row clearfix">
			<div class="span6">
				<div class="clearfix">
					<h2>Your Form</h2>
					<hr>
					<div id="build">
						<form id="target" class="form-horizontal">
							<legend class="valtype" data-valtype="text">表单名</legend>
							<legend class="valtype" data-valtype="text">表单名</legend>
<!-- 							<fieldset> -->
<!-- 								<div id="legend" class="component" rel="popover" -->
<!-- 									title="Form Title" trigger="manual" -->
<%-- 									data-content=" --%>
<!-- 				                    <form class='form'> -->
<!-- 				                      <div class='controls'> -->
<!-- 				                        <label class='control-label'>Title</label> <input class='input-large' type='text' name='title' id='text'> -->
<!-- 				                        <hr/> -->
<!-- 				                        <button class='btn btn-info'>Save</button><button class='btn btn-danger'>Cancel</button> -->
<!-- 				                      </div> -->
<%-- 				                    </form>"> --%>
<!-- 									<legend class="valtype" data-valtype="text">表单名</legend> -->
<!-- 								</div> -->
<!-- 							</fieldset> -->
						</form>
					</div>
				</div>

<!-- 				<div class="span6"></div> -->
			</div>
			   <div class="span6">
	            <h2>拖拽下面的组件到左侧</h2>
	            <hr>
            </div>
			<!-- row -->
		</div>
		<!-- /container -->
	</div>

</body>
<script type="text/javascript">

</script>
</html>
