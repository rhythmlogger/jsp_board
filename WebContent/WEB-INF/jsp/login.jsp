<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<c:import url="head.jsp" />
<style>
</style>
</head>
<body>
	<c:import url="nav.jsp" />
	<hr>
	<fieldset class="mx-auto" style="width: 250px;">
		<legend>로그인</legend>
		<form method="post" action="login" id="form">
			<div>아이디</div>
			<div>
				<input type="text" name="id" id="id" class="form-control"  required minlength="4">
			</div>
			<div>비밀번호</div>
			<div>
				<input type="password" class="form-control" name="password" id="password" required
					minlength="4">
			</div>
			<div>
				<br/>
			</div>
			<div class="btn-group mx-auto" style="width:250px;">
				<input type="submit" class="btn btn-primary" value="로그인" /> <input type="reset"
					value="취소" class="btn btn-primary"/>
			</div>
		</form>
	</fieldset>
	<c:import url="script.jsp" />
</body>
</html>