<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Card Info</title>

<link href="static/css/bootstrap.css" rel="stylesheet">
<link href="static/css/styles.css" rel="stylesheet">

<style type="text/css">
.containertext {
	padding-top: 100px;
}

.alert {
	padding-bottom: 40px;
}
</style>

</head>
<body>
	<div class="container">
		<div class="row ">
			<div class="navbar navbar-inverse ">
				<h3 class="col-lg-4">Payment System Manager</h3>
				<!-- <a class="btn btn-primary col-lg-offset-7 " href="sign-in-page.html" >Назад</a> -->
			</div>
		</div>
	</div>

	<div class="container containertext">
		<div class="row col-lg-4 col-lg-offset-4 alert alert-success"
			role="alert">
			<h2 class="text-center">Карточка зарегистрирована!</h2>
			<p class="text-center">
				<strong>id карточки: </strong><c:out value="${id}"/>
			</p>
			<c:if test="${not empty billid}">
			<p class="text-center">
				<strong>№ счёта: </strong><c:out value="${billid}"/>
			</p>
			</c:if>
			<c:if test="${not empty billpassword}">
			<p class="text-center">
				<strong>Пароль от счёта: </strong><c:out value="${billpassword}"/>
			</p>
			</c:if>
			<p class="text-center">
				<strong>Тип: </strong><c:out value="${type}"/>
			</p>
			<p class="text-center">
				<strong>Пароль от карточки: </strong><c:out value="${cardpassword}"/>
			</p>
		</div>
	</div>

	<form action="userpage.do" method="POST">
		<div class="form-group">
			<div class="col-lg-2 col-lg-offset-5">
				<button class="btn btn-lg btn-primary btn-block" type="submit">Вернуться
					в меню</button>
			</div>
		</div>
	</form>

	<script src="static/js/bootstrap.js" type="text/javascript"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</body>
</html>