<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>亚马逊 - 留言</title>
    <link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/css/adv.css" rel="stylesheet" type="text/css"/>
    <script src="${pageContext.request.contextPath}/scripts/jquery-2.1.0.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/scripts/adv.js" type="text/javascript"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/scripts/function.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/scripts/index.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/scripts/comment.js"></script>
    <script>

        $(function () {
            go(1,3);
             history();
        });
        function go(pageNo,pageSize) {
            var html = "";
            var html2 = "";
            $.post("${pageContext.request.contextPath}/liuyan",
                    {param: "mebo",
                    pageNo:pageNo,
                    pageSize:pageSize},
                function (data) {
                $.each(data.list,function (i,value) {
                   /* data=JSON.stringify(data)*/
                    html += "<li><dl><dt>标题:" + value.reply + "</dt>" +
                        "<dd class='author'><span>作者:" + value.nick_name + "</span></dd>" +
                        " <dd>评论时间:" + value.reply_time + "</dd>" +
                        "<dd>内容：" + value.content + "</dd>" +
                        "<dd>回复时间：" + value.create_time + "</dd></dl></li>";
                });
                html2+="<li><a href='javaScript:go("+ data.prePage +","+data.pageSize+")'>上一页</a></li>" +
                        "<li>"+ data.pageNo +"</li><li>/</li><li>"+data.totalPages+"</li>" +
                        "<li><a href='javaScript:go("+ data.nextPage +","+data.pageSize+")'>下一页</a></li>";
                $(".clearfix").html(html2);
                $("#comment").html(html);
                })
        }


    </script>


</head>
<body>
<%@ include file="index_top.jsp" %>
<div id="position" class="wrap">
    您现在的位置：<a href="${pageContext.request.contextPath}/index.jsp">亚马逊</a> &gt; 在线留言
</div>
<div id="main" class="wrap">
    <div class="lefter">
        <%@ include file="index_product_sort.jsp" %>
    </div>
    <div class="main">
        <div class="guestbook">
            <h2>全部留言</h2>
            <ul id="comment">
                <%--<li>
                    <dl><dt>内容：</dt>
                        <dd class="author"><span>作者：</span></dd>
                        <dd>评论时间：</dd>
                        <dd>回复：</dd>
                        <dd>回复时间:</dd></dl>
                </li>--%>
            </ul>


            <div class="clear"></div>
            <div class="pager">
                <ul class="clearfix">
                </ul>
            </div>

            <div id="reply-box">
                <form action="${pageContext.request.contextPath}/liuyan?param=comment" method="post"
                      onsubmit="return commentCheck()">
                    <table>
                        <tr>
                            <td class="field">昵称：</td>
                            <td><input class="text" type="text" name="guestName"/></td>
                        </tr>
                        <tr>
                            <td class="field">留言标题：</td>
                            <td><input class="text" type="text" name="guestTitle"/></td>
                        </tr>
                        <tr>
                            <td class="field">留言内容：</td>
                            <td><textarea name="guestContent"></textarea></td>
                        </tr>
                        <tr>
                            <td>&nbsp;</td>
                            <td><label class="ui-blue"><input type="submit" name="submit" value="提交留言"/></label></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
    </div>
    <div class="clear"></div>
</div>
<div id="footer">
    Copyright &copy; 2018 上海海文 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
