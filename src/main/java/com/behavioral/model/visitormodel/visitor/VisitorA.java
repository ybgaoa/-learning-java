package com.behavioral.model.visitormodel.visitor;

import com.behavioral.model.visitormodel.node.NodeA;
import com.behavioral.model.visitormodel.node.NodeB;
/*���������(ConcreteVisitor)��ɫ��ʵ�ֳ���������������Ľӿڣ�Ҳ���ǳ���������������ĸ������ʲ�����*/
public class VisitorA implements Visitor {
	/**
     * ��Ӧ��NodeA�ķ��ʲ���
     */
    @Override
    public void visit(NodeA node) {
        System.out.println(node.operationA());
    }
    /**
     * ��Ӧ��NodeB�ķ��ʲ���
     */
    @Override
    public void visit(NodeB node) {
        System.out.println(node.operationB());
    }
}
