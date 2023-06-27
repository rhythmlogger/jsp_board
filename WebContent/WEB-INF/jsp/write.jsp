<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>register</title>
<c:import url="head.jsp" />
<script
	src="https://cdn.ckeditor.com/ckeditor5/38.0.1/classic/ckeditor.js"></script>
<script
	src="https://cdn.ckeditor.com/ckeditor5/38.0.1/classic/translations/ko.js"></script>
</head>
<body>
	<jsp:include page="nav.jsp"></jsp:include>
	<hr>
	<div class="mx-auto" style="width: 500px;">
		<form class="p-3" method="post" action="/write" id="form">
			<fieldset>
				<legend>게시글 작성</legend>
				<div class="input-group">
					<div class="input-group-text">title</div>
					<input type="text" class="form-control" name="title" id="title"
						required>
				</div>
				<div>
					<br>
				</div>
				<div class="input-group-prepend">
					<div class="input-group-text">contents</div>
					<div>
						<textarea class="form-control" name="contents" id="contents"
							rows="24"></textarea>
					</div>
				</div>
				<div>
					<br>
				</div>
				<div>
					<c:choose>
						<c:when test="${sessionScope.id != null}">
							<input type="hidden" name="id" id="id" value="${sessionScope.id}" />
						</c:when>
						<c:otherwise>
							<input type="hidden" name="id" id="id" value="guest" />

						</c:otherwise>
					</c:choose>
				</div>
				<div>
					<input type="submit" class="form-control" value="작성"> <input
						type="reset" class="form-control" value="취소" />
				</div>
			</fieldset>
		</form>
	</div>
	<script>
		ClassicEditor.create(document.querySelector('#contents'), {
			language : "ko",
			 ckfinder: {
			        uploadUrl: '/data-image'
		    },
		    mediaEmbed: {
		        previewsInData:true
		    },
		})
	</script>
	<c:import url="script.jsp" />
</body>

</html>