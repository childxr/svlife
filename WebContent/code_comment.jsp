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
<title>CODE COMMENT</title>
</head>
<body>
<hr width="1000px"/>
<table align="center" class="outbox">
	<s:iterator value="commentList">
	<tr bgcolor="#EBF5FF">
		<td ><s:property value="dateCreated"/></td>
	</tr>
	<tr>
		<td><s:property value="comment"/></td>
	</tr>
	</s:iterator>
</table>
<s:form action="addcodecomment">
<s:hidden value="%{codingId}" name="codingId" />
<table align="center" class="outbox">
	<tr><td><s:textarea name="ccomment" cols="120" rows="8"></s:textarea></td></tr>
</table>
<table align="center" class="outbox">
	<tr><td><input type= "button" value="save" onclick="add_code_comment()"></td></tr>
</table>
</s:form>

</body>
</html>