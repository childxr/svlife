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
<title>CODE</title>
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
			<s:form action="allcode">
			<s:select label="Category *" name="category" headerKey="all" headerValue="all" list="category" />
			</s:form>
			</td>
		</tr>
	<tr>
		<td width="15%"><input type="button" value="Questions" onclick="show_all_coding_questions()"></td>
		<td width="15%"><input type="button" value="History" onclick="show_comment_history(1)"></td>
		<td width="15%"><input type="button" value="Add More" onclick="show_add_code_page()"></td>
	</tr>
</table>
</div>
<div id = "codelist_div" style="display:none" align="center"><s:include value="code_list.jsp"></s:include></div>
<div id = "codedetails_div" style="display:none" align="center"><s:include value="code_details.jsp"></s:include></div>
<div id = "codecomment_div" style="display:none" align="center"><s:include value="code_comment.jsp"></s:include></div>
<div id = "codecommenthis_div" style="display:none" align="center"><s:include value="code_comment_history.jsp"></s:include></div>
<div id = "codedetailadd_div" style="display:none" align="center"><s:include value="code_detail_add.jsp"></s:include></div>
<s:if test="%{info=='true'}">
<div id = "codeaddsuccess_div" align="center"><s:include value="code_detail_add_success.jsp"></s:include></div>
</s:if>
</body>
</html>