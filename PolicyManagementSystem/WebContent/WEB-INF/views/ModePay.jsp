<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MODE PAYMENT</title>
</head>
<style>
body {
	background-image:
		url("https://d1l21ng1r9w8na.cloudfront.net/article/images/800x800/dimg/dreamstime_xl_51023833.jpg");
}
</style>
<body>
	<form:form action="modepays" method="post">
		<h1>PAYMENT OPTIONS</h1>
		<input type="radio" id="credit" name="credit" value="credit">
		<label for="credit">CREDIT</label>
		</br>
		<input type="radio" id="debit" name="debit" value="debit">
		<label for="debit">DEBIT</label>
		</br>
		<input type="radio" id="UPI" name="UPI" value="UPI">
		<label for="UPI">UPI</label>
		</br>
		<input type="submit" value="submit">
	</form:form>
</body>
</html>