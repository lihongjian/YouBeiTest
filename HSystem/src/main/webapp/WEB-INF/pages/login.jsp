<%--
  Created by IntelliJ IDEA.
  User: hongjian
  Date: 2015/8/22
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试系统abc</title>
    <script src="bootstrap/js/jquery-1.10.2.min.js"></script>

    <script>
        function onLogin(){

            var username = $("#userName").val();
            var userpassword = $("#userPassword").val();

            $.ajax({
                type: "POST",
                url: "/login/checkUser.do",
                dataType: "json",
                timeout: 10000,
                data: {
                    account: username,
                    password: userpassword
                }
            }).done(function (data,textStatus,jqXHR) {
                alert(data);
            }).fail(function(jqXHR,textStatus,errorThrown){
                alert(textStatus);
            }).always(function(){
                alert('11111');
            });
        }
    </script>
</head>
<body>

<p>${message}</p>

<form id="loginForm">

    用户名 : <input type="text" id="userName"> <br>
    密码 : <input type="text" id="userPassword"> <br>
    <a href="#" onclick="onLogin()">denglu</a>

</form>

</body>
</html>
