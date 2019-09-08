<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/login_files/css/bootstrap-3.3.4.css">
<link href="/login_files/css/component.css" rel="stylesheet">
</head>
<body>

	 <div class="layui-header">
    <div class="layui-logo">同城配送管理后台平台</div>
    <!-- 头部区域（可配合layui已有的水平导航） -->
    <ul class="layui-nav layui-layout-left">
      <li class="layui-nav-item"><a href="">控制台</a></li>
      <li class="layui-nav-item"><a href="">商品管理</a></li>
      <li class="layui-nav-item"><a href="">用户</a></li>
      <li class="layui-nav-item">
        <a href="javascript:;">其它系统</a>
        <dl class="layui-nav-child">
          <dd><a href="">邮件管理</a></dd>
          <dd><a href="">消息管理</a></dd>
          <dd><a href="">授权管理</a></dd>
        </dl>
      </li>
    </ul>
    <ul class="layui-nav layui-layout-right">
      <li class="layui-nav-item">
        <a href="javascript:;">
          <img src="/layui/images/face/12.gif" class="layui-nav-img">
       ${user.uname}
        </a>
        <dl class="layui-nav-child">
          <dd><a href="javascript:;" class="md-trigger"  data-modal="modal-1">基本资料</a></dd>
          <dd><a href="javascript:;" class="md-trigger"  data-modal="modal-2">安全设置</a></dd>
        </dl>
      </li>
      <li class="layui-nav-item"><a href="/login.jsp">退了</a></li>
    </ul>
  </div>
  
<!-- 触发  弹出层    -->
	<div class="md-modal md-effect-1" id="modal-1">
		<div class="md-content">
			<h3>当前用户的个人信息</h3>
			<div>
				<p>----------------------------------------------------------------</p>
				<ul>
				<li><strong>帐号:</strong>  ${user.uname} </li>
				<li><strong>Email:</strong>  ${user.emial}</li>
				<li><strong>phone:</strong> ${user.phone} </li>
				</ul>
				<button class="md-close btn-sm btn-primary">Close me!</button>
			</div>
		</div>
	</div>
	
	
	<!-- 触发  弹出层    -->
	<div class="md-modal md-effect-1" id="modal-2">
		<div class="md-content">
			<h3>修改密码：</h3>
			<div>
				<form id="addForm" action="/user/updatePwd" method="post">
					<p>----------------------------------------------------------------</p>
					<ul>
					<input type="hidden" name="uid" value="${user.uid}" />
					<li><strong>原始密码:</strong> <input type="text" name="upwd"/>  </li>
					<li><strong>新密码:</strong>  <input type="text" name="pwd2"/></li>
					<li><strong>phone:</strong> ${user.phone} </li>
					</ul>
					<button class="md-close btn-sm btn-primary" type="button" id="submitAdd">Submit !</button>
					
				</formm>
			</div>
		</div>
	</div>

	<!--  触发   弹出层的遮皁层    -->
	<div class="md-overlay"></div>

<script src="/login_files/js/classie.js"></script>
<script src="/login_files/js/modalEffects.js"></script>
<script type="text/javascript" src="/login_files/js/jquery-1.12.3.min.js"></script>
<script type="text/javascript">
	$(function(){
		
		$("#submitAdd").click(function(){
		    
			  var targetUrl = $("#addForm").attr("action");    
			  var data = $("#addForm").serialize();     
			 // alert(targetUrl+"---"+data);
			  $.ajax({ 
				    type:'post',  
				    url:targetUrl, 
				    cache: false,
				    data:data,  //重点必须为一个变量如：data
				    dataType:'text', 
				    success:function(data){      
				      	$("input[name='upwd']").val(null);
				    	$("input[name='pwd2']").val(null);
				    	alert('修改:'+data);
				      
				    },
				    error:function(){ 
				     alert("请求失败")
				    }
				   })
			})
	
		
	});
</script>
  
</body>
</html>