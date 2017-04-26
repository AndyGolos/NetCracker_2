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

<!-- Bootstrap -->
<link href="static/css/bootstrap.css" rel="stylesheet">
<link href="static/css/styles.css" rel="stylesheet">
<!-- <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.2/css/bootstrap-select.min.css" rel="stylesheet"> -->
<style type="text/css">
.margggg {
	margin-left: 25px;
}

.cont {
	margin-top: 5px;
}
</style>
<title>Add Card</title>
</head>

<body>
	<div class="container">
		<div class="row">
			<div class="navbar navbar-inverse ">
				<h3 class="col-lg-4">Payment System Manager</h3>
				<a class="btn btn-primary col-lg-offset-7" href="transitionpage"><fmt:message key="createcard.button.back" /></a>
			</div>
		</div>
	</div>

	<div class="container marg-sign-in">
		<h2 class="form-signin-heading text-center">
			<fmt:message key="createcard.label.createcard" />
		</h2>
		<form class="form-horizontal" action="addcard.do" method="POST">


			<div class="form-group">
				<label class="control-label col-lg-offset-2 col-lg-2"><fmt:message key="createcard.label.addcardtothebill" /></label>
				<div class="col-lg-4">
					<select name="billid">
						<c:forEach var="id" items="${cardsBills}">
							<option><c:out value="${id}" /></option>
						</c:forEach>
					</select>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-lg-offset-2 col-lg-2 " for="Billpass"><fmt:message
						key="createcard.label.billpassword" /></label>
				<div class="col-lg-4">
					<input type="password" class="form-control" id="Billpass"
						placeholder="<fmt:message key="createcard.placeholder.billpassword" />" name="billpassword" required>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-lg-offset-3 col-lg-1"><fmt:message key="createcard.label.type" /></label>
				<div class="col-lg-4">
					<select name="type">
						<c:forEach var="cardType" items="${cardTypes}">
							<option><c:out value="${cardType.type}" /></option>
						</c:forEach>
						<c:forEach var="cardType" items="${cardTypes}">
							<input type="hidden" name="<c:out value="${cardType.type}" />" value="<c:out value="${cardType.id}" />">
						</c:forEach>
					</select>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-lg-offset-2 col-lg-2" for="password"><fmt:message
						key="createcard.label.cardpassword" /></label>
				<div class="col-lg-4">
					<input type="password" class="form-control" id="password"
						placeholder="<fmt:message key="createcard.placeholder.cardpassword" />" name="password" required>
				</div>
			</div>

			<div class="form-group">
				<div class="col-lg-4 col-lg-offset-4">
					<button class="btn btn-lg btn-primary btn-block" type="submit" onclick="return validateAddCard()">
						<fmt:message key="createcard.label.create" />
					</button>
				</div>
			</div>
		</form>
	</div>

	<c:if test="${not empty error}">
		<div class="container marg-sign-in col-lg-offset-4 cont">
			<div class="alert alert-danger col-lg-4 margggg text-center" role="alert">
				<c:if test="${error eq 'billpasswordformat'}">
					<strong><fmt:message key="createcard.error.billpasswordformat" /></strong>
				</c:if>
				<c:if test="${error eq 'billpassword'}">
					<strong><fmt:message key="createcard.error.billpassword" /></strong>
				</c:if>
				<c:if test="${error eq 'passwordblank'}">
					<strong><fmt:message key="createcard.error.passwordblank" /></strong>
				</c:if>
				<c:if test="${error eq 'passwordlength'}">
					<strong><fmt:message key="createcard.error.passwordlength" /></strong>
				</c:if>
				<c:if test="${error eq 'biglength'}">
					<strong><fmt:message key="createcard.error.biglength" /></strong>
				</c:if>
			</div>
		</div>
	</c:if>

	<script src="static/js/bootstrap.js" type="text/javascript"></script>
	<script src="static/js/validation.js" type="text/javascript"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</body>
</html>