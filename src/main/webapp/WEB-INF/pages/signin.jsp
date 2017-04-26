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

.lang {
	color: white;
	font-weight: 500;
}

.formbut {
	margin-top: 16px;
	padding-bottom: 10px;
}

.pformbut {
	margin-top: 22px;
	padding-bottom: 10px;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="navbar navbar-inverse ">
				<h3 class="col-lg-4">Payment System Manager</h3>
				<p class="lang pformbut col-lg-2 col-lg-offset-3 text-right">
					<fmt:message key="login.label.submitchangelanguage" />
				</p>
				<form class="col-lg-1 formbut " action="change.do" method="POST">
					<c:if test="${empty language}">
						<input type="hidden" name="lang" value="en_GB">
					</c:if>
					<c:if test="${language eq 'ru_RU'}">
						<input type="hidden" name="lang" value="en_GB">
					</c:if>
					<c:if test="${language eq 'en_GB'}">
						<input type="hidden" name="lang" value="ru_RU">
					</c:if>
					<input type="hidden" name="page" value="signin">
					<c:if test="${empty language}">
						<button class="btn btn-warning">
							<span class="glyphicon glyphicon-refresh"></span> EN
						</button>
					</c:if>
					<c:if test="${language eq 'en_GB'}">
						<button class="btn btn-warning">
							<span class="glyphicon glyphicon-refresh"></span> RU
						</button>
					</c:if>
					<c:if test="${language eq 'ru_RU'}">
						<button class="btn btn-warning">
							<span class="glyphicon glyphicon-refresh"></span> EN
						</button>
					</c:if>
				</form>
				<a class="btn btn-primary " href="registration"><fmt:message key="login.button.submitregistration" /></a>
			</div>
		</div>
	</div>
	<div class="container marg-sign-in">
		<h2 class="form-signin-heading text-center">
			<fmt:message key="login.label.signin" />
		</h2>
		<form class="form-horizontal " action="userpage.do" method="POST">

			<div class="form-group">
				<label class="control-label col-lg-offset-3 col-lg-1 " for="E-mail"><fmt:message key="login.label.mail" />:</label>
				<div class="col-lg-4">
					<input type="email" class="form-control" id="E-mail" placeholder="<fmt:message key="login.placeholder.email" />"
						name="email" required>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-lg-offset-3 col-lg-1" for="password"><fmt:message key="login.label.pass" />:</label>
				<div class="col-lg-4">
					<input type="password" class="form-control" id="password"
						placeholder="<fmt:message key="login.placeholder.password" />" name="password" required>
				</div>
			</div>
			<div class="form-group">
				<div class="col-lg-4 col-lg-offset-4">
					<button class="btn btn-lg btn-primary btn-block" type="submit" onclick="return validatesignIn()">
						<fmt:message key="login.button.submitsignin" />
					</button>
				</div>
			</div>
		</form>
	</div>


	<c:if test="${empty currentuser}">
	</c:if>
	<c:if test="${not empty currentuser}">
		<div class="container marg-sign-in col-lg-offset-4 cont">
			<div class="alert alert-danger col-lg-4 margggg text-center" role="alert">
				<strong><fmt:message key="login.error" /></strong>
			</div>
		</div>
	</c:if>

	<script src="static/js/validation.js" type="text/javascript"></script>
	<script src="static/js/bootstrap.js" type="text/javascript"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</body>
</html>