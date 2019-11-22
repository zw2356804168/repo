﻿<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<title>海文 在线短信平台</title>
<link type="text/css" rel="stylesheet" href="css/sms.css" />
</head>
<body>
	<form action="#" method="post">
		<div id="main">
			<div class="mainbox">
				<%@include file="menu.jsp"%><%--包含指定的片段--%>
				<div class="content">
					<div class="message">

						<div class="tmenu">
							<ul class="clearfix">
								<li>发送给： <select name="toUser">
										<option selected="selected">test1</option>

										<option>test2</option>

								</select>
								</li>
								<li>标题：<input type="text" name="title" id="title" /></li>
							</ul>
						</div>
						<div class="view">
							<textarea name="content" id="content"></textarea>
							<div class="send">
								<input type="submit" name="submit" value=" " />
							</div>
						</div>

					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>
