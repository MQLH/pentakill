<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<%@ include file="/common/include.jsp"%>
</head>
<script type="text/javascript">
	$(function($) {
		var name = $('#name').val();
		var age = $('#age').val();
		alert("${pageContext.request.contextPath}");
		$.post("/pentakill/hello/hehe.do", {
			"name" : name,
			"age" : age
		}, function(result) {
			alert("success");
		},
		"json");
	});
</script>
<body>
	This is my JSP page.
	<br>
	<form id="testhehe">
		<table>
			<input id="name" value="name" />
			<input id="age" value="123" />
		</table>
	</form>
</body>
</html>
