<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>动态数据填充表格和全选操作</title>
	<link rel="stylesheet" href="layui/css/layui.css"/>
</head>
<body>

	<table class="layui-hide" id="test" lay-filter="test"></table>
	
<script type="text/html" id="toolbarDemo">
  <div class="layui-btn-container">
    <button class="layui-btn layui-btn-sm" lay-event="getCheckData">获取选中行数据</button>
    <button class="layui-btn layui-btn-sm" lay-event="getCheckLength">获取选中数目</button>
    <button class="layui-btn layui-btn-sm" lay-event="isAll">验证是否全选</button>
  </div>
</script>

<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
	
              
          
	<script src="layui/layui.js" charset="utf-8"></script>
	<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
	
	
	<script>
layui.use('table', function(){
  var table = layui.table;
  
  table.render({
    elem: '#test'
    	 ,url:'gosnServlet'  //指定数据的地址
    ,toolbar: '#toolbarDemo'
    ,title: '用户数据表'
    ,cols: [[			//表头
    	{type:"checkbox"},
	      {field:'id', width:100, title: 'ID', sort: true}  //sort: true;  可排序
	      ,{field:'name', width:100, title: '用户名'}
	      ,{field:'age', width:100, title: '年龄', sort: true}
	      ,{field:'sex', width:100, title: '性别'}
	      ,{width:300, title:"操作", toolbar: '#barDemo'}
	     
	    ]]
    ,page: true
  });
  
  //头工具栏事件
  table.on('toolbar(test)', function(obj){
    var checkStatus = table.checkStatus(obj.config.id);
    switch(obj.event){
      case 'getCheckData':
        var data = checkStatus.data;
        layer.alert(JSON.stringify(data));
      break;
      case 'getCheckLength':
        var data = checkStatus.data;
        //循环出全选的id 编号值
        //定义一个数组  来承接 全选的值！
        var arr = new Array();
        for(var i=0; i<data.length; i++){
        	arr[i] = data[i].id;
        	//alert(data[i].id);
        }
       // alert(arr);
        layer.msg('选中了：'+ data.length + ' 个');
      break;
      case 'isAll':
        layer.msg(checkStatus.isAll ? '全选': '未全选');
      break;
    };
  });
  
  //监听行工具事件
  table.on('tool(test)', function(obj){
    var data = obj.data;
    //console.log(obj)
    if(obj.event === 'del'){
      layer.confirm('真的删除行么', function(index){
        obj.del();
        layer.close(index);
      });
    } else if(obj.event === 'edit'){
      layer.prompt({
        formType: 2
        ,value: data.email
      }, function(value, index){
        obj.update({
          email: value
        });
        layer.close(index);
      });
    }
  });
});
</script>


</body>
</html>