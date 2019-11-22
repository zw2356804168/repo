<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>亚马逊 - 登录</title>
<link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/adv.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/scripts/jquery-2.1.0.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/scripts/adv.js" type="text/javascript"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/function.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/index.js"></script>
<script>
	var $userName,$passWord,$text,$button
$(function () {
	$userName=$("#userName");
	$passWord=$("#passWord");
	$text=$("#text");
	$button=$("#button");




	$button.click(function () {
		if(loginCheck()){
			$.post("${pageContext.request.contextPath}/lr.do",{"param":"logn",
				"userName":$userName.val(),
			     "passWord":$passWord.val()},function (data) {
				if(data.success !=true){
					$("#lb").html(data.info);
				}else{
					window.location="index.jsp";
				}
			})
		}
	})

})





</script>



</head>
<body>
<%@ include file="index_top.jsp"  %>
<div id="register" class="wrap">
	<div class="shadow">
		<em class="corner lb"></em>
		<em class="corner rt"></em>
		<div class="box">
			<h1>欢迎回到亚马逊</h1>
			<form id="loginForm" method="post" action="${pageContext.request.contextPath}/lr.do">
				<table>
					<tr>
						<td class="field">用户名：</td>
						<td><input class="text" type="text" name="userName"  id="userName"  /><span></span></td>
					</tr>
					<tr>
						<td class="field">登录密码：</td>
						<td><input class="text" type="password" id="passWord" name="passWord"  />

					</tr>

					<tr>
						<td class="field">验证码：</td>
						<td><input class="text verycode" type="text" id="text" name="veryCode"   maxlength="4"/><img id="veryCode" src="code.jsp" /><span id="Code"></span></td>
					</tr>


					<tr>
						<td></td>
						<td><label class="ui-green"><input type="button" id="button" name="submit" value="立即登录" /></label></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2018  上海海文 All Rights Reserved
</div>
</body>
</html>
