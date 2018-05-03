<%--
  Created by IntelliJ IDEA.
  User: hongjian
  Date: 2015/11/7
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Typing Game</title>
    <script src="/testJavaScript/typingGame/js/TypingGame.js"></script>
    <style type="text/css">
         #menBar{height:2%;background-color: lightgray}
         #gameZone{
             width: 100%;
         }
         #skyArea{
             height: 80%;
             background-image: url("/image/sky.gif");
             overflow: hidden;
         }
         #landArea{
             background-color: #953b39;
             height: 18%;
         }
         .item{
             position:absolute;
             background-color: #802420;
         }
         .itemP{
             position: absolute;
             margin: 0 auto;
             /*font-size: 30pt;*/
             text-align: center;
         }

    </style>
</head>
<body onload= "init()"  onkeypress="pressKey()">
<div id="menBar">
    <button class="itemButton">SS</button>
</div>

<div id="gameZone">
    <div id="skyArea">

    </div>
    <div id="landArea"></div>
</div>
</body>
</html>
