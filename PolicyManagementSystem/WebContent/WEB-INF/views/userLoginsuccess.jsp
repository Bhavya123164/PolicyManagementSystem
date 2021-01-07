<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>USER LOGIN SUCCESS</title>
</head>
body{ background-color: silver; }

<h1>USER LOGINED SUCCESSFULLY</h1>
<h2>To Search Policy Enter Policy Name and Policy Id</h2>
<form:form action="usersearch" method="get">
	<table>
		<tr>
			<td>PolicyName</td>
			<td><input type="PolicyName" value=""></td>
		</tr>
		<tr>
			<td>PolicyId</td>
			<td><input type="PolicyId" value=""></td>
		</tr>
		<td><input type="submit" value="Submit"></td>



		</form:form>


		</body>
		</html>