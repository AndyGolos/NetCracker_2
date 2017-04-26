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

<title>Usage History</title>

<link href="static/css/bootstrap.css" rel="stylesheet">
<link href="static/css/styles.css" rel="stylesheet">

</head>
<body>
	<div class="container">
		<div class="row">
			<div class="navbar navbar-inverse ">
				<h3 class="col-lg-4">Payment System Manager</h3>
				<a class="btn btn-primary col-lg-offset-7" href="userpage"><fmt:message key="historypage.button.back" /></a>
			</div>
		</div>
	</div>
	<div class="container col-lg-10 col-lg-offset-1 ">
		<div>
			<table class="table table-hover">
				<thead>
					<tr>
						<th class="col-lg-2 text-center"><fmt:message key="historypage.label.id" /></th>
						<th class="col-lg-2 text-center"><fmt:message key="historypage.label.cardid" /></th>
						<th class="col-lg-2 text-center"><fmt:message key="historypage.label.time" /></th>
						<th class="col-lg-2 text-center"><fmt:message key="historypage.label.change" /></th>
					</tr>
				</thead>
				<tbody class=" text-center">
					<c:forEach var="history" items="${histories}">
						<tr>
							<td><c:out value="${history.id}" /></td>
							<td><c:out value="${history.cardId}" /></td>
							<td><fmt:formatDate pattern="dd.MM.yyyy HH:mm:ss" value="${history.operationTime}" /></td>
							<td><c:out value="${history.valueChange}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<script src="static/js/bootstrap.js" type="text/javascript"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</body>
</html>