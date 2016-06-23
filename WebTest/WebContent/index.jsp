<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>登录页面</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
	</head>
	<s:head />
	<script type="text/javascript">
	function dosubmit() {
		var username = document.getElementsByName("userBean.username")[0].value;
		var password = document.getElementsByName("userBean.password")[0].value;
		var pattern = /^[a-zA-Z0-9_]{6,12}$/;
		if (!(pattern.test(username) && pattern.test(password))) {
			alert("请输入正确类型的用户名密码!");
			document.getElementsByName("userBean.username")[0].focus();
		} else {
			return true;
		}
	}
</script>
	<body>
		<b>用户登陆</b>
		<hr color="red" />
		<s:actionerror/>
		<s:form name="form1" action="check" method="post">
			<s:textfield name="userBean.username" label="用户名" cssStyle="width:120px"/>
			<s:password name="userBean.password" label="密   码" cssStyle="width:120px"/>
			<tr>
				<td colspan="2" align="center">
					<s:submit value="提 交" theme="simple" onclick="dosubmit()"/>
					<input type="button" value="注 册" onclick="window.location.href='add_user.jsp'"/>
				</td>
			</tr>
		</s:form>
	</body>
</html>
