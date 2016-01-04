<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CS Jobs - Reviewer</title>
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
</head>
<body>
<div style="margin-left: 40px;">
<h2 style="display:inline">CS Jobs</h2> | <a style="display:inline" href="<c:url value='/' />">Main</a>

<p>You are logged in as <em>${authenticatedUser.firstName} ${authenticatedUser.lastName}</em>.</p>

<h3>Reviewer Home</h3>

</br>
<table>
	<tr><td><form action="<c:url value='/logout' />" method="post">
<input name="_csrf" type="hidden" value="${ _csrf.token }" />
<input class="btn" name="submit" type="submit" value="Logout" />
</form></td> <td><a class="btn" href="<c:url value='/applications.html'/>">View applications</a></td></tr>
</table>
</div>
</body>
</html>
