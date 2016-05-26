<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<script type="text/javascript" src="resources/js/jquery-1.8.3.min.js"></script>
</head>
<script type="text/javascript">
	$(function($) {
		var name = $('#name').val();
		var age = $('#age').val();
		/* $.post("/pentakill/hello/hehe.do", {
			name : "111",
			age : "222"
		}, function(result) {
			alert("success");
		}, "json"); */
		var mydata = '{"name":"111","age":"222","createtime":"2015-05-05"}';
		/* $("#addNewsForm", navTab.getCurrentPanel()).serializeArray(); */
		alert(mydata);
		$.ajax({
			url : "http://localhost:8686/pentakill/hello/hehe.do",
			data : mydata,
			type : "post",
			dataType : 'json',
			contentType : 'application/json',
			success : function(result) {
				alert(result);
			}
		});
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
