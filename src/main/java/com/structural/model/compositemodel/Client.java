package com.structural.model.compositemodel;

public class Client {
	public static void main(String[]args){
	    Component root = new Composite("��װ");
	    Component c1 = new Composite("��װ");
	    Component c1_1 = new Composite("��װ-����װ");
	    Component c1_2 = new Composite("��װ-����װ");
	    Component c1_3 = new Composite("��װ-����װ");
	    Component c2 = new Composite("Ůװ");
	    Component c2_1 = new Composite("Ůװ-����װ");
	    Component c2_2 = new Composite("Ůװ-����װ");
	    Component c2_3 = new Composite("Ůװ-����װ");
	    
	    Component leaf1 = new Leaf("����");
	    Component leaf2 = new Leaf("�п�");
	    Component leaf3 = new Leaf("ȹ��");
	    Component leaf4 = new Leaf("��װ");
	    
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
