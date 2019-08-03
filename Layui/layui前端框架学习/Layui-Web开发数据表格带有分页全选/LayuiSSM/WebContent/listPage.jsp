<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>layout 后台布局 -数据表格分页</title>
		
		 <link rel="stylesheet" href="layui/css/layui.css"  media="all">
	</head>
<body class="layui-layout-body">
	<div class="layui-layout layui-layout-admin">
  		<!-- top 顶部 -->
  		<jsp:include page="top.jsp"></jsp:include>
  
 		<!-- left 左边栏 -->
 		<jsp:include page="left.jsp"></jsp:include>
  
		  <div class="layui-body">
		    <!-- 内容主体区域 -->
		    <div style="padding: 15px;">
		      	内容主体区域<br/>
		      	
		      	<table class="layui-hide" id="test" lay-filter="test"></table>
		      	
		      	
		      	
		    
		    </div>
		  </div>
  
  
	  <div class="layui-footer">
	    <!-- 底部固定区域 -->
	    © layui.com - 底部固定区域
	  </div>
	</div>

	<!-- js  -->
	<script src="layui/layui.js" charset="utf-8"></script>
	<script>
		//JavaScript代码区域
		layui.use('element', function(){
		  var element = layui.element;
		  
		});
		</script>
		<script>
		var _hmt = _hmt || [];
		(function() {
		  var hm = document.createElement("script");
		  hm.src = "https://hm.baidu.com/hm.js?d214947968792b839fd669a4decaaffc";
		  var s = document.getElementsByTagName("script")[0]; 
		  s.parentNode.insertBefore(hm, s);
		})();
	</script>
			
			<!-- 向表格中引入操作全选按钮 -->
			<script type="text/html" id="toolbarDemo">
 					 <div class="layui-btn-container">
    					<button class="layui-btn layui-btn-sm" lay-event="getCheckData">获取选中行数据</button>
    					<button class="layui-btn layui-btn-sm" lay-event="getCheckLength">获取选中数目</button>
    					<button class="layui-btn layui-btn-sm" lay-event="isAll">验证是否全选</button>
  					 </div>
			</script>
				  
			<!-- 向表格中引入 操作按钮 -->
	 		<script type="text/html" id="barDemo">
  				<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
  				<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
			</script>
	
	
	<!-- 数据表格分页显示  -->
	<script>
		layui.use('table', function(){
		  var table = layui.table;
		  
		  table.render({
		    elem: '#test'			//获取table id值
		    ,url:'pagelist'			//ajax 异步请求路径
		    ,toolbar: '#toolbarDemo'	//向表格头部中引入操作全选按钮 
		    ,title: '用户数据表'			//设置导出数据时的表名
		    ,width: 800					//设置整个表格的宽度
		    ,cols: [[	
		    	{type:"checkbox"},  //开启全选操作
		       {field:'uid', width:100, title: 'ID', sort: true}  //sort: true;  可排序
		      ,{field:'uname', width:100, title: '用户名'}
		      ,{field:'usex', width:100, title: '性别'}
		      ,{field:'uage', width:100, title: '年龄', sort: true}
		      ,{field:'uaddress', width:150, title: '住址'}
		      ,{width:194, title:"操作", toolbar: '#barDemo'}    //toolbar: 向表格中引入 操作按钮 
		    ]]
		    ,page: true			//开启分页
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
		  
		  //头工具栏事件
		  table.on('toolbar(test)', function(obj){
		    var checkStatus = table.checkStatus(obj.config.id);
		    switch(obj.event){
		      case 'getCheckData':				// ---> 获取选中复选框中的数据：
		        var data = checkStatus.data;
		        layer.alert(JSON.stringify(data));
		      break;
		      case 'getCheckLength':			// ---> 全选功能的控制：
		        var data = checkStatus.data;
		        //循环出全选的id 编号值
		         //定义一个数组  来承接 全选的值！
		         var arr = new Array();
		        for(var i=0; i<data.length; i++){
		        	arr[i] = data[i].uid;
		        	//alert(data[i].uid);
		        }
		        alert(arr);
		        layer.msg('选中了：'+ data.length + ' 个');
		      break;
		      case 'isAll':						// ---> 判断全选功能是否选中：
		        layer.msg(checkStatus.isAll ? '全选': '未全选');
		      break;
		    };
		  });
		  
		  //监听  操作 工具事件  
		  table.on('tool(test)', function(obj){
		    var data = obj.data;
		    //console.log(obj)
		    if(obj.event === 'del'){		//监听删除操作
		      layer.confirm('真的删除行么', function(index){
		    	  layer.msg('ID：'+ data.uid + ' 的删除操作');
		    	  //使用jquery ajax进行异步删除！
		    	  jquery.ajax({
			    		 url:"delete2",
			    		 data:"uid="+data.uid,
			    		 dataType:"text",
			    		 type:"GET",
			    		 success: function(data){
			    			// layer.msg('访问成功！'+data);
			    			 if(data == "1"){
			    				// obj.del();			//删除当前tr 行
			    				 layer.msg('删除成功！');
			    			 }
			    		 },
			    		 error: function(){
			    			 layer.msg('访问失败！');
			    		 }
			    	  })
		        //obj.del();		表示删除当前tr 行
		        layer.close(index);
		      });
		    } else if(obj.event === 'edit'){	//修改操作
		    	layer.alert('编辑行：<br>'+ JSON.stringify(data));
		    
		    }
		  });
		});
		</script>
</body>
</html>