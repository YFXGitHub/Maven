<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		
		<h1>My index.jsp  子表中需要主表的数据</h1>
		<form action="/login" method="post">
			name:<input type="text" name="name" /><br/>
			pwd:<input type="password" name="pwd" /><br/>
			cname:<input type="text" name="cls.cname" /><br/>
			<button type="submit">提交</button>
		</form>
		
	
</body>
</html>