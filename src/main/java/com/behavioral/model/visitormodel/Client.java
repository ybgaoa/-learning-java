package com.behavioral.model.visitormodel;

import com.behavioral.model.visitormodel.node.NodeA;
import com.behavioral.model.visitormodel.node.NodeB;
import com.behavioral.model.visitormodel.visitor.Visitor;
import com.behavioral.model.visitormodel.visitor.VisitorA;

public class Client {
	 public static void main(String[] args) {
	        //����һ���ṹ����
	        ObjectStructure os = new ObjectStructure();
	        //���ṹ����һ���ڵ�
	        os.add(new NodeA());
	        //���ṹ����һ���ڵ�
	        os.add(new NodeB());
	        //����һ��������
	        Visitor visitor = new VisitorA();
	        os.action(visitor);
	    }
}
