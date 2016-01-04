<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<style>
.btn {
  background: #3498db;
  background-image: -webkit-linear-gradient(top, #3498db, #2980b9);
  background-image: -moz-linear-gradient(top, #3498db, #2980b9);
  background-image: -ms-linear-gradient(top, #3498db, #2980b9);
  background-image: -o-linear-gradient(top, #3498db, #2980b9);
  background-image: linear-gradient(to bottom, #3498db, #2980b9);
  -webkit-border-radius: 28;
  -moz-border-radius: 28;
  border-radius: 28px;
  font-family: Arial;
  color: #ffffff;
  font-size: 20px;
  padding: 10px 20px 10px 20px;
  text-decoration: none;
}

.btn:hover {
  background: #f50000;
  background-image: -webkit-linear-gradient(top, #f50000, #3498db);
  background-image: -moz-linear-gradient(top, #f50000, #3498db);
  background-image: -ms-linear-gradient(top, #f50000, #3498db);
  background-image: -o-linear-gradient(top, #f50000, #3498db);
  background-image: linear-gradient(to bottom, #f50000, #3498db);
  text-decoration: none;
}
</style>
<title>Login</title>
</head>
<body>
<div style="margin-left: 40px; margin-top: 40px;">
<table>
<form:form modelAttribute="user">
	<tr><th scope="row" style="text-align: right;">Username/Email:</th> <td><form:input style="width:300px" path="email" /></td> <td><b><form:errors path="email" /></b></td></tr>
	<tr><th scope="row" style="text-align: right;">Password:</th> <td><form:input style="width:300px" path="password" /></td> <td><b><form:errors path="password" /></b></td></tr>
	<tr><td colspan="2" scope="row" style="text-align: right;"><input class="btn" type="submit" name="login" value="Login" /></td></tr>
</form:form>
</table>
</div>
</body>
</html>