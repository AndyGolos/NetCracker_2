<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

<title>All Users</title>

<link href="static/css/bootstrap.css" rel="stylesheet">
<link href="static/css/styles.css" rel="stylesheet">

</head>
<body>

	<div class="container">
		<div class="row ">
			<div class="navbar navbar-inverse ">
				<h3 class="col-lg-4">Payment System Manager</h3>
				<a class="btn btn-primary col-lg-offset-7 " href="userpage"><fmt:message key="alluserspage.button.back" /></a>
			</div>
		</div>
	</div>


	<div class="container col-lg-12 ">
		<div>
			<table class="table table-hover">
				<thead>
					<tr>
						<th class="col-lg-1 text-center"><fmt:message key="alluserspage.label.id" /></th>
						<th class="col-lg-1 text-center"><fmt:message key="alluserspage.label.surname" /></th>
						<th class="col-lg-1 text-center"><fmt:message key="alluserspage.label.name" /></th>
						<th class="col-lg-1 text-center"><fmt:message key="alluserspage.label.lastname" /></th>
						<th class="col-lg-1 text-center"><fmt:message key="alluserspage.label.email" /></th>
						<th class="col-lg-1 text-center"><fmt:message key="alluserspage.label.dateofbirth" /></th>
						<th class="col-lg-1 text-center"><fmt:message key="alluserspage.label.registration" /></th>
					</tr>
				</thead>
				<tbody class=" text-center">
				<c:forEach var="user" items="${users}">
					<tr>
						<td><c:out value="${user.id}"/></td>
						<td><c:out value="${user.surname}"/></td>
						<td><c:out value="${user.name}"/></td>
						<td><c:out value="${user.lastname}"/></td>
						<td><c:out value="${user.email}"/></td>
						<td><c:out value="${user.dateOfBirth}"/></td>
						<td><c:out value="${user.registration}"/></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<script src="static/js/bootstrap.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</body>
</html>