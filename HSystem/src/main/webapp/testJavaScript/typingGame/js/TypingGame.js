/**
 * Created by hongjian on 2015/11/7.
 */

var vItemNum = 10;

var heightSpeed = 0.04;

var hItemNum = 20;

var itemHeight;

var itemWidth;

var interval = 1000;

var keyValues = ["A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z",
    "a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z",
    "1","2","3","4","5","6","7","8","9","0","-","+","="]

var displayItems = [];

var displayDivs = [];

var successNum;

var failedNum;

function TypeItem(valueC,itemInitLeftMin,itemInitLeftMax){

    this.valueC = valueC;
    var vNum = getRandomInt(0,hItemNum);
    this.leftC = vNum * itemInitLeftMax + getRandomInt(itemInitLeftMin,itemInitLeftMax);
    this.topC = getRandomInt(2,itemHeight) * -1;
}


function createItemDivs(num,itemInitLeftMin,itemInitLeftMax){
    var divItems = [];

    for(var i=0 ; i < num ; i++){
        if(keyValues.length >= 1) {
            var keyValueNum = getRandomInt(0, keyValues.length);
            var keyvalue = keyValues[keyValueNum];
            keyValues.splice(keyValueNum, 1);
            var typeitem = new TypeItem(keyvalue, itemInitLeftMin, itemInitLeftMax);
            var itemDiv = createItemDiv(typeitem);
            divItems.push(itemDiv);
        }
    }
    return divItems;
}

function createItemDiv(typeItem){
    var createDiv = document.createElement("div");
    createDiv.setAttribute("class","item");
    var itemP = document.createElement("div");
    itemP.innerHTML = typeItem.valueC;
    createDiv.id = typeItem.valueC;
    itemP.setAttribute("class","itemP");
    createDiv.appendChild(itemP);
    createDiv.style.left = typeItem.leftC;
    createDiv.style.top = typeItem.topC;
    createDiv.style.height = itemHeight;
    createDiv.style.width = itemWidth;
    return createDiv;
}


var pressKey = function(e){
    var key = String.fromCharCode(event.keyCode);
    var displayDivsSub = [];
    if(displayDivs.length>0){
        for(var i = 0 ; i < displayDivs.length ; i++){
            var displayDiv = displayDivs[i];
            if(displayDiv.id == key){
                displayDiv.parentElement.removeChild(displayDiv);
            } else {
                displayDivsSub.push(displayDiv);
            }
        }
    }
    displayDivs = displayDivsSub;
}


function getRandomInt(min,max){
    return Math.floor(Math.random()*(max-min)) + min;
}

function init(){
    var skyArea = document.getElementById("skyArea");
    var skyAreaHeight = skyArea.offsetHeight;
    var skyAreaWidth = skyArea.offsetWidth;
    itemHeight = skyAreaHeight*0.05;
    itemWidth = skyAreaWidth/hItemNum;
    var itemInitLeftMin = 0;
    var itemInitLeftMax = skyAreaWidth/hItemNum;
    var vspeed = skyAreaHeight*heightSpeed;
    var interval1 = setInterval(function(){
        var frequency = getRandomInt(0,3);
        var itemDivs = createItemDivs(frequency,itemInitLeftMin,itemInitLeftMax);
        for(var i = 0 ; i < itemDivs.length ; i ++){
            var itemDiv = itemDivs[i];
            skyArea.appendChild(itemDiv);
            displayDivs.push(itemDiv);
        }
        var displayDivsSub = [];
        if(displayDivs.length>0){
            for(var i = 0 ; i < displayDivs.length ; i++){
                var displayDiv = displayDivs[i];
                if(displayDiv.offsetTop>= skyAreaHeight){
                    keyValues.push(displayDiv.innerText);
                    displayDiv.parentElement.removeChild(displayDiv);
                } else {
                    displayDiv.style.top = displayDiv.offsetTop + vspeed;
                    displayDivsSub.push(displayDiv);
                }
            }
        }
        displayDivs = displayDivsSub;
    },interval);


    Document.onkeydown = pressKey;



}






