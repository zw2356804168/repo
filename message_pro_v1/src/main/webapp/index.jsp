<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
<title>短消息平台</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/sms.css" />

</head>
<body>
	<div id="loginTitle" class="png"></div>
	<div id="loginForm" class="userForm png">
		<form action="${pageContext.request.contextPath}/lr.do?param=login" method="post">
			<dl>
				<div id="error">${requestScope.info}</div>
				<dt>用户名：</dt>
				<dd>
					<input type="text" name="name" />
				</dd>
				<dt>密 码：</dt>
				<dd>
					<input type="password" name="pwd" />
				</dd>
				
			</dl>
			<div class="buttons">
				<input class="btn-login png" type="submit" name="submit" value=" " />
				<a href="register.jsp"><input class="btn-reg png" type="button" name="register" value=" " /></a>
			</div>
		</form>
	</div>
	
	
</body>
</html>








