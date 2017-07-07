<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/jPages.css">
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/jPages.min.js"></script>
</head>
<body>
	<table id="show"></table>
	<!-- Future navigation panel -->
	<ul id="itemContainer">
		<li>1</li>
	</ul>
	<div class="holder"></div>
	<select id="pageSize">
		<option>5</option>
		<option>10</option>
	</select>
	<!-- navigation panel -->
	<div class="holder">
		<a class="jp-previous jp-disabled">← previous</a> <a
			class="jp-current">1</a> <span class="jp-hidden">...</span> <a>2</a>
		<a>3</a> <a>4</a> <a>5</a> <a class="jp-hidden">6</a> <a
			class="jp-hidden">7</a> <a class="jp-hidden">8</a> <a
			class="jp-hidden">9</a> <span>...</span> <a>10</a> <a class="jp-next">next
			→</a>
	</div>
	<script>
		$(function() {
			$("div.holder").jPages({
				containerID : "itemContainer"
			});
			$(".holder a").click(
					function() {
						var pageNumber = $(this).html();
						if ($(this).index() == 0) {
							pageNumber = $(".jp-current").html();
						}
						$(this).addClass("jp-current").siblings().removeClass(
								"jp-current");
						$.ajax({
							url : "UserSlt",
							method : "post",
							dataType : "json",
							data : {
								pageNumber :pageNumber,
								pageSize : $("#pageSize option:selected")
										.html()
							},
							success : function(data) {
								var html = showData(data);
								$("#itemContainer").html("").append(html);
							}
						});

						function showData(data) {
							var html = "";
							for (var i = 0; i < data.length; i++) {
								html += "<tr>";
								html += "<td>" + (i + 1) + "</td>";
								html += "<td>" + data[i].name + "</td>";
								html += "<td>" + data[i].age + "</td>";
								html += "</tr>";
							}
							return html;
						}
						function showData2(data) {
							var html = "";
							for (var i = 0; i < data.length; i++) {
								html += "<li>";
								html += data[i].name + "\t" + data[i].age;
								html += "</li>";
							}
							return html;
						}
					});
		});
	</script>
</body>
</html>