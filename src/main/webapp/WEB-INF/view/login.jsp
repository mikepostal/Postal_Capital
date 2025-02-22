<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Banners Hallmark - Login</title>
<link
	href="https://fonts.googleapis.com/css2?family=Nunito:wght@300;400;600;700;800&display=swap"
	rel="stylesheet">


<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/assets/css/bootstrap.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/assets/vendors/bootstrap-icons/bootstrap-icons.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/assets/css/app.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/assets/css/pages/auth.css"
	type="text/css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/assets/js/jquery-3.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/assets/vendors/perfect-scrollbar/perfect-scrollbar.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/assets/js/bootstrap.bundle.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/assets/js/data-table-jq.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/assets/js/main.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/assets/js/costom-c.js"></script>
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/resources/assets/images/favicon.svg"
	type="image/x-icon" type="text/css">
<link href="https://fonts.googleapis.com/css2?family=Spicy+Rice&family=Courgette&display=swap" rel="stylesheet">

</head>

<body>


	<div id="auth">

		<div class="row h-100">
			<div class="col-lg-5 col-12" >
				<div id="auth-left" class="cus-log">
					<!-- <div class="auth-logo">
                        <a href="index.html"><img src="assets/images/logo/logo.png" alt="Logo"></a>
                    </div> -->
					<h1 class="auth-title" style="font-family: 'Spicy Rice', cursive;">Log in.</h1>
					<p class="auth-subtitle mb-5" style="font-family: 'Courgette', cursive;">Log in with your credentials.</p>
					<c:url var="loginUrl" value="/login" />
					<c:url var="forgotUrl" value="/users/reset/forgot" />

					<%@ include file="common/error-and-success-message.jsp"%>

					<c:if test="${param.error != null}">

						<div class="eror-msg eror-msg-login error-msg">

							<p class="text-danger">Sorry! Invalid credentials</p>
							<a class="delete-msg btn btn-light">X</a>

						</div>
					</c:if>


					<form class="form1" action="${loginUrl}" method="post" style="font-family: 'Courgette', cursive;">
						<div class="form-group position-relative has-icon-left mb-4">
							<input type="text" required class="form-control form-control-xl"
								placeholder="Username" id="username" name="username"
								style="box-shadow: inset 0 4px 6px rgba(0, 0, 0, 0.5); outline: none;">
							<div class="form-control-icon">
								<i class="bi bi-person-fill"></i>
							</div>
						</div>
						<div class="form-group position-relative has-icon-left mb-4">
							<input type="password" required
								class="form-control form-control-xl" placeholder="Password"
								id="password" name="password"
								style="box-shadow: inset 0 4px 6px rgba(0, 0, 0, 0.5); outline: none;">
							<div class="form-control-icon">
								<i class="bi bi-shield-lock-fill"></i>
							</div>
						</div>
						<div class="form-check form-check-lg d-flex align-items-end">
							<input class="form-check-input me-2" type="checkbox" value=""
								id="flexCheckDefault"> <label
								class="form-check-label text-gray-600" for="flexCheckDefault">
								Keep me logged in </label>
						</div>
						<button class="btn btn-primary btn-block btn-lg mt-5 " style="box-shadow: 2px 4px 8px rgba(0,0,0,0.5);">Log
							in</button>
					</form>
					<div class="text-center mt-5 text-lg fs-4" style="font-family: 'Courgette', cursive;">

						<p>
							<a class="font-bold" href="${forgotUrl}">Forgot password?</a>
						</p>
					</div>
				</div>
			</div>
			<div class="col-lg-7 d-none d-lg-block">
				<div id="auth-right"
					style="display: flex; justify-content: center; align-items: center;">
					<img
						src="${pageContext.request.contextPath}/resources/assets/images/logo/image-logo.png"
						alt=""
						style="width: 60%;  height: auto;">
				</div>
			</div>

		</div>

	</div>
</body>

</html>