package com.creation.model.prototypemodel.simpleprototypemodel;

import com.creation.model.prototypemodel.simpleprototypemodel.prototype.Prototype;
/*�ͻ�(Client)��ɫ���ͻ�������������������*/
public class Client {
	/**
     * ������Ҫʹ�õ�ԭ�ͽӿڶ���
     */
    private Prototype prototype;
    /**
     * ���췽����������Ҫʹ�õ�ԭ�ͽӿڶ���
     */
    public Client(Prototype prototype){
        this.prototype = prototype;
    }
    public void operation(Prototype example){
        //��Ҫ����ԭ�ͽӿڵĶ���
        Prototype copyPrototype = prototype.clone();
    }
}
