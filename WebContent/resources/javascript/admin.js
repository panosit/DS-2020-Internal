

function isNumber(){
	var x, text;

	// Get the value of the input field with id="numb"
	x = document.getElementById("classN").value;

	// If x is Not a Number or less than one or greater than 10
	if (isNaN(x) || x < 1 || x > 99) {
		text = "Input not valid";
		alert(text);
		return false;
	} else {
		text = "Input OK";
	}
	alert(text);
}

function firstNameLastName(){

	var br = document.createElement("br");
	br.setAttribute("id", "brrr");

	var form = document.getElementById("registerForm");


	var FirstNamelabel = document.createElement("label");
	FirstNamelabel.setAttribute("for", "firstname");



	var FirstName = document.createElement("input");
	FirstName.setAttribute("name","firstname");
	FirstName.setAttribute("id","firstname");
	FirstName.setAttribute("type","text");
	FirstName.setAttribute("required",true);

	form.appendChild(FirstNamelabel);
	FirstNamelabel.innerHTML = "First Name:"; 
	form.appendChild(br.cloneNode());  
	form.appendChild(FirstName);
	form.appendChild(br.cloneNode());  



	var LastNamelabel = document.createElement("label");
	LastNamelabel.setAttribute("for","lastname");

	var LastName = document.createElement("input");
	LastName.setAttribute("name","lastname");
	LastName.setAttribute("id","lastname");
	LastName.setAttribute("type","text");
	LastName.setAttribute("required",true);


	form.appendChild(LastNamelabel);
	LastNamelabel.innerHTML = "Last Name:"; 
	form.appendChild(br.cloneNode());  
	form.appendChild(LastName);
	form.appendChild(br.cloneNode());  

}

function yesnoCheck(that) {
	var br = document.createElement("br");
	br.setAttribute("id", "brrr");

	var form = document.getElementById("registerForm");



	if (form.childNodes.length > 20  || form.childNodes.length == 13 ) {
		while (form.firstChild) {
			form.removeChild(form.lastChild);
		}

		var usernamelabel = document.createElement("label");
		var username = document.createElement("input");
		username.setAttribute("name", "username");
		username.setAttribute("id", "username");
		username.setAttribute("type", "text");
		username.setAttribute("required", true);

		form.appendChild(usernamelabel);
		usernamelabel.innerHTML = "Username:";
		form.appendChild(usernamelabel);
		form.appendChild(br.cloneNode());

		form.appendChild(username);


		var passwordlabel = document.createElement("label");
		passwordlabel.setAttribute("for", "password");
		passwordlabel.innerHTML = " Κωδικός:";
		form.appendChild(br.cloneNode());
		form.appendChild(passwordlabel);
		form.appendChild(br.cloneNode());

		var password = document.createElement("input");
		password.setAttribute("name", "password");
		password.setAttribute("id", "password");
		password.setAttribute("type", "password");
		password.setAttribute("required", true);
		form.appendChild(password);
		form.appendChild(br.cloneNode());


		var selectlabel = document.createElement("label");
		selectlabel.innerHTML = "Role(admin, teacher, manager):";
		form.appendChild(selectlabel);
		form.appendChild(br.cloneNode());

		var select = document.createElement("select");
		select.setAttribute("id","role");
		select.setAttribute("name", "role");
		select.setAttribute("onchange", "yesnoCheck(this);");
		select.setAttribute("type", "text");
		select.setAttribute("required", true)


		// insert select options
		if (that.value == "manager") {


			var option = document.createElement("option");
			option.text = "manager";
			select.add(option);

			var option2 = document.createElement("option");
			option2.text = "teacher";
			select.add(option2);

			var option3 = document.createElement("option");
			option3.text = "admin";
			select.add(option3);

			form.appendChild(select);
			form.appendChild(br.cloneNode());


			firstNameLastName();

		}else if (that.value == "teacher") {

			var option2 = document.createElement("option");
			option2.text = "teacher";
			select.add(option2);

			var option = document.createElement("option");
			option.text = "manager";
			select.add(option);


			var option3 = document.createElement("option");
			option3.text = "admin";
			select.add(option3);

			form.appendChild(select);
			form.appendChild(br.cloneNode());


			firstNameLastName();

			var classlabel = document.createElement("label");
			classlabel.setAttribute("for","classN");

			var classN = document.createElement("input");
			classN.setAttribute("name","class");
			classN.setAttribute("id","classN");
			classN.setAttribute("type","text");
			classN.setAttribute("required",true);


			form.appendChild(classlabel);
			classlabel.innerHTML = "Class:"; 
			form.appendChild(br.cloneNode());  
			form.appendChild(classN);
			form.appendChild(br.cloneNode());

		}else if (that.value == "admin"){

			var option3 = document.createElement("option");
			option3.text = "admin";
			select.add(option3);

			var option2 = document.createElement("option");
			option2.text = "teacher";
			select.add(option2);

			var option = document.createElement("option");
			option.text = "manager";
			select.add(option);

			form.appendChild(select);
			form.appendChild(br.cloneNode());

		}

	}else{
		if (that.value == "teacher"){
			firstNameLastName();
			
			var classlabel = document.createElement("label");
			classlabel.setAttribute("for","classN");

			var classN = document.createElement("input");
			classN.setAttribute("name","class");
			classN.setAttribute("id","classN");
			classN.setAttribute("type","text");
			classN.setAttribute("required",true);


			form.appendChild(classlabel);
			classlabel.innerHTML = "Class:"; 
			form.appendChild(br.cloneNode());  
			form.appendChild(classN);
			form.appendChild(br.cloneNode());
			
		}else if (that.value == "manager"){
			firstNameLastName();	
		
		}
	}
	var registerForm = document.createElement("input");
	registerForm.setAttribute("type", "submit");
	registerForm.setAttribute("value", "Register");
	registerForm.setAttribute("id", "registerbutton");

	form.appendChild(registerForm);
}



