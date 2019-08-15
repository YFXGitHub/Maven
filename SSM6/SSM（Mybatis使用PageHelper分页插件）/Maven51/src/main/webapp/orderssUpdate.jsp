<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>orderssUpdate</title>
</head>
<body>
			<h1>orderssUpdate</h1>
			<form action="${pageContext.request.contextPath}/orderss/update" method="post">
				<input type="text" name="oid" value="${orderss.oid}" /></br/>
				oNum：<input type="text" name="oNum" value="${orderss.oNum}" /></br/>
				otime：<input type="text" name="otimeString" value="${orderss.otimeString}" /></br/>
				opeopleCount：<input type="text" name="opeopleCount" value="${orderss.opeopleCount}" /></br/>
				oDesc：<input type="text" name="oDesc" value="${orderss.oDesc}" /></br/>
				opayType：<input type="text" name="opayType" value="${orderss.opayType}" /></br/>
				ostatus：<input type="text" name="ostatus" value="${orderss.ostatus}" /></br/>
				<select name="porduct.pid">
					<c:forEach items="${porduct}" var="p">
						<c:if test="${orderss.porduct.pid == p.pid}">
							<option value="${p.pid}" selected="selected">${p.pname}</option>
						</c:if>
						<c:if test="${orderss.porduct.pid != p.pid}">
							<option value="${p.pid}" >${p.pname}</option>
						</c:if>
						
					</c:forEach>
				</select>
				<button type="submit">提交</button>
			</form>
</body>
</html>