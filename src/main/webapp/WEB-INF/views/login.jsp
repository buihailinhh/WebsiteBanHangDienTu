<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!-- directive của JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Log in</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.0/css/all.min.css">
<link rel="stylesheet" href="${rootpath}/admin/dist/css/login.css">
</head>

<body>
	<div class="container" id="container">
		<div class="form-container sign-up-container">
			<form method="POST" action="${classpath }/login_processing_url">
				<h1>Create Account</h1>
				<div class="social-container">
					<a href="#" class="social"><i class="fab fa-facebook-f"></i></a> <a
						href="#" class="social"><i class="fab fa-google-plus-g"></i></a> <a
						href="#" class="social"><i class="fab fa-linkedin-in"></i></a>
				</div>
				<span>or use your email for registration</span> <input type="text"
					placeholder="Name" /> <input type="email" placeholder="Email" />
				<input type="password" placeholder="Password" />
				<button type="submit">Sign Up</button>
			</form>
		</div>
		<div class="form-container sign-in-container">
			<form method="POST" action="${classpath}/login_processing_url">
				<c:if test="${not empty param.login_error }">
					<div class="alert alert-danger" role="alert">Login attempt
						was not successful, try again!!!</div>
				</c:if>
				<h1>Sign in</h1>
				<div class="social-container">
					<a href="#" class="social"><i class="fab fa-facebook-f"></i></a> <a
						href="#" class="social"><i class="fab fa-google-plus-g"></i></a> <a
						href="#" class="social"><i class="fab fa-linkedin-in"></i></a>
				</div>
				<span>or use your account</span> 
				<input type="text" id="username" name="username"	placeholder="Email" /> 
				
				<input type="password" id ="password" name="password"placeholder="Password" /> 
					
					<a href="#">Forgot your password?</a>
				<button type="submit">LOGIN</button>
			</form>
		</div>
		<div class="overlay-container">
			<div class="overlay">
				<div class="overlay-panel overlay-left">
					<h1>Welcome Back!</h1>
					<p>Vui lòng đăng nhập bằng thông tin cá nhân của bạn</p>
					<button class="ghost" id="signIn">Sign In</button>
				</div>
				<div class="overlay-panel overlay-right">
					<h1>Xin chào !</h1>
					<p>Cho 2 phút để nhập thông tin cá nhân</p>
					<button class="ghost" id="signUp">Sign Up</button>
				</div>
			</div>
		</div>
	</div>

	<script src="${rootpath}/admin/dist/css/login.js"></script>
</body>

</html>