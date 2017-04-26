function validatesignIn() {

	var email = document.getElementById("E-mail").value;
	var password = document.getElementById("password").value;

	var html = document.getElementsByTagName("html")[0];
	var lang = html.getAttribute("lang");

	var emailpattern = /^(|(([A-Za-z0-9]+_+)|([A-Za-z0-9]+\-+)|([A-Za-z0-9]+\.+)|([A-Za-z0-9]+\++))*[A-Za-z0-9]+@((\w+\-+)|(\w+\.))*\w{1,63}\.[a-zA-Z]{2,6})$/i;
	var passpattern = /[0-9a-zа-яА-ЯёЁ]{4,}/i;

	var em = emailpattern.test(email);
	var pas = passpattern.test(password);

	var errorlength = document.getElementById("errorlength").value;
	var errorincorrect = document.getElementById("errorincorrect").value;

	if (em == true && pas == true) {
		return true;
	} else if (em == true && pas == false) {
		alert(errorlength);
		return false;
	} else if (em == false && pas == false) {
		alert(errorincorrect);
		return false;
	}
}

function validateRegistration() {

	var surname = document.getElementById("surname").value;
	var name = document.getElementById("name").value;
	var lastname = document.getElementById("lastname").value;
	var email = document.getElementById("E-mail").value;
	var password = document.getElementById("password").value;
	var repeatpassword = document.getElementById("repeatpassword").value;

	var textpattern = /[а-яА-ЯёЁa-zA-Z]{1,}/;
	var emailpattern = /^(|(([A-Za-z0-9]+_+)|([A-Za-z0-9]+\-+)|([A-Za-z0-9]+\.+)|([A-Za-z0-9]+\++))*[A-Za-z0-9]+@((\w+\-+)|(\w+\.))*\w{1,63}\.[a-zA-Z]{2,6})$/i;
	var passpattern = /[0-9a-zа-яА-ЯёЁ]{4,}/i;

	var sn = textpattern.test(surname);
	var name = textpattern.test(name);
	var ln = textpattern.test(lastname);
	var em = emailpattern.test(email);
	var pas = passpattern.test(password);
	var peqp = password === repeatpassword;

	var errorsurname = document.getElementById("errorsurname").value;
	var errorname = document.getElementById("errorname").value;
	var errorlastname = document.getElementById("errorlastname").value;
	var erroremail = document.getElementById("erroremail").value;
	var errorpassword = document.getElementById("errorpassword").value;
	var errorincorrect = document.getElementById("errorincorrect").value;

	if (sn == false) {
		alert(errorsurname);
		return false;
	} else if (name == false) {
		alert(errorname);
		return false;
	} else if (ln == false) {
		alert(errorlastname);
		return false;
	} else if (em == false) {
		alert(erroremail);
		return false;
	} else if (pas == false) {
		alert(errorpassword);
		return false;
	} else if (pas != peqp) {
		alert(errorincorrect);
		return false;
	}
	return true;
}

function validateAddCard() {

	var billpassword = document.getElementById("Billpass").value;
	var password = document.getElementById("password").value;

	var billpattern = /[0-9]{1,}/;
	var passpattern = /[0-9a-zа-яА-ЯёЁ]{4,20}/i;

	var billpass = passpattern.test(billpassword);
	var ps = passpattern.test(password);

	var errorincorrectbillpass = document
			.getElementById("errorincorrectbillpass").value;
	var errorincorrectpass = document.getElementById("errorincorrectpass").value;

	if (billpass == false) {
		alert(errorincorrectbillpass);
		return false;
	} else if (ps == false) {
		alert(errorincorrectpass);
		return false;
	}
	return true;
}

function validateAddCardWithBill() {
	var password = document.getElementById("password").value;
	var passpattern = /[0-9a-zа-яА-ЯёЁ]{4,20}/i;
	var ps = passpattern.test(password);
	var error = document.getElementById("error").value;

	if (ps == false) {
		alert(error);
		return false;
	}
	return true;
}

function validateDeleteCard() {

	var cardid = document.getElementById("cardid").value;
	var password = document.getElementById("password").value;

	var cardidpattern = /[0-9]{1,}/;
	var passpattern = /[0-9a-zа-яА-ЯёЁ]{4,20}/i;

	var ci = cardidpattern.test(cardid);
	var ps = passpattern.test(password);

	var errorid = document.getElementById("errorid").value;
	var errorpass = document.getElementById("errorpass").value;

	if (ci == false) {
		alert(errorid);
		return false;
	} else if (ps == false) {
		alert(errorpass);
		return false;
	}
	return true;
}

function validateFormTransfer() {

	var password = document.getElementById("password").value;
	var cardid = document.getElementById("cardid").value;
	var summ = document.getElementById("summ").value;

	var passpattern = /[0-9a-zа-яА-ЯёЁ]{4,20}/i;
	var cardidpattern = /[0-9]{1,}/;
	var summpattern = /[0-9]{1,}/;

	var ps = passpattern.test(password);
	var ci = cardidpattern.test(cardid);
	var summ = summpattern.test(summ);

	var errorpass = document.getElementById("errorpass").value;
	var errorcardid = document.getElementById("errorcardid").value;
	var errorsumm = document.getElementById("errorsumm").value;

	if (ps == false) {
		alert(errorpass);
		return false;
	} else if (ci == false) {
		alert(errorcardid);
		return false;
	} else if (summ == false) {
		alert(errorsumm);
		return false;
	}
	return true;
}

function validateReplenish() {
	var summ = document.getElementById("summ").value;
	var password = document.getElementById("password").value;

	var summpattern = /[0-9]{1,}/;
	var passpattern = /[0-9a-zа-яА-ЯёЁ]{4,20}/i;

	var ps = passpattern.test(password);
	var summ = summpattern.test(summ);

	var errorsumm = document.getElementById("errorsumm").value;
	var errorpass = document.getElementById("errorpass").value;

	if (summ == false) {
		alert(errorsumm);
		return false;
	} else if (ps == false) {
		alert(errorpass);
		return false;
	}
	return true;
}

function validateUnblock() {
	var id = document.getElementById("id").value;
	var idpattern = /[0-9]{1,}/;
	var ident = idpattern.test(id);
	var errorid = document.getElementById("errorid").value;

	if (ident == false) {
		alert(errorid);
		return false;
	}
	return true;
}