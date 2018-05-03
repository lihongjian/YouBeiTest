<%--
  Created by IntelliJ IDEA.
  User: hongjian
  Date: 2015/11/22
  Time: 14:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript" src="/testAjax/hajax/js/doAjax.js"></script>
    <title></title>
</head>
<>

<div id="thisCombox1">
    <select style="width:120px;" onchange="document.getElementById('input').value=this.value">
        <option value="A类">A类</option>
        <option value="B类">B类</option>
        <option value="C类">C类</option>
        <option value="D类">D类</option>
    </select>
    <input id="input" name="input" style="position:absolute;width:99px;height:16px;left:1px;top:2px;border-bottom:0px;border-right:0px;border-left:0px;border-top:0px;">
</div>


<div id="thisCombox2">
    <a href="javascript:void(0);" onclick="onInitProvince()"><p>Click! get provinces! </p></a>
    省份 : <select id="Provinces"  style="width:120px;" onchange="getCities(this)"></select>
    </br>
    </br>
    城镇 : <select id="Cities" style="width:120px;"></select>
    </br>
</div>

</br>
</br>


<form action="/servlet.servlet">
    name : <input id="name" type="text"> </br>
    account : <input id="account" type="text"> </br>
    <input type="submit" value="submit">
</form>
<p id="message" onclick="getMessageGet()"> click here ! (no contentType and get)</p> </br>
<p id="message1" onclick="getMessagePost()"> click here ! (no contentType)</p> </br>
<p id="message2" onclick="getMessageXML()"> click here ! ( XML )</p> </br>
<p id="message3" onclick="getMessageJSON()"> click here ! (JSON)</p> </br>
<p id="message4" onclick="getMessageHTML()"> click here ! (HTML)</p> </br>

</br>
</br>



</body>
</html>
