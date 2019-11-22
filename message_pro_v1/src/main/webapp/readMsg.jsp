<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<title>读短消息</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/sms.css" />

</head>
<body>
	<div id="main">
		<div class="mainbox">
			<div class="title readMessage png"></div>
			<%@include file="menu.jsp"%><%--包含指定的片段--%>
			<div class="content">
				<div class="message">
					<div class="tmenu">
						<ul class="clearfix">
							<li>题目:${requestScope.msg.title}</li>
							<li>来自:${requestScope.msg.sendUser.name}</li>
							<li>时间:${requestScope.msg.msg_create_date}</li>
						</ul>
					</div>
					<div class="view">
						<p>${requestScope.msg.msgContent}</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
