<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list</title>
<c:import url="head.jsp" />
</head>
<body>

	<c:import url="nav.jsp" />
	<hr>
	<div class="p-3">
		<div>
			<table class="table">
				<c:forEach var="data" items="${list}">
					<tr>
						<td class="col-1">${data.num}</td>
						<td class="col-1"><a href="data?num=${data.num}"
							class="text-wrap">${ data.title}</a></td>
						<td class="col-10">${data.id }</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div>count : ${count}</div>
		<div>
			<ul class="pagination justify-content-center">
				<c:forEach var="num" step="1" end="${count/5+1}" begin="1">
					<li class="page-item"><a class="page-link"
						href="/list?num=${num}">${num}</a></li>
				</c:forEach>
			</ul>
		</div>
	</div>
	<c:import url="script.jsp" />
</body>
</html>