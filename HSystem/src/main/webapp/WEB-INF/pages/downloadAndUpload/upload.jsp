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
    <script src="bootstrap/js/jquery-1.10.2.min.js"></script>
    <script src="FileSaver.js-1.3.4/FileSaver.js-1.3.4/FileSaver.js"></script>
</head>
<body>

<input type="file" id="file1"/>
<br>
<br>
<a href="#" onclick="handleFiles()">处理文件！</a>
<br>
<br>
<a href="#" onclick="doUpload()">上传文件！</a>
<br>
<br>
<a href="#" onclick="doUploadPart()">上传文件！Part方式</a>
<br>
<br>
<a href="#" onclick="doUploadChunk()">上传文件！chunk方式 分块上传 断点续传 秒传</a>
<div id="showResult"></div>

<br>

<script>

    function handleFiles(){
        var file = $("#file1").get(0).files[0]
            var reader = new FileReader();
/*
            if (/text\/\w+/.test(file.type)) {
*/
            saveAs(file, "water1.jpg");//file继承blob saveAs方法可以直接下载

          /*  reader.onload = function() {
                $('<pre>' + this.result + '</pre>').appendTo('body');
            };
            var result = reader.readAsText(file);
            console.dir(result);*/
       /*     reader.readAsArrayBuffer(file);*/
    }
    function doUpload(){
        var fd = new FormData();
        fd.append("uploadFile", $("#file1").get(0).files[0]);
        $.ajax({
            url: "/uploadFile",
            type: "POST",
            processData: false,
            contentType: false,
            data: fd,
            success: function(d) {
            }
        });
    }

    function doUploadPart(){
        var fd = new FormData();
        fd.append("uploadFile", $("#file1").get(0).files[0]);
        $.ajax({
            url: "/uploadFilePart",
            type: "POST",
            processData: false,
            contentType: false,
            data: fd,
            success: function(d) {
            }
        });
    }

    function doUploadChunk(){
        const LENGTH=10*1024*1024;
        var start
        var end;
        start=0;
        end=LENGTH+start;
        var fd = new FormData();
        var  file = $("#file1").get(0).files[0];
        var  partblob = file.slice(start,end);
        fd.append("uploadFile", partblob);
        $.ajax({
            url: "/uploadChunk",
            type: "POST",
            processData: false,
            contentType: false,
            data: fd,
            success: function(d) {
            }
        });
    }


    function sendfile() {
        const LENGTH = 1024 * 1024;
        var sta = 0;
        var end = sta + LENGTH;
        var blob = null;
        var fd = null;

        /*
            xhr 对象
        */
        var xhr = null;

        var mov = document.getElementsByName('mov')[0].files[0];
        //console.log(mov);return;

        var totalsize = mov.size;
        var percent = 0;

        // while(sta < totalsize) {
        timer = setInterval(function(){
            if (sta>totalsize) {
                clearInterval(timer);
            };
            blob = mov.slice(sta,end);
            fd = new FormData();
            fd.append('part',blob);

            xhr = new XMLHttpRequest();
            xhr.open('POST',"",false);

            xhr.send(fd);

            sta = end;
            end = sta + LENGTH;

            percent = 100 * end / totalsize;
            if(percent > 100) {
                percent = 100;
            }
        },1)

        // }

    }
</script>
</body>
</html>
