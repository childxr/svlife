<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="./javascript/jquery.js"></script>
<script type="text/javascript" src="./javascript/jquery-json.js"></script>
<script type="text/javascript" src="./javascript/submit.js"></script>
<link rel="stylesheet" type="text/css" href="./css/styles.css">
<title>ADD EXAM</title>
</head>
<body>
<s:form action="addexam" method="post" enctype="multipart/form-data">
<table class="outbox">
	<tr>
		<td><s:textarea name="question" label="Question" cols="75" rows="5"/></td>
		<td><s:textfield name="category" label="Category"/></td>
		<td><s:textarea name="options" label="Options" cols="75" rows="5"/></td>
		<td><s:textarea name="answer" label="Answer" cols="75" rows="5"/></td>
		<td><s:submit value="submit" /></td>
	</tr>
</table>
</s:form>

</body>
</html>