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
<title>Quiz</title>
</head>
<body>
<hr width="1000px"/>
<s:form action="addQuiz">
<s:hidden value="%{id}" name="id" />
<s:hidden value="%{question}" name="question" />
<s:hidden value="%{answer}" name="answer" />
<div id = "ques_sec_div" style="display:none">
<hr width="1000px"/>
	<table align="center" class="outbox">
		<tr id="qbanner"><td><h5 class="cques"><s:property value = "id"/>.<s:property value = "question"/></h5></td></tr>
	</table>
	<table align="center" class="outbox">
		<tr><td><s:textarea name="ans" cols="120" rows="8"></s:textarea></td></tr>
	</table>
	<table align="center" class="outbox">
		<tr><td><input type="button" value="answer" onclick="show_answer()"></td></tr>
	</table>
</div>
<div id = "answer_sec_div" style="display:none">
	<table align="center" class="outbox">
		<tr><td><h5 class="cques"><s:property value = "answer" /></h5><td></tr>
	</table>
	<table align="center" class="outbox">
		<tr><td><s:textarea name="comment" cols="120" rows="8"></s:textarea></td></tr>
	</table>
	<table align="center" class="outbox">
		<tr><td><input type= "button" value="save" onclick="add_quiz()"></td></tr>
	</table>
</div>
</s:form>


</body>
</html>