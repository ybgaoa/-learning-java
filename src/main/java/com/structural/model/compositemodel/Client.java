package com.structural.model.compositemodel;

public class Client {
	public static void main(String[]args){
	    Component root = new Composite("服装");
	    Component c1 = new Composite("男装");
	    Component c1_1 = new Composite("男装-老年装");
	    Component c1_2 = new Composite("男装-中年装");
	    Component c1_3 = new Composite("男装-青年装");
	    Component c2 = new Composite("女装");
	    Component c2_1 = new Composite("女装-老年装");
	    Component c2_2 = new Composite("女装-中年装");
	    Component c2_3 = new Composite("女装-青年装");
	    
	    Component leaf1 = new Leaf("衬衫");
	    Component leaf2 = new Leaf("夹克");
	    Component leaf3 = new Leaf("裙子");
	    Component leaf4 = new Leaf("套装");
	    
	    root.addChild(c1);
	    root.addChild(c2);
	    
	    c1.addChild(c1_1);
	    c1.addChild(c1_2);
	    c1.addChild(c1_3);
	    
	    c2.addChild(c2_1);
	    c2.addChild(c2_2);
	    c2.addChild(c2_3);
	    
	    c1_1.addChild(leaf1);
	    c1_2.addChild(leaf2);
	    c1_3.addChild(leaf4);
	    c2_1.addChild(leaf4);
	    c2_2.addChild(leaf3);
	    c2_3.addChild(leaf3);
	    
	    root.printStruct("");
	}
}
