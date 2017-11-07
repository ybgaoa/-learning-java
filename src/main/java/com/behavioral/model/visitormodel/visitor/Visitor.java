package com.behavioral.model.visitormodel.visitor;

import com.behavioral.model.visitormodel.node.NodeA;
import com.behavioral.model.visitormodel.node.NodeB;
/*抽象访问者(Visitor)角色：声明了一个或者多个方法操作，形成所有的具体访问者角色必须实现的接口。*/
public interface Visitor {
	/**
     * 对应于NodeA的访问操作
     */
    public void visit(NodeA node);
    /**
     * 对应于NodeB的访问操作
     */
    public void visit(NodeB node);
}
