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
<title>CODE Details</title>
</head>
<body>
<table align="center" class="outbox">
	<tr><td><h4 class="ctitle"><s:property value="code.question" /></h4></td></tr>
</table>
<hr width="1000px"/>
<table align="center" class="outbox">
	<s:iterator value="description">
	<tr>
		<td><h5 class="cques"><s:property /></h5></td>
	</tr>
	</s:iterator>
</table>
<br>
<hr width="1000px"/>
<table align="center" class="outbox">
	<s:iterator value="idea">
	<tr>
		<td><h5 class="des"><s:property /></h5></td>
	</tr>
	</s:iterator>
</table>
<br>
<table align="center" class="outbox">
<tr><td><img src="<s:property value="picPath"/>" ></img></td></tr>
</table>


</html>