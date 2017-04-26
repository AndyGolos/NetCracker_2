<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<fmt:requestEncoding value="UTF-8" />

<c:if test="${empty language}">
	<fmt:setLocale value="ru_RU" />
</c:if>
<c:if test="${not empty language}">
	<fmt:setLocale value="${language}" />
</c:if>
<fmt:setBundle basename="com.Golosov.i18n.i18n" />

<!DOCTYPE html>
<html lang="${language}">
<head>

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Delete Card</title>

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
				<a class="btn btn-primary col-lg-offset-7" href="transitionaddardpage.html"><fmt:message
						key="deletecardpage.button.back" /></a>
			</div>
		</div>
	</div>

	<div class="container marg-sign-in">
		<h2 class="form-signin-heading text-center">
			<fmt:message key="deletecardpage.label.delete" />
		</h2>

		<form class="form-horizontal" action="deleteCard.do" method="POST">
			<div class="form-group">
				<label class="control-label col-lg-offset-2 col-lg-2" for="password"><fmt:message
						key="deletecardpage.label.cardid" /></label>
				<div class="col-lg-4">
					<input type="number" class="form-control" id="password"
						placeholder="<fmt:message key="deletecardpage.placeholder.cardid" />" min="1" name="cardid" required>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-lg-offset-2 col-lg-2" for="password"> <fmt:message
						key="deletecardpage.label.cardpassword" /></label>
				<div class="col-lg-4">
					<input type="password" class="form-control" id="password"
						placeholder="<fmt:message key="deletecardpage.placeholder.cardpassword" />" name="password" required>
				</div>
			</div>

			<div class="form-group">
				<div class="col-lg-4 col-lg-offset-4">
					<button class="btn btn-lg btn-primary btn-block" type="submit" onclick="return validateAddCard()">
						<fmt:message key="deletecardpage.button.deletecard" />
					</button>
				</div>
			</div>
		</form>
	</div>

	<c:if test="${not empty error}">
		<div class="container marg-sign-in col-lg-offset-4 cont">
			<div class="alert alert-danger col-lg-4 margggg text-center" role="alert">
				<c:if test="${error eq 'password'}">
					<strong><fmt:message key="deletecardpage.error.password" /></strong>
				</c:if>
				<c:if test="${error eq 'id'}">
					<strong><fmt:message key="deletecardpage.error.id" /></strong>
				</c:if>
				<c:if test="${error eq 'format'}">
					<strong><fmt:message key="deletecardpage.error.format" /></strong>
				</c:if>
			</div>
		</div>
	</c:if>




	<script src="static/js/validation.js" type="text/javascript"></script>
	<script src="static/js/bootstrap.js" type="text/javascript"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</body>
</html>