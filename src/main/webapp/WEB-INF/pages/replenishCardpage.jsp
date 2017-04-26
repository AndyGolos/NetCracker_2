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

<title>Replenish Card</title>

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
				<a class="btn btn-primary col-lg-offset-7" href="userpage"><fmt:message key="replenishpage.button.back" /></a>
			</div>
		</div>
	</div>

	<div class="container marg-sign-in">
		<h2 class="form-signin-heading text-center">
			<fmt:message key="replenishpage.label.replenishbill" />
		</h2>

		<form class="form-horizontal" action="replenishbill.do" method="POST">
			<div class="form-group">
				<label class="control-label col-lg-offset-2 col-lg-2" for="summ"><fmt:message key="replenishpage.label.summ" /></label>
				<div class="col-lg-4">
					<input type="number" class="form-control" id="summ"
						placeholder="<fmt:message key="replenishpage.placeholder.summ" />" min="1" name="summ" required>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-lg-offset-2 col-lg-2" for="password"><fmt:message
						key="replenishpage.label.password" /></label>
				<div class="col-lg-4">
					<input type="password" class="form-control" id="password"
						placeholder="<fmt:message key="replenishpage.placeholder.password" />" name="password" required>
				</div>
			</div>
			<input type="hidden" name="cardid" value="<c:out value="${cardid}"/>"> <input type="hidden" name="billid"
				value="<c:out value="${billid}"/>">
			<div class="form-group">
				<div class="col-lg-4 col-lg-offset-4">
					<button class="btn btn-lg btn-primary btn-block" type="submit" onclick="return validateReplenish()">
						<fmt:message key="replenishpage.button.replenish" />
					</button>
				</div>
			</div>
		</form>
	</div>

	<c:if test="${not empty error}">
		<div class="container marg-sign-in col-lg-offset-4 cont">
			<div class="alert alert-danger col-lg-4 margggg text-center" role="alert">
				<c:if test="${error eq 'format'}">
					<strong><fmt:message key="replenishpage.error.format" /></strong>
				</c:if>
				<c:if test="${error eq 'password'}">
					<strong><fmt:message key="replenishpage.error.password" /></strong>
				</c:if>
			</div>
		</div>
	</c:if>

	<input type="hidden" id="errorsumm" value="<fmt:message key="replenishpage.jserror.summ" />">
	<input type="hidden" id="errorpass" value="<fmt:message key="replenishpage.jserror.pass" />">


	<script src="static/js/validation.js" type="text/javascript"></script>
	<script src="static/js/bootstrap.js" type="text/javascript"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</body>
</html>