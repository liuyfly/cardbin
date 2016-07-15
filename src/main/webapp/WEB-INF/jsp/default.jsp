<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sitemesh"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>众安在线 - 运营平台 - <sitemesh:title /></title>
<meta http-equiv="Cache-Control" content="no-store" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<link rel="stylesheet" type="text/css"
	href="${ctx}/static/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css"
	href="${ctx}/static/font-awesome/css/font-awesome.min.css" />
<link rel="stylesheet" type="text/css"
	href="${ctx}/static/bootstrap-portnine/css/theme.css" />
<script type="text/javascript"
	src="${ctx}/static/jquery/jquery-3.0.0.min.js"></script>
<script type="text/javascript"
	src="${ctx}/static/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="${ctx}/static/bootstrap/js/bootstrap-dialog.js"></script>
<script type="text/javascript"
	src="${ctx}/static/bootstrap/js/bootstrap-validation.js"></script>
<!-- 
<script type="text/javascript" src="${ctx}/static/tool/DateFormat.js""></script>
-->
<sitemesh:head />
</head>
<body>

	<div class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<ul id="ssouser" class="nav pull-right hide">
				<li class="dropdown"><a href="#" role="button"
					class="dropdown-toggle" data-toggle="dropdown"> <i
						class="icon-user"></i><span id="ssoname"></span><i
						class="icon-caret-down"></i>
				</a>
					<ul class="dropdown-menu">
						<li><a tabindex="-1" href="${ctx}/logout">退出</a></li>
					</ul></li>
			</ul>
			<ul class="nav pull-right hide">
				<li class="dropdown"><a href="#" role="button"
					class="dropdown-toggle" data-toggle="dropdown"> <i
						class="icon-gift"></i>相关平台<i class="icon-caret-down"></i>
				</a>
					<ul id="applications" class="dropdown-menu">
					</ul></li>
			</ul>
			<a class="brand" href="${ctx}">众安在线</a>
		</div>
	</div>

	<div id="side-menu" class="sidebar-nav"></div>

	<div class="content">
		<div class="header">
			<h4 class="page-title" id="title-caption">欢迎使用众安在线运营平台</h4>
		</div>
		<div class="container-fluid">
			<sitemesh:body />
		</div>
	</div>
<!-- 
	<script type="text/javascript" src="${ctx}/static/tool/layout.js"></script>
 -->

</body>
</html>