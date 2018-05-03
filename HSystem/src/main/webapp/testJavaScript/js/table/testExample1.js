/**
 * Created by hongjian on 2015/10/26.
 */
var selectRow=null;
//����ʱ,�ı���ʽ;
function onClickChangeStyle(obj){
    //��ȡ������;
    var tab = document.getElementById("tab");

    //��ȡ��ǰ��ѡ���±�;
    var currentRowIndex = obj.rowIndex;

    //��ȡ�����������;
    var tablRows = tab.rows.length;

    //��ȡ����һ��,��һ�е�ֵ;
    var firstCellValue = tab.rows[0].cells[0].innerHTML;

    //��ȡ���ĵ�һ�У���һ�еĵ�һ��Ԫ�ص�ֵ;
    var firstChildValue = tab.rows[0].cells[0].firstChild.value;

    //ѭ������������;����ѡ��ĵ�ǰ�У��ı䱳����ɫ��
    for(var i = 1;i<tablRows;ii=i+1){
        if(currentRowIndex == i){
            //Ϊѡ�еĵ�ǰ������css��ʽ;
            selectRow  = tab.rows[i];
            tab.rows[i].className= "onClickStyle";
        }else{
            //��û��ѡ�е��еı�����ʽ����Ϊ��ɫ;
            tab.rows[i].className= "hideStyle";
        }
    }
}

//�������ʱ���ı���ɫ;
function onmouseOverMethod(selectThis){
    selectThis.className="displayStyle";
    if(selectRow==selectThis){
        selectThis.className="onClickStyle";
    }
}

//����Ƴ�ʱ���ı䱳����ɫ;
function onmouseOutMethod(selectThis){
    selectThis.className="hideStyle";
    if(selectRow == selectThis){
        selectThis.className="onClickStyle";
    }
}

//�����;
function addRow(){
    var tab = document.getElementById('tab');
    var rowIndex = tab.rows.length+1;

    //���һ��;
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
    td3.innerHTML = "����";
    td4.innerHTML = "22";
    td5.innerHTML = "�޵�ַ";
    td6.innerHTML = "<a href='#' onclick='addRow()'>���</a>";
    td7.innerHTML = "<a href='#' onclick='deleteRow(this)'>ɾ��</a>";

    //��ʼ����;
    initRows(tab);
}

//��ʼ����,�������к�;
function initRows(tab){
    var tabtabRows = tab.rows.length;
    for(var i = 0;i<tabRows.length;i++){
        tab.rows[i].cells[0].firstChild.value=i;
    }
}

//ɾ����;(obj�������Ӷ���)
function deleteRow(obj){
    var tab = document.getElementById('tab');
    //��ȡtr����;
    var tr = obj.parentNode.parentNode;

    if(tab.rows.length>2){
        //tr.parentNode��ָ���ǣ�table����;�Ƴ��ӽڵ�;
        tr.parentNode.removeChild(tr);
    }
    //���������к�;
    initRows(document.getElementById('tab'));
}
