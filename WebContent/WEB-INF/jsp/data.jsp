<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>data</title>
<c:import url="head.jsp" />
</head>
<body>
	<c:import url="nav.jsp" />
	<div>Data</div>
	<div>
		<table class="table">
			<tr>
				<td>${data.num}</td>
				<td>${data.title}</td>
				<td>${data.id }</td>
			</tr>
		</table>
		<div>${data.contents}</div>
	</div>
	<br>
	<br>
	<br>
	<hr>
		<div>
			Comment
		</div>
	<div>
		<table class="table">
		<c:forEach var="comment" items="${commentList}">
				<tr>
					<td>${comment.num}</td>
					<td>${comment.rnum}</td>
					<td>${comment.contents}</td>
					<td>${comment.id }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<hr>
	<div>
		<form action="comment" method="post">
			<input type="hidden" name="id" value="${data.id}">
			<input type="hidden" name="num" value="${data.num}">
			<input type="text" name="contents">
			<input type="submit">
		</form>
	</div>
	<c:import url="script.jsp" />
</body>
</html>