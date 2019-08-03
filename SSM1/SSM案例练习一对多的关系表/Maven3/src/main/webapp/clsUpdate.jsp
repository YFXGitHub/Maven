<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>clsUpdate</title>
</head>
<body>
	<h1>clsUpdate</h1>
	<form action="update" method="post">
		<input type="hidden" name="cid" value="${cls.cid}" /><br/>
		cname:<input type="text" name="cname" value="${cls.cname}" /><br/>
		<button type="submit">提交</button>
	</form>
</body>
</html>