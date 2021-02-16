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
input[type=text] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type=submit] {
  width: 100%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #45a049;
}

div {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
</style>
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