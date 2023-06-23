<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<ul class="nav  justify-content-center">
	<li class="nav-item"><a class="nav-link" href="/">[ 홈 ]</a></li>
	<li class="nav-item"><a class="nav-link" href="/list">[ 목록 ]</a></li>
	<c:choose>
		<c:when test="${sessionScope.id != null}">
			<li class="nav-item"><a class="nav-link" href="/logout">[ 로그아웃 ]</a></li>
			<li class="nav-item"><a class="nav-link" href="/write">[ 글쓰기 ]</a></li>
			<li class="nav-item"><a class="nav-link disabled" href="#">${sessionScope.id}님
					반갑습니다</a></li>
		</c:when>
		<c:otherwise>
			<li class="nav-item"><a class="nav-link" href="/register">[ 회원가입 ]</a></li>
			<li class="nav-item"><a class="nav-link" href="/login">[ 로그인 ]</a></li>
		</c:otherwise>
	</c:choose>
</ul>
