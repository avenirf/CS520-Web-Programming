<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>For Admin</title>
</head>
<body>

<p style="margin-left: 40px;"><strong>California State University LA Jobs</strong></p>

<p style="margin-left: 40px;"><a href="CSJob">CSJobs</a> > Admin</p>

<p style="margin-left: 40px;"><a href="AddJob">Post New Job Opening</a></p>

<div style="margin-left: 40px;">
<table border="1" cellpadding="2" cellspacing="2">
	<thead>
		<tr>
			<th>Job</th>		
			<th>Posted On</th>
			<th></th>		
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${jobs}" var="job">
			<tr>
				<td>${job.job}</td>
				<td>${job.date}</td>
				<td><a href="ViewApplicants?index=${job.index}">View Applicants</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</div>
</body>
</html>