package com.creation.model.prototypemodel.simpleprototypemodel.prototype;
/*����ԭ�ͣ�Concrete Prototype����ɫ�������ƵĶ��󡣴˽�ɫ��Ҫʵ�ֳ����ԭ�ͽ�ɫ��Ҫ��Ľӿڡ�*/
public class ConcretePrototype2 implements Prototype {
	public Prototype clone(){
        //��򵥵Ŀ�¡���½�һ�������������û�����ԾͲ��ٸ���ֵ��
        Prototype prototype = new ConcretePrototype2();
        return prototype;
    }
}
