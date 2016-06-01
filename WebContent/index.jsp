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
<%@ include file="/common/include.jsp"%>
</head>
<script type="text/javascript">
	function sub() {
		var serialize = getFromJsonString();
		alert(serialize);
		$.ajax({
			type : "post",
			url : "/pentakill/hello/hehe.do",
			contentType : "application/json",
			data : serialize,
			success : function(msg) {
				alert("Data Saved: " + msg);
			}
		});
	}
</script>
<body>
	This is my JSP page.
	<br>
	<form id="testhehe">
		<table>
			<input id="name" name="name" value="name" />
			<input id="age" name="age" value="123" />
			<input id="createtime" name="createtime" value="2016-06-26" />
		</table>
		<input type="submit" onclick="sub()">
	</form>
</body>
</html>
