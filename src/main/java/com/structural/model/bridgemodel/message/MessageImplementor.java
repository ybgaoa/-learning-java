package com.structural.model.bridgemodel.message;
/*ʵ�ֻ�(Implementor)��ɫ�������ɫ����ʵ�ֻ���ɫ�Ľӿڣ��������������ʵ�֡�
 * ����ָ�����ǣ�����ӿڲ�һ���ͳ��󻯽�ɫ�Ľӿڶ�����ͬ��ʵ���ϣ��������ӿڿ��Էǳ���һ����
ʵ�ֻ���ɫӦ��ֻ�����ײ�����������󻯽�ɫӦ��ֻ�������ڵײ�����ĸ���һ��Ĳ�����*/
public interface MessageImplementor {
	 /**
     * ������Ϣ
     * @param message Ҫ������Ϣ������
     * @param toUser  ��Ϣ�Ľ�����
     */
    public void send(String message , String toUser);
}
