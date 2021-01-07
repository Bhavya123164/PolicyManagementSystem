<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>POLICY REGISTERATION SUCCESS</title>
</head>



<style>
body {
	background-color: skyblue;
}
</style>
<script type="text/javascript">
	function deletePolicy(id) {
		if (confirm('Do you want to delete this policy?')) {
			var url = 'delete/' + id;
			window.location.href = url;
		}
	}
</script>
<body>
	<h1>POLICY REGISTERATION SUCCESS</h1>
	<table border="1">
		<tr>
			<th>Policy Id</th>
			<th>Policy Name</th>
			<th>Policy Type</th>
			<th>Company Name</th>
			<th>Number of Years</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${policy}" var="policyperson">
			<tr>
				<td>${policyperson.id}</td>
				<td>${policyperson.policyType}</td>
				<td>${policyperson.policyName}</td>
				<td>${policyperson.companyName}</td>
				<td>${policyperson.years}</td>
				<td><a href="<c:url value='/fetchById/${policyperson.id}'/>">EditPolicy</a></td>
				<td><a href="<c:url value='/delete/${policyperson.id}'/>">Delete
						Policy</a></td>
			</tr>
		</c:forEach>
	</table>
	<form action=" " method="get">

		<input type="submit" value="home">
</body>
</html>