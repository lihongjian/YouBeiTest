/**
 * Created by hongjian on 2015/10/25.
 */

/**
 * window ϵͳ�����ö���,�ڲ�ͬ��������в�ͬ
 *
 * window����ı���,����Ҫ���� "window."
 */
function testbasic(){

 /*   window.resizeTo(400,400); // edge ����  chrome����
    window.moveTo(700,800);   // edge chrome������
    window.moveBy(0, 300); // edge chrome������*/

    /** window.open  edge��chrome������ **/
    //var win = window.open("https://www.baidu.com/","_blank","height=300,winth=300");  //������
/*    var win2 = window.open("testBom2.jsp","_blank","height=300,winth=300");  //������
    window.msg="this messge from your parent page !";
    win.opener = window;*/

    /**setTimeOut  ����������run ��������run() ע��!!**/
    //window.setTimeout(run,3000);
    //window.setInterval(run,1000);  //edge�����в�һ�� alertʱ ��ҳ��lock�� edgeֱ����ѭ����..
}

function run(){
    alert("abc");
}


function testDocument(){


}


function testFrames(){

}


function testHistory(){

    //history.forward();
    history.back();  //����ǰһ��ҳ��

}

function testLocation(){

}

function testNavigator(){

}

function testScreen(){

}