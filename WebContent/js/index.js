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
