package com.behavioral.model.iterativesubmodel;
/*聚集(Aggregate)角色：此抽象角色给出创建迭代子(Iterator)对象的接口。*/
public abstract class Aggregate {
	/**
     * 工厂方法，创建相应迭代子对象的接口
     */
    public abstract Iterator createIterator();
}
