/**
 * Created by hongjian on 2015/10/25.
 */

/**
 * && 逻辑与  返回true false
 *
 * || 逻辑或 左右两边都是false时,返回其中第一个不为false的值或者最后一个值
 *
 * ! 逻辑非
 *
 * 逻辑运算中
 *
 * 0 null NaN "" undefined 都表示false
 *
 * 也就是说其他所有对象都作为true处理,或者返回(||)
 */

function getLogicalOperatorTest(){
    var s1 = "this is s1";
    var s2 = "1";

    var n1 = 1;

    var b1 = false;
    var b2 = true;


  /*  alert(b1||s1); // 返回 "this is s1"
    alert(b2||s1); // 返回 ture

    alert(b1||s2); // 返回 1
    alert(b2||s2); // 返回 ture

    alert(b1||n1); // 返回 1
    alert(b2||n1); // 返回 ture

    alert(s2&&b2);  //返回 true
    alert(!s2);     //返回 false

   */
}

function T(e){
    e = e||{};
    alert(e.name);
}
