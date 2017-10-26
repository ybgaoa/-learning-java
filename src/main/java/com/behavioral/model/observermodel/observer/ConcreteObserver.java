package com.behavioral.model.observermodel.observer;
/*����۲���(ConcreteObserver)��ɫ���洢�������״̬��ǡ��״̬��
����۲��߽�ɫʵ�ֳ���۲��߽�ɫ��Ҫ��ĸ��½ӿڣ��Ա�ʹ�����״̬�������״̬ ��Э���������Ҫ������۲��߽�ɫ���Ա���һ��ָ����������������á�*/
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
