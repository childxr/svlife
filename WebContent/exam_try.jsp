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
<title>TRY EXAM</title>
</head>
<body>
<hr width="1000px"/>
<table align="center" class="outbox">
	<s:iterator value="questionContent">
	<tr>
		<td><h5 class="cques"><s:property /></h5></td>
	</tr>
	</s:iterator>
</table>
<br>


<table align="center" class="outbox">
	<s:iterator value="optionsContent">
		<tr><td><h5 class="cques"><s:property /></h5></td></tr>
	</s:iterator>
</table>
<s:form action="addexamtry" method="post" enctype="multipart/form-data">
<table align="center" class="outbox">
	<tr><td><s:textarea name="yanswer" cols="75" rows="5" label="Your Answers"></s:textarea></td></tr>
</table>
<table align="center" class="outbox">
	<tr><td><input type="button" value="check" onclick="show_exam_answer()"></td></tr>
</table>
<div id="examanser_div" style="display:none">
	<table align="center" class="outbox">
		<tr><td>Answer</td><td><s:property value = "answer" /><td></tr>
	</table>
	<table align="center" class="outbox">
		<tr><td><s:textarea name="comment" cols="75" rows="5" label="Your Comment"></s:textarea></td></tr>
	</table>
	<table align="center" class="outbox">
		<tr><td><input type= "button" value="save" onclick="add_exam_try(<s:property value="examId"/>)"></td></tr>
	</table>
</div>
</s:form>
<hr width="1000px"/>

</body>
</html>