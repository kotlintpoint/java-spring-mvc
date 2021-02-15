<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
#customers {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#customers td, #customers th {
  border: 1px solid #ddd;
  padding: 8px;
}

#customers tr:nth-child(even){background-color: #f2f2f2;}

#customers tr:hover {background-color: #ddd;}

#customers th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #4CAF50;
  color: white;
}
</style>
</head>
<body>
	<h1>Customer List</h1>
	<table id="customers">
		 <tr>
			    <th>ID</th>
			    <th>First Name</th>
			    <th>Last Name</th>
			    <th>Email</th>
			    <th>Action</th>
	  </tr>
		<c:forEach items="${customers}" var="customer">
			<c:url var="updateUrl" value="/customer/showFormForUpdate">
				<c:param name="customerId" value="${customer.id}"></c:param>
			</c:url>
			<c:url var="deleteUrl" value="/customer/delete">
				<c:param name="customerId" value="${customer.id}"></c:param>
			</c:url>
			<tr>
				<td>${customer.id}</td>
				<td>${customer.firstName}</td>
				<td>${customer.lastName}</td>
				<td>${customer.email}</td>
				<td>
					<a href="${updateUrl}">Update</a>
					|
					<a href="${deleteUrl}"
						onclick="if(!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>