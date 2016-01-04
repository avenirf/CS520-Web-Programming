<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Info about applicant</title>
</head>
<body>

<p style="margin-left: 40px;"><strong>California State University LA Jobs</strong></p>

<p style="margin-left: 40px;"><a href="CSJob">CSJobs</a> > <a href="Enter"> Applicant</a> 
	> Applicant Info</p>

<div style="margin-left: 40px;">
<table border="1" cellpadding="2" cellspacing="2">
	<thead>
		<tr>
			<th>Job</th>		
			<th>Posted On</th>
			<c:if test="${empty applicant.job}">
    			<td></td>       				
    		</c:if>		
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${list}" var="list">
			<tr>
				<td>${list.job.job}</td>
				<td>${list.job.date}</td>
    			<c:choose>
    				<c:when test="${empty applicant.job}">
        				<td><a href="AddApplication?index=${list.job.index}&name=${applicant.name}">Add Application</a></td>
    				</c:when>    
    				<c:otherwise>
    					<c:if test="${ list.link == false }">
    						<td><a href="AddApplication?index=${list.job.index}&name=${applicant.name}">Add Application</a></td>
    					</c:if>
    				</c:otherwise>
				</c:choose>    
			</tr>
		</c:forEach>
	</tbody>
</table>
</div>
</br>
<div style="margin-left: 40px;"><strong>Job position:</strong>
	<c:forEach items="${applicant.job}" var="apJob">
		<ul>
			<li>${ apJob.job }</li>
		</ul>
	</c:forEach>
</div>

<p style="margin-left: 40px;"><strong>Applicant name:</strong> ${ applicant.name }</p>

<p style="margin-left: 40px;"><strong>Education:</strong></p>

<div style="margin-left: 40px;">
<table border="1" cellpadding="2" cellspacing="2">
	<thead>
		<tr>
			<th>Degree</th>		
			<th>University</th>
			<th>Year</th>		
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${applicant.degree}" var="degree">
			<tr>
				<td>${ degree.degree }</td>
				<td>${ degree.university }</td>
				<td>${ degree.year }</td>
			</tr>
		</c:forEach>
			<tr>
				<td colspan="3" align="right">
					<button onclick="location.href='AddDegree?name=${applicant.name}'">+ Add Degree</button>
				</td>
			</tr>
	</tbody>
</table>
</div>

</body>
</html>