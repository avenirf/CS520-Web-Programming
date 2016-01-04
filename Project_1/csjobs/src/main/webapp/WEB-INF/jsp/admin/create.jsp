<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>CS Jobs - Create new job</title>
</head>
<body>
<h2>CS Jobs</h2>
<form:form modelAttribute="job">

<div style="margin-left: 40px;">
<table border="1" cellpadding="2" cellspacing="2">
	<tbody>
		<tr>
			<th style="text-align: right;">Title</th>
			<td><form:input path="title" type="text"/> <b><form:errors path="title" /></b></td>
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
			<td><select name="committeeChair">
			<c:forEach items="${reviewers}" var="chear">
				<option value="${chear.id}">${ chear.firstName } ${ chear.lastName }</option>
			</c:forEach>
			</select>
			</td>
		</tr>
		<tr>
			<th style="text-align: right;">Committee Members</th>
			<td>
			<c:forEach items="${reviewers}" var="member">
				<input name="committeeMembers" type="checkbox" value="${member.id}" />${member.firstName} ${member.lastName}<br />
			</c:forEach>
			</td>
		</tr>
		<tr>
			<td colspan="2"><input name="create" type="submit" value="Create" /></td>
		</tr>
	</tbody>
</table>
</div>

</form:form>
</body>
</html>
