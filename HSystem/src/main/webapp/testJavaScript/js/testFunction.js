/**
 * Created by hongjian on 2015/10/25.
 */
/**
 *
 * javascript ��һ�ж��Ƕ���, function��Ҳ��һ�ֶ���
 *  function���õ�ʱ�����()��ʾ������ִ��
 *  �������()��ʾ��������
 *
 *
 *  �������ص�ʱ����Զ�����arguments
 *  arguments�������� ����ͨ����׺[i]����ȡ��function�Ĳ�����ֵ
 *
 *
 *  function ����������
 *
 */
function function1(){
    alert("abcD");
}



function getfunction(){
    /*var f1 = function1;
    f1();*/


    funcArgs(1,2,3);

}

/**arguments**/
var funcArgs = function func(a,b){
    alert(a);
    alert(b);
    for(var i=0;i<arguments.length;i++){
        alert(arguments[i]);
    }
}


/**�ݹ�**/


/**
 * ���췽�� constructor
 * �ж϶�������� typeof
 *
 * ���������� : �հ�
 *
 */
var a = function (){
    var d1 = [];
    alert(typeof d1 == Object && d1.constructor == Array);
}

/***
 * �հ�
 *
 * �ñհ�ʵ�ַ�װ  dd��˽�е�
 */
function f1(){
    var dd = 0;
    var f2 = function(){
        dd++;
        alert(dd);
    }
    return f2;
}
var f3 = f1(); //fi�е�dd���ᱻ���� f3�������ʱ�� dd�Żᱻ����
f3();
f3();
f3();