<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
h1 {
	background-color: white;
}

body {
	background-color: skyblue;
}

li {
	text-align: center;
}

p {
	background-color: white;
}
</style>
<title>home</title>
</head>
<body>
	<h1>
		<center>Welcome to Policy Management System</center>
	</h1>
	<ul>
		<center>
			<a href="<c:url value='/adminreg'/>">ADMIN REGISTRATION</a><br /> <a
				href="<c:url value='/userreg'/>">USER REGISTRATION</a><br /> <a
				href="<c:url value='/vendorregpage'/>">VENDOR REGISTRATION</a><br />
	</ul>
	</center>



	<p>
	<center>Any Information</center>
	</p>
	<p>
	<center>@PolicyManagementService@gmail.com</center>
	</p>
</body>
</html>