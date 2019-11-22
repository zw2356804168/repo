<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>亚马逊-首页</title>
    <link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/css/adv.css" rel="stylesheet" type="text/css"/>
    <script src="${pageContext.request.contextPath}/scripts/jquery-2.1.0.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/scripts/adv.js" type="text/javascript"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/scripts/function.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/scripts/index.js"></script>
    <script>


   $(function () {
       go(1,12);
       history();

   });
        function go(pageNo,pageSize) {
            var html2 ="";
            var html="";
            $.ajax({
                "url":"${pageContext.request.contextPath}/Product.do",
                "type":"GET",
                "data":{param:"Product",
                    pageNo:pageNo,
                    pageSize:pageSize
                },
                "datatype":"json",
                "success":callback,
                "error":function () {
                    alert("用户操作出错")
                }
            })
            function callback(data) {

                $.each(data.list,function (i,value) {
                    html += "<li><dl><dt><a href='hl.do?param=dingdan&id="+value.id+"' target='_self'><img src='" + value.img_source + "'>" + value.name + "</a></dt>" + " <dd class='title'>" +
                        "<a href='' target='_self'></a></dd><dd class='price'>￥" + value.price + "</dd></dl></li>";
                    $(".product2").html(html);

                })

                var html2="<li><a href='javaScript:go("+ data.prePage +","+data.pageSize+")'>上一页</a></li>" +
                    "<li>"+ data.pageNo +"</li>" +"<li>/</li>"+ "<li>"+data.totalPages+"</li>" +
                    "<li><a href='javaScript:go("+ data.nextPage +","+data.pageSize+")'>下一页</a></li>";
                $(".clearfix").html(html2);
            }
            return false;
        }
    </script>



</head>
<body>
<%@ include file="index_top.jsp" %>
<div id="middle">
    <div class="p_left">
        <!--商品分类-->
        <%@ include file="index_product_sort.jsp" %>
        <!--商品分类结束-->

        <div class="pre_look">
            <h3>最近浏览</h3>



            <script>
                function history() {
                    $.ajax({
                        url:"${pageContext.request.contextPath}/hl.do",
                        type:"POST",
                        data:{
                            "param":"history",
                            "historyid":"${cookie.historyid.value}"
                        },
                        dataType:"json",
                        success:function (data) {

                            for (var i=0;i<data.length;i++){
                                var c=data[i];
                                var n=$(".pre_look");
                                var $dl=$("<dl></dl>");
                                var $dt=$("<dt></dt>");
                                var $img=$("<img src='"+c.img_source+"' width='50px' height='50px'>");
                                var $dd=$("<dd></dd>");
                                var $a= $("<a href='/hl.do?param=dingdan&id="+c.id+"'>"+c.name+"</a>")
                                $dt.append($img);
                                $dd.append($a);
                                $dl.append($dt);
                                $dl.append($dd);
                                n.append($dl);
                            }
                        }
                    });
                }



            </script>








           <%-- <dl>
                <dt>
                    <img style="width: 54px; height: 54px;" src=""/>
                </dt>
                <dd>
                    <a href=""></a>
                </dd>
            </dl>--%>





        </div>
    </div>

    <div class="p_center">
        <div id="wrapper">
            <div id="focus">
                <ul>
                    <li><a href="#"><img src="images/T1.jpg"/></a></li>
                    <li><a href="#"><img src="images/T2.jpg"/></a></li>
                    <li><a href="#"><img src="images/T3.jpg"/></a></li>
                    <li><a href="#"><img src="images/T4.jpg"/></a></li>
                    <li><a href="#"><img src="images/T5.jpg"/></a></li>
                </ul>
            </div>
        </div>
        <div class="p_list">
            <div class="p_info">
                <img src="images/icon_sale.png"/>商品列表
            </div>
        </div>

                      <ul class="product2">
                           <li><dl><dt><a href="" target="_self"><img src="" /></a></dt><dd class="title">
           					<a href="" target="_self"></a></dd><dd class="price">￥</dd></dl></li>

                            </ul>



        			<div class="pager">
        				<ul class="clearfix">
        					<li><a href="#">上一页</a></li>
                                    <li>2</li>
                            <li><a href="#">3</a></li>
                            <li><a href="#">下一页</a></li>
        				</ul>
        			</div>


    </div>

    <div id="p_right">
        <%@ include file="index_news.jsp" %>
        <%@ include file="hotproduct.jsp" %>
    </div>
</div>

<div id="foot">Copyright © 2018 上海海文 All Rights Reserved.</div>
</body>
</html>

