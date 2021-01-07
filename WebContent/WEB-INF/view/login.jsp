<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<title>List Customers</title>
<!-- reference our style sheet -->
	<spring:url value="/resources/css/style.css" var="mainCss" />
    <link rel="stylesheet" type="text/css" href="${mainCss}">
</head>
<body>

   <h3>Login</h3>
   
<div class="form-group">

   <form:form action="${pageContext.request.contextPath}/authUser" method="POST">
    <c:if test="${param.error != null}">
           <i>Sorry! Invalid username/password!</i>
           <br>
   </c:if>
   
                   <label class="form-label">User Name</label>
                   <input type="text" name="username"/>
           
           			<br>
                   <label class="form-label">Password</label>
                   <input type="password" name="password"/><br>
                   <button class="btn" type="submit">Login</button>
                  
   </form:form>
   
</div>

</body>
</html>