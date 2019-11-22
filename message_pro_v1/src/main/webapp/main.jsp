<%@page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%--导入jstl核心标签库--%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %><%--导入函数标签库,里面包含很多字符串处理函数--%>
<!DOCTYPE html>
<html>
<head>
    <title>海文在线短信平台</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/sms.css"/>
    <%--<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/alertify.css"/>--%>

    <script type="text/javascript" src="${pageContext.request.contextPath}/scripts/jquery.js"></script>
   <%-- <script type="text/javascript" src="${pageContext.request.contextPath}/scripts/alertify.js"></script>--%>
    <script>
        function delMsg(id) {
            /*reset();
            alertify.confirm("确认框", function (e) {
                if (e) {
                    alertify.success("点击确认");
                } else {
                    alertify.error("点击取消");
                }
            });*/

            if(window.confirm("是否确定删除?")){
                //发送给Servlet
                window.location.href="${pageContext.request.contextPath}/msg.do?param=delMsg&id="+id;
            }
            return false;//阻止超链接的默认行为
        }

       /* //初始化操作
        var reset = function () {
            alertify.set({
                labels : {
                    ok   : "确认",
                    cancel : "取消"
                },
                delay : 5000,
                buttonReverse : false,
                buttonFocus  : "ok"
            });
        };*/
    </script>
</head>
<body>
<div id="main">
    <div class="mainbox">
        <div class="title myMessage png"></div>
        <%@include file="menu.jsp" %>
        <%--包含指定的片段--%>
        <!--错误信息  -->
        <div id="error"></div>
        <!--短消息列表  -->
        <div class="content messageList">
            <ul>
                <c:forEach items="${requestScope.msgs}" var="msg">
                    <c:choose>
                        <c:when test="${msg.state==1}">
                            <li class="unReaded">
                        </c:when>
                        <c:otherwise>
                            <li>
                        </c:otherwise>
                    </c:choose>
                    <em>${msg.msg_create_date}</em>
                    <em><a href="#">回信</a></em>
                    <em><a href="#" onclick="delMsg(${msg.id})">删除</a></em>
                    <p>
                        <strong>${msg.title}</strong>
                        <a href="${pageContext.request.contextPath}/msg.do?param=queryMsgById&id=${msg.id}">
                                <%--判断内容的长度是否大于8--%>
                            <c:choose>
                                <c:when test="${fn:length(msg.msgContent)>15}">
                                    ${fn:substring(msg.msgContent,0 , 15)}...
                                </c:when>
                                <c:otherwise>
                                    ${msg.msgContent}
                                </c:otherwise>
                            </c:choose>
                        </a>
                    </p>

                    </li>
                </c:forEach>
            </ul>
        </div>
        <!--分页栏 -->
        <div align="center" style="margin-top:10px">
            <a href="#">首页</a>&nbsp;&nbsp;&nbsp;
            <a href="#">上一页</a>&nbsp;&nbsp;
            <a href="#">下一页</a>&nbsp;&nbsp;
            3/10&nbsp;&nbsp;
            <a href="#">最后一页</a>
        </div>
    </div>
</div>
</body>
</html>
