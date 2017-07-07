<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="js/jquery-3.2.1.min.js"></script>
<style>
#show {
	margin: auto;
	border:1px solid black;
	border-collapse: collapse;
}

#show td {
	border:1px solid black;
}

#pageNumber {
	display: inline-block;
	margin: 50px auto;
}

#pageNumber li {
	list-style: none;
	display: inline-block;
	width: 30px;
	text-align: center;
	border: 1px solid black;
}
</style>
</head>
<body>
	<table id="show"></table>
	<select id="pageSize">
		<option>5</option>
		<option>10</option>
	</select>
	<ul id="pageNumber">
		<li value="1"><<</li>
		<li value="1">1</li>
		<li value="2">2</li>
		<li value="3">3</li>
		<li value="4">4</li>
		<li value="4">>></li>
	</ul>
	<script>
		$(function() {
			$("#pageNumber li").click(function() {
				$.ajax({
					url : "UserSlt",
					method : "post",
					dataType : "json",
					data : {
						pageNumber : $(this).val(),
						pageSize : $("#pageSize option:selected").html()
					},
					success : function(data) {
						var html = showData(data);
						$("#show").html("").append(html);
					}
				});

				function showData(data) {
					var html = "";
					for (var i = 0; i < data.length; i++) {
						html += "<tr>";
						html += "<td>" + (i+1) + "</td>";
						html += "<td>" + data[i].name + "</td>";
						html += "<td>" + data[i].age + "</td>";
						html += "</tr>";
					}
					return html;
				}
			});
		})
	</script>
</body>
</html>