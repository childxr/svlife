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
<title>EXAM SUMMARY</title>
</head>
<body>
<s:iterator value="examtryList">
<hr width="1000px"/>
<table align="center" class="outbox">
	<tr>
		<td width="10%"><h5 class="category"><s:property value = "examtryId"/></h5></td>
		<td width="70%"><h5 class="category"><s:property value = "exam.category"/></h5></td>
		<td width="20%"><h5 class="time"><s:date name="dateCreated" format="MM/dd/yyyy hh:mm:ss "/></h5></td>
	</tr>
</table>
<table align="center" class="outbox">
	<tr><td><h5 class="cques"><s:property value = "exam.question" escape="false"/></h5></td></tr>
	<tr><td><h5 class="cques"><s:property value = "exam.options" escape="false"/></h5></td></tr>
</table>
<table align="center" class="outbox">
	<tr id="abanner"><td width="50%" ><h5 class="cques">Your Answer</h5></td><td width="50%"><h5 class="cques">Reference Answer</h5></td></tr>
	<tr><td><h6 class="cques"><s:property value = "yanswer"/></h6></td><td><h5 class="cques"><s:property value = "exam.answer"/></h5></td></tr>
</table>
<table align="center" class="outbox">
	<tr id="abanner"><td><h5 class="cques">Note</h5></td></tr>
	<tr id="nbanner"><td><h5 class="cques"><s:property value = "comment" /></h5></td></tr>
</table>
</s:iterator>
<table align="center" class="outbox">
	<tr>
	<s:iterator value="pages"><td><input type="button" value="<s:property />" onclick="show_exam_try_summary(<s:property />)"></td></s:iterator>
	</tr>
</table>

</body>
</html>