/**
 * Created by hongjian on 2015/10/25.
 */

/**
 * window 系统的内置对象,在不同浏览器略有不同
 *
 * window下面的变量,不需要加入 "window."
 */
function testbasic(){

 /*   window.resizeTo(400,400); // edge 可以  chrome不行
    window.moveTo(700,800);   // edge chrome都不行
    window.moveBy(0, 300); // edge chrome都不行*/

    /** window.open  edge和chrome都可以 **/
    //var win = window.open("https://www.baidu.com/","_blank","height=300,winth=300");  //都可以
/*    var win2 = window.open("testBom2.jsp","_blank","height=300,winth=300");  //都可以
    window.msg="this messge from your parent page !";
    win.opener = window;*/

    /**setTimeOut  方法必须用run 而不能用run() 注意!!**/
    //window.setTimeout(run,3000);
    //window.setInterval(run,1000);  //edge还是有不一样 alert时 主页面lock了 edge直接死循环了..
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
    history.back();  //返回前一个页面

}

function testLocation(){

}

function testNavigator(){

}

function testScreen(){

}