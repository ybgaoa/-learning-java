package com.creation.model.prototypemodel.simpleprototypemodel.prototype;
/*抽象原型(Prototype)角色：这是一个抽象角色，通常由一个Java接口或Java抽象类实现。
 * 此角色给出所有的具体原型类所需的接口。*/
public interface Prototype {
	 /**
     * 克隆自身的方法
     * @return 一个从自身克隆出来的对象
     */
    public Prototype clone();
}
