<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>stuUpdate</title>
</head>
<body>
	<h1>stuUpdate</h1>
	<form action="update" method="post">
		<input type="hidden"  name="sid" value="${stu.sid}" /><br/>
		sname:<input type="text" name="sname" value="${stu.sname}" /><br/>
		sex:<input type="text" name="sex" value="${stu.sex}" /><br/>
		age:<input type="text" name="age" value="${stu.age}" /><br/>
		cj:<input type="text" name="cj" value="${stu.cj}" /><br/>
		
		select:<select name="cls.cid">	
					<c:forEach items="${clsList}" var="cls">
						<!-- 设置下拉列表框的默认值:使用关键字selected  -->
						<c:if test="${stu.cls.cid == cls.cid}">
							<option value="${cls.cid}" selected="selected">${cls.cname}</option>
						</c:if>
						<c:if test="${stu.cls.cid != cls.cid}">
							<option value="${cls.cid}">${cls.cname}</option>
						</c:if>
					</c:forEach>
			   </select>
		<button type="submit">提交</button>
	</form>
</body>
</html>

