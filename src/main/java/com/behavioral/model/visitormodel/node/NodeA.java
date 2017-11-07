package com.behavioral.model.visitormodel.node;

import com.behavioral.model.visitormodel.visitor.Visitor;
/*具体节点(ConcreteNode)角色：实现了抽象节点所规定的接受操作。*/
public class NodeA extends Node {
	/**
     * 接受操作
     */
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
    /**
     * NodeA特有的方法
     */
    public String operationA(){
        return "NodeA";
    }
}
