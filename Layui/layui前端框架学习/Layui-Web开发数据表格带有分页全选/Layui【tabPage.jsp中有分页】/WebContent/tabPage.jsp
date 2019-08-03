<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>表格数据分页</title>
		
		<link rel="stylesheet" href="layui/css/layui.css"/>
	</head>
<body>
		<table class="layui-hide" id="test" lay-filter="test"></table>
		
		
		
		
		<script src="layui/layui.js" charset="utf-8"></script>
		<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 --> 
		 
		<script>
		layui.use('table', function(){
		  var table = layui.table;
		  
		  table.render({
		    elem: '#test'
		    ,url:'pageServlet'
		    ,toolbar: true
		    ,title: '用户数据表'
		    ,totalRow: true
		    ,cols: [[
		      {field:'uid', title:'ID', width:80, fixed: 'left', unresize: true, sort: true, totalRowText: '合计行'}
		      ,{field:'uname', width:100, title: '用户名'}
		      ,{field:'usex', width:100, title: '性别'}
		      ,{field:'uage', width:100, title: '年龄', sort: true}
		      ,{field:'uaddress', width:150, title: '住址'}
		    ]]
		    ,page: true
		    ,response: {
		      statusCode: 200 //重新规定成功的状态码为 200，table 组件默认为 0
		    }
		    ,parseData: function(res){ //将原始数据解析成 table 组件所规定的数据
		      return {
		    	  "code": res.status, //解析接口状态   在编写json 是一定要注意这些命名不可改变！否则解析失败！
		          "msg": res.message, //解析提示文本
		          "count": res.total, //解析数据长度
		          "data": res.rows.item //解析数据列表
		      };
		    }
		  });
		});
		</script>
		
		
	

</body>
</html>