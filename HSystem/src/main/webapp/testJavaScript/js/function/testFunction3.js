/**
 * Created by hongjian on 2015/10/29.
 */

// ����
function Class() {}

// ��extend��create����prototype�����У��Ա�����̳�
Class.prototype.extend = function () {};
Class.prototype.create = function () {};

// Ϊ�����ڻ�����ֱ����.extend�ķ�ʽ���е���
Class.extend = function (props) {
    return this.prototype.extend.call(this, props);
}

Class.prototype.create = function (props) {
    /*
     createʵ�����Ƕ�new�ķ�װ��
     create���ص�ʵ��ʵ���Ͼ���new�������ʵ����
     this��ָ����õ�ǰcreate�Ĺ��캯����
     */
    var instance = new this();
    /*
     �󶨸�ʵ��������
     */
    for (var name in props) {
        instance[name] = props[name];
    }
    return instance;
}

Class.prototype.extend = function (props) {
    /*
     �����������µ�����
     */
    var SubClass = function () {};
    /*
     �̳и�������Ժͷ�����
     ��Ȼǰ���Ǹ�������Զ�����prototype��
     ��������create�����ġ�ʵ�����ԡ���
     */
    SubClass.prototype = Object.create(this.prototype);
    // ��������Լ��ķ���������
    for (var name in props) {
        SubClass.prototype[name] = props[name];
    }
    SubClass.prototype.constructor = SubClass;

    /*
     ������Ҫ��.extend�ķ�ʽ��.create�ķ�ʽ���ã�
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
// ���ø��෽��
man.say();

man.walk();

