<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<style>
body {
	background-color: silver;
}
</style>
<meta charset="ISO-8859-1">
<title>ADMIN LOGIN SUCCESS</title>
</head>
<body>
	<h1>ADMIN LOGINED SUCCESSFULLY</h1>
	<a href="<c:url value='/policyreg'/>">POLICY REGISTRATION</a>
	<br />
</body>
</html>