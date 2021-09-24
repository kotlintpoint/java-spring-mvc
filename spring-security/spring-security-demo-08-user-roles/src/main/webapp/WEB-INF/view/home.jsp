<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>KotlinTpoint</h1>
	<hr>
	<p>Welcome to the Home Page</p>
	<hr>
		<!-- display user name and roles -->
		<p>User : <sec:authentication property="principal.username"/> 
			<br><br>
			Role(s) : <sec:authentication property="principal.authorities"/>
		</p>
		
		<hr>
		
		<sec:authorize access="hasRole('MANAGER')">
		
			<!-- Add a link to point to /leaders .... this is for the managers -->
			<p>
				<a href="${pageContext.request.contextPath}/leaders">Leadership Meeting</a>
				(Only for Manager Peeps)			
			</p>
		</sec:authorize>
		
		<sec:authorize access="hasRole('ADMIN')">
			<!-- Add a link to point to /systems ... this is for admins -->
			<p>
				<a href="${pageContext.request.contextPath}/systems">IT System Meeting</a>
				(Only for Admin Peeps)			
			</p>
		</sec:authorize>
	<hr>
	<!-- Add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout" 
			   method="POST" >
		<input type="submit" value="Logout" />
	</form:form>
</body>
</html>