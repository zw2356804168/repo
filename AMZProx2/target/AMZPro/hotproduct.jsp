<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/adv.css" rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/scripts/jquery-2.1.0.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/scripts/adv.js" type="text/javascript"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/function.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/index.js"></script>
<script>
	var html="";
	$(function () {

		$.ajax({
			url:"${pageContext.request.contextPath}/Product.do",
			type:"GET",
			data:{"param":"HotSale"},
			datatype:"json",
			success:callback1,
			error:function () {
				alert("-----页面出错------");
			}
		})

	})
	function callback1(data) {
		for (var i=0;i<5;i++){
			html +="<li><dl><dt><a href='hl.do?param=dingdan&id="+data[i].id+"' target='_self'> <img src='"+data[i].img_source+"'/>"+data[i].description+"</a>" +
					"</dt><dd class='p_name'><a href='' target=_self></a></dd>" +
					"<dd class='price'></dd></dl></li>";

		}

		$("#HotSale").html(html);
	}






</script>





<div class="hot_sale">
	<h2>热卖推荐</h2>
	<ul id="HotSale">
		<%--<li><dl><dt><a href="" target="_self"> <img src="" /></a>
				</dt><dd class="p_name"><a href="" target="_self"></a></dd>
				<dd class="price">￥</dd></dl></li>--%>
	</ul>
</div>
