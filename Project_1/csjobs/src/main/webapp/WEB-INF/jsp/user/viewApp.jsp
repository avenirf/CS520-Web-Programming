<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Application</title>
</head>
<body>

<div style="margin-left: 40px;">
<p><h3>Application for position:</h3> ${ app.job.title }</p>

<table>
	<tr><th scope="row" style="text-align: left;">Company:</th> <td>${ app.company }</td></tr>
	<tr><th scope="row" style="text-align: left;">Title:</th> <td>${ app.title }</td></tr>
	<tr><th scope="row" style="text-align: left;">Start year:</th> <td>${ app.start_year }</td></tr>
</table>
</br>
<table border="1">	
	<tr><th colspan="2" scope="row" style="text-align: center;">Degrees</th></tr>
	<c:forEach items="${app.degree}" var="degre">
		<tr><th colspan="2" scope="row" style="text-align: center;"></th></tr>
		<tr><th scope="row" style="text-align: left;">University:</th><td>${ degre.school }</td></tr>
		<tr><th scope="row" style="text-align: left;">Degree:</th><td>${ degre.name }</td></tr>
		<tr><th scope="row" style="text-align: left;">Year:</th><td>${ degre.year }</td></tr>
	</c:forEach>
</table>
</br>

<ul>
<li>Curriculum vitae: <a href="<c:url value='download.html?fileId=${app.c_v.id}'/>"> ${ app.c_v.name }</a></li>
<li>Research statement: <a href="<c:url value='download.html?fileId=${app.research_s.id}'/>"> ${ app.research_s.name }</a></li>
<li>Teaching statement: <a href="<c:url value='download.html?fileId=${app.teaching_s.id}'/>"> ${ app.teaching_s.name }</a></li>
</ul>

</div>

</body>
</html>