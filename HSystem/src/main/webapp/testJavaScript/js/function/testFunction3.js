/**
 * Created by hongjian on 2015/10/29.
 */

// 基类
function Class() {}

// 将extend和create置于prototype对象中，以便子类继承
Class.prototype.extend = function () {};
Class.prototype.create = function () {};

// 为了能在基类上直接以.extend的方式进行调用
Class.extend = function (props) {
    return this.prototype.extend.call(this, props);
}

Class.prototype.create = function (props) {
    /*
     create实际上是对new的封装；
     create返回的实例实际上就是new构造出的实例；
     this即指向调用当前create的构造函数；
     */
    var instance = new this();
    /*
     绑定该实例的属性
     */
    for (var name in props) {
        instance[name] = props[name];
    }
    return instance;
}

Class.prototype.extend = function (props) {
    /*
     派生出来的新的子类
     */
    var SubClass = function () {};
    /*
     继承父类的属性和方法，
     当然前提是父类的属性都放在prototype中
     而非上面create方法的“实例属性”中
     */
    SubClass.prototype = Object.create(this.prototype);
    // 并且添加自己的方法和属性
    for (var name in props) {
        SubClass.prototype[name] = props[name];
    }
    SubClass.prototype.constructor = SubClass;

    /*
     介于需要以.extend的方式和.create的方式调用：
     */
    SubClass.extend = SubClass.prototype.extend;
    SubClass.create = SubClass.prototype.create;

    return SubClass;
}


var Human = Class.extend({
    say: function () {
        console.log("Hello");
    }
});

var human = Human.create();
console.log(human)
human.say();

var Man = Human.extend({
    walk: function () {
        console.log("walk");
    }
});

var man = Man.create({
    name: "Lee",
    age: 22
});

console.log(man);
// 调用父类方法
man.say();

man.walk();

