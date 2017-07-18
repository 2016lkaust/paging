# paging分页简单实现

# 数据库表
[user.sql](WebContent/sql/user.sql)

# index.jsp
需要四个容器，分别用于显示ajax请求后台获取的数据（show）、选择每页显示的个数（class="perpage"）、显示数据总数（id=total_num）、页码（id="pageCtr1"）

# index.js
```js
var queryList = "UserSlt";
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
	$.ajax({
		url : queryList,
		method : "post",
		dataType : "json",
		data : {
			"page" : curPage,// 当前页面
			"rows" : pageSize
		// 页面大小
		},
		success : function(data) {
			var total_num = 30;// total_num暂时写死 ，后期需要从后台获取

			/* 在id为show的组件中显示数据，先将组件置空，然后将生成的html添加到组件中显示 */
			$("#show").html("").append(showData(data));

			/* 直接套用，无需修改 */
			if (refreshPage == "1") {
				initPageNum(total_num, pageSize);
				$('#total_num').text(total_num);
				$('#pageCtr1').css('width', 'auto');
			}
		}
	});
}
/* 用于数据显示，将数据拼接为html，根据自己需要进行修改 */
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
```
**注**
以上js文件只需修改showData，如果想修改显示样式，用ul等其他标签显示的话，jsp文件中的"show"标签要修改为相应的标签。

- 待测试
试试在Page bean中，无参构造器直接设置pageSize和pageNumber为servlet中设置的值
