package com.behavioral.model.observermodel.observer;
/*����۲���(Observer)��ɫ��Ϊ���еľ���۲��߶���һ���ӿڣ��ڵõ������֪ͨʱ�����Լ�������ӿڽ������½ӿڡ�*/
public interface Observer {
	/**
     * ���½ӿ�
     * @param state    ���µ�״̬
     */
    public void update(String state);
}
