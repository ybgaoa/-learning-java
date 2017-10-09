package com.creation.model.prototypemodel.simpleprototypemodel.prototype;
/*具体原型（Concrete Prototype）角色：被复制的对象。此角色需要实现抽象的原型角色所要求的接口。*/
public class ConcretePrototype2 implements Prototype {
	public Prototype clone(){
        //最简单的克隆，新建一个自身对象，由于没有属性就不再复制值了
        Prototype prototype = new ConcretePrototype2();
        return prototype;
    }
}
