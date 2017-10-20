package com.structural.model.bridgemodel.message;
/*具体实现化(ConcreteImplementor)角色：这个角色给出实现化角色接口的具体实现。*/
public class MessageSMS implements MessageImplementor {

	public void send(String message, String toUser) {
		System.out.println("使用系统内短消息的方法，发送消息'"+message+"'给"+toUser);
	}

}
