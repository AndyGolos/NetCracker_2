function validatesignIn() {

	var email = document.getElementById("E-mail").value;
	var password = document.getElementById("password").value;

	var emailpattern = /^(|(([A-Za-z0-9]+_+)|([A-Za-z0-9]+\-+)|([A-Za-z0-9]+\.+)|([A-Za-z0-9]+\++))*[A-Za-z0-9]+@((\w+\-+)|(\w+\.))*\w{1,63}\.[a-zA-Z]{2,6})$/i;
	var passpattern=/[0-9a-z]{4,}/i;
  
    var em=emailpattern.test(email);
    var pas=passpattern.test(password);

    if (em==true &&  pas==true) {
        return true;
    } else if (em==true &&  pas==false){
    	alert("Пароль должен содержать минимум 4 символа!");
    	return false;
    } else if (em==false &&  pas==false)  {
        alert("Введенные данные некорректны!");
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
	var passpattern=/[0-9a-z]{4,}/i;
  
  	var sn = textpattern.test(surname);
  	var name = textpattern.test(name);
  	var ln = textpattern.test(lastname);
    var em=emailpattern.test(email);
    var pas=passpattern.test(password);
    var peqp = password===repeatpassword;

    if(sn==false){
    	alert("Неверно введена фамилия!");
    	return false;
    } else if(name==false){
    	alert("Неверно введено имя!");
    	return false;
    } else if(ln==false){
    	alert("Неверно введено отчество!");
    	return false;
    } else if(em==false){
    	alert("Неверно введен email!");
    	return false;
    } else if(pas==false){
    	alert("Неверно введен пароль!");
    	return false;
    } else if(pas!=peqp){
    	alert("Пароли не совпадают!");
    	return false;
    } 
     return true;
}



function validateAddCard() {

	var bill = document.getElementById("Bill").value;
	var billpassword = document.getElementById("Billpass").value;
	var password = document.getElementById("password").value;

	var billpattern = /[0-9]{1,}/;
	var passpattern=/[0-9a-z]{4,}/i;

	var bl = billpattern.test(bill);
	var billpass = passpattern.test(billpassword);
	var ps = passpattern.test(password);

	if(bl==false){
    	alert("Неверно введена счёт!");
    	return false;
    } else if(billpass==false){
    	alert("Неверно введен пароль от счёта!");
    	return false;
    } else if(ps==false){
    	alert("Неверно введен пароль!");
    	return false;
    } 
    return true;
}