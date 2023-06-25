<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<c:import url="head.jsp" />
<script src="https://code.jquery.com/jquery-3.6.4.min.js">
	
</script>

<script>
	function id_check() {
		let id = document.getElementById("id").value;
		console.log(id);
		if (id.length < 4) {
			alert("4글자이상");
			return;
		} else {
			$.ajax({
				url : "/id-check", // 클라이언트가 HTTP 요청을 보낼 서버의 URL 주소
				data : {
					"id" : id
				},
				method : "POST", // HTTP 요청 메소드(GET, POST 등)
			}).done(function(json) {
				if (parseInt(json) == 1) {
					alert("중복");
				} else {

					let idElement = document.getElementById("id_check_button");
					idElement.value = "OK";
					let id_check_button = document.getElementById("id");
				}

			})
			// HTTP 요청이 실패하면 오류와 상태에 관한 정보가 fail() 메소드로 전달됨.
			.fail(function(xhr, status, errorThrown) {
				console.log('fail', status, errorThrown);
			})
		}

	}
	function check_password() {
		let password = document.getElementById("password").value;
		let re_password = document.getElementById("re_password").value;
		if (password != re_password) {
			alert("비밀번호가 일치하지 않습니다.");
		}
	}
</script>
</head>
<body>
	<jsp:include page="nav.jsp"></jsp:include>
	<hr>
	<form method="post" action="/register" id="form">
		<fieldset class="mx-auto" style="width: 250px;">
			<legend>회원가입</legend>
			<div>아이디</div>
			<div class="input-group">
				<input type="text" class="form-control" name="id" id="id" required
					minlength="4"> <input type="button" class="btn btn-primary"
					value="중복확인" id="id_check_button" onclick="id_check()">
			</div>
			<div>비밀번호</div>
			<div>
				<input type="password" class="form-control" name="password"
					id="password" required minlength="4">
			</div>
			<div>비밀번호 재입력</div>
			<div>
				<input type="password" class="form-control" name="re_password"
					required id="re_password" minlength="4" onchange="check_password()">
			</div>
			<div>이메일</div>
			<div>	
				<input type="email" name="email" class="form-control" required>
			</div>
			<div>
				<br>
			</div>
			<div class="mx-auto btn-group" style="width: 250px;">
				<input type="submit" value="회원가입" class="btn btn-primary"
					id="register_button" /> <input type="reset"
					class="btn btn-primary" value="취소" />
			</div>
		</fieldset>

	</form>
	<c:import url="script.jsp" />
</body>

</html>