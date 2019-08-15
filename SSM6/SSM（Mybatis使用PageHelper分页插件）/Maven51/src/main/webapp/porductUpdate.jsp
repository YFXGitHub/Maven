<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>porductUpdate</title>
</head>
<body>
	
	<h1>porductUpdate</h1>
	<form action="${pageContext.request.contextPath}/porduct/update" method="post">
		<input type="hidden" name="pid" value="${porduct.pid}" /><br/>
		pname:<input type="text" name="pname" value="${porduct.pname}" /><br/>
		pice:<input type="text" name="pice" value="${porduct.pice}" /><br/>
		pdesc:<input type="text" name="pdesc" value="${porduct.pdesc}" /><br/>
		pdate:<input type="text" name="pdate" value="${porduct.pdate}" /><br/>
		<button type="submit">提交</button>
	</form>

</body>
</html>