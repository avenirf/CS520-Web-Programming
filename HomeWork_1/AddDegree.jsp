<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Add Degree</title>
</head>
<body>

<form action="AddDegree" method="post">
<div style="margin-left: 40px;">
<p><strong>California State University LA Jobs</strong></p>

<p><a href="CSJob">CSJobs</a> > <a href="Login"> Name Check</a> > <a href="ApplicantInf2?name=${ applicant.name }">Applicant Info</a> > Add Degree</p>

<p style="margin-left: 40px;"><strong>Applicant Name:</strong> ${ applicant.name }</p>

<p style="margin-left: 40px;">Please enter your Degree:</p>
<table border="1" cellpadding="2" cellspacing="2">
	<tbody>
		<tr>
			<th scope="row" style="text-align: right;">Degree:</th>
			<td><input name="degree" type="text" /></td>
		</tr>
		<tr>
			<th scope="row" style="text-align: right;">University:</th>
			<td><input name="university" type="text" /></td>
		</tr>
		<tr>
			<th scope="row" style="text-align: right;">Year when end:</th>
			<td><input name="year" type="text" /></td>
		</tr>
		<tr>
			<td colspan="2" scope="row" style="text-align: right;">
				<input name="add" type="submit" value="Add degree" />
			</td>
		</tr>
	</tbody>
</table>
<input type="hidden"  name="applicant" value="${ applicant.name }"/>
</div>
</form>

</body>
</html>