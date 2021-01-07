
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AdminLogin</title>
</head>
<style>
body {
	background-color: silver;
}
</style>
<body>
	<h1>AdminLogin</h1>
	<form:form action="adminloginsucess" method="post">
		<table>
			<tr>
				<td>AdminName</td>
				<td><input type="adminName" value=""></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" value=""></td>
			</tr>
			<td><input type="submit" value="Submit"></td>
			</form:form>
</body>
</html>