<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>注册页面</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
	</head>
	<script type="text/javascript">
  	function ff(){
  	var username = document.getElementsByName("userBean.username")[0].value;
	var password = document.getElementsByName("userBean.password")[0].value;
  	var pattern = /^[a-zA-Z0-9_]{6,12}$/;
		if (!(pattern.test(username) && pattern.test(password))) {
			alert("请输入正确类型的用户名!");
			document.getElementsByName("userBean.username")[0].focus();
		} else {
			return true;
			}
		}
	</script>
	
		<script type="text/javascript">
		var httpRequest;
		var context;
		var nameObj;
		var labelobj;
		//var elObj;
		var bool=true;
		function initPage(){
			nameObj = document.all.userBean.username;
			//elObj = document.all.UU_El;
			
			labelobj=document.getElementById('label1');
		//	labelobj1=document.getElementById('label2');
			
		}
		function createHttpRequest(){
			if(window.ActiveXObject){
		        return new ActiveXObject("Microsoft.XMLHTTP");
		    }else if(window.XMLHttpRequest){
		        return new XMLHttpRequest();
		    }
		}
		
		function sendMessage(){
		    // var obj = document.getElementById()
		   
			var url = "${pageContext.request.contextPath}/checkusername.action?uname="+nameObj.value;
			httpRequest = createHttpRequest();
			
			httpRequest.onreadystatechange = backMethod; 
			// 3. init XMLHttpRequest Comm
			httpRequest.open("POST",url,true);
			
			// 4. send request
			httpRequest.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
			httpRequest.send();
		}

		function backMethod(){
			if(httpRequest.readyState == 4 && httpRequest.status == 200){
				var text = httpRequest.responseText;
				//alert(text);
				if(text=='false'){
				labelobj.innerHTML='<font color=\'red\'>-1</font>';
				bool=false;
				}
				
				if(text=='true'){
				bool=true;
				labelobj.innerHTML='<font color=\'green\'>1</font>';
				}
				
			}
		}
		
		function sub(){
		 var pwd= document.all.userBean.password;
		 var repwd=document.all.repassword;
		//  var U_el=document.all.UU_El;
		 if(nameObj.value.length<=0 || pwd.value.length<=0 || repwd.value.length<=0 ||repwd.value!=U_Pwd.value){
		   bool= false;
		   return bool;
		 
		 }
		  
		   return bool;
		}
	</script>
	
	<b>用户注册</b>
	<hr color="red" />
	<body>
		<form name="form1" action="adduser.action" method="post">
			<table>
				<tr>
					<td align="right">
						用户名:
					</td>
					<td>
						<input type="text" name="userBean.username" onblur="sendMessage()"
							style="width: 130px; height: 20px" /><font color="red">*</font><label id="label1"></label> 
					</td>
				</tr>
				<tr>
					<td align="right">
						密 码:
					</td>
					<td>
						<input type="password" name="userBean.password"
							style="width: 130px; height: 20px" /><font color="red">*</font>
					</td>
				</tr>
				<tr>
					<td align="right">
						确认密码:
					</td>
					<td>
						<input type="password" name="repassword"
							style="width: 130px; height: 20px" /><font color="red">*</font>
					</td>
				</tr>
								<tr>
					<td align="right">
						性 别:
					</td>
					<td>
						<input type="radio" name="userBean.sex" value="true" checked="checked" />
						男
						<input type="radio" name="userBean.sex"  value="false"/>
						女
					</td>
				</tr>
				<tr>
					<td align="right">
						昵 称:
					</td>
					<td>
						<input type="text" name="userBean.name"
							style="width: 130px; height: 20px" /><font color="red">*</font>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="注 册"  onclick="ff()" />
						<input type="button" value="返 回" onclick="history.go(-1)"/>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
