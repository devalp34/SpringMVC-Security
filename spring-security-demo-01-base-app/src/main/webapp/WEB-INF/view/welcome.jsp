<%@ taglib prefix = "form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Welcome</title>
	</head>
	<body>
	<div style="width:50%;
				height:50%;
				float:center;
				text-align:center;
				margin:25% 25% 25% 25%;
				background-color:lightpink;">
		<p> hi..........</p><br>
		<p>
			Username : <security:authentication property="principal.username"/>
		</p><br>
		<p>
			Role : <security:authentication property="principal.authorities"/>
		</p><br>
		
		
		<!-- link for the student -->
		<security:authorize access="hasRole('student')">
		<hr>
			<a href="${pageContext.request.contextPath}/student"> For student club </a>
		</security:authorize>
		
		
		<!-- link for the teacher -->
		<security:authorize access="hasRole('teacher')">
		<hr>
			<a href="${pageContext.request.contextPath}/teacher"> For Teacher meeting</a>
		</security:authorize>
		
		
		<form:form action="${pageContext.request.contextPath}/logout" method="post">
			<input type="submit" value = "logout"/>
		</form:form>
	
	</div>
	</body>
</html>