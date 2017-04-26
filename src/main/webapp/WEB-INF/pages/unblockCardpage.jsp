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

<title>Unblock Card</title>

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
				<a class="btn btn-primary col-lg-offset-7" href="userpage"><fmt:message key="unblockpage.button.back" /></a>
			</div>
		</div>
	</div>
	<div class="container marg-sign-in">
		<h2 class="form-signin-heading text-center"><fmt:message key="unblockpage.label.unblockcard" /></h2>

		<form class="form-horizontal" action="unblock.do" method="POST">
			<div class="form-group">
				<label class="control-label col-lg-offset-2 col-lg-2" for="password"><fmt:message key="unblockpage.label.idcard" /></label>
				<div class="col-lg-4">
					<input type="text" class="form-control" id="id" placeholder="<fmt:message key="unblockpage.placeholder.id" />" name="cardid" required>
				</div>
			</div>
			<div class="form-group">
				<div class="col-lg-4 col-lg-offset-4">
					<button class="btn btn-lg btn-primary btn-block" type="submit" onclick="return validateUnblock()"><fmt:message key="unblockpage.button.unblock" /></button>
				</div>
			</div>
		</form>
	</div>
	
	<input type="hidden" id="errorid" value="<fmt:message key="unblockpage.jserror.cardid" />">
	
	<c:if test="${not empty error}">
		<div class="container marg-sign-in col-lg-offset-4 cont">
			<div class="alert alert-danger col-lg-4 margggg text-center" role="alert">
				<c:if test="${error eq 'format'}">
					<strong><fmt:message key="unblockpage.error.format" /></strong>
				</c:if>
				<c:if test="${error eq 'nocard'}">
					<strong><fmt:message key="unblockpage.error.nocard" /></strong>
				</c:if>
				<c:if test="${error eq 'unblocked'}">
					<strong><fmt:message key="unblockpage.error.unblocked" /></strong>
				</c:if>
			</div>
		</div>
	</c:if>
	<script src="static/js/validation.js" type="text/javascript"></script>
	<script src="static/js/bootstrap.js" type="text/javascript"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</body>
</html>