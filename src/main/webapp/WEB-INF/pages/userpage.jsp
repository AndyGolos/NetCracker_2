<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link href="static/css/bootstrap.css" rel="stylesheet">
<link href="static/css/styles.css" rel="stylesheet">

<title>User Page</title>

</head>

<body>

	<div class="container">
		<div class="row">
			<div class="navbar navbar-inverse ">
				<h3 class="col-lg-4">Payment System Manager</h3>
				<form action="signin.do" method="GET">
					<div class="form-group">
						<div class="col-lg-2 col-lg-offset-5">
							<button type="submit"
								class="btn btn-primary col-lg-offset-6 btn-block">Выход</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<jsp:useBean id="user" class="beans.userbeans.User" scope="session" />
	<div class="container">
		<div class="row col-lg-6 col-lg-offset-1">
			<div class="well profile col-lg-12">
				<h2 class="text-center">Информация</h2>
				<p>
					<strong>#id: </strong>
					<jsp:getProperty property="id" name="user" />
				</p>
				<p>
					<strong>Фамилия: </strong>
					<jsp:getProperty property="surname" name="user" />
				</p>
				<p>
					<strong>Имя: </strong>
					<jsp:getProperty property="name" name="user" />
				</p>
				<p>
					<strong>Отчество: </strong>
					<jsp:getProperty property="lastname" name="user" />
				</p>
				<p>
					<strong>E-mail: </strong>
					<jsp:getProperty property="email" name="user" />
				</p>
				<!-- Сделать датам нормальный вид -->
				<p>
					<strong>Дата рождения: </strong>
					<jsp:getProperty property="dateOfBirth" name="user" />
				</p>
				<p>
					<strong>Дата регистрации: </strong>
					<jsp:getProperty property="registration" name="user" />
				</p>
			</div>
		</div>

		<div class="row col-lg-3 col-lg-offset-1 ">
			<form action="transitionAddCardpage.do">
				<button class="btn btn-lg btn-success btn-block formbutt"
					type="submit">Создать карточку</button>
			</form>
			<form action="transitionDeleteCardpage.do">
				<button class="btn btn-lg btn-danger btn-block formbutt"
					type="submit">Удалить карточку</button>
			</form>
			<form action="">
				<button class="btn btn-lg btn-success btn-block formbutt"
					type="submit">Перевести деньги</button>
			</form>
			<form action="">
				<button class="btn btn-lg btn-success btn-block formbutt"
					type="submit">Оплата услуг</button>
			</form>
			<form action="allUsers.do" method="POST">
				<button class="btn btn-lg btn-success btn-block formbutt"
					type="submit">Список юзеров(админ)</button>
			</form>
			<form action="transitionunblock.do" method="POST">
				<button class="btn btn-lg btn-success btn-block formbutt"
					type="submit">Разблокировать карту(админ)</button>
			</form>
			<form action="">
				<button class="btn btn-lg btn-success btn-block formbutt"
					type="submit">Создать счёт(админ)</button>
			</form>
		</div>
	</div>

	<!-- и тут не было  col-lg-12-->
	<div class="container col-lg-12">
		<!-- Было row  col-lg-12-->
		<div>
			<table class="table table-hover">
				<thead>
					<tr>
						<!-- Всё было по 2 до кнопок! -->
						<th class="col-lg-1 text-center">#id</th>
						<th class="col-lg-1 text-center">Тип</th>
						<th class="col-lg-1 text-center">Счёт</th>
						<th class="col-lg-1 text-center">Статус</th>
						<th class="col-lg-1 text-center">Баланс</th>
						<th class="col-lg-1 text-center">Валидна до</th>
						<th class="col-lg-1 text-center">История</th>
						<th class="col-lg-1 text-center">Заблокировать</th>
						<th class="col-lg-1 text-center">Пополнить счёт</th>
					</tr>
				</thead>
				<tbody class=" text-center">
					<c:forEach var="card" items="${cards}">
						<tr>
							<td><c:out value="${card.id}" /></td>
							<td><c:out value="${card.type.type}" /></td>
							<td><c:out value="${card.bill.id}" /></td>
							<c:if test="${card.status}">
								<td><c:out value="Активирована" /></td>
							</c:if>
							<c:if test="${not card.status}">
								<td><c:out value="Заблокирована" /></td>
							</c:if>
							<td><c:out value="${card.bill.money}" /></td>
							<td><c:out value="${card.validity}" /></td>
							<td>
								<form action="history.do" method="POST">
									<input type="hidden" name="history"
										value="<c:out value="${card.id}"/>" />
									<button class="btn btn-sm btn-primary btn-block" type="submit"
										id="<c:out value="${card.id}"/>">Просмотреть</button>
								</form>
							</td>
							<td>
								<form action="block.do" method="POST">
									<c:if test="${card.status}">
										<input type="hidden" name="block"
											value="<c:out value="${card.id}"/>" />
										<button class="btn btn-sm btn-warning btn-block" type="submit">Заблокировать</button>
									</c:if>
									<c:if test="${not card.status}">
										<button class="btn btn-sm btn-warning btn-block" type="submit"
											id="<c:out value="${card.id}"/>" disabled>Заблокировать</button>
									</c:if>
								</form>
							</td>
							<td>
								<form action="replenish.do" method="POST">
									<input type="hidden" name="billid" value="<c:out value="${card.bill.id}"/>" />	
									<%-- <input type="hidden" name="replenish" value="<c:out value="${card.id}"/>" /> --%>
									<c:if test="${card.status}">
									<button class="btn btn-sm btn-success btn-block" type="submit">Пополнить</button>
									</c:if>
									<c:if test="${not card.status}">
									<button class="btn btn-sm btn-success btn-block" type="submit" disabled>Пополнить</button>
									</c:if>
								</form>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

	<!-- <script src="static/js/bootstrap.js" type="text/javascript"></script> -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</body>
</html>