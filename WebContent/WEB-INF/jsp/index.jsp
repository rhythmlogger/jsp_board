<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>홈</title>
<c:import url="head.jsp" />
</head>
<body>
	<c:import url="nav.jsp" />
	<hr>
	<div class="mx-auto" style="width: 500px">
		<div class="card" style="width: 18rem;">
			<div class="card-body">
				<h5 class="card-title">Github</h5>
				<h6 class="card-subtitle mb-2 text-body-secondary">Source Code</h6>
				<p class="card-text">/RhythmLogger/jsp_board</p>
				 <a href="https://github.com/rhythmlogger/jsp_board" class="btn btn-primary">Go</a>
			</div>
		</div>
	</div>
	<c:import url="script.jsp" />
</body>
</html>