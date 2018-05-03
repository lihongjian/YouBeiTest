<%--
  Created by IntelliJ IDEA.
  User: hongjian
  Date: 2015/10/26
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style type="text/css">
        .displayStyle{
            background-color:00FFFF;
        }

        .hideStyle{
            background-color:#FFFFF;
        }

        .onClickStyle{
            background-color:00FF00;
        }

        a{
            color:red;
        }

        a:hover{
            color:green;
        }
    </style>
    <script src="/testJavaScript/js/table/testExample1.js"></script>
    <title></title>
</head>
<body>
<form name="myForm">
    <table width="100%" id="tab" name="tab" border="0px" style="text-align:center;">
        <tr style="background-color:0099FF;color:black;">
            <td>选择</td>
            <td>编号</td>
            <td>姓名</td>
            <td>年龄</td>
            <td>地址</td>
            <td>操作</td>
            <td>操作</td>
        </tr>
        <tr id="tr1" onmouseOver="onmouseOverMethod(this)" onmouseOut="onmouseOutMethod(this)" onclick="onClickChangeStyle(this)">
            <td><input type='hidden'><input type="checkbox" value="11"/></td>
            <td>100</td>
            <td>张三</td>
            <td>15</td>
            <td>湖南株洲</td>
            <td><a href="#" onclick="addRow()">添加</a></td>
            <td><a href="#" onclick="deleteRow(this)">删除</a></td>
        </tr>
        <tr id="tr2" onmouseOver="onmouseOverMethod(this)" onmouseOut="onmouseOutMethod(this)" onclick="onClickChangeStyle(this)">
            <td><input type="checkbox" value="22"/></td>
            <td>101</td>
            <td>李四</td>
            <td>15</td>
            <td>湖南长沙</td>
            <td><a href="#" onclick="addRow()">添加</a></td>
            <td><a href="#" onclick="deleteRow(this)">删除</a></td>
        </tr>
        <tr id="tr3" onmouseOver="onmouseOverMethod(this)" onmouseOut="onmouseOutMethod(this)" onclick="onClickChangeStyle(this)">
            <td><input type="checkbox" value="33"/></td>
            <td>102</td>
            <td>王五</td>
            <td>15</td>
            <td>湖南湘潭</td>
            <td><a href="#" onclick="addRow()">添加</a></td>
            <td><a href="#" onclick="deleteRow(this)">删除</a></td>
        </tr>
    </table>


</form>
</body>

</html>
