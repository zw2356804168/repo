<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/adv.css" rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/scripts/jquery-2.1.0.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/scripts/adv.js" type="text/javascript"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/function.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/index.js"></script>
<script>
$(function () {
	var html="";
	$.ajax({
		"url":"${pageContext.request.contextPath}/cate.do",
		"type":"POST",
		"data":{"param":"cate"},
		"datatype":"json",
		"success":callback,
		"error":function () {
			alert("用户信息出错");
		}
	})
	function callback(data) {
		/*for (var i=0;i<data.length;i++){
			html += "<dt><a href=''>"+data[i].name+"</a></dt>";
			for (var j=0;j<data[i].list.length;j++){
				html+="<dd><a href=''>"+data[i].list[j].name+"</a></dd>";
			}
		}*/
		$.each(data,function (i,value) {
			html += "<dt><a href='${pageContext.request.contextPath}/hl.do?param=Firstid&id="+value.id+"'>"+value.name+"</a></dt>";

                $.each(value.list,function (i,value1) {
					html+="<dd><a href='${pageContext.request.contextPath}/hl.do?param=secondId&id="+value1.id+"'>"+value1.name+"</a></dd>";
				})
		})
     $("#categroy").html(html);
	}

})







</script>
<div class="p_category">
	<h2>商品分类</h2>
		<dl id="categroy">

		</dl>
</div>

