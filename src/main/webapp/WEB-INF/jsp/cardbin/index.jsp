<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>test</title>

<link rel="stylesheet" type="text/css" href="${ctx}/static/jquery-extgrid/css/grid.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/static/jquery-extgrid/css/grid.gray.css" />
<script type="text/javascript" src="${ctx}/static/jquery-extgrid/js/jquery.extgrid.1.2.4.js"></script>
<!-- 
 -->
<script type="text/javascript" src="${ctx}/static/jquery/jquery-3.0.0.min.js"></script>
<script>
	$(document).ready(function() {
		$('#search').click(function() {
			if($.trim($("#cardNo").val()) == '') {
				alert("请输入卡号");
				return;
			}
			$.ajax({
				type : "POST",
				url : '${ctx}/cardbin/getCardBin',
				data:{
					'cardNo' : $("#cardNo").val()
				},
				dataType : 'json',
				success : function(data) {
					alert(data.data);
				}
			});
		});
	});
</script>
<style type="text/css">
#condition>div {
	padding: 12px;
}

#condition table tr td {
	height: 36px;
}
</style>
</head>
<body>
<!-- 
	****先输入卡号，然后点击按钮，然后就有内容弹出****
	</br>
	<p style="color: red">获取卡bin</p>
	卡号：
	<input id="cardNo" type="text" />
	<input id="getCardbin" type="button" value="获取" />
-->
	
	
	
	<div class="block">
		<div class="block-heading">
			<a href="#condition" data-toggle="collapse">查询条件</a>
		</div>
		<div id="condition" class="block-body collapse in" style="overflow:visible">
			<div class="container-fluid form-horizontal" style="margin: 20px;">
				<div class="row-fluid">
					<div class="span5">
						<div class="control-group">
							<label class="control-label" for="cardNo">卡号</label>
							<div class="controls">
								<input type="text" id="cardNo" placeholder="卡号" maxlength="21" />
							</div>
						</div>
					</div>
					<div class="span5">
						<div class="control-group">
							<label class="control-label">&nbsp;</label>
							<div class="controls">
								<button id="search" class="btn btn-primary">查询</button>
								<button id="clean" class="btn btn-primary">重置</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="block">
		<div class="block-heading">
			<a href="#result" data-toggle="collapse">输出项</a>
		</div>
		<div id="result" class="block-body collapse in"></div>
	</div>
</body>
</html>