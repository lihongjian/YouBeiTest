/**
 * Created by hongjian on 2015/10/26.
 */
var selectRow=null;
//单击时,改变样式;
function onClickChangeStyle(obj){
    //获取表格对象;
    var tab = document.getElementById("tab");

    //获取当前行选择下标;
    var currentRowIndex = obj.rowIndex;

    //获取表格所有行数;
    var tablRows = tab.rows.length;

    //获取表格第一行,第一列的值;
    var firstCellValue = tab.rows[0].cells[0].innerHTML;

    //获取表格的第一行，第一列的第一个元素的值;
    var firstChildValue = tab.rows[0].cells[0].firstChild.value;

    //循环表格的所有行;并且选择的当前行，改变背景颜色；
    for(var i = 1;i<tablRows;ii=i+1){
        if(currentRowIndex == i){
            //为选中的当前，设置css样式;
            selectRow  = tab.rows[i];
            tab.rows[i].className= "onClickStyle";
        }else{
            //把没有选中的行的背景样式设置为白色;
            tab.rows[i].className= "hideStyle";
        }
    }
}

//鼠标移入时，改变颜色;
function onmouseOverMethod(selectThis){
    selectThis.className="displayStyle";
    if(selectRow==selectThis){
        selectThis.className="onClickStyle";
    }
}

//鼠标移除时，改变背景颜色;
function onmouseOutMethod(selectThis){
    selectThis.className="hideStyle";
    if(selectRow == selectThis){
        selectThis.className="onClickStyle";
    }
}

//添加行;
function addRow(){
    var tab = document.getElementById('tab');
    var rowIndex = tab.rows.length+1;

    //添加一行;
    var tr  = tab.insertRow();
    tr.onmouseover = tr.className="displayStyle" ;
    tr.onmouseout = tr.className="hideStyle" ;
    tr.onclick=function (){this.className="onClickChangeStyle(this)";}

    var td1 = tr.insertCell();
    var td2 = tr.insertCell();
    var td3 = tr.insertCell();
    var td4 = tr.insertCell();
    var td5 = tr.insertCell();
    var td6 = tr.insertCell();
    var td7 = tr.insertCell();

    td1.innerHTML = "<input type='hidden'/><input type='checkbox' value = '1'>";
    td2.innerHTML = ""+rowIndex;
    td3.innerHTML = "测试";
    td4.innerHTML = "22";
    td5.innerHTML = "无地址";
    td6.innerHTML = "<a href='#' onclick='addRow()'>添加</a>";
    td7.innerHTML = "<a href='#' onclick='deleteRow(this)'>删除</a>";

    //初始化行;
    initRows(tab);
}

//初始化行,设置序列号;
function initRows(tab){
    var tabtabRows = tab.rows.length;
    for(var i = 0;i<tabRows.length;i++){
        tab.rows[i].cells[0].firstChild.value=i;
    }
}

//删除行;(obj代表连接对象)
function deleteRow(obj){
    var tab = document.getElementById('tab');
    //获取tr对象;
    var tr = obj.parentNode.parentNode;

    if(tab.rows.length>2){
        //tr.parentNode，指的是，table对象;移除子节点;
        tr.parentNode.removeChild(tr);
    }
    //重新生成行号;
    initRows(document.getElementById('tab'));
}
