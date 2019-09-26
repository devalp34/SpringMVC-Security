<%@ taglib prefix = "form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<style>
	.failed{
		color:red;
	}
</style>
</head>
<body>
<div style="border:5px solid grey;
			text-align:center">
<p> Login page .......</p><br>
<form:form action="${pageContext.request.contextPath}/processedForm"
			method="post">
	<c:if test="${param.error != null}">
		<i class="failed">False login credential :(</i>
	</c:if>
	<p>
		UserName: <input type="text" name="username">
	</p>
	<p>
		Password: <input type="text" name="password">
	</p>
	<input type="submit" value="Submit"/>
</form:form>
</div>
</body>
</html>