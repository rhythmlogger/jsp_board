<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>nav</title>
</head>
<body>
	<ul>
		<li><a href="/">index</a></li>
		<li><a href="/list">list</a></li>
		<c:choose>
			<c:when test="${sessionScope.id != null}">
				<li>${sessionScope.id}</li> 님 반갑습니다
				<li><a href="/logout">logout</a></li>
			</c:when>
			<c:otherwise>
				<li><a href="/register">register</a></li>
				<li><a href="/login">login</a></li>
			</c:otherwise>
		</c:choose>
	</ul>
</body>
</html>