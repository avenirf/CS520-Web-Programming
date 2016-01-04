<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>CS Jobs Main Page</title>
</head>
<body>
<div style="margin-left: 40px;">
<h2>Welcome to CS Jobs</h2>

<c:if test="${empty authenticatedUser}">
<p>
  <a href="<c:url value='/addUser.html' />">Registration</a> |
  <!--  <a href="<c:url value='/admin/home.html' />">Admin</a> |
  <a href="<c:url value='/reviewer/home.html' />">Reviewer</a> |
  <a href="<c:url value='/user/home.html' />">Applicant</a> |-->
  <a href="<c:url value='/user/login.html' />">Login</a>
</p>
</c:if>

<c:if test="${not empty authenticatedUser}">
<p>You are logged in as <em>${authenticatedUser.firstName} ${authenticatedUser.lastName}</em>.</p>
<form action="<c:url value='/logout' />" method="post">
<input name="_csrf" type="hidden" value="${ _csrf.token }" />
<input class="btn" name="submit" type="submit" value="Logout" />
</form>
</c:if>

<h3>Open Job Positions</h3>
<ul>
<c:forEach items="${openJobs}" var="job">
  <li><a href="<c:url value='/jobDescription/${job.id}.html' />">${job.title}</a></li>
</c:forEach>
</ul>
</div>
</body>
</html>