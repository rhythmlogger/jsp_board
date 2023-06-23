<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시</title>
<c:import url="head.jsp" />
</head>
<body>
	<c:import url="nav.jsp" />
	<div class="mx-auto" style="width: 500px;">
		<table class="table">
			<tr>
				<th scope="col">번호</th>
				<th scope="col">제목</th>
				<th scope="col">글쓴이</th>
			</tr>
			<tr>
				<td>${data.num}</td>
				<td>${data.title}</td>
				<td>${data.id }</td>
			</tr>
		</table>
		<div>
			<table class="table">
				<tr>
					<th scope="col">내용</th>
				</tr>
				<tr>
					<td>${data.contents}</td>
				</tr>
			</table>
		</div>
	</div>
	<div class="mx-auto" style="width: 500px;">
		<form action="delete-data" method="POST">
			<input type="hidden" name="num" value="${data.num}" /> <input
				type="submit" class="btn btn-danger" value="글 삭제">
		</form>
	</div>
	<div>
		<br>
	</div>
	<div class="mx-auto" style="width: 500px;">
		<table class="table">
			<tr>
				<th class='col-2'>아이디</th>
				<th class='col-8'>내용</th>
				<th class='col-2'>삭제</th>
			</tr>
			<c:forEach var="comment" items="${commentList}">
				<tr>
					<td>${comment.id }</td>
					<td>${comment.contents}</td>
					<td><c:if test="${sessionScope.id eq comment.id}">
							<form action="delete-comment" method="post">
								<input type="hidden" name="cnum" value="${comment.cnum}">
								<input type="hidden" name="num" value="${data.num}"> <input
									type="submit" value="댓글 삭제" class="btn btn-danger" />
							</form>
						</c:if></td>
				</tr>
			</c:forEach>
		</table>
		<div>
			<form action="comment" method="post">

				<input type="hidden" name="id" value="${sessionScope.id}"> <input
					type="hidden" name="num" value="${data.num}">
				<div class="input-group">
					<input type="text" name="contents" class="form-control"> <input
						class="btn btn-primary" type="submit">
				</div>
			</form>
		</div>
	</div>
	<c:import url="script.jsp" />
</body>
</html>