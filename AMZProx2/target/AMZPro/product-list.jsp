<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>亚马逊 - 产品列表</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/function.js"></script>
	<link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet" type="text/css"/>
	<link href="${pageContext.request.contextPath}/css/adv.css" rel="stylesheet" type="text/css"/>
	<script src="${pageContext.request.contextPath}/scripts/jquery-2.1.0.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/scripts/adv.js" type="text/javascript"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/function.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/index.js"></script>





</head>
<body>
	<%@ include file="index_top.jsp"%>
	<div id="position" class="wrap">




     		您现在的位置：<a href="index.jsp">亚马逊</a> &gt;
		<a href="${pageContext.request.contextPath}/hl.do?param=Firstid&id=${requestScope.Firstid.id}">
		${requestScope.Firstid.name}</a> &gt; <a href="${pageContext.request.contextPath}/hl.do?param=secondId&id=${requestScope.secondId.id}">${requestScope.secondId.name}





	</div>
	<div id="main" class="wrap">
		<div class="lefter">
			<%@ include file="index_product_sort.jsp"%>
			<div class="spacer"></div>
			<div class="last-view">
				<h2>最近浏览</h2>
				<dl class="clearfix">
					<dt>
						<img style="width: 54px; height: 54px;" src="images/product/0.jpg" />
					</dt>
					<dd>
						<a href="#">商品名称</a>
					</dd>
					<c:forEach items="" var="p">
							<dt><img style="width: 54px; height: 54px;" src="" /></dt>
							<dd><a href=""></a></dd>
						</c:forEach></dl></div></div><div class="main">
			<div class="product-list">
				<h2>全部商品</h2>
				<div class="clear"></div>
				<ul class="product clearfix">

					<c:forEach items="${requestScope.mid}" var="mid">
					<li><dl><dt><a href="#" target="_self"><img src="${mid.img_source}" /></a>
							</dt>
							<dd class="title">
								<a href="#" target="_self">"+${mid.name}+"</a>
							</dd>
							<dd class="price">${mid.price}</dd>
						</dl>
					</li>
					</c:forEach>
					<c:forEach items="${requestScope.sid}" var="sid">
					<li>
						<dl>
							<dt>
								<a href="hl.do?param=dingdan&id=${sid.id}" target="_self"><img src="${sid.img_source}" /></a>
							</dt>
							<dd class="title">
								<a href="#" target="_self">${sid.description}</a>
							</dd>
							<dd class="price">${sid.price}</dd>
						</dl>
					</li>
					</c:forEach>

				</ul>
				<div class="clear"></div>
				<div class="pager">
					<ul class="clearfix">
						<li><a href="#">上一页</a></li>
						<li>2</li>


						<li><a href="#">3</a></li>


						<li><a href="#">下一页</a></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="clear"></div>
	</div>
	<div id="footer">Copyright &copy; 2018 上海海文 All Rights Reserved.
		京ICP证1000001号</div>
</body>
</html>

