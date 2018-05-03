<%--
  Created by IntelliJ IDEA.
  User: hongjian
  Date: 2015/10/26
  Time: 9:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style type="text/css">
        div#container{width:100%}
        div#header {background-color:#99bbbb;height:12%}
        div#menu {background-color:#ffff99;height:80%;width:20%;float:left;}
        div#content {height:80%;width:80%;float:left;}
        div#footer {background-color:#99bbbb;clear:both;text-align:center;}
        div#contentButton{height:5%}
        div#contentMain{background-color: #ffffff; height:55%}
        div#contentSub{height:40%}
        .trHeader{background-color: #49afcd;font-size: 18px;}
        .trBody-rest{background-color: #ffffff}
        .trBody-hover{background-color: #dfe8fd}
        .trBody-selected{background-color: #0044cc}
        .headerbutton{height:80%;width:4.5%;}
        h1 {margin-bottom:0;}
        h2 {margin-bottom:0;font-size:18px;}
        ul {margin:0;}
        li {list-style:none;}
    </style>
    <script src="/testJavaScript/js/table/testTable.js"></script>
    <title>this is a table</title>
</head>
<body onload= "init()">

<div id="container">

<div id="header">
    this is header
</div>

<div id="menu">
    <h2>Menu</h2>
    <ul>
        <li>HTML</li>
        <li>CSS</li>
        <li>JavaScript</li>
    </ul>
</div>


    <div id="content">

      <div id="contentButton">
          <button id="Add" class="headerbutton" onclick=onAdd(this)>增加</button>
          <button id="Modify" class="headerbutton" onclick=onModify(this)>修改</button>
          <button id="Save" class="headerbutton" onclick=onSave(this)>保存</button>
          <button id="Delete" class="headerbutton" onclick=onDelete(this)>删除</button>
          <button id="Copy" class="headerbutton" onclick=onCopy(this)>复制</button>
      </div>

        <div id="contentMain">

<table id="tableMain" width='100%' border="1" style="background-color: #ffffff">
    <caption>this table</caption>
    <colgroup><col width="3%"/></colgroup>
    <colgroup><col width="22%"/></colgroup>
    <colgroup><col width="20%"/></colgroup>
    <colgroup><col width="25%"/></colgroup>
    <colgroup><col width="30%"/></colgroup>
    <tbody>
    <tr class="trHeader" >
        <td><input class="allChecker" id ="allChecker"type="checkbox"/></td>
        <th>heading</th>
        <th>heading2</th>
        <th>heading3</th>
        <th>heading4</th>
    </tr>
    <tr class="trBody-rest">
        <td><input class="rowChecker" type="checkbox"/></td>
        <td>row 1,cell 1</td>
        <td>row 1,cell 2</td>
        <td>row 1,cell 3</td>
        <td>row 1,cell 4</td>
    </tr>
    <tr class="trBody-rest">
        <td><input class="rowChecker" type="checkbox"/></td>
        <td>row 2,cell 1</td>
        <td>row 2,cell 2</td>
        <td>row 2,cell 3</td>
        <td>row 2,cell 4</td>
    </tr>
    <tr class="trBody-rest">
        <td><input class="rowChecker" type="checkbox"/></td>
        <td>row 3,cell 1</td>
        <td>row 3,cell 2</td>
        <td>row 3,cell 3</td>
        <td>row 3,cell 4</td>
    </tr>
    <tr class="trBody-rest">
        <td><input class="rowChecker" type="checkbox"/></td>
        <td>row 4,cell 1</td>
        <td>row 4,cell 2</td>
        <td>row 4,cell 3</td>
        <td>row 4,cell 4</td>
    </tr>
    <tr class="trBody-rest">
        <td><input class="rowChecker" type="checkbox"/></td>
        <td colspan="2">row 4,cell 1</td>
        <td>row 4,cell 3</td>
        <td>row 4,cell 4</td>
    </tr>
    </tbody>
</table>

    </div>

<div id="contentSub">

<table id="tableSub" width='100%' border="1">
    <colgroup span="2"  style="background-color: #d9d9d9;"><col align="center" width="15%"/><col width="25%"/></colgroup>
    <colgroup><col width="35%"/></colgroup>
    <colgroup><col  width="35%"/></colgroup>
    <tr>
        <th colspan="2">TYPE</th>
        <th>Title</th>
        <th>Price</th>
    </tr>
    <tr>
        <th>TYPE</th>
        <th>ISBN</th>
        <th>Title</th>
        <th>Price</th>
    </tr>
    <tr>
        <td>abc</td>
        <td>3476896</td>
        <td>My first HTML</td>
        <td>$53</td>
    </tr>
</table>
    </div>


    </div>
    <div id="footer">Copyright W3School.com.cn</div>
    </div>
</body>
</html>
