<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page isELIgnored="false" %>
<html>
<body>
<%@ include file="menus.html" %>
<h2>Student Form!</h2>

	<form:form method="get" action="processForm" modelAttribute="student">
	
		First Name : <form:input path="firstName" />
	
		<br><br>
		
		Last Name : <form:input path="lastName" />
		
		<br><br>
		
		Country : <form:select path="country">
						<form:options items="${student.countryOptions}"/>
				</form:select>
		
		<br><br>
		
		Favourite Language : 
		
		Java <form:radiobutton path="favouriteLanguage" value="Java"/>
		C# <form:radiobutton path="favouriteLanguage" value="C#"/>
		PHP <form:radiobutton path="favouriteLanguage" value="Php"/>
		C++ <form:radiobutton path="favouriteLanguage" value="C++"/>
		
		<br><br>
		
		Operating Systems : 
		
		Linux <form:checkbox path="operatingSystems" value="Linux"/>
		Windows <form:checkbox path="operatingSystems" value="Windows"/>
		Mac <form:checkbox path="operatingSystems" value="Mac"/>
		
		<br><br>
		
		<input type="submit" value="Submit">

	</form:form>

</body>
</html>
