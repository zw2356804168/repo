<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/adv.css" rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/scripts/jquery-2.1.0.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/scripts/adv.js" type="text/javascript"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/function.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/index.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/comment.js"></script>


<style type="text/css">
.news-list ul li {
	
}
</style>
<script>
	var $news;
$(function () {
	$news=$("#news");
	var html="";
	$.ajax({
		"url":"${pageContext.request.contextPath}/news.do",
		"type":"GET",
		"data":{"param":"Allnews"},
		"datatype":"json",
		"success":callback,
		"error":function () {
			alert("用户信息出错");
		}
	})
	function callback(data)  {
		for(var i=0;i<data.length;i++){
			html += "<li><a href='${pageContext.request.contextPath}/news.do?param=new&id="+data[i].id+"'>"+data[i].title+"</a></li>";
			$("#news").html(html);
		}
		/*$.each(data,function (i) {
			alert(i);
			html += "<li><a href='${pageContext.request.contextPath}/news.do?param=new&id="+data[i].id+"'>"+data[i].title+"</a></li>";
          $("#news").html(html);
		})*/
	}
})



</script>

<div class="newsList">
	<h2>新闻动态</h2>
	<ul id="news">
		<li><a href=""></a></li>
	</ul>
</div>
