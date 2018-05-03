/**
 * Created by hongjian on 2015/10/25.
 */
/**
 *
 * javascript 中一切都是对象, function是也是一种对象
 *  function调用的时候加入()表示函数的执行
 *  如果不加()表示函数本身
 *
 *
 *  函数加载的时候会自动加载arguments
 *  arguments类似数组 可以通过后缀[i]依次取出function的参数的值
 *
 *
 *  function 当做类来用
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


/**递归**/


/**
 * 构造方法 constructor
 * 判断对象的类型 typeof
 *
 * 函数的特性 : 闭包
 *
 */
var a = function (){
    var d1 = [];
    alert(typeof d1 == Object && d1.constructor == Array);
}

/***
 * 闭包
 *
 * 用闭包实现封装  dd是私有的
 */
function f1(){
    var dd = 0;
    var f2 = function(){
        dd++;
        alert(dd);
    }
    return f2;
}
var f3 = f1(); //fi中的dd不会被回收 f3被清掉的时候 dd才会被回收
f3();
f3();
f3();