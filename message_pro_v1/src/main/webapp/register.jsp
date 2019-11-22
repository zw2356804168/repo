<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>海文 在线短信平台</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/sms.css"/>
    <script src="${pageContext.request.contextPath}/scripts/jquery.js" type="text/javascript"></script>

    <script>
        var $name,$pwd,$affirm,$email,$error;
        $(function () {
            //找到元素
            $name=$("#name");
            $pwd=$("#pwd");
            $affirm=$("#affirm");
            $email=$("#email");
            $error=$("#error");
        })

        /**
         * 表单验证函数
         * @returns {boolean}
         */
        function validate() {
            if($name.val()==""){
                $error.html("<span style='color:red'>用户名不能为空</span>");
                return false;
            }
            if($pwd.val()==""){
                $error.html("<span style='color:red'>密码不能为空</span>");
                return false;
            }
            if($affirm.val()==""){
                $error.html("<span style='color:red'>确认密码不能为空</span>");
                return false;
            }
            if($affirm.val()!=$pwd.val()){
                $error.html("<span style='color:red'>两次密码不一致</span>");
                return false;
            }
            if($email.val()==""){
                $error.html("<span style='color:red'>邮箱不能为空</span>");
                return false;
            }
            var reg = /^[0-9a-zA-Z_.-]+[@][0-9a-zA-Z_.-]+([.][a-zA-Z]+){1,2}$/;
            if(!reg.test($email.val())){
                $error.html("<span style='color:red'>邮箱格式不正确</span>");
                return false;
            }
            return true;
        }
    </script>
</head>

<body>
<div id="regTitle" class="png"></div>
<div id="regForm" class="userForm png">

    <%--
      当提交表单的时候会触发onsubmit事件,只有当onsubmit事件的返回值为return true的时候才会提交表达,否则不提交
    --%>
    <form action="${pageContext.request.contextPath}/lr.do?param=register" method="post" onsubmit="return validate()">
        <dl>
            <div id="error">${requestScope.info}</div>
            <dt>用 户 名：</dt>
            <dd>
                <input type="text" name="name" id="name"/>
            </dd>
            <dt>密 码：</dt>
            <dd>
                <input type="password" name="pwd" id="pwd"/>
            </dd>
            <dt>确认密码：</dt>
            <dd>
                <input type="password" name="affirm" id="affirm"/>
            </dd>
            <dt>邮 箱：</dt>
            <dd>
                <input type="text" name="email" id="email"/>
            </dd>
        </dl>
        <div class="buttons">
            <input class="btn-reg png" type="submit" name="register" value=" "/><input
                class="btn-reset png" type="reset" name="reset" value=" "/>
        </div>
        <div class="goback">
            <a href="index.jsp" class="png">返回登录页</a>
        </div>
    </form>
</div>
</body>
</html>
