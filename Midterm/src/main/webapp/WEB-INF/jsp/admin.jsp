<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CS Jobs - Admin</title>
</head>
<body>
<h2>CS Jobs (Exam Edition)</h2>

<p>You are logged in as <em>${authenticatedUser.firstName} ${authenticatedUser.lastName}</em>.
<a href="<c:url value='/logout.html' />">Logout</a></p>

<p style="margin-left: 40px;"><a href="job/create.html">Create New Job</a></p>

<div style="margin-left: 40px;">
<table border="1" cellpadding="2" cellspacing="2">
	<thead>
		<tr>
			<th scope="col">Job</th>
			<th scope="col">Publish Date</th>
			<th scope="col">Close Date</th>
			<th scope="col">Operations</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${jobs}" var="job">
		<tr>
			<td><a href="<c:url value='/job/viewAll.html?id=${job.id}'/>">${ job.title }</a></td>
			<td style="text-align: center;"><fmt:formatDate pattern="M/d/yyyy" value="${job.publishDate}" /></td>
			<td style="text-align: center;"><fmt:formatDate pattern="M/d/yyyy" value="${ job.closeDate }" /></td>
			<td style="text-align: center;"><a href="<c:url value='/job/edit.html?id=${job.id}'/>">Edit</a></td>
		</tr>
	</c:forEach>
	</tbody>
</table>
</div>

</body>
</html>
