/**
 * Created by hongjian on 2015/10/29.
 */

/**
 * 继承
 *
 * @param name
 */
function classA(name){
    this.classA = name;
}

classA.prototype.sayHi = function(){
    alert(this.classA);
}

function protoTypeObject(o){
    var F = function(){};
    F.prototype = o;
    return new F();
}

function classASub(name,arg){
    classA.call(this,name);
    this.arg = arg;
}

classASub.prototype = protoTypeObject(classA.prototype);
classASub.prototype.constructor =  classASub;

classASub.prototype.sayArgs = function() {
    alert(this.arg);
}

var classAs = new classASub("this class","this args");
classAs.sayArgs();
classAs.sayHi();

var classa = new classA("class A name");
classa.sayHi();
//classa.sayArgs();  // 父类不能调用子类prototype的方法,这句话报错


