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
<title>CODE LIST</title>
</head>
<body>
<hr width="1000px"/>
<table align="center" width="1000px">
	<s:iterator value="codeList">
	<s:form actoin="codedetails">
	<tr>
	<td width="40px" align="left"><input type="button" value="<s:property value="codingId" />" onclick="show_code_details(<s:property value = "codingId"/>)"></td>
	<td align="left"><s:property value = "question"/></td>
	<td width="25%" align="right"><s:date name="dateCreated" format="MM/dd/yyyy hh:mm:ss a"/></td>
	<!--  
		<td width="5%"align="left"><input type="button" value="<s:property value="codingId" />" onclick="show_code_details(<s:property value = "codingId"/>)"></td>
		<td align="left"><s:property value = "question"/></td>
		<td width="5%" align="left"><s:property value = "dateCreated"/></td>-->
	</tr>
	</s:form>
	</s:iterator>
</table>
<br>
<br>
<hr width="1000px"/>
</body>
</html>