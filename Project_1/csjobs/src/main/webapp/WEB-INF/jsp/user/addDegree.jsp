<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<title>Add Degree</title>
</head>

<body>
<h2>CS Jobs</h2>
<h3>${application.job.title}</h3>
<p>Applicant: ${application.applicant.firstName} ${application.applicant.lastName}</p>

<form:form modelAttribute="degree">
<table border="1">
<tr><th>Degree</th><th>School</th><th>Year</th></tr>
<c:forEach items="${application.degree}" var="degree">
<tr>
  <td>${degree.name}</td>
  <td>${degree.school}</td>
  <td>${degree.year}</td>
</tr>
</c:forEach>
<tr>
  <td><form:input path="name" /></td>
  <td><form:input path="school" /></td>
  <td><form:input path="year" /></td>
</tr>
</table>
<p>
  <input type="submit" name="add" value="Add" />
  <a href="home.html">Finish</a>
</p>
</form:form>
</body>

</html>