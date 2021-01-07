<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>USER SUCCESS</title>
</head>
<style>
body {
	background-color: silver;
}

th {
	background-color: blue;
}
</style>



<body>
	<h1>
		<center>USER REGISTERATION SUCCESS</center>
	</h1>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>First Name</th>
			<th>LastName</th>
			<th>Age</th>
			<th>Gender</th>
			<th>Contact Number</th>
			<th>UserId</th>
			<th>Password</th>
		</tr>
		<c:forEach items="${userList}" var="user1">
			<tr>
				<td>${user1.id}</td>
				<td>${user1.firstName}</td>
				<td>${user1.lastName}</td>
				<td>${user1.age}</td>
				<td>${user1.gender}</td>
				<td>${user1.contactNumber}</td>
				<td>${user1.userId}</td>
				<td>${user1.password}</td>
			</tr>
		</c:forEach>
	</table>
	<center>
		<a href="<c:url value='/userloginpage'/>">USER LOGIN PAGE</a><br />
	</center>
</body>
</html>