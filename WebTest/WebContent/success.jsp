<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>成功页面</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
	</head>
			<script language="javascript">
	var tt = "error.jsp";
	function jump() {
		setTimeout("goback()", "1000");
	}
	function goback() {
		window.location = top.targeturl;
	}
</script>
	<body>
	<b>操作成功</b>
	<hr color="red"/>
	&nbsp;&nbsp;恭喜您,操作成功!<br/>
	&nbsp;&nbsp;点击<a href="showuser.action">这里</a>返回信息列表.
	</body>
</html>
