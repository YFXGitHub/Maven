<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

		<title></title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/jqueryPage_files/pagination.css" />
		<script src="${pageContext.request.contextPath}/jqueryPage_files/jquery-1.10.2.js"></script>
		<script src="${pageContext.request.contextPath}/jqueryPage_files/jquery.min.js"></script>
		<script src="${pageContext.request.contextPath}/jqueryPage_files/pagination.js"></script>
		</head>



<body style=""><a href="/porduct/findPagebean">sadfasdf</a>
	<div class="box" id="wrap1">
		
	</div>
	<script type="text/javascript">
		$(function(){
			
			
		});
		
		
	
				var onPagechange = function(page){
				    console.log('当前点击页码',page);
				    
				}
				var obj = {
				    wrapid:'wrap1', //页面显示分页器容器id
				    total:18891,//总条数
				    pagesize:10,//每页显示10条
				    currentPage:1,//当前页
				    onPagechange:onPagechange,
				    //btnCount:7 页数过多时，显示省略号的边界页码按钮数量，可省略，且值是大于5的奇数
				}
				pagination.init(obj);
	</script>


</body></html>