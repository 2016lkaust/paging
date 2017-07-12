<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML>
<html>
<head>
<script src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="js/nextPage.js"></script>
<link rel="stylesheet" type="text/css" href="css/fanye.css">
<base href="<%=basePath%>">

<title>分页练习</title>

<meta charset="utf-8">

</head>

<body>
	<table id="show"></table>
	<!--翻页部分-->
	<div class="pagination-list">
		<!-- 每页显示个数 -->
		<div class="pagination-count pull-left">
			<span>每页</span> <select class="perpage"
				onchange="refreshOrderTable()">
				<option>3</option>
				<option>5</option>
				<option>10</option>
				<option>20</option>
				<option>50</option>
				<option>100</option>
			</select>
			<!-- 显示数据总数 -->
			<span>共有</span> <span id="total_num"></span> <span>条数据</span>
		</div>
		<!-- 页码 -->
		<div class="fanye pull-right" id="pageCtr1"></div>
	</div>
	<!-- 翻页结束 -->
	
<script type="text/javascript" src="js/index.js"></script>
</body>
</html>
