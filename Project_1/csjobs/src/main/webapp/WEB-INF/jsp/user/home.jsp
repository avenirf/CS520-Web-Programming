<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<style>
.btn {
  background: #3498db;
  background-image: -webkit-linear-gradient(top, #3498db, #2980b9);
  background-image: -moz-linear-gradient(top, #3498db, #2980b9);
  background-image: -ms-linear-gradient(top, #3498db, #2980b9);
  background-image: -o-linear-gradient(top, #3498db, #2980b9);
  background-image: linear-gradient(to bottom, #3498db, #2980b9);
  -webkit-border-radius: 28;
  -moz-border-radius: 28;
  border-radius: 28px;
  font-family: Arial;
  color: #ffffff;
  font-size: 20px;
  padding: 10px 20px 10px 20px;
  text-decoration: none;
}

.btn:hover {
  background: #f50000;
  background-image: -webkit-linear-gradient(top, #f50000, #3498db);
  background-image: -moz-linear-gradient(top, #f50000, #3498db);
  background-image: -ms-linear-gradient(top, #f50000, #3498db);
  background-image: -o-linear-gradient(top, #f50000, #3498db);
  background-image: linear-gradient(to bottom, #f50000, #3498db);
  text-decoration: none;
}
</style>
<title>User main page</title>
</head>
<body>
<div style="margin-left: 40px;">
<h2 style="display:inline">CS Jobs</h2> | <a style="display:inline" href="<c:url value='/' />">Main</a>
<p>You are logged in as <em>${authenticatedUser.firstName} ${authenticatedUser.lastName}</em>.</p>

<table>
	<tr><th scope="row" style="text-align: left;">List of CS Jobs:</th></tr>
	<c:forEach items="${ jobs }" var="job">
		<tr>
			<td><a href="<c:url value='/jobDescription/${job.id}.html'/>"> ${job.title} </a></td>
				<c:choose>
				    <c:when test="${ job.check }">
				    	<c:forEach items="${ applications }" var="application">
				    	<c:if test="${ job.id == application.job.id }">
				        	<td>[<a href="<c:url value='viewApp.html?id=${application.id}'/>">view application</a>]</td>
						</c:if>
						</c:forEach>
				    </c:when>
				    <c:otherwise>
						<td>[<a href="<c:url value='/user/apply.html?jobId=${ job.id }'/>">apply</a>]</td>
				    </c:otherwise>
				</c:choose>
		</tr>
	</c:forEach>
</table>
<input type="hidden" name="id" value="${ user.id }"/>
</br>

<form action="<c:url value='/logout' />" method="post">
<input name="_csrf" type="hidden" value="${ _csrf.token }" />
<input class="btn" name="submit" type="submit" value="Logout" />
</form>


</div>
</body>
</html>