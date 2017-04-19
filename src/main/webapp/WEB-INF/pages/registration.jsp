<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="static/css/bootstrap.css" rel="stylesheet">
<link href="static/css/styles.css" rel="stylesheet">
<title>Registration</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="navbar navbar-inverse ">
				<h3 class="col-lg-4">Payment System Manager</h3>
				<a class="btn btn-primary col-lg-offset-7" href="signin">Войти</a>
				<!-- <form action="signin.do" method="GET">
					<div class="form-group">
						<div class="col-lg-2 col-lg-offset-5">
							<button type="submit"
								class="btn btn-primary col-lg-offset-6 btn-block">Войти</button>
						</div>
					</div>	
				</form> -->
			</div>
		</div>
	</div>
	<div class="container marg">
		<h2 class="form-signin-heading col-lg-offset-5">Please sign up</h2>

		<form class="form-horizontal " action="registration.do" method="POST">
			<div class="form-group">
				<label class="control-label col-lg-offset-2 col-lg-2" for="surname">Фамилия:</label>
				<div class="col-lg-4">
					<input type="text" class="form-control" id="surname"
						placeholder="Введите фамилию" name="surname" required>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-lg-offset-3 col-lg-1" for="name">Имя:</label>
				<div class="col-lg-4">
					<input type="text" class="form-control" id="name"
						placeholder="Введите имя" name="name" required>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-lg-offset-3 col-lg-1" for="lastname">Отчество:</label>
				<div class="col-lg-4">
					<input type="text" class="form-control" id="lastname"
						placeholder="Введите отчество" name="lastname" required>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-lg-offset-3 col-lg-1 " for="E-mail">E-mail:</label>
				<div class="col-lg-4">
					<input type="email" class="form-control" id="E-mail"
						placeholder="Введите e-mail" name="email" required>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-lg-offset-2 col-lg-2">Дата
					рождения:</label>
				<div class="col-lg-4">
					<input type="date" class="form-control" id="date"
						placeholder="Повторите пароль" name="dateOfBirth" required
						max="2017-04-07" min="1950-01-01">
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
				<label class="control-label col-lg-offset-2 col-lg-2"
					for="repeatpassword">Повторите пароль:</label>
				<div class="col-lg-4">
					<input type="password" class="form-control" id="repeatpassword"
						placeholder="Повторите пароль" name="repeatpassword" required>
				</div>
			</div>

			<div class="form-group">
				<div class="col-lg-2 col-lg-offset-5">
					<button class="btn btn-lg btn-primary btn-block" type="submit"
						onclick="return validateRegistration()">Sign up</button>
				</div>
			</div>
		</form>
	</div>

	<script src="static/js/validation.js" type="text/javascript"></script>
	<script src="static/js/bootstrap.js" type="text/javascript"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</body>
</html>