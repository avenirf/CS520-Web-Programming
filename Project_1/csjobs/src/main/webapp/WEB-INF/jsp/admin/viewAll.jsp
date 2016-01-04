<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>CSJobs - Job</title>
</head>
<body>
<h2>CS Jobs</h2>
<h3>${job.title}</h3>
<p><b>Posted on:</b> <fmt:formatDate value="${job.publish_date}" pattern="M/d/yyyy" /></p>
<p><b>Close on:</b>  <fmt:formatDate value="${job.close_date}" pattern="M/d/yyyy" /></p>
<p><b>Job Description:</b></p>
<p>${job.description}</p>
<p><b>Review committee chair:</b></p>
<p>${job.committeeChair.firstName} ${job.committeeChair.lastName}</p>
<p><b>Review committee members:</b></p>
<c:forEach items="${job.reviewers}" var="member">
	<li>${ member.firstName } ${ member.lastName }</li>
</c:forEach>
<p><b>Applicants:</b></p>
<ul>
<c:forEach items="${applications}" var="application">
	<li><a href="<c:url value='/user/viewApp.html?id=${application.id}'/>">${ application.applicant.firstName } ${ application.applicant.lastName }</a></li>
</c:forEach>
</ul>
</body>
</html>
