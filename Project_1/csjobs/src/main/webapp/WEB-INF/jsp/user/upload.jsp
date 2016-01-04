<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>File update</title>
</head>
<body>
	<form action="upload.html?${_csrf.parameterName}=${_csrf.token}" method="post" enctype="multipart/form-data">
	Curriculum vitae: <input type="file" name="c_v" /> <br />
    Research statement: <input type="file" name="research_s" /> <br />
    Teaching statement: <input type="file" name="teaching_s" /> <br />
	<input type="submit" name="upload" value="Upload" />
	<input type ="hidden" name="applicationId" value="${ application.id }" />
	</form>
</body>
</html>