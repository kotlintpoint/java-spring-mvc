<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Simple Form</title>
<link href='<c:url value="/resources/css/styles.css"/>' rel="stylesheet" />
<script type="text/javascript" src='<c:url value="/resources/js/script.js"/>'></script>

</head>
<body>
	<h1>Customer Form</h1>
	<div>
		<sf:form action="process-form" modelAttribute="customer">
			<sf:hidden path="id"/>
			
			First Name : <sf:input path="firstName" type="text" /> 
			<sf:errors path="firstName" cssClass="error"></sf:errors>
			<br><br>
			Last Name : <sf:input path="lastName" type="text"/>
			<sf:errors path="lastName" cssClass="error"></sf:errors>
			<br><br>
			Email : <sf:input path="email" type="text"/>
			<br><br>
			<input type="submit">
		</sf:form>
	</div>
</body>
</html>