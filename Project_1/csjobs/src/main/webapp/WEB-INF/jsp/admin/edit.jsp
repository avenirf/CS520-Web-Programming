<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CS Jobs - Edit job</title>
</head>
<body>
<h2>CS Jobs</h2>

<form:form modelAttribute="job">
<div style="margin-left: 40px;">
<table border="1" cellpadding="2" cellspacing="2">
	<tbody>
		<tr>
			<th style="text-align: right;">Title</th>
			<td><form:input path="title" type="text"/></td>
		</tr>
		<tr>
			<th style="text-align: right;">Description</th>
			<td><form:textarea cols="60" path="description" rows="5"></form:textarea></td>
		</tr>
		<tr>
			<th style="text-align: right;">Publish Date</th>
			<td><form:input path="publish_date" type="text" /></td>
		</tr>
		<tr>
			<th style="text-align: right;">Close Date</th>
			<td><form:input path="close_date" type="text" /></td>
		</tr>
		<tr>
			<th style="text-align: right;">Committee Chair</th>
			<td>
			<form:select items="${reviewers}" path="committeeChair" itemValue="id" itemLabel="firstName"/>
			</td>
		</tr>
		<tr>
			<th style="text-align: right;">Committee Members</th>
			<td>
 			<c:forEach items="${reviewers}" var="reviewer">
    			<form:checkbox path="reviewers" value="${reviewer}" /> ${reviewer.firstName} ${reviewer.lastName} <br />
    		</c:forEach>
			</td>
		</tr>
		<tr>
			<td colspan="2"><input name="save" type="submit" value="Save" /></td>
		</tr>
	</tbody>
</table>
</div>
</form:form>

</body>
</html>