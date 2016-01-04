<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Add Application</title>
</head>
<body>

<form action="AddApplication" method="post">
<div style="margin-left: 40px;">
<p><strong>California State University LA Jobs</strong></p>

<p><a href="CSJob">CSJobs</a> > <a href="Enter">Applicant</a> > Add Application - Name</p>

<p style="margin-left: 40px;"><strong>Job position:</strong> ${ job.job }</p>

<p style="margin-left: 40px;">Please enter your name:</p>
<table border="1" cellpadding="2" cellspacing="2">
	<tbody>
		<tr>
			<th scope="row" style="text-align: right;">Applicant Name:</th>
			<td><input name="newName" type="text" /></td>
		</tr>
		<tr>
			<td colspan="2" scope="row" style="text-align: right;"><input name="add" type="submit" value="Next >>" /></td>
		</tr>
	</tbody>
</table>
<input type="hidden"  name="job" value="${ job.index }"/>
</div>
</form>

</body>
</html>