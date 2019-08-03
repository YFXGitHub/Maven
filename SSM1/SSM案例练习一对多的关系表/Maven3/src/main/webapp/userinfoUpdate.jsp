<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>userinfoUpdate</title>
</head>
<body>
	
		<h1>userinfoUpdate</h1>userinfo
		<form action="update" method="post">
			<input type="hidden" name="uid" value="${userinfo.uid}" /><br/>
			usercard:<input type="text" name="usercard" value="${userinfo.usercard}" /><br/>
			userpwd:<input type="password" name="userpwd" value="${userinfo.userpwd}" /><br/>
			userphone:<input type="text" name="userphone" value="${userinfo.userphone}" /><br/>
			useraddress:<input type="text" name="useraddress" value="${userinfo.useraddress}" /><br/>
			<button type="submit">提交</button>
		</form>
</body>
</html>