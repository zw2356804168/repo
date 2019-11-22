<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>亚马逊 - 注册页</title>
<link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/adv.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/scripts/jquery-2.1.0.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/scripts/adv.js" type="text/javascript"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/function.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/index.js"></script>
<script>
    var $userName,$passWord,$sex,$birthday,$identity,$email,$mobile,$address,current

    $(function () {
        $userName=$("#userName");
        $passWord=$("#passWord");
        $sex=$("#sex");
        $birthday=$("#birthday");
        $identity=$("#identity");
        $email=("#email");
        $mobile=("#mobile");
        $address=$("#address");
        $current=$("#current");

    })
    function validata() {
        if ( $userName.val()==""){
            current="用户名不能为空";
            return false;
        }
        if ( $passWord.val()==""){
            current="密码不能为空";
            return false;
        }
        if ( $sex.val()==""){
            current="性别不能为空";
            return false;
        }
        if ( $birthday.val()==""){
            current="生日不能为空";
            return false;
        }
        if ( $email.val()==""){
            current="邮箱不能为空";
            return false;
        }
        if ( $mobile.val()==""){
            current="手机不能为空";
            return false;
        }
        if ( $address.val()==""){
            current="地址不能为空";
            return false;
        }

    }












</script>


</head>
<body>
<%@ include file="index_top.jsp"  %>

<div id="register" class="wrap">
	<div class="shadow">
		<em class="corner lb"></em>
		<em class="corner rt"></em>
		<div class="box">
			<h1>欢迎注册亚马逊</h1>
			<ul class="steps clearfix">
				<li id="current"><em></em>填写注册信息</li>
				<li class="last"><em></em>注册成功</li>
			</ul>
			<form id="regForm" method="post" action="${pageContext.request.contextPath}/rl.do?param=register" onsubmit="return validata() "   >
				<table>
					<tr>
						<td class="field">用户名：</td>
						<td><input id="userName" class="text" type="text" name="userName" id="userName" onfocus="FocusItem(this)"   maxlength="15"/><span id="uName"></span></td>
					</tr>
					<tr>
						<td class="field">登录密码：</td>
						<td><input class="text" type="password" id="passWord" name="passWord" onfocus="FocusItem(this)" /><span></span></td>
					</tr>
					<tr>
						<td class="field">确认密码：</td>
						<td><input class="text" type="password" name="rePassWord"  id="rePassWord" onfocus="FocusItem(this)"  /><span></span></td>
					</tr>
					<tr>
						<td class="field">性别：</td>
						<td ><input type="radio" name="sex"  id="sex" style="border:0px;" checked="checked" value="0" />男<input type="radio" name="sex" style="border:0px;" value="1"/>女<span></span></td>
					</tr>
					<tr>
						<td class="field">出生日期：</td>
						<td><input class="text" type="text" name="birthday" id="birthday" /><span></span></td>
					</tr>
					<tr>
						<td class="field">身份证：</td>
						<td><input class="text" type="text" name="identity" id="identity"/><span></span></td>
					</tr>
					<tr>
						<td class="field">电子邮件：</td>
						<td><input class="text" type="text" name="email"    id="email"/><span id="uemail"></span></td>
					</tr>
					<tr>
						<td class="field">手机：</td>
						<td><input class="text" type="text" name="mobile" id="mobile"/><span></span></td>
					</tr>
					<tr>
						<td class="field">地址：</td>
						<td><input class="text" type="text" name="address"  id="address"
								   /><span></span></td>
					</tr>

					<tr>
						<td></td>
						<td><label class="ui-green"><input type="submit" name="submit" value="提交注册" /></label></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2018 上海海文 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>

