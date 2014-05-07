<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="./javascript/jquery.js"></script>
<script type="text/javascript" src="./javascript/jquery-json.js"></script>
<script type="text/javascript" src="./javascript/submit.js"></script>
<link rel="stylesheet" type="text/css" href="./css/styles.css">
<title>Quiz Summary</title>
</head>
<body>
<hr width="1000px"/>
<table align="center" class="outbox">
	<tr id="qbanner"><td><h5 class="cques"><s:property value = "q_id"/>.<s:property value = "question"/></h5></td></tr>
	<tr><td></td></tr>
</table>
<table align="center" class="outbox">
	<tr id="abanner"><td width="50%" ><h5 class="cques">Your Answer</h5></td><td width="50%"><h5 class="cques">Reference Answer</h5></td></tr>
	<tr><td><h5 class="cques"><s:property value="ans" /></h5></td><td><h5 class="cques"><s:property value = "answer" /></h5></td></tr>
</table>
<table align="center" class="outbox">
	<tr id="abanner"><td><h5 class="cques">Note</h5></td></tr>
	<tr><td><h5 class="cques"><s:property value = "comment" /></h5></td></tr>
</table>

</body>
</html>