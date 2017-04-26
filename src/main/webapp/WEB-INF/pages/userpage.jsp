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
							<button type="submit" class="btn btn-primary col-lg-offset-6 btn-block">
								<fmt:message key="userpage.button.exit" />
							</button>
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
				<h2 class="text-center">
					<fmt:message key="userpage.label.userinfo" />
				</h2>
				<p>
					<strong><fmt:message key="userpage.label.id" /></strong>
					<jsp:getProperty property="id" name="user" />
				</p>
				<p>
					<strong><fmt:message key="userpage.label.surname" /></strong>
					<jsp:getProperty property="surname" name="user" />
				</p>
				<p>
					<strong><fmt:message key="userpage.label.name" /></strong>
					<jsp:getProperty property="name" name="user" />
				</p>
				<p>
					<strong><fmt:message key="userpage.label.lastname" /></strong>
					<jsp:getProperty property="lastname" name="user" />
				</p>
				<p>
					<strong><fmt:message key="userpage.label.email" /></strong>
					<jsp:getProperty property="email" name="user" />
				</p>
				<p>
					<strong><fmt:message key="userpage.label.dateofbirth" /></strong>
					<jsp:getProperty property="dateOfBirth" name="user" />
				</p>
				<p>
					<strong><fmt:message key="userpage.label.registration" /></strong>
					<jsp:getProperty property="registration" name="user" />
				</p>
			</div>
		</div>
		<div class="row col-lg-3 col-lg-offset-1 ">
			<c:forEach var="role" items="${user.role}">
				<c:if test="${role.role eq 'Клиент'}">
					<form action="transitionAddCardpage.do">
						<button class="btn btn-lg btn-success btn-block formbutt" type="submit">
							<fmt:message key="userpage.button.createcard" />
						</button>
					</form>
					<jsp:useBean id="cards" type="java.util.List<beans.cardbeans.Card>" scope="session" />
					<c:if test="${fn:length(cards)==0}">
					</c:if>
					<c:if test="${fn:length(cards)!=0}">
						<form action="transitionDeleteCardpage.do">
							<button class="btn btn-lg btn-danger btn-block formbutt" type="submit">
								<fmt:message key="userpage.button.deletecard" />
							</button>
						</form>
					</c:if>
					<c:if test="${fn:length(cards)==0}">
					</c:if>
					<c:if test="${fn:length(cards)!=0}">
						<form action="transitionformtransfer.do">
							<button class="btn btn-lg btn-success btn-block formbutt" type="submit">
								<fmt:message key="userpage.button.transfermoney" />
							</button>
						</form>
					</c:if>
					<!-- <form action="">
				<button class="btn btn-lg btn-success btn-block formbutt"
					type="submit">Оплата услуг</button>
			</form> -->
				</c:if>
				<c:if test="${role.role eq 'Администратор'}">
					<form action="allUsers.do" method="POST">
						<button class="btn btn-lg btn-success btn-block formbutt" type="submit">
							<fmt:message key="userpage.button.listofusers" />
						</button>
					</form>
					<form action="transitionunblock.do" method="POST">
						<button class="btn btn-lg btn-success btn-block formbutt" type="submit">
							<fmt:message key="userpage.button.unblockcard" />
						</button>
					</form>
				</c:if>
			</c:forEach>
		</div>
	</div>
	<div class="container col-lg-12">
		<div>
			<table class="table table-hover">
				<thead>
					<tr>
						<th class="col-lg-1 text-center"><fmt:message key="userpage.label.card.id" /></th>
						<th class="col-lg-1 text-center"><fmt:message key="userpage.label.card.type" /></th>
						<th class="col-lg-1 text-center"><fmt:message key="userpage.label.card.bill" /></th>
						<th class="col-lg-1 text-center"><fmt:message key="userpage.label.card.status" /></th>
						<th class="col-lg-1 text-center"><fmt:message key="userpage.label.card.moneyamount" /></th>
						<th class="col-lg-1 text-center"><fmt:message key="userpage.label.card.validity" /></th>
						<th class="col-lg-1 text-center"><fmt:message key="userpage.label.card.history" /></th>
						<th class="col-lg-1 text-center"><fmt:message key="userpage.label.card.block" /></th>
						<th class="col-lg-1 text-center"><fmt:message key="userpage.label.card.replenish" /></th>
					</tr>
				</thead>
				<tbody class=" text-center">
					<c:forEach var="card" items="${cards}">
						<tr>
							<td><c:out value="${card.id}" /></td>
							<td><c:out value="${card.type.type}" /></td>
							<td><c:out value="${card.bill.id}" /></td>
							<c:if test="${card.status}">
								<td><fmt:message key="userpage.label.status.active" /></td>
							</c:if>
							<c:if test="${not card.status}">
								<td><fmt:message key="userpage.label.status.blocked" /></td>
							</c:if>
							<td><c:out value="${card.bill.money}" /></td>
							<td><c:out value="${card.validity}" /></td>
							<td>
								<form action="history.do" method="POST">
									<input type="hidden" name="history" value="<c:out value="${card.id}"/>" />
									<button class="btn btn-sm btn-primary btn-block" type="submit" id="<c:out value="${card.id}"/>">
										<fmt:message key="userpage.button.watchhistory" />
									</button>
								</form>
							</td>
							<td>
								<form action="block.do" method="POST">
									<c:if test="${card.status}">
										<input type="hidden" name="block" value="<c:out value="${card.id}"/>" />
										<button class="btn btn-sm btn-warning btn-block" type="submit">
											<fmt:message key="userpage.button.blockcard" />
										</button>
									</c:if>
									<c:if test="${not card.status}">
										<button class="btn btn-sm btn-warning btn-block" type="submit" id="<c:out value="${card.id}"/>" disabled>
											<fmt:message key="userpage.button.blockcard" />
										</button>
									</c:if>
								</form>
							</td>
							<td>
								<form action="replenish.do" method="POST">
									<input type="hidden" name="billid" value="<c:out value="${card.bill.id}"/>" /> <input type="hidden"
										name="cardid" value="<c:out value="${card.id}"/>" />
									<c:if test="${card.status}">
										<button class="btn btn-sm btn-success btn-block" type="submit">
											<fmt:message key="userpage.button.replenish" />
										</button>
									</c:if>
									<c:if test="${not card.status}">
										<button class="btn btn-sm btn-success btn-block" type="submit" disabled>
											<fmt:message key="userpage.button.replenish" />
										</button>
									</c:if>
								</form>
							</td>
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