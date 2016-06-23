<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>修改页面</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
	</head>
	<b>用户修改</b>
	<hr color="red" />
	<body>
		<form name="form1" action="updateuser.action" method="post">
			<table>
				<c:forEach items="${list}" var="dd">
					<tr>
						<td align="right">
							ID:
						</td>
						<td>
							<input type="hidden" name="userBean.id" value="${dd.id }" />
							${dd.id }
						</td>
					</tr>
					<tr>
						<td align="right">
							用户名:
						</td>
						<td>
							<input type="hidden" name="userBean.username"
								value="${dd.username}" />
							${dd.username }
						</td>
					</tr>
					<tr>
						<td align="right">
							密码:
						</td>
						<td>
							<input type="password" name="userBean.password"
								value="${dd.password }" style="width: 130px; height: 20px" />
							<font color="red">*</font>
						</td>
					</tr>
					<tr>
						<td align="right">
							确认密码:
						</td>
						<td>
							<input type="password" name="repassword" value="${dd.password }"
								style="width: 130px; height: 20px" />
							<font color="red">*</font>
						</td>
					</tr>
					<tr>
						<td align="right">
							昵称:
						</td>
						<td>
							<input type="text" name="userBean.name" value="${dd.name}"
								style="width: 130px; height: 20px" />
							<font color="red">*</font>
						</td>
					</tr>
					<tr>
						<td align="right">
							性别:
						</td>
						<td>
							<c:if test="${dd.sex==true}">
								<input type="radio" name="userBean.sex" value="true"
									checked="checked" />男
						<input type="radio" name="userBean.sex" value="false" />女
					</c:if>
							<c:if test="${dd.sex==false}">
								<input type="radio" name="userBean.sex" value="true" />男
						<input type="radio" name="userBean.sex" value="false"
									checked="checked" />女
					</c:if>
						</td>
					</tr>
					<tr>
						<td align="right">
							注册日期:
						</td>
						<td>
							<input type="hidden" value="${dd.regdate }" />
							${dd.regdate }
						</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="修改" />
						<input type="button" value="返回" onclick="history.go(-1)" />
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
