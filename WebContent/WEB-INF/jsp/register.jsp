<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>register</title>
<script src="https://code.jquery.com/jquery-3.6.4.min.js">
	
</script>

<script>
	function id_check() {
		let id = document.getElementById("id").value;
		console.log(id);
		if (id.length < 4){
			alert("4글자이상");
			return ;
		}else{
			$.ajax({
				url : "/id_check", // 클라이언트가 HTTP 요청을 보낼 서버의 URL 주소
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
	function check_password(){
		let password=document.getElementById("password").value;
		let re_password=document.getElementById("re_password").value;
		if ( password != re_password){
			alert("비밀번호가 일치하지 않습니다.");
		}
	}
</script>
</head>
<body>
	<jsp:include page="nav.jsp"></jsp:include>
	<hr>
	<div>
		<form method="post" action="/register" id="form">
			<div>id</div>
			<div>
				<input type="text" name="id" id="id" required minlength="4"> <input
					type="button" value="중복확인" id="id_check_button"
					onclick="id_check()">
			</div>
			<div>password</div>
			<div>
				<input type="password" name="password" id="password" required  minlength="4">
			</div>
			<div>re-password</div>
			<div>
				<input type="password" name="re_password" required id="re_password"  minlength="4" onchange="check_password()">
			</div>
			<div>e-mail</div>
			<div>
				<input type="email" name="email"  required>
			</div>
			<div>
				<input type="submit" value="회원가입" id="register_button" />
			</div>
			<div>
				<input type="reset" value="취소"/>
			</div>
		</form>
	</div>

</body>

</html>