<%--
  Created by IntelliJ IDEA.
  User: hongjian
  Date: 2016/1/8
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <script type="application/javascript">

      var a = 1;
      function mousedownFn(){
         alert(111);
      }
      function mouseupFn(){
        console.log(90909);
        alert(a);
      }
      function mouseDownUpFn(bb){
        // alert 之后或者调试断点之后 onmouseup 里面的就不走了
        // alert 之后 button的焦点就失去了 就不会触发按钮的 onmouseup 事件
        // alert("123213213");
        console.log(1111111);
        a =100;
        bb.onmouseup=mouseupFn
      }
    </script>
</head>
<body>

<input type="button" value="test-mouseDown" onmousedown="mousedownFn()"/>
<br/>
<br/>
<input type="button" value="test-mouseUp" onmouseup="mouseupFn()"/>
<br/>
<br/>
<input type="button" value="test-mouseDownUp" onmousedown="mouseDownUpFn(this)"/>
<br/>
<br/>
<input type="button" value="test-mouseDownUp" onmouseover="mouseDownUpFn(this)"/>

</body>
</html>
