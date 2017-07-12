var totalNumInt = 0;
var pageSizeInt = 10;
var curPage = 1;
var pageCount=1;
var widthTotal=400;
var widthBtn=45;

//引用翻页js，需要实现函数 refreshForPageChange();，查询服务器数据需要传输curPage， 页数初始化或者改变时调用initPageNum， 不能在refreshForPageChange中调用initPageNum
/*//每页显示多少条数
function refreshOrderTable() {
	var perpage = $('.perpage').val();
	refreshTablePage("1", perpage);
}
// 翻页刷新
function refreshForPageChange() {
	var perpage = $('.perpage').val();
	refreshTablePage("0", perpage);
}*/
function initPageNum(totalNum, pageSize)
{
	pageCount =1;
	curPage = 1;
	totalNumInt = parseInt(totalNum);
	pageSizeInt = parseInt(pageSize);

	if(totalNumInt > pageSizeInt){
		//余数
		var t1= totalNumInt%pageSizeInt;
		if(t1 != 0){
			pageCount = (totalNumInt - t1)/pageSizeInt + 1;
		}else{
			pageCount = totalNumInt/pageSizeInt;
		}

	}else{
		pageCount = 1;
	}

	refreshPageHtml();

	$("#pageCtr1").css("width",width+"px");
}

function initPageNumWithCurrPage(totalNum, pageSize, curPage2)
{
	pageCount =1;
	if (curPage2) {
		curPage = curPage2;
	} else {
		curPage = 1;
	}
	totalNumInt = parseInt(totalNum);
	pageSizeInt = parseInt(pageSize);

	if(totalNumInt > pageSizeInt){
		//余数
		var t1= totalNumInt%pageSizeInt;
		if(t1 != 0){
			pageCount = (totalNumInt - t1)/pageSizeInt + 1;
		}else{
			pageCount = totalNumInt/pageSizeInt;
		}

	}else{
		pageCount = 1;
	}

	refreshPageHtml();

	$("#pageCtr1").css("width",width+"px");
}

function refreshPageHtml(){
	var html = '';
	html = getPageHtml();
	$("#pageCtr1").html(html);
	$("#page" + curPage).attr("class","currentpage");
}

function getPageHtml(){
	var Html = "";
	Html += '<a class="lh38" onclick="gotoPage('+1+')"><img src="images/first.png"/></a>';
	Html += '<a class="lh38" onclick="pageUp()"><img src="images/uppage.png"/></a>';
	if(pageCount <= 7){
		for(var i = 1 ; i <= pageCount; i++){
			Html += '<a style="cursor: pointer;" id="page'+i+'" onclick="gotoPage('+i+')">'+ i + '</a>';
		}

		width = 200+widthBtn*pageCount;
	}else{
		var startBtn = curPage - 2;
		var endBtn = curPage + 2;
		if(endBtn > pageCount){
			startBtn -= endBtn - pageCount;
			endBtn = pageCount;
		}
		if(startBtn < 1){
			startBtn = 1;
		}

		if(endBtn <=7){
			for(var i = 1 ; i <= 7; i++){
				Html += '<a  style="cursor: pointer;" id="page'+i+'" onclick="gotoPage('+i+')">'+ i + '</a>';
			}
			Html += '<span>...</span>';

			width = 200+widthBtn*8;
		}else {
			for(var i = 1 ; i <= 2; i++){
				Html += '<a  style="cursor: pointer;" id="page'+i+'" onclick="gotoPage('+i+')">'+ i + '</a>';
			}
			Html += '<span>...</span>';
			for(var i = startBtn ; i <= endBtn; i++){
				Html += '<a  style="cursor: pointer;" id="page'+i+'" onclick="gotoPage('+i+')">'+ i + '</a>';
			}

			width = 200+widthBtn*(endBtn - startBtn + 4);
			if(endBtn < pageCount){
				Html += '<span>...</span>';

				width += widthBtn;
			}
		}
	//	Html += '<a id="page'+ pageCount+'" onclick="gotoPage('+pageCount+')">'+ pageCount + '</a>';
	}
	Html += '<a onclick="pageDown()"><img src="images/downpage.png"/></a>';
	Html += '<a onclick="gotoPage('+pageCount+')"><img src="images/last.png"/></a>';
	Html += '<span class="nothing">共'+pageCount+'页</span>';
	//Html += '<span class="nothing">共'+pageCount+'页，到第</span>';
	//Html += '<input class="fanyetext" type="text" id="pageInput" value="'+ curPage +'" onkeydown="pageClick(event)" />';
	//Html += '</span class="nothing">页</span>';
	//Html += '<button class="fanyebtn" onclick="changePage()">确定</button>';

	return Html;
}

function pageUp(){
	gotoPage(curPage - 1);
}

function pageDown(){
	gotoPage(curPage + 1);
}

function changePage(){
	gotoPage(parseInt($("#pageInput").val()));
}

function gotoPage(gotoPage){
	var newPage = parseInt(gotoPage);
	if(newPage < 1)
		newPage = 1;
	if(newPage > pageCount)
		newPage = pageCount;

	if(newPage != curPage){
		$("#page"+ newPage).attr("class","currentpage");
		$("#page"+ curPage).attr("class","");
		curPage = newPage;
		$("#pageInput").val(curPage);
		refreshForPageChange();
		refreshHtml();
	}
}

function gotoPageNoRefresh(gotoPage){
	var newPage = parseInt(gotoPage);
	if(newPage < 1)
		newPage = 1;
	if(newPage > pageCount)
		newPage = pageCount;

	if(newPage != curPage){
		$("#page"+ newPage).attr("class","currentpage");
		$("#page"+ curPage).attr("class","");
		curPage = newPage;
		$("#pageInput").val(curPage);
		refreshHtml();
	}
}

function refreshHtml(){
	if(pageCount > 7){
		refreshPageHtml();
	}
}

function pageClick(e){
	var keynum;
    if(window.event){//IE
		keynum = e.keyCode;
	}else if(e.which){// Netscape/Firefox/Opera
		keynum = e.which;
	}
	if(keynum == 13){
		changePage();
	}
}
