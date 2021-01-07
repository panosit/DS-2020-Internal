<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
	
<html>
<head>
	<spring:url value="/resources/css/style.css" var="mainCss" />
	<link rel="stylesheet" type="text/css" href="${mainCss}">
	
	<spring:url value="/logout" var="logout"/>
<title>Παιδικός Σταθμός</title>
</head>
<body>
	<nav><span class="header">Παιδικός Σταθμός</span><span class="side">Hello, ${username}<br><a href=${logout} class="logout">Αποσύνδεση</a></span></nav>


		 	<div class="main">
		
	<sec:authorize access="hasRole('ADMIN')">
<spring:url value="/resources/javascript/admin.js" var="adminjs" />
		<script type="text/javascript" src="${adminjs}" ></script>
		<h1>Συνδεθήκατε ως ADMIN</h1>
		<h3>Register</h3>
		<form id="registerForm" action="register" method="post"  onsubmit="return isNumber()">
			<label for="username">Username:</label><br> 
			<input name="username" id="username" type="text" required><br>
			<label for="password">Κωδικός:</label><br> 
			<input name="password" id="password" type="password" required><br>
			<label for="role">Role(admin, teacher, manager):</label><br>
			<select id="role" name="role" type="text" onchange="yesnoCheck(this);" required>
			<option value="0">Select role:</option>
			<option value="admin">admin</option>
			<option value="teacher">teacher</option>
			<option value="manager">manager</option>
			</select>
			<br>
		</form>
		<br>
		<br>
		<br>
		<h3>Users</h3>
		<c:forEach items="${users}" var="user">
			<ul>
				<li>Ονομα: ${user.username} Ρόλος: ${user.authority}</li>
			</ul>
		</c:forEach>
		<br>
		<h3>Delete</h3>
		<form   action="delete" method="post">
			<label for="deleteUsername">Username:</label><br> 
			<input
				type="text" id="deleteUsername" name="deleteUsername"><br>
			<input type="submit" value="Delete"><br>
		</form>
		<br>
		<br>
		<br>
		<h3>Update</h3>
		<form action="update" method="post">
		     <label for="uusername">Username:</label><br>
		     <input id="uusername" name="uusername" type="text" required><br>
		     <label for="oldpassword">Old password:</label><br>
		     <input id="oldpassword" name="oldpassword" type="password" required><br>
		     <label for="newpassword">New password:</label><br>
		     <input id="newpassword" name="newpassword" type="password" required><br>
		     <input type="submit" value="Update">
		</form>
		<br>
		<br>
		<br>
	</sec:authorize>
	
	
	
	<sec:authorize access="hasRole('MANAGER')">
	<spring:url value="/resources/javascript/manager.js" var="managerjs" />
		
		<h1>Συνδεθήκατε ως Διευθυντής</h1>
			<h3>Τμήματα</h3>
		<c:forEach items="${tmimata}" var="tmimata">
		
			<ul>
				<li>Ονομα: ${tmimata.username} Τμήμα: ${tmimata.classN}</li>
			</ul>
		</c:forEach>
			<h3>Αιτησεις:</h3>
			<div id="applications"></div>	
		<h3>Register a child</h3>
		<form action="registerChild" method="post" onsubmit="return isNumber()">
          <label for="firstname">Firstname:</label><br>
		  <input id="firstname" type="text" name="firstname"><br>
		  <label for="lastname">Lastname:</label><br>
		  <input id="lastname" type="text" name="lastname"><br>
		  <label for="class">Class:</label><br>
		  <input id="class" type="text" name="class"><br>
		  <input type="submit" value="register">
		</form>
		
		<h3>Delete Application</h3>
		<select id="selectDelete" type="text">
		</select>
		<input type="button" id="deleteSubmit" value="Delete" onclick="deleteApplication();">
		
		<script type="text/javascript" src="${managerjs}" ></script>
		<script>window.onload = getRequest();</script>
		<script type="text/javascript">
		
		function isNumber(){
			var x, text;

			// Get the value of the input field with id="numb"
			x = document.getElementById("class").value;

			// If x is Not a Number or less than one or greater than 10
			if (isNaN(x) || x < 1 || x > 99) {
				text = "Input not valid";
				alert(text);
				return false;
			} else {
				return true;
			}
		}
		</script>
	</sec:authorize>
	
	
	
	<sec:authorize access="hasRole('TEACHER')">
		<h1>Συνδεθήκατε ως εκπαιδευτικός είστε στο τμήμα ${teacher.classN}</h1>
		<h3>Παιδιά</h3>
		<c:forEach items="${child}" var="child">
			<ul>
				<li>Ονομα: ${child.firstname} Επώνυμο: ${child.lastname} Τμήμα: ${child.classN}</li>
			</ul>
		</c:forEach>
	</sec:authorize>
	</div>
</body>




</html>