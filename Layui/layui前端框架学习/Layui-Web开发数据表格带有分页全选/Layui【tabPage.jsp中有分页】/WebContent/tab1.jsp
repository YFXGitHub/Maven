<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>表格</title>
	<link rel="stylesheet" href="layui/css/layui.css"/>
</head>
<body>

<div class="layui-btn-group demoTable">
  <button class="layui-btn" data-type="getCheckLength">获取选中数目</button>
</div>

	<table class="layui-hide" id="test"></table>
              
          
	<script src="layui/layui.js" charset="utf-8"></script>
	<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
	<script>
		layui.use('table', function(){
		  var table = layui.table;
		  
		  //这是方法渲染
		  table.render({
		    elem: '#test'
		    ,url:'user.json'  //指定数据的地址
		    ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
		    ,cols: [[			//表头
		    	{type:"checkbox"},
		      {field:'id', width:80, title: 'ID', sort: true}  //sort: true;  可排序
		      ,{field:'username', width:80, title: '用户名'}
		      ,{field:'sex', width:80, title: '性别', sort: true}
		      ,{field:'city', width:80, title: '城市'}
		      ,{field:'sign', title: '签名', width: '30%', minWidth: 100} //minWidth：局部定义当前单元格的最小宽度，layui 2.2.1 新增
		      ,{field:'experience', title: '积分', sort: true}
		      ,{field:'score', title: '评分', sort: true}
		      ,{field:'classify', title: '职业'}
		      ,{field:'wealth', width:137, title: '财富', sort: true}
		    ]]
		  });
		});
	</script>
	
	<script src="//res.layui.com/layui/dist/layui.js" charset="utf-8"></script>

</body>
</html>