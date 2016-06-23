<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>信息查看</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
	</head>
	<body>
		<b>用户信息</b>
		<hr color="red" />
		<table border="1">
			<tr>
				<th>
					序号
				</th>
				<th>
					用户名
				</th>
				<th>
					昵称
				</th>
				<th>
					性别
				</th>
				<th>
					注册日期
				</th>
				<th>
					操作
				</th>
			</tr>
			<c:forEach items="${list}" var="dd">
				<tr align="center">
					<th>
						${dd.id }
					</th>
					<td>
						${dd.username }
					</td>
					<td>
						${dd.name }
					</td>
					<td>
						<c:if test="${dd.sex==true}">
						男
						</c:if>
						<c:if test="${dd.sex==false}">
						女
						</c:if>

					</td>
					<td>
						${dd.regdate }
					</td>
					<td>
						<a href="loadbyid.action?id=${dd.id }">修改</a>&nbsp;
						<a href="deleteuser.action?id=${dd.id }">删除</a>
					</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="6" align="right">
				第${pageBean.pageNum }页/共${pageBean.maxPage }页
					<a href="showuser.action?page=1">首页</a>
					<c:if test="${pageBean.pageNum>1}">
						<a href="showuser.action?page=${pageBean.lastPage }"> 上一页</a>
					</c:if>
					<c:if test="${pageBean.pageNum<pageBean.maxPage}">
						<a href="showuser.action?page=${pageBean.nextPage}"> 下一页</a>
					</c:if>
					<a href="showuser.action?page=${pageBean.maxPage}"> 尾页</a>&nbsp;&nbsp;
				</td>
			</tr>
			<tr>
			<td colspan="6">
			<input type="button" value="添加新用户" onclick="window.location.href='add_user.jsp'">
			</td>
			</tr>
		</table>
	</body>
</html>
