package com.behavioral.model.visitormodel;

import java.util.ArrayList;
import java.util.List;

import com.behavioral.model.visitormodel.node.Node;
import com.behavioral.model.visitormodel.visitor.Visitor;
/*�ṹ����(ObjectStructure)��ɫ�������µ����Σ����Ա����ṹ�е�����Ԫ�أ�
�����Ҫ���ṩһ���߲�εĽӿ��÷����߶�����Է���ÿһ��Ԫ�أ�
�����Ҫ��������Ƴ�һ�����϶������һ���ۼ�����List��Set��*/
public class ObjectStructure {
	private List<Node> nodes = new ArrayList<Node>();
    
    /**
     * ִ�з�������
     */
    public void action(Visitor visitor){
        
        for(Node node : nodes)
        {
            node.accept(visitor);
        }
        
    }
    /**
     * ���һ����Ԫ��
     */
    public void add(Node node){
        nodes.add(node);
    }
}
