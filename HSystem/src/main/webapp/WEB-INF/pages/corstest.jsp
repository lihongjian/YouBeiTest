<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/25
  Time: 14:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>跨域问题研究</title>
    <script src="bootstrap/js/jquery-1.10.2.min.js"></script>
</head>
<body>
    <h1> 跨域 </h1>
    <h1> spring的配置在next.section9.hsystem_beta里面</h1>
     <!-- 显然img跨域是没有什么问题的 -->
    <div style="width: 600px;height: 600px;overflow: hidden">
    <img src="http://192.168.43.198:8082/hsystem/water1.jpg"/>
    </div>
    <a href="#" onclick="localTest()">非跨域调用</a>
    <a href="#" onclick="crossDomainTest()">跨域调用</a>

    <script>

        function localTest(){
            $.ajax({
                type: 'post',
                url: 'login/checkUser.do',
                data: {
                    userName : 'hongjian',
                    userPassword : 'abc'
                },
                dataType:'json',
                success: function(data, textStatus, jqXHR){
                    console.dir(data);
                }
            });
        }
        function crossDomainTest(){
            $.ajax({
                type: 'post',
                crossDomain: true, //添加这个为跨域
                url: 'http://192.168.43.198:8082/hsystem/hello/sayHello',
                data: {
                    name : 'hongjian'
                },
                headers:{ myheader :"hello",
                    myheader1 : "boy!"},  // 添加header会使cors请求变为复杂模式
                dataType:'json',
                xhrFields: {
/*
                    'Access-Control-Allow-Origin': 'localhost:8081',  //当请求携带cookie的时候不需要这个
*/
                    withCredentials: true //当请求携带cookie的时候需要这个
                },
                success: function(data, textStatus, jqXHR){
                    console.log("getAllResponseHeaders:"+jqXHR.getAllResponseHeaders());
                    console.dir(data.name);
                    console.dir(data.balance);
                }
            });
        }

    </script>



</body>
</html>
