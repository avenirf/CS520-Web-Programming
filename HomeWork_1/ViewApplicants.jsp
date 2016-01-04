<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Applicants</title>
</head>
<body>

<p style="margin-left: 40px;"><strong>California State University LA Jobs</strong></p>

<p style="margin-left: 40px;"><a href="CSJob">CSJobs</a> > <a href="Admin">Admin</a> > Applicants</p>

<p style="margin-left: 40px;"><strong>Job position:</strong> ${ job.job }</p>

<div style="margin-left: 40px;">
<table border="1" cellpadding="2" cellspacing="2">
	<thead>
		<tr>
			<th>Applicant</th>		
			<th>Applied On</th>		
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${applicants}" var="applicant">
			<c:forEach items="${applicant.job}" var="apJob">
				<c:if test="${apJob == job}">
					<tr>
						<td><a href="ApplicantInf?name=${applicant.name}&index=${job.index}">${applicant.name}</a></td>
						<td>${applicant.applied}</td>
					</tr>
				</c:if>
			</c:forEach>
		</c:forEach>
	</tbody>
</table>
</div>

</body>
</html>