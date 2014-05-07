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
<title>ADD CODE DETAIL</title>
</head>
<body>
<hr width="1000px"/>
<s:form action="addcode" id="addcode" method="post" enctype="multipart/form-data">
<table align="center" class="outbox">
	<tr><td><s:textfield name="title" label="Title"/></td></tr>
	<tr><td><s:textfield name="cat" label="Category"/></td></tr>
	<tr><td><s:file name="texFile" label="Txt File"/></td></tr>
	<tr><td><s:file name="imageFile" label="Img File"/></td></tr>
    <tr><td><s:submit value="submit" /></td></tr>
</table>
</s:form>
<br>
<br>
<hr width="1000px"/>

</body>
</html>