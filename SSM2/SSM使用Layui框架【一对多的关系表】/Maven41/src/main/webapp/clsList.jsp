<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" href="/layui/lib/layui/css/layui.css"  media="all">
</head>
<body>
	
	<table class="layui-hide" id="test" lay-filter="test"></table>
	
	<!-- 引用行内按钮 -->
	<script type="text/html" id="toolbarDemo">
  	<div class="layui-btn-container">
    	<button class="layui-btn layui-btn-sm" lay-event="getCheckData">获取选中行数据</button>
    	<button class="layui-btn layui-btn-sm" lay-event="getCheckLength">获取选中数目</button>
    	<button class="layui-btn layui-btn-sm" lay-event="isAll">验证是否全选</button>
  	</div>
	</script>
 
 	<!-- 引用操作按钮 -->
	<script type="text/html" id="barDemo">
  		<a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
  		<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
  		<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
	</script>
	
	
	<script src="/layui/lib/layui/layui.js" charset="utf-8"></script> <!-- 绝对路径 -->
	<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 --> 
	<script>
		layui.use(['layer', 'jquery', 'form', 'table'], function(){
		  var table = layui.table;
		  var form = layui.form;
		  var layer = layui.layer;
		  var $ = layui.jquery;

		  table.render({
		    elem: '#test'
		    ,url:'/cls/findAll'		//绝对路径
		    ,toolbar: '#toolbarDemo'
		    ,title: '班级数据表'
		    ,totalRow: true
		    ,cols: [[
		    	 {type:'checkbox'}
		      ,{field:'cid', title:'ID', width:120, sort: true}
		      ,{field:'cname', title:'班级名', width:150, edit: 'text'}
		      ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:200}
		    
		    ]]
		    ,page: true
		    ,response: {
		      statusCode: 200 //重新规定成功的状态码为 200，table 组件默认为 0
		    }
		    ,parseData: function(res){ //将原始数据解析成 table 组件所规定的数据
		      return {
		        "code": res.status, //解析接口状态
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
		      case 'getCheckData':
		        var data = checkStatus.data;
		        layer.alert(JSON.stringify(data));
		      break;
		      case 'getCheckLength':
		        var data = checkStatus.data;
		        //定义一个数组  来承接 全选的值！   
		         var arr = new Array();
		        for(var i=0; i<data.length; i++){
		        	arr[i] = data[i].cid;
		        }
		       // alert(arr);
		       // layer.msg('选中了：'+ data.length + ' 个');
		       //	执行批量删除！
		       $.ajax({
		    	   url:"/cls/deleteClsAll",
		    	   data:"uid="+arr,
		    	   dataType:"text",
		    	   type:"GET",
		    	   success: function(data){
		    		   layer.msg('执行批量删除访问'+data);
		    		   location.reload();	//此方法可重新加载html，jsp页面！
		    	   },
		    	   error: function(){
		    		   layer.msg('执行批量删除访问失败！');
		    	   }
		       });
		       
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
		    if(obj.event === 'detail'){		//监听查看按钮
		        layer.msg('ID：'+ data.cid + ' 的查看操作');
		      } else if(obj.event === 'del'){		//监听删除按钮
		      layer.confirm('真的删除行么', function(index){
		    	  layer.msg('ID：'+ data.cid + ' 的删除操作');
		    	  $.ajax({
		    		 url:"/cls/deleteCls",		//执行异步删除， 不刷新当前页面
		    		 data:"cid="+data.cid,
		    		 dataType:"text",
		    		 type:"GET",
		    		 success:function(data){
		    			if(data == 'yes'){
			    			 obj.del();		//删除当前行
		    			}
		    			if(data == 'no'){
		    				 layer.msg('当前班级下有学生，删除失败！');
		    			}
		    		 },
		    		 error:function(){
		    			 layer.msg('执行删除访问失败！');
		    		 }
		    	  });
		        //obj.del();
		        layer.close(index);
		      });
		    }  else if(obj.event === 'edit'){		//监听编辑按钮
		       // layer.alert('编辑行：<br>'+ JSON.stringify(data))
		       // 打开表单弹框
		       layer.open({
					type:"1",				//0  就是指  提示框！
					title:"弹出表单",			//标题
					skin:"layui-layer-lan",	//标题的背景色
					area:["480px", "260px"],	//设置宽，高！
					//offset:"auto",   默认页面居中显示！
					shade:[0.8, '#2F4056'],		//遮皁
					shadeClose:true,			//点击遮皁 关闭
					//time:5000,				//表示5秒后关闭！
					anim:0,						//弹出动画 0~6！
					content:$("#context")  //content:"提示！" 也可写入标签
				});
		        //表单初始赋值
		        form.val('example', {
		          "cid": data.cid // "name": "value"
		          ,"cname": data.cname
		        });
		    }
		  });
		  
		});
	</script>
	
</body>

	<div id="context" style="display: none;">
		<div style="padding-right: 40px; margin-top: 25px;">
				<form class="layui-form" action="/cls/updateCls" method="post"   lay-filter="example">		<!-- lay-filter="example"  设置表单初始值  -->
					  <div class="layui-form-item">   <!-- layui-form-item 表示一行 -->
					    <label class="layui-form-label">cid</label>
					    <div class="layui-input-block">
					      <input type="text" name="cid" required  lay-verify="required"  autocomplete="off" class="layui-input" readonly="readonly">
					    </div>
					  </div>
					  
					  <div class="layui-form-item">   <!-- layui-form-item 表示一行 -->
					    <label class="layui-form-label">cname</label>
					    <div class="layui-input-block">
					      <input type="text" name="cname" required  lay-verify="required" placeholder="请输入班级名" autocomplete="off" class="layui-input">
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