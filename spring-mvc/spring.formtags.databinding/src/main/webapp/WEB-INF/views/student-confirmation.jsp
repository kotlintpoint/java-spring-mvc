<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<%@ include file="menus.html" %>
<h2>Student Confirmation Page!</h2>

<p>The Student is Confirmed : ${student.firstName} ${student.lastName}</p>

<p>Country : ${student.country}</p>

<p>Favourite Language : ${student.favouriteLanguage}</p>

<p>Operating Systems : </p>
<ul>
	<c:forEach items="${student.operatingSystems}" var="operatingSystem">
		<li>${operatingSystem}</li>
	</c:forEach>
</ul>

</body>
</html>
