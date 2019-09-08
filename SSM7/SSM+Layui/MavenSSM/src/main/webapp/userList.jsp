<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>用户管理</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <meta name="apple-mobile-web-app-status-bar-style" content="black"> 
  <meta name="apple-mobile-web-app-capable" content="yes">
  <meta name="format-detection" content="telephone=no">
  
  <link rel="stylesheet" href="/layui/css/layui.css"  media="all">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
 	<!-- 引用top -->
 	<jsp:include page="index_top.jsp" />
  
  <div class="layui-side layui-bg-black">
   <!-- 引用left -->
 	<jsp:include page="index_left.jsp" />
  </div>
  
  <div class="layui-body">
    <!-- 内容主体区域 -->
    <div style="padding: 15px;">
      
    	<table class="layui-hide" id="test" lay-filter="test"></table>
      
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
			
       
      

  </div>
  
  <div class="layui-footer">
    <!-- 底部固定区域 -->
    © layui.com - 底部固定区域
  </div>
</div>
	<script src="/layui/layui.js" charset="utf-8"></script>
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
						    elem: '#test'			//获取table id值
						    ,url:'/user/pagelist'			//ajax 异步请求路径
						    ,toolbar: '#toolbarDemo'	//向表格头部中引入操作全选按钮 
						    ,title: '用户数据表'			//设置导出数据时的表名
						    ,width: 900					//设置整个表格的宽度
						    ,cols: [[	
						    	{type:"checkbox"},  //开启全选操作
						       {field:'uid', width:100, title: 'ID', sort: true}  //sort: true;  可排序
						      ,{field:'uname', width:120, title: '帐号'}
						      ,{field:'upwd', width:100, title: '密码'}
						      ,{field:'emial', width:150, title: '电子邮箱'}
						      ,{field:'phone', width:150, title: '手机号'}
						      ,{width:220, title:"操作", toolbar: '#barDemo'}    //toolbar: 向表格中引入 操作按钮 
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
				  
				  //监听行工具事件
				  table.on('tool(test)', function(obj){
				    var data = obj.data;
				    //console.log(obj)
				    if(obj.event === 'del'){		//监听删除操作
				      layer.confirm('真的删除行么', function(index){
				    	  layer.msg('ID：'+ data.uid + ' 的删除操作');
				    	  //使用jquery ajax进行异步删除！
				    	  jquery.ajax({
					    		 url:"/user/delete",
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
				    	    ,"upwd": data.upwd
				    	    ,"emial": data.emial
				    	    ,"phone": data.phone
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
				<form class="layui-form" action="/user/update" method="post"  lay-filter="example">		<!-- layui-form 表单  -->
					  <div class="layui-form-item">   <!-- layui-form-item 表示一行 -->
					  <br/>
					  <input type="text" name="uid" />
					    <label class="layui-form-label">帐号</label>
					    <div class="layui-input-block">
					      <input type="text" name="uname" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
					    </div>
					  </div>
	
					 <div class="layui-form-item">   <!-- layui-form-item 表示一行 -->
					    <label class="layui-form-label">密码</label>
					    <div class="layui-input-block">
					      <input type="text" name="upwd" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
					    </div>
					  </div>
					  
					<div class="layui-form-item">   <!-- layui-form-item 表示一行 -->
					    <label class="layui-form-label">电子邮箱</label>
					    <div class="layui-input-block">
					      <input type="email" name="emial" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
					    </div>
					  </div>
					  
					   <div class="layui-form-item">   <!-- layui-form-item 表示一行 -->
					    <label class="layui-form-label">手机号</label>
					    <div class="layui-input-block">
					      <input type="text" name="phone" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
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




 