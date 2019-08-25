<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<!-- saved from url=(0048)http://www.jq22.com/demo/pagination201808061005/ -->
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

	<title></title>
	<link rel="stylesheet" href="./jqueryPage_files/pagination.css">
	<script src="./jqueryPage_files/jquery.min.js"></script>
	<script src="./jqueryPage_files/pagination.js"></script>
	<script type="text/javascript">
		$(function(){
			alert("aaaa");
			$.ajax({
				url: "urlServlet",
				dataType:"json",
				type:"GET",
				success: function(data){
					alert("success"+data);
					//alert(data.pageCount);
					$.each(data, function(index, elem){
						//alert(elem.id+"-"+elem.name+"-"+elem.sex+"-"+elem.age+"-"+elem.address);
						 $("#tab").append('<tr><td>'+elem.id+'</td><td>'+elem.name+'</td><td>'+elem.sex+'</td><td>'+elem.age+'</td><td>'+elem.address+'</td></tr>');
					});
				},
				error: function(){
					alert("error!");
				}
			});
		});
	</script>
</head>



<body style="">
	<table id="tab">
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>SEX</th>
			<th>AGE</th>
			<th>ADDRESS</th>
		</tr>
	</table>
	<div class="box" id="wrap1">
	<span class="pagination-btn" id="pagination-prev">&lt;</span>
	<script type="text/javascript">
				var onPagechange = function(page){
				    //console.log('当前点击页码',page);
				    alert('当前点击页码'+page);
				    //删除table中的tr 第一行tr除外
				    $("#tab tr:not(:first)").remove();
				    $.ajax({
						url: "urlServlet",
						dataType:"json",
						data:"page="+page,
						type:"GET",
						success: function(data){
							alert("success"+data);
							$.each(data, function(index, elem){
								//alert(elem.id+"-"+elem.name+"-"+elem.sex+"-"+elem.age+"-"+elem.address);
								 $("#tab").append('<tr><td>'+elem.id+'</td><td>'+elem.name+'</td><td>'+elem.sex+'</td><td>'+elem.age+'</td><td>'+elem.address+'</td></tr>');
							});
						},
						error: function(){
							alert("error!");
						}
					});
				    
				}
				var obj = {
				    wrapid:'wrap1', //页面显示分页器容器id
				    total:100,//总条数
				    pagesize:10,//每页显示10条
				    currentPage:1,//当前页
				    onPagechange:onPagechange,
				    //btnCount:7 页数过多时，显示省略号的边界页码按钮数量，可省略，且值是大于5的奇数
				}
				pagination.init(obj);
	</script>


</body></html>