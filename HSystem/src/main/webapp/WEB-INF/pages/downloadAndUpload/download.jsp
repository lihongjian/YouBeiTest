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
    <title>download</title>
    <meta charset="UTF-8">
    <script src="bootstrap/js/jquery-1.10.2.min.js"></script>
    <script src="FileSaver.js-1.3.4/FileSaver.js-1.3.4/FileSaver.js"></script>
    <script src="jquery/jquery-base64-master/jquery.base64.js"></script>
</head>
<h1>download</h1>
<input type="file" id="file1"/>
<br>
<br>
<a href="#"  onclick="downLoadUploadFile()" >downLoadUploadFile ! Let's begin! 开始</a>
<br>
<br>
<a href="/downLoadFileStream"  >downLoadFileStream ! Let's begin! 开始</a>
<br>
<br>
<a href="#" onclick="downLoadZippedFile()"  >downLoadZippedFile ! Let's begin! 开始</a>
<br>
<br>
<a href="#" onclick="downloadNewPage()">downloadNewPage ! Let's begin! 开始</a>
<br>
<br>
<a href="#" onclick="downloadForm()">downloadForm ! Let's begin! 开始</a>
<br>
<br>
<a href="#"  onclick="downLoadTest()" >downLoadTest ! Let's begin! 开始</a>

<img src="">

<script>
    function doDownLoad(){
        var url = "/downLoadZip";
        $.ajax(url,{
            dataType:'json',
            method:'GET',
            data:{id:'111'},
            success:function(res){
               // save txt , that is easy
              /*  var blob = new Blob([res.data], {type: "text/plain;charset=utf-8"});
                saveAs(blob, "hello world.txt");*/
            },
            error:function(){
                alert("error");
            }
        });
    }


    function downLoadUploadFile(){
        var  file = $("#file1").get(0).files[0];
        saveAs(file, file.name);
    }
    function downLoadZippedFile(){
        var url = "/downLoadZip";
        $.ajax(url,{
            dataType:'json',
            method:'GET',
            data:{id:'111'},
            success:function(res){
                // save txt , that is easy
                var blob = convertZipDataToBlob(res.data);
                saveAs(blob, "abc.zip");
            },
            error:function(){
                alert("error");
            }
        });
    }

    function convertZipDataToBlob(base64Data){
        var format = "application/zip";
        var base64 = base64Data;
        var code = window.atob(base64.split(",")[0]);
        var aBuffer = new window.ArrayBuffer(code.length);
        var uBuffer = new window.Uint8Array(aBuffer);
        for(var i = 0; i < code.length; i++){
            uBuffer[i] = code.charCodeAt(i) & 0xff ;
        }
        console.info([aBuffer]);
        console.info(uBuffer);
        console.info(uBuffer.buffer);
        console.info(uBuffer.buffer==aBuffer); //true

        var blob=null;
        try{
            blob = new Blob([uBuffer], {type : format});
        }
        catch(e){
            window.BlobBuilder = window.BlobBuilder ||
                window.WebKitBlobBuilder ||
                window.MozBlobBuilder ||
                window.MSBlobBuilder;
            if(e.name == 'TypeError' && window.BlobBuilder){
                var bb = new window.BlobBuilder();
                bb.append(uBuffer.buffer);
                blob = bb.getBlob("application/zip");

            }
            else if(e.name == "InvalidStateError"){
                blob = new Blob([aBuffer], {type : format});
            }
            else{

            }
        }
        alert(blob.size);
        return blob;
    }


    function convertImgDataToBlob(base64Data) {
        var format = "image/jpeg";
        var base64 = base64Data;
        //这里其实很巧妙，atob仅支持ascii码表，ascii只解析8位bit，即1个字节，
        // 所以后台无论是utf8 utf16 gbk还是什么编码方式，在这里一致解析成ascii字符，
        // 所以后面取得的ubuffer才能与服务器上的完全保持一致
        var code = window.atob(base64.split(",")[1]);
        var aBuffer = new window.ArrayBuffer(code.length);
        var uBuffer = new window.Uint8Array(aBuffer);
        for(var i = 0; i < code.length; i++){
            uBuffer[i] = code.charCodeAt(i) & 0xff ;
        }
        console.info([aBuffer]);
        console.info(uBuffer);
        console.info(uBuffer.buffer);
        console.info(uBuffer.buffer==aBuffer); //true

        var blob=null;
        try{
            blob = new Blob([uBuffer], {type : format});
        }
        catch(e){
            window.BlobBuilder = window.BlobBuilder ||
                window.WebKitBlobBuilder ||
                window.MozBlobBuilder ||
                window.MSBlobBuilder;
            if(e.name == 'TypeError' && window.BlobBuilder){
                var bb = new window.BlobBuilder();
                bb.append(uBuffer.buffer);
                blob = bb.getBlob("image/jpeg");

            }
            else if(e.name == "InvalidStateError"){
                blob = new Blob([aBuffer], {type : format});
            }
            else{

            }
        }
        alert(blob.size);
        return blob;

    };

    // 会打开一个空白页下载，然后空白页消失，用户体验不好
    function downloadNewPage() {
        window.open('/downLoadFileStream');
    }

    // 直接下载，用户体验好
    function downloadForm() {
        var $form = $('<form method="GET"></form>');
        $form.attr('action', '/downLoadFileStream');
        $form.appendTo($('body'));
        $form.submit();
    }

    function downLoadTest(){
        var url = "/downloadTest";
        $.ajax(url,{
            dataType:'json',
            method:'GET',
            data:{id:'111'},
            success:function(res){
                console.dir(res);
                console.info($.base64.decode(res.abcbase64));
                console.info($.base64.decode(res.abcbase64utf16));
                console.info($.base64.decode(res.abcbase64utf8));
                console.info($.base64.decode(res.bcdbase64));
                console.info($.base64.decode(res.bcdbase64utf16));
                console.info($.base64.decode(res.bcdbase64utf8));

                decodeBase64AndShowBytes(res.abcbase64);
                decodeBase64AndShowBytes(res.abcbase64utf16);
                decodeBase64AndShowBytes(res.abcbase64utf8);
                decodeBase64AndShowBytes(res.bcdbase64);
                decodeBase64AndShowBytes(res.bcdbase64utf16);
                decodeBase64AndShowBytes(res.bcdbase64utf8);
            },
            error:function(){
                alert("error");
            }
        });
    }

    function decodeBase64AndShowBytes(base64){
        var code = window.atob(base64);
        var aBuffer = new window.ArrayBuffer(code.length);
        var uBuffer = new window.Uint8Array(aBuffer);
        for(var i = 0; i < code.length; i++){
            uBuffer[i] = code.charCodeAt(i) & 0xff ;
        }
        console.info(uBuffer);
    }
</script>
</body>
</html>
