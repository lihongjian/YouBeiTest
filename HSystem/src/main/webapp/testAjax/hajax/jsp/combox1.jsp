<%--
  Created by IntelliJ IDEA.
  User: hongjian
  Date: 2015/11/29
  Time: 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="GENERATOR" content="Microsoft FrontPage 5.0">
    <meta name="ProgId" content="FrontPage.Editor.Document">
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
    <title>可编辑下拉框</title>
</head>
<body>
<table style="border:2px outset;background-color:#d2e8FF" width="250" height="100" align="center">
    <tr>
        <td width="60%" height="30" align="center">
            <select name="fason">
                <option value="可编辑下拉框">可编辑下拉框</option>
                <option value="作者">作者</option>
            </select>
        </td>
    </tr>
</table>
<script language="javascript">
    function combox(obj,select){
        this.obj=obj
        this.name=select;
        this.select=document.getElementsByName(select)[0];
        /*要转换的下拉框*/
    }
    /*初始化对象*/
    combox.prototype.init=function(){
        var inputbox="<input name='combox_"+this.name+"' onchange='"+this.obj+".find()' "
        inputbox+="style='position:absolute;width:"+(this.select.offsetWidth-16)+";height:"+this.select.offsetHeight+";left:"+getL(this.select)+";top:"+getT(this.select)+"'>"
        document.write(inputbox)
        with(this.select.style){
            left=getL(this.select)
            top=getT(this.select)
            position="absolute"
            clip="rect(0 "+(this.select.offsetWidth)+" "+this.select.offsetHeight+" "+(this.select.offsetWidth-18)+")"
            /*切割下拉框*/
        }
        this.select.onchange=new Function(this.obj+".change()")
        this.change()

    }
    /*初始化结束*/

    ////////对象事件定义///////
    combox.prototype.find=function(){
        /*当搜索到输入框的值时,下拉框自动定位*/
        var inputbox=document.getElementsByName("combox_"+this.name)[0]
        with(this.select){
            for(i=0;i<options.length;i++)
                if(options[i].text.indexOf(inputbox.value)==0){
                    selectedIndex=i
                    this.change();
                    break;
                }
        }
    }

    combox.prototype.change=function(){
        /*定义下拉框的onchange事件*/
        var inputbox=document.getElementsByName("combox_"+this.name)[0]
        inputbox.value=this.select.options[this.select.selectedIndex].text;
        with(inputbox){select();focus()};
    }
    ////////对象事件结束///////
    /*公用定位函数(获取控件绝对坐标)*/
    function getL(e){
        var l=e.offsetLeft;
        while(e=e.offsetParent)l+=e.offsetLeft;
        return l
    }
    function getT(e){
        var t=e.offsetTop;
        while(e=e.offsetParent)t+=e.offsetTop;
        return t
    }
    /*结束*/
</script>
<script language="javascript">
    var a=new combox("a","fason")
    a.init()
</script>

</body>

