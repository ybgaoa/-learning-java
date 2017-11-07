package com.behavioral.model.visitormodel.node;

import com.behavioral.model.visitormodel.visitor.Visitor;
/*����ڵ�(ConcreteNode)��ɫ��ʵ���˳���ڵ����涨�Ľ��ܲ�����*/
public class NodeB extends Node {
	/**
     * ���ܷ���
     */
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
    /**
     * NodeB���еķ���
     */
    public String operationB(){
        return "NodeB";
    }

}
