
var aString = "";
var bString = new String("this is b String!");
var cString = "huhu \n cici"

var aBoolean = true;
var bBoolean = new Boolean(false);

var aNumber = 5;
var bNumber = 7.7777;
var cNumbner = 011; //8������0��ͷ
var dNumber = 0xff; //16������0x������0X����
var zNumber = 0;
var nNumber = parseInt(bString);


var p;


/** NaN ������ֵ  infinite����  **/
function getNumber(){
/*
    alert(cNumbner);  //8�����Զ�ת��Ϊ��10����,���Ϊ17
    alert(dNumber);  //16�����Զ�ת��Ϊ��10����,���Ϊ255
    alert(bNumber.toExponential(2)); //ת��Ϊָ��������
    alert(bNumber.toFixed(2)); //ȡС�������λ
    alert(bNumber.toPrecision(2)); //ת��Ϊʹ����λ����
    alert(bNumber.toString(10)); //ת��ΪStringʹ��10����
    alert(aNumber/zNumber);  //����Infinity
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










