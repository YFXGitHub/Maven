<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>porductList</title>
</head>
<body>

	<h1>porductList</h1>
	<c:if test="${empty findPorductAll}">
		<h2>暂时没有数据！</h2>
	</c:if>
	<c:if test="${not empty findPorductAll}">
		<h3><a href="${pageContext.request.contextPath}/porductAdd.jsp">添加</a></h3>
		<table>
			<tr>
				<td>pid</td>
				<td>pname</td>
				<td>pice</td>
				<td>pdesc</td>
				<td>pdate</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${findPorductAll}" var="p">
				<tr>
					<td>${p.pid}</td>
					<td>${p.pname}</td>
					<td>${p.pice}</td>
					<td>${p.pdesc}</td>
					<td>${p.pdate}</td>
					<td><a href="/porduct/updatePre?pid=${p.pid}">修改</a> · <a href="/porduct/delete?pid=${p.pid}">删除</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>