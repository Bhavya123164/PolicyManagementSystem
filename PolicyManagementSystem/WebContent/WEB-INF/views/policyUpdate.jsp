<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>POLICY UPDATE</title>
</head>
<body>
	<h1>POLICY UPDATED FORM</h1>



	<c:url var="action" value="/editPol/"></c:url>
	<form:form action="${action}" method="post" modelAttribute="editPolicy">
		<table>
			<tr>
				<td>Policy Id</td>
				<td><form:input path="id" readonly="true" />
			</tr>
			<tr>
				<td>Policy Name</td>
				<td><form:input path="policyName" /></td>
			</tr>
			<tr>
				<td>Policy Type</td>
				<td><form:input path="policyType" /></td>
			</tr>
			<tr>
				<td>Company Name</td>
				<td><form:input path="companyName" /></td>
			</tr>
			<tr>
				<td>Number of years</td>
				<td><form:input path="years" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="EDIT"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>