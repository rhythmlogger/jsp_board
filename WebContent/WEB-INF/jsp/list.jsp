<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 목록</title>
<c:import url="head.jsp" />
</head>
<body>

	<c:import url="nav.jsp" />
	<hr>
	<div class="mx-auto" style="width:500px;">
		<div>
			<table class="table">
				<tr>
					<th scope="col">번호</th>
					<th scope="col">제목</th>
					<th scope="col">글쓴이</th>
					<th scope="col">조회</th>
				</tr>
				<c:forEach var="data" items="${list}">
					<tr>
						<td class="col-2">${data.num}</td>
						<td class="col-6"><a href="data?num=${data.num}"
							class="text-wrap">${ data.title}</a></td>
						<td class="col-2">${data.id }</td>
						<td class="col-2">${data.hit }</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div>게시글 수 : ${count}, 페이지 수 ${Double.valueOf(Math.ceil(count/5)).intValue()} </div>
		<div>
			<ul class="pagination justify-content-center">
				<c:forEach var="num" step="1" end="${Double.valueOf(Math.ceil(count/5)).intValue()}" begin="1">
					<li class="page-item"><a class="page-link"
						href="/list?num=${num}">${num}</a></li>
				</c:forEach>
			</ul>
		</div>
	</div>
	<c:import url="script.jsp" />
</body>
</html>