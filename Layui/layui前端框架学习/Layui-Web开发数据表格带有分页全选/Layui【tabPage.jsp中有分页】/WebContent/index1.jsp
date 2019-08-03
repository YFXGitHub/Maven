<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>	
	<meta charset="UTF-8">
	<title>JSON</title>
		
	<script>
	/*
		案例一：
			var person = {"name":"里斯", "age":"12", "sex":"男"};
			alert(person.age);
			
		案例二：
			var json = [{"name":"拉沙德", "age":"42", "sex":"男"}, {"name":"绿卡速度", "age":"12", "sex":"女"}];
			for(var i=0; i<json.length; i++){
				alert(json[i].name);
			}
		
		案例三：
			var json = {"person":[{"name":"拉沙德", "age":"42", "sex":"男"}, {"name":"绿卡速度", "age":"12", "sex":"女"}]};
			alert(json.person[1].name);
			
		案例四:
			var json = {
				"person1":[{"name":"拉沙德", "age":"42", "sex":"男"}, {"name":"绿卡速度", "age":"12", "sex":"女"}],
				"person2":[{"name":"资料卢卡斯", "age":"33", "sex":"男"}, {"name":"拉斯科觉得", "age":"23", "sex":"女"}],
			};
			alert(json.person2[1].name);
	
	*/
		
		var json = {
						"person1":[{"name":"拉沙德", "age":"42", "sex":"男"}, {"name":"绿卡速度", "age":"12", "sex":"女"}],
						"person2":[{"name":"资料卢卡斯", "age":"33", "sex":"男"}, {"name":"拉斯科觉得", "age":"23", "sex":"女"}],
					};
		alert(json.person2[1].name);
		
		
		
	</script>
</head>
<body>
	<H1>学习Json</H1>
	

</body>
</html>