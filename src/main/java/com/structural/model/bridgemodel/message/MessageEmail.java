package com.structural.model.bridgemodel.message;
/*����ʵ�ֻ�(ConcreteImplementor)��ɫ�������ɫ����ʵ�ֻ���ɫ�ӿڵľ���ʵ�֡�*/
public class MessageEmail implements MessageImplementor {

	public void send(String message, String toUser) {
		System.out.println("ʹ���ʼ�����Ϣ�ķ�����������Ϣ'"+message+"'��"+toUser);
	}

}
