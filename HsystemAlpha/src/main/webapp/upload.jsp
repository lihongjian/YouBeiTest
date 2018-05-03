<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/26
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>upload</title>
    <script src="jquery/jquery-1.7.2.js"></script>
</head>
<body>

<input type="file" id="file1"/>
<br>
<br>
<a href="#" onclick="doUpload()">上传文件！</a>
<div id="showResult"></div>
<br>

<script>
    function doUpload(){
        const LENGTH=10*1024*1024;
        var start
        var end;
        start=0;
        end=LENGTH+start;
        var fd = new FormData();
        var  file = $("#file1").get(0).files[0];
        var  partblob = file.slice(start,end);
        fd.append("partfile", partblob);
        $.ajax({
            url: "/doUpload.action",
            type: "POST",
            processData: false,
            contentType: false,
            data: fd,
            success: function(d) {
            }
        });
    }
</script>
</body>
</html>
