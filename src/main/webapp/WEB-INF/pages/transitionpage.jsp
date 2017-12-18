<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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

<title>Transition page</title>

<link href="static/css/bootstrap.css" rel="stylesheet">
<link href="static/css/styles.css" rel="stylesheet">

</head>
<body>

	<div class="container">
		<div class="row">
			<div class="navbar navbar-inverse ">
				<h3 class="col-lg-4">Payment System Manager</h3>
				<a class="btn btn-primary col-lg-offset-7" href="userpage"><fmt:message key="transitionaddcardpage.button.back" /></a>
			</div>
		</div>
	</div>

	<div class="container margtransition">
		<h2 class="form-signin-heading text-center">
			<fmt:message key="transitionaddcardpage.label.newcard" />
		</h2>

        <jsp:useBean id="cards" type="java.util.List<beans.Card>" scope="session"/>

		<form class="form-horizontal " action="createCard.do">
			<div class="form-group">
				<div class="col-lg-4 col-lg-offset-4">
					<c:if test="${fn:length(cards)==0}">
						<button class="btn btn-lg btn-success btn-block" type="submit" disabled>
							<fmt:message key="transitionaddcardpage.button.existingaccount" />
						</button>
					</c:if>
					<c:if test="${fn:length(cards)!=0}">
					<button class="btn btn-lg btn-success btn-block" type="submit">
							<fmt:message key="transitionaddcardpage.button.existingaccount" />
						</button>
					</c:if>
				</div>
			</div>
		</form>		
		<form class="form-horizontal " action="createCardWithBill.do">
			<div class="form-group">
				<div class="col-lg-4 col-lg-offset-4">
					<button class="btn btn-lg btn-success btn-block" type="submit" onclick="">
						<fmt:message key="transitionaddcardpage.button.newaccount" />
					</button>
				</div>
			</div>
		</form>
	</div>
	<script src="static/js/validation.js" type="text/javascript"></script>
	<script src="static/js/bootstrap.js" type="text/javascript"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</body>
</html>