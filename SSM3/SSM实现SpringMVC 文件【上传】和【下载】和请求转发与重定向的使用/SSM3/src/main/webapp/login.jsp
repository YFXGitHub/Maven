<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>MY Login。jsp</h1>
	<form action="/login/test1" method="post">
		uname:<input type="text" name="uname"/><br/>
		upwd:<input type="password" name="upwd"/><br/>
		uphone:<input type="number" name="uphone"/><br/>
		<button type="submit">提交</button>
	</form>

	
</body>
</html>