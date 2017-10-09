package com.creation.model.prototypemodel.registrationprototypemodel;

import com.creation.model.prototypemodel.registrationprototypemodel.prototype.ConcretePrototype1;
import com.creation.model.prototypemodel.registrationprototypemodel.prototype.ConcretePrototype2;
import com.creation.model.prototypemodel.registrationprototypemodel.prototype.Prototype;

public class Client {

	public static void main(String[] args) {
		try{
            Prototype p1 = new ConcretePrototype1();
            PrototypeManager.setPrototype("p1", p1);
            //��ȡԭ������������
            Prototype p3 = PrototypeManager.getPrototype("p1").clone();
            p3.setName("����");
            System.out.println("��һ��ʵ����" + p3);
            //���˶�̬���л���ʵ��
            Prototype p2 = new ConcretePrototype2();
            PrototypeManager.setPrototype("p1", p2);
            //���»�ȡԭ������������
            Prototype p4 = PrototypeManager.getPrototype("p1").clone();
            p4.setName("����");
            System.out.println("�ڶ���ʵ����" + p4);
            //����ע�������ԭ��
            PrototypeManager.removePrototype("p1");
            //�ٴλ�ȡԭ������������
            Prototype p5 = PrototypeManager.getPrototype("p1").clone();
            p5.setName("����");
            System.out.println("������ʵ����" + p5);
        }catch(Exception e){
            e.printStackTrace();
        }
	}

}