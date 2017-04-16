<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

	<div class="container">
		<div class="row col-lg-6 col-lg-offset-1">
			<div class="well profile col-lg-12">
				<h2 class="text-center">Информация о клиенте</h2>
				<p>
					<strong>#id: </strong> 10203040
				</p>
				<p>
					<strong>Фамилия: </strong>Голосов
				</p>
				<p>
					<strong>Имя: </strong>Андрей
				</p>
				<p>
					<strong>Отчество: </strong> Дмитриевич
				</p>
				<p>
					<strong>Телефон: </strong> +375291722837
				</p>
				<p>
					<strong>E-mail: </strong> andygolosov@mail.ru
				</p>
				<p>
					<strong>Дата рождения: </strong> 21.07.1996
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
			<form action="">
				<button class="btn btn-lg btn-success btn-block formbutt"
					type="submit">Список юзеров(админ)</button>
			</form>
			<form action="">
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
					<tr>
						<td>1</td>
						<td>Visa</td>
						<td>232132</td>
						<td>Заблокирована</td>
						<td>2000</td>
						<td>22.08.2016</td>
						<td>
							<form>
								<button class="btn btn-sm btn-primary btn-block" type="submit">Просмотреть</button>
							</form>
						</td>
						<td>
							<form>
								<button class="btn btn-sm btn-warning btn-block" type="submit"
									disabled>Заблокировать</button>
							</form>
						</td>
						<td>
							<form>
								<button class="btn btn-sm btn-success btn-block" type="submit">Пополнить</button>
							</form>
						</td>
					</tr>
					<tr>
						<td>2</td>
						<td>MasterCard</td>
						<td>243242</td>
						<td>Активна</td>
						<td>212100</td>
						<td>22.08.2016</td>
						<td>
							<form>
								<button class="btn btn-sm btn-primary btn-block" type="submit">Просмотреть</button>
							</form>
						</td>
						<td>
							<form>
								<button class="btn btn-sm btn-warning btn-block" type="submit"
									disabled>Заблокировать</button>
							</form>
						</td>
						<td>
							<form>
								<button class="btn btn-sm btn-success btn-block" type="submit">Пополнить</button>
							</form>
						</td>
					</tr>
					<tr>
						<td>3</td>
						<td>Maestro</td>
						<td>765675</td>
						<td>Заблокирована</td>
						<td>10000</td>
						<td>22.08.2016</td>
						<td>
							<form>
								<button class="btn btn-sm btn-primary btn-block" type="submit">Просмотреть</button>
							</form>
						</td>
						<td>
							<form>
								<button class="btn btn-sm btn-warning btn-block" type="submit">Заблокировать</button>
							</form>
						</td>
						<td>
							<form>
								<button class="btn btn-sm btn-success btn-block" type="submit">Пополнить</button>
							</form>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>


	<script src="static/js/bootstrap.js" type="text/javascript"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</body>
</html>