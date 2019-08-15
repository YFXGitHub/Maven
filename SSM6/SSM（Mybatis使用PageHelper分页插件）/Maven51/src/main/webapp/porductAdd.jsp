<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>porductAdd</title>
</head>
<body>
		<h1>porductAdd</h1>
	<form action="${pageContext.request.contextPath}/porduct/add" method="post">
		pname:<input type="text" name="pname" /><br/>
		pice:<input type="text" name="pice" /><br/>
		pdesc:<input type="text" name="pdesc" /><br/>
		<button type="submit">提交</button>
	</form>

</body>
</html>