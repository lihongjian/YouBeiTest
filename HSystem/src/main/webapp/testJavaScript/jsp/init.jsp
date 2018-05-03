<%--
  Created by IntelliJ IDEA.
  User: hongjian
  Date: 2015/9/25
  Time: 16:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript" src="../../testJavaScript/js/testBasicType.js"></script>
    <script type="text/javascript" src="../../testJavaScript/js/testLogicalOperators.js"></script>
    <script type="text/javascript" src="../../testJavaScript/js/testFunction.js"></script>
    <script type="text/javascript" src="../../testJavaScript/js/testGlobal.js"></script>
<%--<script src="../../testJavaScript/js/*"></script>--%>
    <title></title>
</head>
<body>

    <a href="javaScript:getNumber()">this.number.getResult</a> <br>

    <a href="javaScript: getString()">this.string.getResult</a> <br>

    <a href="javaScript:getLogicalOperatorTest()">this.LogicalOperator.getResult</a><br>

    <a href="javaScript:T()">this.LogicalOperator.getResult2</a><br>

    <a href="javaScript:getfunction()">this.function.getResult</a><br>

    <a href="javaScript:testEval()">this.Global.getResult</a><br>




    <form action="/login/checkUser.do">

        账户 : <input type="text" name="userName" id="userName"> <br>
        密码 : <input type="text" name="userPassword" id="userPassword"> <br>
        <input type="submit" value="登陆">

    </form>
</body>
</html>
