<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>亚马逊- 购物车</title>
<link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/adv.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/scripts/jquery-2.1.0.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/scripts/adv.js" type="text/javascript"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/function.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/index.js"></script>
<script type="text/javascript" src="scripts/shopping.js"></script>
</head>
<body>
<%@ include file="index_top.jsp"  %>

<div id="position" class="wrap">
	您现在的位置：<a href="index.jsp">亚马逊</a> &gt; 购物车
</div>
<div class="wrap">
	<div id="shopping">
		<form action="${pageContext.request.contextPath}/cart?param=settlement" method="post">
			<c:forEach items="${sessionScope.cart.list}" var="cartItem">
				<table>
					<tr>
						<th>商品名称</th>
						<th>商品价格</th>
						<th>购买数量</th>
						<th>操作</th>
					</tr>


					<!-- 根据用户购物车生成列表 -->
					<tr id="product_id_1">
						<td class="thumb"><img style="width: 100px; height: 100px;" src="${cartItem.product.img_source}" /><a href="">${cartItem.product.name}</a></td>
						<td class="price" id="price_id_1">
							￥${cartItem.product.price}<span id="span_1"></span>
							<input type="hidden" id="subPrice" value="" name="sumPrice"/>
							<input type="hidden"  value="" name="pId"/>
							<input type="hidden"  value="" name="hpStock" id=""/>
						</td>
						<td class="number">
							<input type="text" name="number" value="${cartItem.quanity}" maxlength="5"
								   size="1"  style="text-align:center; vertical-align:middle" disabled="disabled"/>
						</td>
						<td class="delete"><a href="${pageContext.request.contextPath}/cart?param=delete&id=${cartItem.product.id}">删除</a></td>
					</tr>
				</table>
			</c:forEach>

			<div class="button"><input type="submit" value="" /></div>
		</form>
	</div>
</div>
<div id="footer">
	Copyright &copy; 2018 上海海文 All Rights Reserved.
</div>
</body>
</html>

