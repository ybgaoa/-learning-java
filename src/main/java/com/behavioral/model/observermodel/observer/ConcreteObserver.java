package com.behavioral.model.observermodel.observer;

public class ConcreteObserver implements Observer{
	//�۲��ߵ�״̬
    private String observerState;
    
    public void update(String state) {
        /**
         * ���¹۲��ߵ�״̬��ʹ����Ŀ���״̬����һ��
         */
        observerState = state;
        System.out.println("״̬Ϊ��"+observerState);
    }
}
