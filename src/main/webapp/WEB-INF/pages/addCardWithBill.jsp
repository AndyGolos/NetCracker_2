<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Add Card With Bill</title>

<link href="static/css/bootstrap.css" rel="stylesheet">
<link href="static/css/styles.css "  rel="stylesheet">
<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.2/css/bootstrap-select.min.css" rel="stylesheet">
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="navbar navbar-inverse ">
				<h3 class="col-lg-4">Payment System Manager</h3>
				<a class="btn btn-primary col-lg-offset-7"
					href="transitionpage">Назад</a>
			</div>
		</div>
	</div>




	<div class="container marg-sign-in">
		<h2 class="form-signin-heading text-center">Создать карточку</h2>
		<form class="form-horizontal" action="newcardinfo.html">


			<div class="form-group">
				<label class="control-label col-lg-offset-3 col-lg-1">Тип:</label>
				<div class="col-lg-4">
					<select class="selectpicker form-control" data-style="btn-success"
						id="type">
						<option>Visa</option>
						<option>MasterCard</option>
						<option>Maestro</option>
					</select>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-lg-offset-3 col-lg-1" for="password">Пароль:</label>
				<div class="col-lg-4">
					<input type="password" class="form-control" id="password"
						placeholder="Введите пароль" required>
				</div>
			</div>

			<div class="form-group">
				<div class="col-lg-4 col-lg-offset-4">
					<button class="btn btn-lg btn-primary btn-block" type="submit"
						onclick="return validateAddCard()">Создать</button>
				</div>
			</div>

		</form>
	</div>

	<script src="static/js/validation.js" type="text/javascript"></script>
	<script src="static/js/bootstrap.js" type="text/javascript"></script>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.2/js/bootstrap-select.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.2/js/i18n/defaults-*.min.js"></script>

</body>
</html>