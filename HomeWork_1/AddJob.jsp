<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Add new Job</title>
</head>
<body>

<form action="AddJob" method="post">
<div style="margin-left: 40px;">
<p><strong>California State University LA Jobs</strong></p>

<p><a href="CSJob">CSJobs</a> > <a href="Admin">Admin</a> > New Job Opening</p>

<table border="1" cellpadding="2" cellspacing="2">
	<tbody>
		<tr>
			<th scope="row" style="text-align: right;">Job:</th>
			<td><input name="newJob" type="text" /></td>
		</tr>
		<tr>
			<td colspan="2" scope="row" style="text-align: right;"><input name="add" type="submit" value="Post" /></td>
		</tr>
	</tbody>
</table>
</div>
</form>

</body>
</html>