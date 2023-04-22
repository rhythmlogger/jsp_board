<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
</head>
<body>
	<c:import url="nav.jsp" />
	<hr>
	<div>
		<form method="post" action="login" id="form">
			<div>id</div>
			<div>
				<input type="text" name="id" id="id" required minlength="4">
			</div>
			<div>password</div>
			<div>
				<input type="password" name="password" id="password" required  minlength="4">
			</div>
			<div>
				<input type="submit" value="로그인" />
			</div>
			<div>
				<input type="reset" value="취소"/>
			</div>
		</form>
	</div>
</body>
</html>