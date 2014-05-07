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
<title>EXAM</title>
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
		<tr>
			<td width="15%"><input type="button" value="Hack It" onclick="show_exam_question(0)"></td>
			<td width="15%"><input type="button" value="Summary" onclick="show_exam_try_summary(1)"></td>
			<td width="15%"><input type="button" value="Add More" onclick="show_add_exam_page()"></td>
		</tr>
	</table>
</div>
<div id = "examadd_div" style="display:none" align="center"><s:include value="exam_add.jsp"></s:include></div>
<div id = "examtry_div" style="display:none" align="center"><s:include value="exam_try.jsp"></s:include></div>
<div id = "examtryend_div" style="display:none" align="center"><s:include value = "exam_end.jsp" /></div>
<div id = "examsummary_div" style="display:none" align="center"><s:include value = "exam_summary.jsp" /></div>
<s:if test="%{info=='true'}">
<div id = "examaddsc_div" align="center"><s:include value="exam_add_success.jsp"></s:include></div>
</s:if>
</body>
</html>