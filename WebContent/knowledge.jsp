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
<title>Knowledge</title>
</head>
<body>

<table align="center" class="outbox">
	<s:iterator value="knowledgeList">
	<tr id="qbanner"><td><h5 class="cques"><s:property value = "knowledgeId"/>.<s:property value = "question"/></h5></td></tr>
	<tr><td><h5 class="cques"><s:property value = "answer" escape="false"/></h5></td></tr>
	<tr><td><h5 class="category"><s:property value = "category"/></h5></td></tr>
	</s:iterator>
</table>
<table align="center" class="outbox">
	<tr>
	<s:iterator value="pages"><td><input type="button" value="<s:property />" onclick="show_knowledge(<s:property />)"></td></s:iterator>
	</tr>
</table>


</body>
</html>