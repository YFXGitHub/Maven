<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
		<script type="text/javascript" src="js/jquery-1.9.0.min.js"></script>
		<script type="text/javascript">
			function ClickA(){
				$.ajax({
					url:"jsonServlet",
					dataType:"json",
					Type:"GET",
					success: function(data){
						alert("成功！"+data);
						alert(data.name);
					},
					error:function(){
						alert("失败");
					}
					
				});
				alert("sdf");
			}
			
		</script>
</head>
<body>
	
		<a href="javascript:;" onclick="ClickA()">点我</a>
</body>
</html>