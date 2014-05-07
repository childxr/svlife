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
<title>CODE COMMENT HISTORY</title>
</head>
<body>
<hr width="1000px"/>
<s:iterator value="commentList">
<s:form actoin="codedetails">
<table align="center" class="outbox">
	<tr bgcolor="#EBF5FF">
		<td width="90%"><s:property value="code.question"/></td>
		<td ><s:property value="dateCreated"/></td>
	</tr>
	
	<tr>
		<td width="90%"><s:property value="comment"/></td>
		<td><input type="button" value="more" onclick="show_code_details(<s:property value = "code.codingId"/>)"/></td>
	</tr>
</table>
</s:form>
</s:iterator>
<hr width="1000px"/>
<table align="center" class="outbox">
	<tr>
	<s:iterator value="pages"><td><input type="button" value="<s:property />" onclick="show_comment_history(<s:property />)"></td></s:iterator>
	</tr>
</table>
</body>
</html>