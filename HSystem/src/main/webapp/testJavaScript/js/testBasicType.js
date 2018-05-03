
var aString = "";
var bString = new String("this is b String!");
var cString = "huhu \n cici"

var aBoolean = true;
var bBoolean = new Boolean(false);

var aNumber = 5;
var bNumber = 7.7777;
var cNumbner = 011; //8进制以0开头
var dNumber = 0xff; //16进制以0x或者是0X结束
var zNumber = 0;
var nNumber = parseInt(bString);


var p;


/** NaN 不是数值  infinite无穷  **/
function getNumber(){
/*
    alert(cNumbner);  //8进制自动转换为了10进制,结果为17
    alert(dNumber);  //16进制自动转换为了10进制,结果为255
    alert(bNumber.toExponential(2)); //转换为指数计数法
    alert(bNumber.toFixed(2)); //取小数点后两位
    alert(bNumber.toPrecision(2)); //转化为使用两位精度
    alert(bNumber.toString(10)); //转化为String使用10进制
    alert(aNumber/zNumber);  //返回Infinity
    alert(p);   // undefined
    alert(nNumber); //NaN
 */
}


/**null  undefined**/
function getString(){

    alert(cString);

    cString = cString.link("www.baidu.com");
    alert(cString);

}










