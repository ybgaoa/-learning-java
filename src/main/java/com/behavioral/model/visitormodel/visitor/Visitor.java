package com.behavioral.model.visitormodel.visitor;

import com.behavioral.model.visitormodel.node.NodeA;
import com.behavioral.model.visitormodel.node.NodeB;
/*���������(Visitor)��ɫ��������һ�����߶�������������γ����еľ�������߽�ɫ����ʵ�ֵĽӿڡ�*/
public interface Visitor {
	/**
     * ��Ӧ��NodeA�ķ��ʲ���
     */
    public void visit(NodeA node);
    /**
     * ��Ӧ��NodeB�ķ��ʲ���
     */
    public void visit(NodeB node);
}
