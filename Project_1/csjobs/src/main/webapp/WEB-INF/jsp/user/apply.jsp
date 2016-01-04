<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Apply for position</title>
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
</head>
<body>
<div style="margin-left: 40px; margin-top: 40px;">
<h3>${application.job.title}</h3>
<p>Applicant: ${application.applicant.firstName} ${application.applicant.lastName}</p>

<form:form modelAttribute="application">
<p>Current Job Position:</p>
<table>
	<tr><th scope="row" style="text-align: right;">Company:</th> 
		<td><form:input path="company" /></td>
		<td><b style="color:red"><form:errors path="company" /></b></td></tr>
	<tr><th scope="row" style="text-align: right;">Title:</th> 
		<td><form:input style="width:300px" path="title" /></td>
		<td><b style="color:red"><form:errors path="title" /></b></td></tr>
	<tr><th scope="row" style="text-align: right;">Start year:</th> 
		<td><form:input style="width:300px" path="start_year" /></td>
		<td><b style="color:red"><form:errors path="start_year" /></b></td></tr>
		<tr><td colspan="2" scope="row" style="text-align: right;">
			<input class="btn" type="submit" name="apply" value="Next >>" />
			</td>
		</tr>
</table>
</form:form>

</div>
</body>
</html>