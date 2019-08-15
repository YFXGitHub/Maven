<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h1>OrderssList</h1>
		<c:if test="${empty orderss}">
			<h3>暂时没有数据！</h3>
		</c:if>
		<c:if test="${not empty orderss}">
			<table border="1" width="900">
				<tr>
					<td>oid</td>
					<td>oNum</td>
					<td>otime</td>
					<td>opeopleCount</td>
					<td>oDesc</td>
					<td>opayType</td>
					<td>ostatus</td>
					<td>pname</td>
					<td>操作</td>
				</tr>
				<c:forEach items="${orderss}" var="o">
					<tr>
						<td>${o.oid}</td>
						<td>${o.oNum}</td>
						<td>${o.otimeString}</td>
						<td>${o.opeopleCount}</td>
						<td>${o.oDesc}</td>
						<td>${o.opayType == 1? '微信支付':'支付宝'}</td>
						<td>${o.ostatus ==1? '上架':'下架'}</td>
						<td>${o.porduct.pname}</td>
						<td><a href="${pageContext.request.contextPath}/orderss/delete?oid=${o.oid}">删除</a> | 
							<a href="${pageContext.request.contextPath}/orderss/updatePre?oid=${o.oid}">修改</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		
</body>
</html>