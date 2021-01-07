<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>POLICY REGISTER</title>
</head>
<style>
body {
	background-color: lightgreen;
}
</style>
<body>
	<h1>
		<center>POLICY REGISTERATION</center>
	</h1>
	<c:url var="action" value="/savepolicy"></c:url>
	<form:form action="${action}" method="post" modelAttribute="policyform">
		<center>
			<table>
				<tr>
					<td>PolicyName</td>
					<td><form:input path="policyName" /><font color="red"><form:errors
								path="policyName"></form:errors></font>
				</tr>
				</br>
				<tr>
					<td>PolicyType</td>
					<td><form:input path="policyType" /><font color="red"><form:errors
								path="policyType"></form:errors></font>
				</tr>
				</br>
				<tr>
					<td>Company Name</td>
					<td><form:input path="companyName" /><font color="red"><form:errors
								path="companyName"></form:errors></font>
				</tr>
				</br>

				<tr>
					<td>years</td>
					<td><form:input path="years" /><font color="red"><form:errors
								path="years"></form:errors></font>
				</tr>
				</br>
				<tr>
					<td><input type="Submit" value="Register"></td>
				</tr>
				</br>
			</table>
		</center>
	</form:form>
</body>
</html>