<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Transfer</title>

<link href="static/css/bootstrap.css" rel="stylesheet">
<link href="static/css/styles.css" rel="stylesheet">

</head>
<body>
	<div class="container">
		<div class="row">
			<div class="navbar navbar-inverse ">
				<h3 class="col-lg-4">Payment System Manager</h3>
				<a class="btn btn-primary col-lg-offset-7" href="userpage">Назад</a>
			</div>
		</div>
	</div>
	<div class="container marg-sign-in">
		<h2 class="form-signin-heading  text-center">Перевод</h2>

		<form class="form-horizontal " action="transfermoney.do" method="POST">
			<div class="form-group">
				<label class="control-label col-lg-offset-2 col-lg-2">Снять
					со счёта:</label>
				<div class="col-lg-4">
					<select name="billid">
						<c:forEach var="id" items="${cardsBills}">
							<option><c:out value="${id}" /></option>
						</c:forEach>
					</select>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-lg-offset-2 col-lg-2" for="password">Пароль
					от счёта:</label>
				<div class="col-lg-4">
					<input type="password" class="form-control" id="password"
						placeholder="Введите пароль" name="billpassword" required>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-lg-offset-2 col-lg-2 " for="bill">На
					счёт:</label>
				<div class="col-lg-4">
					<input type="text" class="form-control" id="bill"
						placeholder="Введите счёт" name="billtransferid" required>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-lg-offset-2 col-lg-2 " for="summ">Сумма:</label>
				<div class="col-lg-4">
					<input type="text" class="form-control" id="summ"
						placeholder="Введите сумму" name="summ" required>
				</div>
			</div>

			<div class="form-group">
				<div class="col-lg-2 col-lg-offset-5">
					<button class="btn btn-lg btn-primary btn-block" type="submit"
						onclick="return validatesignIn()">Перевести</button>
				</div>
			</div>

		</form>
	</div>

	<script src="static/js/bootstrap.js" type="text/javascript"></script>
	<script src="static/js/validation.js" type="text/javascript"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</body>
</html>