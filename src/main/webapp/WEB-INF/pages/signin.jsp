<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Sign In</title>
<link href="static/css/bootstrap.css" rel="stylesheet">
<link href="static/css/styles.css" rel="stylesheet">
<style type="text/css">
.margggg {
	margin-left: 25px;
}

.cont {
	margin-top: 5px;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="navbar navbar-inverse ">
				<h3 class="col-lg-4">Payment System Manager</h3>
				<a class="btn btn-primary col-lg-offset-6" href="registration">Зарегестрироваться</a>
				<!-- <form action="registration.do" method="GET">
					<div class="form-group">
						<div class="col-lg-2 col-lg-offset-5">
							<button type="submit"
								class="btn btn-primary col-lg-offset-6 btn-block">Зарегистрироваться</button>
						</div>
					</div>	
				</form> -->
			</div>
		</div>
	</div>
	<div class="container marg-sign-in">
		<h2 class="form-signin-heading col-lg-offset-5">Please sign in</h2>
		<form class="form-horizontal " action="userpage.do" method="POST">

			<div class="form-group">
				<label class="control-label col-lg-offset-3 col-lg-1 " for="E-mail">E-mail:</label>
				<div class="col-lg-4">
					<input type="email" class="form-control" id="E-mail"
						placeholder="Введите e-mail" name="email" required>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-lg-offset-3 col-lg-1" for="password">Пароль:</label>
				<div class="col-lg-4">
					<input type="password" class="form-control" id="password"
						placeholder="Введите пароль" name="password" required>
				</div>
			</div>
			<div class="form-group">
				<div class="col-lg-4 col-lg-offset-4">
					<button class="btn btn-lg btn-primary btn-block" type="submit"
						onclick="return validatesignIn()">Sign in</button>
				</div>
			</div>
		</form>
	</div>

	<c:if test="${empty useremail}">
	</c:if>
	<c:if test="${not empty useremail}">
		<div class="container marg-sign-in col-lg-offset-4 cont">
			<div class="alert alert-danger col-lg-4 margggg text-center" role="alert">
				<strong>Введен некорректный логин!</strong>
			</div>
		</div>
	</c:if>
	<c:if test="${empty userpassword}">
	</c:if>
	<c:if test="${not empty userpassword}">
	<div class="container marg-sign-in col-lg-offset-4 cont">
		<div class="alert alert-danger col-lg-4 margggg text-center" role="alert">
			<strong>Введен некорректный пароль!</strong>
		</div>
	</div>
	</c:if>

	<script src="static/js/validation.js" type="text/javascript"></script>
	<script src="static/js/bootstrap.js" type="text/javascript"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</body>
</html>