package com.behavioral.model.visitormodel;

import com.behavioral.model.visitormodel.node.NodeA;
import com.behavioral.model.visitormodel.node.NodeB;
import com.behavioral.model.visitormodel.visitor.Visitor;
import com.behavioral.model.visitormodel.visitor.VisitorA;

public class Client {
	 public static void main(String[] args) {
	        //创建一个结构对象
	        ObjectStructure os = new ObjectStructure();
	        //给结构增加一个节点
	        os.add(new NodeA());
	        //给结构增加一个节点
	        os.add(new NodeB());
	        //创建一个访问者
	        Visitor visitor = new VisitorA();
	        os.action(visitor);
	    }
}
