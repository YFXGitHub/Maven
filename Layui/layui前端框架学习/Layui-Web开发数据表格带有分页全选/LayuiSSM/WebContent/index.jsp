<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
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
      
      <blockquote class="layui-elem-quote">
        注意：该页面只是简单的后台布局示例，并不是一整套后台系统方案，您可以关注 layui 官方提供后台模板解决方案：
        <a href="https://www.layui.com/admin/" target="_blank" class="layui-btn layui-btn-danger">layuiAdmin</a>
      </blockquote>
      
      <blockquote class="layui-elem-quote">
        layui 之所以赢得如此多人的青睐，更多是在于它“前后台系统通吃”的能力。既可编织出绚丽的前台页面，又可满足繁杂的后台功能需求。
        <br>layui 后台布局， 致力于让每一位开发者都能轻松搭建自己的后台模板。
      </blockquote>
      
      <a href="/doc/element/layout.html#admin" target="_blank" class="layui-btn layui-btn-lg">获取该布局代码</a>
      
      <br><br><br><br>
    
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
</body>
</html>