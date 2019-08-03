<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>My index.jsp  | <a href="login.jsp">login.jsp</a> | <a href="/showDownFiles">showDownFiles文件下载</a></h1>
	<h2>Spring  MVC 实现单文件上传</h2>
	<form action="${pageContext.request.contextPath}/uploadFile" method="post" enctype="multipart/form-data">
		选择文件：<input type="file" name="myfile" accept="image/jpeg,image/png,image/gif"/><br/>
		文件描述：<input type="text" name="describe"/><br/>
		<button type="submit">提交</button>
	</form>
</body>
</html>