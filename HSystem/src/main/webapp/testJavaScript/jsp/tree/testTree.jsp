<%--
  Created by IntelliJ IDEA.
  User: hongjian
  Date: 2015/11/6
  Time: 20:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <style type="text/css">
        /* 控制根节点的CSS样式定义 */
        .outline {
            font-size: 12pt;
            margin-left: 15pt;
            text-indent: -28pt;
            cursor: hand;
            text-decoration: none
        }

        /* 控制第一级子节点的CSS样式定义 */
        .outline1 {
            font-size: 12pt;
            margin-left: 24pt;
            text-indent: -36pt;
            cursor: hand;
            text-decoration: none
        }

        /* 控制第二级子节点的CSS样式定义 */
        .outline11 {
            font-size: 12pt;
            margin-left: 38pt;
            text-indent: -50pt;
            cursor: hand;
            text-decoration: none
        }

        /* 控制根节点下叶子节点的CSS样式定义 */
        .passage0 {
            font-size: 12pt;
            margin-left: 15pt;
            text-indent: -28pt;
            text-decoration: none
        }

        /* 控制第一级节点下叶子节点的CSS样式定义 */
        .passage1 {
            font-size: 12pt;
            margin-left: 24pt;
            text-indent: -36pt;
            text-decoration: none
        }

        /* 控制第二级节点下叶子节点的CSS样式定义 */
        .passage11 {
            font-size: 12pt;
            margin-left: 38pt;
            text-indent: -50pt;
            text-decoration: none;
        }
    </style>

    <script type="text/javascript" src="/testJavaScript/js/tree/testTree.js"></script>

</head>
<body>
<div id="root" class="outline">
    <img id="rootImage" class="outline" alt="rootImage"
         src="/image/plus.gif" height="12px" width="12px"/>
    我的电脑
</div>
<div id="rootDetails" style="display: none">
    <div id="child1" class="outline1">
        <img id="child1Image" class="outline1" alt="child1Image"
             src="/image/plus.gif"  height="12px" width="12px"/>
        本地磁盘 C:
    </div>
    <div id="child1Details" style="display: none">
        <div class="passage11">
            <img class="passage11" src="/image/passage.gif" height="12px" width="12px"/>
            文件一
        </div>
        <div class="passage11">
            <img class="passage11" src="/image/passage.gif" height="12px" width="12px"/>
            文件二
        </div>
    </div>
    <div id="child2" class="outline1">
        <img id="child2Image" class="outline1" alt="child2Image"
             src="/image/plus.gif" height="12px" width="12px"/>
        本地磁盘 D:
    </div>
    <div id="child2Details" style="display: none">
        <div class="passage11">
            <img class="passage11" src="/image/passage.gif" height="12px" width="12px"/>
            文件三
        </div>
        <div class="passage11">
            <img class="passage11" src="/image/passage.gif" height="12px" width="12px"/>
            文件四
        </div>
    </div>
    <div id="child3" class="outline1">
        <img id="child3Image" class="outline1" alt="child3Image"
             src="/image/plus.gif" height="12px" width="12px"/>
        本地磁盘 E:
    </div>
    <div id="child3Details" style="display: none">
        <div class="passage11">
            <img class="passage11" src="/image/passage.gif" height="12px" width="12px"/>
            文件五
        </div>
        <div class="passage11">
            <img class="passage11" src="/image/passage.gif" height="12px" width="12px"/>
            文件六
        </div>
    </div>
    <div class="passage1">
        <img class="passage1" src="/image/passage.gif" height="12px" width="12px"/>
        文件七
    </div>
</div>
</body>


</body>
</html>
