package com.behavioral.model.visitormodel.node;

import com.behavioral.model.visitormodel.visitor.Visitor;
/*����ڵ�(Node)��ɫ������һ�����ܲ���������һ�������߶�����Ϊһ��������*/
public abstract class Node {
	/**
     * ���ܲ���
     */
    public abstract void accept(Visitor visitor);
}
