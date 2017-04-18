<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html>
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
				<a class="btn btn-primary col-lg-offset-7 " href="userpage">Назад</a>
			</div>
		</div>
	</div>


	<div class="container col-lg-12 ">
		<div>
			<table class="table table-hover">
				<thead>
					<tr>
						<th class="col-lg-1 text-center">#id</th>
						<th class="col-lg-1 text-center">Фамилия</th>
						<th class="col-lg-1 text-center">Имя</th>
						<th class="col-lg-1 text-center">Отчество</th>
						<th class="col-lg-1 text-center">Email</th>
						<th class="col-lg-1 text-center">Дата рождения</th>
						<th class="col-lg-1 text-center">Дата регистрации</th>
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