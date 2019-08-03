<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>layout 后台布局 -Layui</title>
 
  
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
		    	  内容主体区域
			      <br><br>
					
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
						 
		    </div>
		  </div>
	  
		  <div class="layui-footer">
		    <!-- 底部固定区域 -->
		    © layui.com - 底部固定区域
		  </div>
	</div>
	
	
	<!--  js  -->
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
		
		
		<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
			<script>
				layui.use(['form','table','jquery'], function(){
					  var form = layui.form;
					  var jquery = layui.jquery;
					  var table = layui.table;
				  
				  table.render({
				    elem: '#test'
				    ,url:'list'  			//指定数据的地址
				    ,toolbar: '#toolbarDemo'		//向表格头部中引入操作全选按钮 
				    ,title: '用户数据表'
				    ,width:796
				    ,cols: [[			//表头
				    	{type:"checkbox"},
				    	 {field:'uid', width:100, title: 'ID', sort: true}  //sort: true;  可排序
					      ,{field:'uname', width:100, title: '用户名'}
					      ,{field:'usex', width:100, title: '性别'}
					      ,{field:'uage', width:100, title: '年龄', sort: true}
					      ,{field:'uaddress', width:150, title: '住址'}
					      ,{width:190, title:"操作", toolbar: '#barDemo'}
					     
					    ]]
				    ,page: true
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
				  
				  //监听行工具事件
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
					    				 obj.del();			//删除当前tr 行
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
				    	//layer.alert('编辑行：<br>'+ JSON.stringify(data));
				    
				    	 //弹出表单对话框
				    	layer.open({
							type:"1",				//0  就是指  提示框！
							title:"弹出表单",			//标题
							skin:"layui-layer-lan",	//标题的背景色
							area:["500px", "390px"],	//设置宽，高！
							//offset:"auto",   默认页面居中显示！
							shade:[0.8, '#2F4056'],		//遮皁
							shadeClose:true,			//点击遮皁 关闭
							//time:5000,				//表示5秒后关闭！
							anim:0,						//弹出动画 0~6！
							content:$("#context")  //content:"提示！" 也可写入标签
						});
				    	  //表单初始赋值
				    	  form.val('example', {
				    		"uid": data.uid
				    	    ,"uname": data.uname // "name": "value"
				    	    ,"usex": data.usex
				    	    ,"uage": data.uage
				    	    ,"uaddress": data.uaddress
				    	  })
				    }
				  });
				  
				 // <!-- 当点击编辑是不弹框， 就将如下代码加上！  -->
				  var $ = layui.$, active = {
				  };
				  
				});
		</script>
</body>

	<div id="context" style="display: none;">
		<div style="padding-right: 30px;">
				<form class="layui-form" action="update2" method="post"  lay-filter="example">		<!-- layui-form 表单  -->
					  <div class="layui-form-item">   <!-- layui-form-item 表示一行 -->
					  <br/>
					  <input type="text" name="uid" />
					    <label class="layui-form-label">姓名</label>
					    <div class="layui-input-block">
					      <input type="text" name="uname" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
					    </div>
					  </div>
	
					  <div class="layui-form-item">
					    <label class="layui-form-label">性别</label>
					    <div class="layui-input-block">
					      <input type="radio" name="usex" value="男" title="男">
					      <input type="radio" name="usex" value="女" title="女">
					    </div>
					  </div>

					<div class="layui-form-item">   <!-- layui-form-item 表示一行 -->
					    <label class="layui-form-label">年龄</label>
					    <div class="layui-input-block">
					      <input type="number" name="uage" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
					    </div>
					  </div>
					  
					   <div class="layui-form-item">   <!-- layui-form-item 表示一行 -->
					    <label class="layui-form-label">地址</label>
					    <div class="layui-input-block">
					      <input type="text" name="uaddress" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
					    </div>
					  </div>
					 
					  <div class="layui-form-item">
					    <div class="layui-input-block">
					      <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
					      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
					      
					    </div>
					  </div>
				</form>
		</div>
	</div>
</html>
