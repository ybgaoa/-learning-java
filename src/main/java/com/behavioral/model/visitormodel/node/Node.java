package com.behavioral.model.visitormodel.node;

import com.behavioral.model.visitormodel.visitor.Visitor;
/*抽象节点(Node)角色：声明一个接受操作，接受一个访问者对象作为一个参数。*/
public abstract class Node {
	/**
     * 接受操作
     */
    public abstract void accept(Visitor visitor);
}
