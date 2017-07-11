<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script src="js/jquery-3.2.1.min.js"></script>
<!-- <script type="text/javascript" src="js/message.js"></script> -->
<!-- <script type="text/javascript" src="js/commFunc.js"></script> -->
<script type="text/javascript" src="js/nextPage.js"></script>
<link rel="stylesheet" type="text/css" href="css/fanye.css">
<base href="<%=basePath%>">

<title>My JSP 'paging.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

</head>

<body>
	<table id="show"></table>
	<!--追加翻页代码-->
	<div class="pagination-list">
		<div class="pagination-count pull-left">
			<span>每页</span> <select class="perpage"
				onchange="refreshOrderTable()">
				<option>3</option>
				<option>5</option>
				<option>10</option>
				<option>20</option>
				<option>50</option>
				<option>100</option>
			</select> <span>共有</span> <span id="total_num"></span> <span>条数据</span>
		</div>
		<div class="fanye pull-right" id="pageCtr1"></div>
	</div>
	<script>
		var pageSize = 10;
		var pageNum = 0;
		var totalNum = 0;
		var queryList = "UserSlt2";
		refreshOrderTable();

		// 每页显示多少条数
		function refreshOrderTable() {
			var perpage = $('.perpage').val();
			refreshTablePage("1", perpage);
		}
		// 翻页刷新
		function refreshForPageChange() {
			var perpage = $('.perpage').val();
			refreshTablePage("0", perpage);
			console.log(perpage);
		}

		/*
		 * 用服务器刷新列表页面 1刷新页码， 0翻页不刷新页码
		 */
		function refreshTablePage(refreshPage, pageSize) {
			var total_num = 30;// total_num暂时写死 ，后期需要从后台获取
			$.ajax({
				url : queryList,
				method:"post",
				dataType:"json",
				data : {
					"page" : curPage,
					"rows" : pageSize
				},
				success : function(data) {
					console.log(data);
					$("#show").html("").append(showData(data));
					if (refreshPage == "1") {
						initPageNum(total_num, pageSize);
						$('#total_num').text(total_num);
						$('#pageCtr1').css('width', 'auto');
					}
				}
			});
		}
		function showData(data) {
			var html = "";
			for ( var i = 0; i < data.length; i++) {
				html += "<tr>";
				html += "<td>" + (i + 1) + "</td>";
				html += "<td>" + data[i].name + "</td>";
				html += "<td>" + data[i].age + "</td>";
				html += "</tr>";
			}
			return html;
		}
	</script>
</body>
</html>
