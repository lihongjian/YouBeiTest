/**
 * Created by hongjian on 2015/10/26.
 */


var mainSelectedRow = []


var mainTableRowMouseOut = function onMainTableRowMouseOut() {

    //e = e||Event;
    var row = this;
    if (row.className != 'trBody-selected') {
        row.className = 'trBody-rest';
    }
}


var mainTableRowMouseOver = function onMainTableRowMouseOver() {

    //e = e||Event;
    var row = this;
    if (row.className != 'trBody-selected') {
        row.className = 'trBody-hover';
    }
}

var mainTableRowClick = function onMainTableRowMouseOver(e) {
    var row = this;
    var checkers = row.getElementsByClassName("rowChecker");
    var checker = checkers[0];
    if (row.className != 'trBody-selected') {
        row.className = 'trBody-selected';
        checker.checked = true;
    } else {
        row.className = 'trBody-rest';
        checker.checked = false;
    }
}

var mainTableAllCheck = function onMainTableAllCheck(e) {

    var allChecker = this;
    var mainTable = getParentElementByTagName(allChecker, 'TABLE');
    var rowCheckers = mainTable.getElementsByClassName("rowChecker");
    for (var i = 0; i < rowCheckers.length; i++) {
        var rowChecker = rowCheckers[i];
        rowChecker.checked = allChecker.checked;
        fireRowCheckerChanged(rowChecker);
    }
}


function onMainTableRowCheck(e) {
    if (e || e.stopPropagation) {
        e.stopPropagation();
    }
    else {
    //才用IE的停止事件冒泡的方法
        window.event.CancelBubble = true;
    }
    fireRowCheckerChanged(this);
    fireMainCheckerChanged(this);
}


function fireRowCheckerChanged(checker){
    var row = getParentElementByTagName(checker,'TR');
    if (checker.checked) {
        row.className = 'trBody-selected';
    } else {
        row.className = 'trBody-rest';
    }
}


function fireMainCheckerChanged(checker){
    var tableMain = getParentElementByTagName(checker, 'TABLE');
    var allcheckers = tableMain.getElementsByClassName("allChecker");
    var allchecker = allcheckers[0];
    var allCheckerStatus = true;
    var rowCheckers = tableMain.getElementsByClassName("rowChecker");
    for (var i = 0; i < rowCheckers.length; i++) {
        var rowChecker = rowCheckers[i];
        if(!rowChecker.checked){
            allCheckerStatus = false;
        }
    }
    allchecker.checked=allCheckerStatus;
}



/**
 * 做一个递归,取tagname相匹配的父级元素
 * @param thisNode
 * @param tagName
 * @returns {*}
 */
function getParentElementByTagName(thisNode, tagName) {
    var parentElement = thisNode.parentElement;
    if (!parentElement.tagName) {
        return parentElement;
    }
    if (parentElement.tagName != tagName) {
        return getParentElementByTagName(parentElement, tagName);
    } else {
        return parentElement;
    }
}

function init() {
    var tableMain = document.getElementById("tableMain");
    var rowsBody = tableMain.getElementsByClassName("trBody-rest");
    for (var i = 0; i < rowsBody.length; i++) {
        var row = rowsBody[i];
        addRowListener(row);
    }
    var allcheckers = tableMain.getElementsByClassName("allChecker");
    var allchecker = allcheckers[0];
    allchecker.onclick = mainTableAllCheck;

    var rowCheckers = tableMain.getElementsByClassName("rowChecker");
    for (var i = 0; i < rowCheckers.length; i++) {
        var rowChecker = rowCheckers[i];
        rowChecker.onclick = onMainTableRowCheck;
    }
}


function addRowListener(row) {
    row.onmouseout = mainTableRowMouseOut;   // chrome对应的是点击事件,而对于edge是鼠标指针移动事件...  无语
    row.onmouseover = mainTableRowMouseOver;
    row.onclick = mainTableRowClick;
}


function onAdd(e) {
    var tableMain = document.getElementById("tableMain");
    var newRow = tableMain.insertRow();
    newRow.className = "trBody-rest";
    addRowListener(newRow);
    var newCell0 = newRow.insertCell();
    var newCell1 = newRow.insertCell();
    var newCell2 = newRow.insertCell();
    var newCell3 = newRow.insertCell();
    var newCell4 = newRow.insertCell();
    newCell0.innerHTML = '<input class="rowChecker" type="checkbox"/>';
    newCell1.innerText = "new cell1";
    newCell2.innerText = "new cell2";
    newCell3.innerText = "new cell3";
    newCell4.innerText = "new cell4";
}

function onModify(e) {

}

function onSave(e) {

}

function onDelete(e) {
    var tableMain = document.getElementById("tableMain");
    var rows = tableMain.getElementsByClassName("trBody-selected");
    while(rows.length > 0) {
        tableMain.deleteRow(rows[0].rowIndex);
        rows = tableMain.getElementsByClassName("trBody-selected");
    }
}

function onCopy(e) {
    var tableMain = document.getElementById("tableMain");
    var tableTbodys = tableMain.getElementsByTagName("tbody");
    var tableTbody = tableTbodys[0];
    var allRows = tableTbody.getElementsByTagName("tr");
    var newRow = allRows[0].cloneNode(true);
    tableTbody.appendChild(newRow);
}

