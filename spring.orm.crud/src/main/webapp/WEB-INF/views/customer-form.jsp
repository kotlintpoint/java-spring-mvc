<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Simple Form</title>
<style type="text/css">
	.error{
		color:red
	}
</style>
</head>
<body>
	<h1>Customer Form</h1>
	<sf:form action="process-form" modelAttribute="customer">
		<sf:hidden path="id"/>
		
		First Name : <sf:input path="firstName"/> <sf:errors path="firstName" cssClass="error"></sf:errors>
		<br><br>
		Last Name : <sf:input path="lastName"/>
		<br><br>
		Email : <sf:input path="email"/>
		<br><br>
		<input type="submit">
	</sf:form>
</body>
</html>