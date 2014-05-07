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
<title>Review</title>
</head>
<body>
<table class="mytitle" align="center">
	<tr><td align="left"><h1>LIFE IN SILICON VALLEY</h1></td>
	<td><a href="index.jsp" style="text-decoration: none">HOME</a></td>
	<td>LIFE</td>
	<td><a href = "review.action" style="text-decoration:none;">REVIEW</a></td>
	<td><a href = "code.action" style="text-decoration:none;">CODE</a></td>
	<td><a href = "exam.action" style="text-decoration:none;">EXAM</a></td>
	<td><a href = "study.jsp" style="text-decoration:none;">STUDY</a></td>
	<td>ABOUT US</td>
	</tr>
</table>
<div align="center">
	<table align="center" class="outbox">
		<tr><td>
			<s:form action="knowledge">
			<s:select label="Category *" name="category" headerKey="all" headerValue="all" list="categoryList" />
			</s:form>
			</td>
		</tr>
	<tr>
		<td width="15%"><input type="button" value="Knowledge" onclick="show_knowledge('1')"></td>
		<td width="15%"><input type="button" value="SmallQuiz" onclick="show_quiz()"></td>
		<td width="15%"><input type="button" value="History" onclick="show_quiz_history('1')"></td>
		<td width="15%"><input type="button" value="Add More" onclick="show_add_knowledge_page()"></td>
	</tr>
</table>
</div>
<div id = "knowledge_div" style="display:none" align="center"><s:include value="knowledge.jsp"></s:include></div>
<div id = "quiz_div" style="display:none" align="center"><s:include value="quiz.jsp"></s:include></div>
<div id = "summary_div" style="display:none" align="center"><s:include value="quiz_summary.jsp"></s:include></div>
<div id = "history_div" style="display:none" align="center"><s:include value="quiz_history.jsp"></s:include></div>
<div id = "knowledgeadd_div" style="display:none" align="center"><s:include value="knowledge_add.jsp"></s:include></div>
<s:if test="%{info=='true'}">
<div id = "knowledgeaddsc_div" align="center"><s:include value="knowledge_add_success.jsp"></s:include></div>
</s:if>

</body>
</html>