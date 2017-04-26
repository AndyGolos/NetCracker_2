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

<title>Transfer</title>

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
				<a class="btn btn-primary col-lg-offset-7" href="userpage"><fmt:message key="transferpage.button.back" /></a>
			</div>
		</div>
	</div>
	<div class="container marg-sign-in">
		<h2 class="form-signin-heading  text-center">
			<fmt:message key="transferpage.label.transfer" />
		</h2>

		<form class="form-horizontal " action="transfermoney.do" method="POST">
			<div class="form-group">
				<label class="control-label col-lg-offset-2 col-lg-2"><fmt:message key="transferpage.label.cardid" /></label>
				<div class="col-lg-4">
					<select name="cardid">
						<c:forEach var="id" items="${cardsIds}">
							<option><c:out value="${id}" /></option>
						</c:forEach>
					</select>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-lg-offset-2 col-lg-2" for="password"><fmt:message
						key="transferpage.label.cardpass" /></label>
				<div class="col-lg-4">
					<input type="password" class="form-control" id="password"
						placeholder="<fmt:message key="transferpage.placeholder.cardpassword" />" name="cardpassword" required>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-lg-offset-2 col-lg-2 " for="cardid"><fmt:message
						key="transferpage.label.cardtransferid" /></label>
				<div class="col-lg-4">
					<input type="text" class="form-control" id="cardid"
						placeholder="<fmt:message key="transferpage.placeholder.cardid" />" name="cardtransferid" required>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-lg-offset-2 col-lg-2 " for="summ"><fmt:message key="transferpage.label.summ" /></label>
				<div class="col-lg-4">
					<input type="text" class="form-control" id="summ" placeholder="<fmt:message key="transferpage.placeholder.summ" />"
						name="summ" required>
				</div>
			</div>

			<div class="form-group">
				<div class="col-lg-2 col-lg-offset-5">
					<button class="btn btn-lg btn-primary btn-block" type="submit" onclick="return validateFormTransfer()">
						<fmt:message key="transferpage.button.transfer" />
					</button>
				</div>
			</div>
		</form>
	</div>

	<c:if test="${not empty error}">
		<div class="container marg-sign-in col-lg-offset-4 cont">
			<div class="alert alert-danger col-lg-4 margggg text-center" role="alert">
				<c:if test="${error eq 'incorrectpass'}">
					<strong><fmt:message key="transferpage.error.incorrectpass" /></strong>
				</c:if>
				<c:if test="${error eq 'incorrectcardid'}">
					<strong><fmt:message key="transferpage.error.incorrectcardid" /></strong>
				</c:if>
				<c:if test="${error eq 'unexsistcard'}">
					<strong><fmt:message key="transferpage.error.unexsistcard" /></strong>
				</c:if>
				<c:if test="${error eq 'incorrectsumm'}">
					<strong><fmt:message key="transferpage.error.incorrectsumm" /></strong>
				</c:if>
				<c:if test="${error eq 'lowmoney'}">
					<strong><fmt:message key="transferpage.error.lowmoney" /></strong>
				</c:if>
			</div>
		</div>
	</c:if>
	
	<input type="hidden" id="errorpass" value="<fmt:message key="transferpage.jserror.password" />">
	<input type="hidden" id="errorcardid" value="<fmt:message key="transferpage.jserror.idcard" />">
	<input type="hidden" id="errorsumm" value="<fmt:message key="transferpage.jserror.summ" />">

	<script src="static/js/bootstrap.js" type="text/javascript"></script>
	<script src="static/js/validation.js" type="text/javascript"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</body>
</html>