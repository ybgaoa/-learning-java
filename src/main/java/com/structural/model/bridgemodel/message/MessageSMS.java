package com.structural.model.bridgemodel.message;
/*����ʵ�ֻ�(ConcreteImplementor)��ɫ�������ɫ����ʵ�ֻ���ɫ�ӿڵľ���ʵ�֡�*/
public class MessageSMS implements MessageImplementor {

	public void send(String message, String toUser) {
		System.out.println("ʹ��ϵͳ�ڶ���Ϣ�ķ�����������Ϣ'"+message+"'��"+toUser);
	}

}
