
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%double num = Math.random();%>
<div id="header">
	<div class="login_menu">
		<div class="login_container">




			<c:set value="${sessionScope.login }" var="login"></c:set>
			<c:choose>

				<c:when test="${login.id!=null}">
					<ul class="m_left">
				<li><a href="login.jsp" class="c_red">欢迎${login.uname}</a>&nbsp;&nbsp;&nbsp;</li>
					<li><a href="login.jsp">注销</a>&nbsp;&nbsp;&nbsp;</li>
					</ul>
					</c:when>
				<c:otherwise>
					<ul class="m_left">
					<li><a href="login.jsp" class="c_red">请登录</a>&nbsp;&nbsp;&nbsp;</li>
				    <li><a href="register.jsp">请注册</a>&nbsp;&nbsp;&nbsp;</li>
				    <li><a href="login.jsp">注销</a>&nbsp;&nbsp;&nbsp;</li>
					</ul>
				</c:otherwise>
			</c:choose>





			<ul class="m_right">
				<li><img src="images/icon_3.png">
					<a href="shopping.jsp" class="c_red">购物车</a></li>
				<li><img src="images/icon_2.png"><a href="guestbook.jsp">留言</a></li>
				<li><img src="images/icon_1.png"><a href="index.jsp">首页</a></li>
			</ul>
		</div>
	</div>
	<div class="logo_search">
		<div class="logo">
			<img src="images/LOGO.png">
		</div>
<script>

function mohu() {
	window.location="${pageContext.request.contextPath}/Product.do?param=mohu&word="+$("#qname").val();
}

</script>



		<div class="search">
			<input type="text" placeholder="输入宝贝" id="qname" />
			<button class="query_button" onclick="mohu()">搜索</button>
		</div>
	</div>
	<div class="nav_bar">
		<div class="nav_bar_container">
			<ul>
				<li><a href="#">商品名称</a></li>
				<li><a href="#">商品名称</a></li>
				<li><a href="#">商品名称</a></li>
				<li><a href="#">商品名称</a></li>
			</ul>
		</div>
	</div>
</div>
